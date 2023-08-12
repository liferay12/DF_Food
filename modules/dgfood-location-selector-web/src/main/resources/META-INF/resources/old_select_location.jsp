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

UserLocation userLocation = UserLocationLocalServiceUtil.getUserLocationByUserId(selUserId);

LocationUrlConfiguration locationUrlConfiguration = portletDisplay.getPortletInstanceConfiguration(LocationUrlConfiguration.class);

List<ListTypeEntry>  entries = ListTypeEntryLocalServiceUtil.getListTypeEntries(locationUrlConfiguration.locationType());

List<ListTypeEntry>  lstEntries = ListTypeEntryLocalServiceUtil.getListTypeEntries(locationUrlConfiguration.role());

%>

<liferay-portlet:actionURL  name="<%= actionCommandName %>" var="selectLocationURL" />

<aui:form action="<%= selectLocationURL %>" cssClass="portlet-users-admin-edit-user" data-senna-off="true" method="post" name="fm" autocomplete="off" >

    <aui:input name="p_u_i_d" type="hidden" value="<%= selUserId %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="cmd" type="hidden" value="<%= (userLocation != null) ? Constants.UPDATE : Constants.ADD %>" />
	<aui:input name="existingLocationId" type="hidden" value="<%= (userLocation != null) ? userLocation.getLocationId() : 0%>" />
	<aui:input name="userLocationId" type="hidden" value="<%= (userLocation != null) ? userLocation.getUserLocationId() : 0%>" />
	<aui:input name="screenNavigationCategoryKey" type="hidden" value="<%= screenNavigationCategoryKey %>" />
	<aui:input name="screenNavigationEntryKey" type="hidden" value="<%= screenNavigationEntryKey %>" />
	
	<div id="<portlet:namespace />errorMsg"></div>
		<liferay-ui:error exception="<%=LocationAssignedException.class  %>" message="selected-user-is-already-assigned-to-a-location"></liferay-ui:error>
	<liferay-ui:error exception="<%=NoSuchUserException.class  %>" message="invalid-user-selection"></liferay-ui:error>
	<liferay-ui:error exception="<%=NoLocationExistException.class  %>" message="invalid-location-selection"></liferay-ui:error>
	<liferay-ui:error exception="<%=UserLocationAlreadyExistException.class  %>" message="selected-location-and-role-are-already-exist-please-try-different-combination"></liferay-ui:error>

	
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

			<clay:row>
				<clay:col md="6">
					<aui:select name="locationType" label="location-type" value="<%= (userLocation != null) ? userLocation.getLocationType() : StringPool.BLANK%>">
					<% for(ListTypeEntry entry : entries) {%>
					     <aui:option label="<%=entry.getName(locale) %>" value="<%=entry.getKey() %>"></aui:option>
					<%} %>
					</aui:select>
				</clay:col>
				<clay:col md="6"><%@ include file="/autocomplete.jsp"%>
				</clay:col>
				<clay:col md="6">
				 <aui:input name="assigneeUserName" label="assignee-user-name"  disabled="<%= selUser != null%>"  value="<%= (selUser != null) ? selUser.getFullName() : StringPool.BLANK%>">
				 </aui:input> 
				</clay:col>
				<clay:col md="6">
				 <aui:select name="roleKey" label="role" value="<%= (userLocation != null) ? userLocation.getRoleKey() : StringPool.BLANK%>">
					<% for(ListTypeEntry entry : lstEntries) {%>
					     <aui:option label="<%=entry.getName(locale) %>" value="<%=entry.getKey() %>"></aui:option>
					<%} %>
				</aui:select>
              </clay:col>
			</clay:row>
			<span aria-hidden="true" class="loading-animation loading-animation-sm"    style="display: none" ></span>

			<aui:input name="locationId" type="hidden" value="<%= (userLocation != null) ? userLocation.getLocationId() : 0%>" ></aui:input>
			
			<aui:input name="locationCode" type="hidden" value="<%= (userLocation != null) ? userLocation.getLocationCode() : StringPool.BLANK%>"></aui:input>
			
			
		</clay:sheet-section>

		<c:if test="<%= editable && (boolean)request.getAttribute(LocationSelectorPortletKeys.SHOW_CONTROLS) %>">
			<clay:sheet-footer>
				<aui:button name="save" onClick='<%= "event.preventDefault(); " + liferayPortletResponse.getNamespace() + "submitLocationEntry();" %>' type="submit" value="save" />

				<c:if test="<%= !portletName.equals(LocationSelectorPortletKeys.MY_ACCOUNT) %>">
					<aui:button href="<%= backURL %>" type="cancel" value="cancel"/>
				</c:if>
			</clay:sheet-footer>
		</c:if>
	</clay:sheet>

</aui:form>

<%@ include file="/commonjs.jsp"%>






<aui:select name="locationType"  required="true" label="location-code">
					   <aui:validator name="custom">
					      function(val){
					           if(val == 0 ){
					                 return false;
					           }
					           return true;
					      }
					   
					   </aui:validator>
					 
					
					</aui:select>
					
<<aui:script>    new Liferay.DynamicSelect([
        {
            select: '<portlet:namespace />locationType',
            selectData: (callback) => {
                Liferay.Service(
                    '/assetcategory/get-vocabulary-categories',
                    {
                      vocabularyId: 305205,
                      start: -1,
                       end: -1,
                       orderByComparator: null 
                    },
                    callback
                );
            },
            selectDesc: 'titleCurrentValue',
            selectId: 'categoryId',
            selectSort: '<%= true %>',
            selectVal: '<%= 0L %>',
        },
        {
            select: '<portlet:namespace />roleKey',
            selectData: (callback,selectKey) => {
                Liferay.Service(
                    '/assetcategory/get-child-categories',
					{
					    parentCategoryId: Number(selectKey),
					    start: -1,
					    end: -1,
					    orderByComparator: null 
					},
                    callback
                );
            },
            selectDesc: 'titleCurrentValue',
            selectId: 'categoryId',
            selectSort: '<%= true %>',
            selectVal: '<%= 0L %>',
        }
        
    ]);



</aui:script>
