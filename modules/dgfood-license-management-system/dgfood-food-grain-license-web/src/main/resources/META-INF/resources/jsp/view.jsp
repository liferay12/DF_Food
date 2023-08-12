<%@ include file="/jsp/init.jsp"%>

<style type="text/css">
.h-divider {
	margin-top: 5px;
	margin-bottom: 5px;
	height: 1px;
	width: 100%;
	border-top: 1px solid gray;
}
</style>

<portlet:renderURL var="addFormDataURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FoodGrainLicensePortletKeys.NEW_FG_LICENSE_MVC_RENDER_COMMAND%>" />
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>" />
</portlet:renderURL>

<portlet:renderURL var="checkApplicationStatusURL">
	<portlet:param name="mvcPath"
		value="/jsp/fglicense_status_check/fglicense_input.jsp" />
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>" />
</portlet:renderURL>

<portlet:renderURL var="dashboardFGLicenseURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FoodGrainLicensePortletKeys.DASHBOARD_SCREEN_FG_LICENSE_MVC_RENDER_COMMAND%>" />
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>" />
</portlet:renderURL>

<div class="container">
	<aui:button-row>
		<aui:button type="button" href="<%=addFormDataURL%>" value="label-apply-for-new-fg-license">
		</aui:button>
		<aui:button type="button" href="<%=checkApplicationStatusURL%>" value="label-check-application-status" >
		</aui:button>
		<aui:button type="button" href="http://localhost:8080/c/portal/login" value="login" >
		</aui:button>
		<!-- <aui:button id="callJson" value='Call JSON'
			onClick="callJson();"></aui:button> -->
	</aui:button-row>
</div>