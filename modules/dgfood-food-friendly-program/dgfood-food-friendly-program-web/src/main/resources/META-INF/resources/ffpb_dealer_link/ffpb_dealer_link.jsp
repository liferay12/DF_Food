<%@include file="/ffpb_dealer_link/init.jsp" %>

<c:choose>
	<c:when  test='<%= FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId, FoodFriendlyProgramConstants.DEALER_BENEFICIARY_LINK) %>'>


<%
String back = ParamUtil.getString(request, "backURL");
%>

<liferay-util:include page="/ffpb_admin/ffpb_profile.jsp" servletContext="<%= application %>" />

<aui:button-row>
    <aui:button type="cancel" value="back" href="<%=back %>"></aui:button>
	<aui:button  value='link-now'></aui:button>
	
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