<%@include file="../init.jsp" %>


<c:choose>
	<c:when  test='<%= FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId, FoodFriendlyProgramConstants.REVIEW_BENEFICIARY) %>'>



<%
String back = ParamUtil.getString(request, "backURL");
%>

<liferay-util:include page="/ffpb_admin/ffpb_profile.jsp" servletContext="<%= application %>" >

</liferay-util:include>


<c:if test="${workflowPending}">

<dgfood-ui:workflow-task
 className="<%=FFPBeneficiary.class.getName() %>" 
 classPK="${ffpBeneficiary.getBeneficiaryId()}" 
 redirect="<%=back %>" 
 />

</c:if>


	</c:when>
	<c:otherwise>
		<div class="alert alert-danger text-center">
			<div>
				<liferay-ui:message
					key="access-denied" />
			</div>
	</c:otherwise>
</c:choose>