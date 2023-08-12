<%@include file="/init.jsp"%>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Grievance grievance = (Grievance)row.getObject();

if(Validator.isNotNull(grievance)){
String rowURL = (String)row.getParameter("rowURL");
String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-portlet:renderURL var="updateURL">
	<liferay-portlet:param name="mvcPath" value="/details.jsp" />
	<portlet:param name="grievanceId" value="<%=String.valueOf(grievance.getGrievanceId())%>"/>
	<liferay-portlet:param name="redirect" value="<%=redirect %>" />
</liferay-portlet:renderURL> 
<%if(renderRequest.isUserInRole(RoleConstants.UCF)){ %>
<liferay-ui:icon icon="reply"  message="<%=CustomLanguageUtil.get(request,"reply")%>" url="<%=updateURL%>" > </liferay-ui:icon>
<%} %>
<liferay-ui:icon icon="eye-open"  message="<%=CustomLanguageUtil.get(request,"view")%>" url="<%=updateURL%>" > </liferay-ui:icon>
<%}%>