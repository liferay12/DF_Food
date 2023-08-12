<%@ include file="init.jsp" %>

<%
int unReadNotificationCount = UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), false);
List<UserNotificationEvent> userNotificationEvents = UserNotificationEventLocalServiceUtil.getUserNotificationEvents(themeDisplay.getUserId(), 0, 5);
%>

<li class="dash-notify-drop">
      <a href="javascript:;" class="noti-click">
         <clay:icon symbol="bell-on" /><%=unReadNotificationCount > 9 ? "9+" : unReadNotificationCount %>
         <circle cx="11.5" cy="4.5" r="4.5" fill="#E84C3D"></circle>
      </a>
      <div class="dash-notification-box-wrapper" style="display: none;">
      <% for(UserNotificationEvent event : userNotificationEvents){ 
    	 UserNotificationFeedEntry userNotificationFeedEntry = UserNotificationManagerUtil.interpret(StringPool.BLANK, event, ServiceContextFactory.getInstance(request));
    	 long creadted = System.currentTimeMillis() - event.getTimestamp();
      %>
          <div class="notify-box">
              <div class="noti-icon">
                  <span><clay:icon symbol="bell-on" /></span>
              </div>
              <div class="noti-text">
                  <c:if test="<%= !event.isArchived() %>">
						<h4>
					</c:if>
							<%= userNotificationFeedEntry.getBody() %>
					<c:if test="<%= !event.isArchived() %>">
						</h4>
					</c:if>
                  <c:choose>
                  
                   <c:when test="<%= creadted < 60000 %>">
	                   <a href="javascript:;">
	                      <liferay-ui:message  key="label-just-now" />
	                    </a>
                   </c:when>
                   <c:otherwise>
	                    <a href="javascript:;">
	                    	<liferay-ui:message arguments="<%= LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - event.getTimestamp(), true) %>" key="x-ago" translateArguments="<%= false %>" />
	                    </a>
                   </c:otherwise>
                  
                  </c:choose>
                  
                 
              </div>
          </div>
      <%} %>
          <div class="view-all-btn">
              <a href="${notificationPageUrl}"> <liferay-ui:message  key="label-view-all" /></a>
          </div>
      </div>
</li>


<script>
$(document).ready(function(){
	  $(".noti-click").click(function(){
	  $(".dash-notification-box-wrapper").slideToggle();
	  });
	  $('body').on('click', function (e) {
	      if (!$('.dash-notify-drop').is(e.target)
	          && $('.dash-notify-drop').has(e.target).length === 0
	          && $('.open').has(e.target).length === 0
	      ) {
	          $('.dash-notification-box-wrapper').slideUp();
	      }
	  });
	});
</script>