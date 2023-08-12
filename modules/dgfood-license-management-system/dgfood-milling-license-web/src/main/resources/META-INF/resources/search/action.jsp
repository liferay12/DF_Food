<%@include file="/search/init.jsp"%>

<%

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
MillingLicense entry = (MillingLicense)row.getObject();

%>

<portlet:renderURL var="viewMillingLicenseURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MillingLicensePortletKeys.VIEW_SINGLE_MILLING_MVC_RENDER_COMMAND%>" />
	<portlet:param name="millingLicenseId"
		value="<%=String.valueOf(entry.getMillingLicenseId())%>" />
	<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>" />
</portlet:renderURL>

<liferay-ui:icon url="<%=viewMillingLicenseURL %>" icon="view" markupView="lexicon" message="" />
