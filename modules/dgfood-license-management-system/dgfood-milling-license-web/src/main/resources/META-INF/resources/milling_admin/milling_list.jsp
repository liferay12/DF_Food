<%@page import="bd.gov.dgfood.milling.license.web.internal.display.context.MillingLicenseDisplayContext"%>
<%@include file="/milling_admin/init.jsp"%>

<style>

/* width */
::-webkit-scrollbar {
	width: 5px;
}

/* Track */
::-webkit-scrollbar-track {
	background: #f1f1f1;
}

/* Handle */
::-webkit-scrollbar-thumb {
	background: #888;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
	background: #555;
}

thead, tbody {
	display: block;
}

tbody {
	height: 300px;
	overflow-y: auto;
	overflow-x: hidden;
}
</style>
<%
MillingLicenseDisplayContext millingLicenseDisplayContext = new MillingLicenseDisplayContext(request, liferayPortletRequest, liferayPortletResponse);
pageContext.setAttribute("customSearchContainer",millingLicenseDisplayContext.getSearch());
%>

<portlet:renderURL var="searchURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MillingLicensePortletKeys.LIST_MILLING_MVC_RENDER_COMMAND%>"/>
</portlet:renderURL>

<div id='dashboard_search_box'>
	<aui:form action="${searchURL}" name="fm"
		cssClass="container-fluid-1280">
		<clay:row>
			<clay:col md="3" sm="6">
				<label for="fromDate"><liferay-ui:message key="from-date"></liferay-ui:message></label>
				<aui:input name="fromDate" label="" value="12/12/1222" type="Date"
					placeholder="select" />
			</clay:col>
			<clay:col md="3" sm="6">
				<label for="toDate"><liferay-ui:message key="to-date"></liferay-ui:message></label>
				<aui:input name="toDate" label="" value="" type="Date"
					placeholder="select" />
			</clay:col>
			<clay:col md="2" sm="6">
				<label for="status"><liferay-ui:message
						key="foodGrainLicense-status"></liferay-ui:message></label>
				<aui:select name="status" label="">
					<aui:option value="-1">
						<liferay-ui:message key="select"></liferay-ui:message>
					</aui:option>
					<aui:option value="0">
						<liferay-ui:message key="approved"></liferay-ui:message>
					</aui:option>
					<aui:option value="1">
						<liferay-ui:message key="pending"></liferay-ui:message>
					</aui:option>
					<aui:option value="4">
						<liferay-ui:message key="rejected"></liferay-ui:message>
					</aui:option>
				</aui:select>
			</clay:col>
			<clay:col md="2" sm="6">
				<label for="keywords"><liferay-ui:message key="keywords"></liferay-ui:message></label>
				<aui:input name="keywords" label="" value="" placeholder="search" />
			</clay:col>
			<clay:col md="2" sm="6">
				<aui:button-row>
					<aui:button type="button" value='search' id="search_filters"></aui:button>
					<aui:button type="reset"></aui:button>
				</aui:button-row>
			</clay:col>
		</clay:row>
	</aui:form>
</div>
<clay:row>
	<clay:col md="12" sm="6">
		<div id="<portlet:namespace />dashboard-search-container">
			<%@include file="/search/search_container.jsp"%>
		</div>
	</clay:col>
</clay:row>

<dgfood-ui:ajax-search-container
	containerId='<%=liferayPortletResponse.getNamespace() + "dashboard-search-container"%>'
	resourceId="<%=MillingLicensePortletKeys.POPULATE_MILLING_LIST_MVC_RESOURCE_COMMAND %>"
	formId='<%=liferayPortletResponse.getNamespace() + "fm"%>'
	buttonId='<%= liferayPortletResponse.getNamespace() + "search_filters"%>' 
/>