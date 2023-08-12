<%@include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
UserLocation userLocation = (UserLocation)row.getObject();
%>

<portlet:actionURL name="<%=LocationSelectorPortletKeys.DELETE_USER_LOCATION_MVC_ACTION %>" var="deleteLocationURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="userLocationId" value="<%= String.valueOf(userLocation.getUserLocationId()) %>" />
		</portlet:actionURL>

<liferay-ui:icon url="<%=deleteLocationURL %>" icon="times-circle" markupView="lexicon" message="" />