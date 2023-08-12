<%@include file="/alert/init.jsp" %>
 <%

int status = GetterUtil.getInteger(request.getAttribute("dgfood-ui:alert:status"));
long classPK = GetterUtil.getLong(request.getAttribute("dgfood-ui:alert:classPK"));
String className = GetterUtil.getString((String)request.getAttribute("dgfood-ui:alert:className"));
String type = GetterUtil.getString(request.getAttribute("dgfood-ui:alert:type"));
String comment = StringPool.BLANK;
if(type.equalsIgnoreCase("alert") && status == StatusConstants.STATUS_REJECTED){
	comment = WorflowTaskSubmissionUtil.getTaskComments(classPK, className);
}

%>
  
<c:choose>

<c:when test="<%=type.equalsIgnoreCase("alert")%>">

  <div class="alert alert-<%= StatusConstants.getStatusStyle(status) %>" role="alert">
	<strong class="lead"><%=CustomLanguageUtil.get(request, StatusConstants.getStatusLabel(status)) %></strong>
	<p> <%=comment %> </p>
  </div>

</c:when>
<c:when test="<%=type.equalsIgnoreCase("status")%>">

 <span class="taglib-workflow-status">
 <strong class="label label-<%= StatusConstants.getStatusStyle(status) %> status text-uppercase workflow-status-<%= StatusConstants.getStatusLabel(status) %> <%= StatusConstants.getStatusCssClass(status) %> workflow-value">
			<%=CustomLanguageUtil.get(request, StatusConstants.getStatusLabel(status)) %>
		</strong>
 </span>

</c:when>

</c:choose>