<%@ include file="init.jsp" %>

<style>
.noti-top-header{
    display: flex;
    align-items: center;
    justify-content: space-between;
}
</style>


<%
String rowIds  = PortalUtil.getPortletNamespace("com_liferay_notifications_web_portlet_NotificationsPortlet") + "rowIds";
%>

<liferay-portlet:actionURL name="markNotificationsAsRead" var="markNotificationsAsReadURL" portletName="com_liferay_notifications_web_portlet_NotificationsPortlet">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</liferay-portlet:actionURL>


<clay:container-fluid>

<div class="noti-top-header">
	<aui:input name="checkAll" type="checkbox"  label="label-select-all" />
	<liferay-ui:icon
				cssClass="modify-link" 
				id="mark-as-read"
				label="<%=true%>" 
				linkCssClass="btn btn-secondary btn-sm"
				message="label-mark-as-read"
				method="get"
				url="<%=markNotificationsAsReadURL.toString() %>" 
	/>
	
</div>

	<aui:form action="<%= currentURL %>" method="get" name="fm">
	
	<aui:input name="<%=rowIds %>" useNamespace="false" id="<%=rowIds %>" type="hidden"></aui:input>
		<div class="user-notifications">
			<liferay-ui:search-container
			    delta="4"
				emptyResultsMessage="you-do-not-have-any-notifications"
				rowChecker="<%=new RowChecker(liferayPortletResponse) %>"
				id="userNotificationEventSearchContainer"
				iteratorURL="<%= currentURLObj %>" total="<%=UserNotificationEventLocalServiceUtil.getUserNotificationEventsCount(themeDisplay.getUserId()) %>">
		
				<liferay-ui:search-container-results results="<%=UserNotificationEventLocalServiceUtil.getUserNotificationEvents(themeDisplay.getUserId(),searchContainer.getStart(),searchContainer.getEnd()) %>" />
		
				<liferay-ui:search-container-row
					className="com.liferay.portal.kernel.model.UserNotificationEvent"
					keyProperty="userNotificationEventId"
					modelVar="userNotificationEvent"
				>
				
				<liferay-ui:search-container-column-date></liferay-ui:search-container-column-date>
				
				<%UserNotificationFeedEntry userNotificationFeedEntry = UserNotificationManagerUtil.interpret(StringPool.BLANK, userNotificationEvent, ServiceContextFactory.getInstance(request)); %>
				
				<%@ include file="/user_notification_entry.jspf" %>
					
				</liferay-ui:search-container-row>
		
				<liferay-ui:search-iterator
				    displayStyle="descriptive"
					markupView="lexicon"
						/>
			</liferay-ui:search-container>
		
		
		</div>
	</aui:form>
</clay:container-fluid>	

<aui:script>

var checkAll = document.getElementById("<portlet:namespace />checkAll");

checkAll.addEventListener('click', function (event){

      const checkboxStatus = event.currentTarget.checked;

      Liferay.componentReady('<portlet:namespace />userNotificationEventSearchContainer').then(
            (searchContainer) => {

            if (checkboxStatus) {
                searchContainer.select.toggleAllRows(true);
            }
            else {
                searchContainer.select.toggleAllRows(false);
            }

    })
    
})

var markAsRead = document.getElementById("<portlet:namespace />mark-as-read");

markAsRead.addEventListener('click', function (event){

	event.preventDefault();
	
	var form = document.querySelector('#<portlet:namespace />fm');
	
	if (form) {
	
			var rowIds = Liferay.Util.listCheckedExcept(
				form,
				'<portlet:namespace />allRowIds'
			);
			
			if(rowIds){
			
			   var markAsReadURL = event.currentTarget.getAttribute('href');
			   form.setAttribute("method", "post");
			   form.querySelector('#<%=rowIds %>').value = rowIds;
			   submitForm(form, markAsReadURL);
			
			}
			
	}

})

</aui:script>

