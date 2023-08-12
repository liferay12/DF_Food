<%@include file="/ffpb_admin/init.jsp" %>

<c:choose>
	<c:when  test='<%= FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId, FoodFriendlyProgramConstants.VIEW) %>'>


<%
String back = ParamUtil.getString(request, "backURL");
%>

<liferay-util:include page="/ffpb_admin/ffpb_profile.jsp" servletContext="<%= application %>" />

<aui:button-row>
	<aui:button  value='edit'></aui:button>
	<aui:button type="cancel" value="back" href="<%=back %>"></aui:button>
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