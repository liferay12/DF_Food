<%@page import="bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

SalesCustomer entry = (SalesCustomer)row.getObject();
%>
<c:if test="${view}"> 
<portlet:renderURL var="detailViewURL">
			<portlet:param name="mvcRenderCommandName" value="/customer/detail_view" />
			<portlet:param name="customerId" value="<%=String.valueOf(entry.getSalesCustomerId()) %>" />
			<portlet:param name="redirect" value="<%=currentURL %>" />
</portlet:renderURL>

<liferay-ui:icon url="<%=detailViewURL %>" icon="view" markupView="lexicon"
	message="" />

</c:if>
<c:if test="${edit}"> 
<portlet:renderURL var="editURL">
			<portlet:param name="mvcRenderCommandName" value="/customer/edit_entry" />
			<portlet:param name="customerId" value="<%=String.valueOf(entry.getSalesCustomerId()) %>" />
			<portlet:param name="redirect" value="<%=currentURL %>" />
			<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.EDIT %>" />
</portlet:renderURL>

<liferay-ui:icon url="<%=editURL %>" icon="pencil" markupView="lexicon" message="" />
</c:if>

