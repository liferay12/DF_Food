<%@include file="../init.jsp"%>

<liferay-ui:error message="${errorKey}" exception="<%=InvalidFGLicenseInformationException.class %>"></liferay-ui:error>
<liferay-ui:error message="${errorKey}" exception="<%=Exception.class %>"></liferay-ui:error>

<h3><liferay-ui:message key="label-fg-license-form-error" /> </h3>

<portlet:renderURL var="addFormDataURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FoodGrainLicensePortletKeys.NEW_FG_LICENSE_MVC_RENDER_COMMAND%>" />
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>" />
</portlet:renderURL>

<aui:button-row>
	<aui:button type="button" href="<%=addFormDataURL%>" value="label-apply-for-new-fg-license">
	</aui:button>
</aui:button-row>
