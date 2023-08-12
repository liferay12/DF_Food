<%@ include file="init.jsp" %>


<%
String actionCommandName = (String)request.getAttribute(LocationSelectorPortletKeys.ACTION_COMMAND_NAME);
boolean editable = (boolean)request.getAttribute(LocationSelectorPortletKeys.EDITABLE);

User selUser = PortalUtil.getSelectedUser(request);
request.setAttribute(LocationSelectorPortletKeys.SELECTED_USER, selUser);

if (selUser != null) {
	PortalUtil.setPageSubtitle(selUser.getFullName(), request);
}

long selUserId = (selUser != null) ? selUser.getUserId() : 0;

String screenNavigationCategoryKey = ParamUtil.getString(request, "screenNavigationCategoryKey", LocationSelectorPortletKeys.CATEGORY_KEY_GENERAL);
String screenNavigationEntryKey = ParamUtil.getString(request, "screenNavigationEntryKey");

PortletURL viewURL = renderResponse.createRenderURL();

String backURL = ParamUtil.getString(request, "backURL", viewURL.toString());
if (!portletName.equals(LocationSelectorPortletKeys.MY_ACCOUNT)) {
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(backURL);
	renderResponse.setTitle((selUser == null) ? LanguageUtil.get(request, "add-user") : LanguageUtil.format(request, "edit-user-x", selUser.getFullName(), false));
}
String redirect = ParamUtil.getString(request, "redirect");

if (Validator.isNull(redirect)) {
	redirect = PortletURLBuilder.createRenderURL(
			renderResponse
		).setMVCRenderCommandName(
				"/users_admin/edit_user"
		).setBackURL(
			backURL
		).setParameter(
			"p_u_i_d", selUserId
		).buildString();
}

redirect = HttpComponentsUtil.addParameter(redirect, liferayPortletResponse.getNamespace() + "screenNavigationCategoryKey", screenNavigationCategoryKey);
redirect = HttpComponentsUtil.addParameter(redirect, liferayPortletResponse.getNamespace() + "screenNavigationEntryKey", screenNavigationEntryKey); 


%>

<liferay-portlet:actionURL  name="<%= actionCommandName %>" var="selectLocationURL" />

<aui:form action="<%= selectLocationURL %>" cssClass="portlet-users-admin-edit-user" data-senna-off="true" method="post" name="fm" autocomplete="off" >

	<div id="<portlet:namespace />errorMsg"></div>
	
		<clay:sheet>
		
			<clay:sheet-header>
				<h2 class="sheet-title"><liferay-ui:message key="locations"></liferay-ui:message></h2>
			</clay:sheet-header>


		<clay:sheet-section>

			<clay:content-row containerElement="h3" cssClass="sheet-subtitle">
				<clay:content-col expand="<%=true%>">
					<span class="heading-text"><liferay-ui:message
							key="locations" /></span>
				</clay:content-col>
			</clay:content-row>

	<liferay-ui:search-container
	    compactEmptyResultsMessage="<%= true %>"
		iteratorURL="<%= currentURLObj %>"
		emptyResultsMessage="no-results-found"
		total="<%= UserLocationLocalServiceUtil.getUserLocationsCountByUserId(selUserId)%>"
	>
		<liferay-ui:search-container-results
			results="<%= UserLocationLocalServiceUtil.getUserLocationsByUserId(selUserId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="bd.gov.dgfood.common.services.model.UserLocation"
			modelVar="userLocation"
		>
			
		<liferay-ui:search-container-column-text
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
				property="roleKey"
				name="role"
				 cssClass="table-cell-expand-smallest"
			/>
			
		<liferay-ui:search-container-column-text>
			<portlet:actionURL name="<%=LocationSelectorPortletKeys.DELETE_USER_LOCATION_MVC_ACTION %>" var="deleteLocationURL">
				<portlet:param name="redirect" value="<%= redirect %>" />
				<portlet:param name="userLocationId" value="<%= String.valueOf(userLocation.getUserLocationId()) %>" />
			</portlet:actionURL>

            <liferay-ui:icon url="<%=deleteLocationURL %>" icon="times-circle" markupView="lexicon" message="" />
		</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
			searchContainer="<%= searchContainer %>"
		/>
	</liferay-ui:search-container>
			
			
	</clay:sheet-section>

 </clay:sheet>

</aui:form>

