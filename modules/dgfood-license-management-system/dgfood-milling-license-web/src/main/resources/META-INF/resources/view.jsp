<%@page import="bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys"%>
<%@ include file="/init.jsp"%>

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
		value="<%=MillingLicensePortletKeys.NEW_MILLING_MVC_RENDER_COMMAND%>" />
	<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>" />
</portlet:renderURL>

<portlet:renderURL var="millingLicenseURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MillingLicensePortletKeys.MILIING_SCREEN_MILLING_MVC_RENDER_COMMAND%>" />
	<portlet:param name="millingLicenseId"
		value="<%=String.valueOf(304)%>" />
	<portlet:param name="backURL"
		value="<%=themeDisplay.getURLCurrent()%>" />
</portlet:renderURL>

<portlet:renderURL var="viewMillingLicenseURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MillingLicensePortletKeys.VIEW_SINGLE_MILLING_MVC_RENDER_COMMAND%>" />
	<portlet:param name="millingLicenseId"
		value="<%=String.valueOf(304)%>" />
	<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>" />
</portlet:renderURL>

<portlet:renderURL var="listLicenseURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MillingLicensePortletKeys.LIST_MILLING_MVC_RENDER_COMMAND%>" />
	<portlet:param name="backURL"
		value="<%=themeDisplay.getURLCurrent()%>" />
</portlet:renderURL>

<div class="container">
	<c:choose>
		<c:when test="<%=themeDisplay.isSignedIn()%>">
			<aui:button-row>
				<aui:button type="button" href="<%=millingLicenseURL%>"
					value='milling-license-details'>
				</aui:button>
				<aui:button type="button" href="<%=viewMillingLicenseURL%>"
					value='milling-license-profile'>
				</aui:button>
				<aui:button type="button" href="<%=addFormDataURL%>"
					value='apply-for-new-milling-license'>
				</aui:button>
				<aui:button type="button" href="<%=listLicenseURL%>"
					value='list-milling-license'>
				</aui:button>
			</aui:button-row>
		</c:when>
		<c:otherwise>
			<aui:button-row>
				<aui:button type="button"
					href="http://localhost:8080/c/portal/login" value='login'>
				</aui:button>
				<!-- <aui:button id="callJson" value='Call JSON'
			onClick="callJson();"></aui:button> -->
			</aui:button-row>
		</c:otherwise>
	</c:choose>
</div>