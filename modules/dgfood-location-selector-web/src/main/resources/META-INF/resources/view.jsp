<%@ include file="init.jsp" %>

<style>
.capitalize{
 text-transform: capitalize; 
}
</style>

<%

    PortletURL portletURL = renderResponse.createRenderURL();
    String actionURL = portletURL.toString();
    
    PortletURL addLogCategoryURL = portletURL;
    addLogCategoryURL.setParameter("mvcPath", LocationSelectorPortletKeys.EDIT_USER_LOCATION_JSP);
    addLogCategoryURL.setParameter("redirect", currentURL);
    
    CreationMenu creationMenu =
    		new CreationMenu() {
    			{
    				addPrimaryDropdownItem(
    					dropdownItem -> {
    						dropdownItem.setHref(addLogCategoryURL);
    						dropdownItem.setLabel(LanguageUtil.get(request, "assign-location"));
    					});
    			}
    		};
    
    renderResponse.setTitle(LanguageUtil.get(request, "user-Location"));
    
%>

<clay:management-toolbar
	clearResultsURL="<%= actionURL %>"
	searchActionURL="<%= actionURL %>"
	componentId="userLocationManagementToolbar"
	creationMenu="<%= creationMenu %>"
	namespace="<%= liferayPortletResponse.getNamespace() %>"
	searchContainerId="userLocation"
	searchFormName="fm1"
	selectable="false"
/>

<aui:form cssClass="container-fluid container-fluid-max-xl" name="fm">
	<liferay-ui:search-container
		iteratorURL="<%= currentURLObj %>"
		emptyResultsMessage="no-results-found"
		total="<%= UserLocationLocalServiceUtil.getUserLocationsCount() %>"
	>
		<liferay-ui:search-container-results
			results="<%= UserLocationLocalServiceUtil.getUserLocations( searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="bd.gov.dgfood.common.services.model.UserLocation"
			modelVar="userLocation"
		>
		
				
		<%
			PortletURL rowURL = null;

			//if (RolePermissionUtil.contains(permissionChecker, role.getRoleId(), ActionKeys.UPDATE)) {
				rowURL = renderResponse.createRenderURL();

				rowURL.setParameter("mvcPath", LocationSelectorPortletKeys.EDIT_USER_LOCATION_JSP);
				PortletURL searchContainerPortletURL = searchContainer.getIteratorURL();

				rowURL.setParameter("redirect", searchContainerPortletURL.toString());
				rowURL.setParameter("userLocationId", String.valueOf(userLocation.getUserLocationId()));
			//}
			%>
			
		<liferay-ui:search-container-column-text
		        href="<%= rowURL %>"
				property="locationType"
				name="location-type"
				 cssClass="table-cell-expand-smallest capitalize"
			/>
			
		<liferay-ui:search-container-column-text
				property="locationName"
				name="location-name"
				 cssClass="table-cell-expand-smallest"
			/>
			
			<liferay-ui:search-container-column-text
			   cssClass="table-cell-expand-smallest"
				property="locationCode"
				name="location-code"
			/>
			
		<liferay-ui:search-container-column-text
				property="userName"
				name="assignee-user-name"
				 cssClass="table-cell-expand-smallest"
			/>
			
	   <liferay-ui:search-container-column-text
				property="roleKey"
				name="role"
				 cssClass="table-cell-expand-smallest"
			/>
			
		<liferay-ui:search-container-column-jsp
			path="/user_Location_action.jsp"
		/>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
			searchContainer="<%= searchContainer %>"
		/>
	</liferay-ui:search-container>
</aui:form>

