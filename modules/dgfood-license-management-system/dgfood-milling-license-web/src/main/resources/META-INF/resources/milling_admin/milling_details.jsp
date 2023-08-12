<%@include file="/milling_admin/init.jsp"%>

<%
MillingLicense millingLicense = (MillingLicense) request.getAttribute("millingLicense");
String back = ParamUtil.getString(request, "backURL");
%>

<liferay-util:include page="/milling_admin/milling_profile.jsp"
	servletContext="<%= application %>" />

<c:choose>
	<c:when test="${workflowPending}">
		<dgfood-ui:workflow-task 
			className="<%=MillingLicense.class.getName() %>"
			classPK="${millingLicense.getMillingLicenseId()}" 
			redirect="<%=back %>" />
	</c:when>
	<c:otherwise>
		<aui:button-row>
			<aui:button type="cancel" value="back" href="<%=back %>"></aui:button>
		</aui:button-row>
	</c:otherwise>
</c:choose>

