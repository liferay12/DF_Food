<%@ include file="init.jsp" %>


<%

long userLocationId = ParamUtil.getLong(request, "userLocationId");

String redirect = ParamUtil.getString(request, "redirect");

UserLocation userLocation = UserLocationLocalServiceUtil.fetchUserLocation(userLocationId);

LocationUrlConfiguration locationUrlConfiguration = portletDisplay.getPortletInstanceConfiguration(LocationUrlConfiguration.class);

List<ListTypeEntry>  entries = ListTypeEntryLocalServiceUtil.getListTypeEntries(locationUrlConfiguration.locationType());

List<ListTypeEntry>  lstEntries = ListTypeEntryLocalServiceUtil.getListTypeEntries(locationUrlConfiguration.role());

%>

<liferay-portlet:actionURL  name="<%=LocationSelectorPortletKeys.EDIT_USER_LOCATION_MVC_ACTION %>" var="selectLocationURL" />

<liferay-frontend:edit-form
		action="<%= selectLocationURL %>"
		method="post"
		name="fm"
		autocomplete="off" 
	>
	<div id="<portlet:namespace />errorMsg"></div>
	<liferay-ui:error exception="<%=LocationAssignedException.class  %>" message="selected-user-is-already-assigned-to-a-location"></liferay-ui:error>
	<liferay-ui:error exception="<%=NoSuchUserException.class  %>" message="invalid-user-selection"></liferay-ui:error>
	<liferay-ui:error exception="<%=NoLocationExistException.class  %>" message="invalid-location-selection"></liferay-ui:error>
	<liferay-ui:error exception="<%=UserLocationAlreadyExistException.class  %>" message="selected-location-and-role-are-already-exist-please-try-different-combination"></liferay-ui:error>

		<liferay-frontend:edit-form-body>
			<liferay-frontend:fieldset-group>
				<liferay-frontend:fieldset>
   
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="cmd" type="hidden" value="<%= (userLocation != null) ? Constants.UPDATE : Constants.ADD %>" />
	<aui:input name="existingLocationId" type="hidden" value="<%= (userLocation != null) ? userLocation.getLocationId() : 0%>" />
	<aui:input name="userLocationId" type="hidden" value="<%= (userLocation != null) ? userLocation.getUserLocationId() : 0%>" />



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
				 <aui:input name="assigneeUserName" label="assignee-user-name"  disabled="<%= userLocation != null%>"  value="<%= (userLocation != null) ? userLocation.getUserName() : StringPool.BLANK%>">
				 <aui:validator name="required" errorMessage="this-filed-is-required"></aui:validator>
					<aui:validator name="custom" errorMessage="please-select-user">
					  function(){

						    if(Number(document.getElementById('<portlet:namespace />assigneeUserId').value) > 0){
						         return true;
						    }else{
						      return false;
						    }
					   }
					    
					</aui:validator>
				 
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
			
			<c:if test="<%= userLocation == null %>">
			   <aui:button value="select" onClick='<%= liferayPortletResponse.getNamespace() + "selectUser();" %>'></aui:button>
			
			</c:if>
			
			<aui:input name="locationId"  type="hidden" value="<%= (userLocation != null) ? userLocation.getLocationId() : ParamUtil.getLong(request, "locationId",0)%>" ></aui:input>
			
			<aui:input name="assigneeUserId" type="hidden" value="<%= (userLocation != null) ? userLocation.getUserId() : ParamUtil.getLong(request, "assigneeUserId",0)%>" ></aui:input>
			
			<aui:input name="locationCode" type="hidden" value="<%= (userLocation != null) ? userLocation.getLocationCode() : ParamUtil.getString(request, "locationCode",StringPool.BLANK)%>"></aui:input>


           <span aria-hidden="true" class="loading-animation loading-animation-sm"    style="display: none" ></span>
		</liferay-frontend:fieldset>
			</liferay-frontend:fieldset-group>
		</liferay-frontend:edit-form-body>

		<liferay-frontend:edit-form-footer>
			<aui:button name="save"
			onClick='<%="event.preventDefault(); " + liferayPortletResponse.getNamespace()
							+ "submitLocationEntry();"%>'
			type="submit" value="save" />

			<aui:button type="cancel" href="<%=redirect %>"/>
		</liferay-frontend:edit-form-footer>
	</liferay-frontend:edit-form>

<%@ include file="/commonjs.jsp"%>

<aui:script>

Liferay.provide(
			window,
			'<portlet:namespace />selectUser',
			() => {
			
		const assigneeUserId = document.getElementById('<portlet:namespace />assigneeUserId');
		const assigneeUserName = document.getElementById('<portlet:namespace />assigneeUserName');
		
		const data = [assigneeUserId.value];	
		
		 Liferay.Util.openSelectionModal({
					onSelect: (selectedItem) => {
						if (selectedItem) {
							assigneeUserName.value = selectedItem.entityname;
							assigneeUserId.value = selectedItem.entityid;
							Liferay.Util.focusFormField('#<portlet:namespace />assigneeUserName');
						}
					},
					selectEventName: '<portlet:namespace />selectUser',
					selectedData: data,
					title:
						'<liferay-ui:message arguments="user" key="select-user" />',
					url:
						'<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="eventName" value='<%= liferayPortletResponse.getNamespace() + "selectUser" %>' /> <portlet:param name="mvcPath" value="/select_user.jsp" /></portlet:renderURL>',
				});

								
});

</aui:script>

