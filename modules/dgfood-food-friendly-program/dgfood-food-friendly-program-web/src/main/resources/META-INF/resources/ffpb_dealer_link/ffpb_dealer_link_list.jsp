<%@include file="/ffpb_dealer_link/init.jsp" %>

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


</style>

<c:choose>
	<c:when  test='<%= FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId, FoodFriendlyProgramConstants.DEALER_BENEFICIARY_LINK) %>'>


<%
String back = ParamUtil.getString(request, "backURL");
%>

<portlet:renderURL var="linkURL">			
			<portlet:param name="mvcPath" value="/ffpb_dealer_link/ffpb_dealer_link_list.jsp" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
</portlet:renderURL>



<liferay-util:include page="/search/search_container.jsp" servletContext="<%= application %>" >
    <liferay-util:param name="paginate" value="false" />
</liferay-util:include>


<aui:button-row>
    <aui:button type="cancel" value="back" href="<%=back %>"></aui:button>
	<aui:button  value='link-now' href="<%=linkURL %>"></aui:button>
	
</aui:button-row>

	</c:when>
	<c:otherwise>
		<div class="alert alert-danger text-center">
			<div>
				<liferay-ui:message
					key="access-denied" />
			</div>
	</c:otherwise>
</c:choose>