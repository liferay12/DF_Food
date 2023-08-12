<%@include file="../init.jsp"%>

<%
	String applicationNo = ParamUtil.getString(request, ParameterConstants.APPLICATION_NUMBER);
%>
<h3><liferay-ui:message key="label-fg-license-form-submitted-successfully" /> </h3>
<h4><liferay-ui:message key="label-your-application-no" /> : <%=applicationNo%></h4>

<portlet:renderURL var="trackFgLicenseURL">
	<portlet:param name="mvcPath" value="/fglicense_status_check/fglicense_input.jsp" />
</portlet:renderURL>

<aui:button-row>
	<aui:button type="button" value="label-check-application-status" href="<%=trackFgLicenseURL%>">
	</aui:button>
	<aui:button type="button" href="http://localhost:8080/c/portal/login" value="login" >
	</aui:button>
</aui:button-row>
