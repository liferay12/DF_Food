<%@include file="/search/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

FFPBeneficiary entry = (FFPBeneficiary)row.getObject();

%>

<portlet:renderURL var="viewBeneficiaryURL">
			<portlet:param name="ffpb_id" value="<%= String.valueOf(entry.getBeneficiaryId()) %>" />
			<c:if test="${review }">
			   <portlet:param name="jsp" value="/ffpb_admin/ffpb_review.jsp" />
			</c:if>
			<c:if test="${linking}">
			   <portlet:param name="jsp" value="/ffpb_dealer_link/ffpb_dealer_link.jsp" />
			</c:if>
			<portlet:param name="mvcRenderCommandName" value="/ffpb_admins/view_ffpb" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
</portlet:renderURL>

<liferay-ui:icon url="<%=viewBeneficiaryURL %>" icon="view" markupView="lexicon"
	message="" />


<c:if test="${edit}">
<liferay-ui:icon url="#" icon="pencil" markupView="lexicon" message="" />
</c:if>





<%-- <liferay-ui:icon url="test.com" icon="trash" markupView="lexicon"
	message="" />
 --%>
