<%@page import="bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation"%>
<%@include file="/allocation/init.jsp" %>


<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

SalesCustomerAllocation entry = (SalesCustomerAllocation)row.getObject();
%>

<portlet:renderURL var="detailViewURL">
			<portlet:param name="mvcPath" value="/allocation/allocation_view.jsp" />
			<portlet:param name="salesCustomerAllocationId" value="<%=String.valueOf(entry.getSalesCustomerAllocationId()) %>" />
			<portlet:param name="redirect" value="<%=currentURL %>" />
</portlet:renderURL>

<liferay-ui:icon url="<%=detailViewURL %>" icon="view" markupView="lexicon"
	message="" />


<c:if test="<%=  currentYear == entry.getYear() %>"> 
<portlet:renderURL var="editURL">
			<portlet:param name="mvcPath" value="/allocation/indent.jsp" />
			<portlet:param name="salesCustomerAllocationId" value="<%=String.valueOf(entry.getSalesCustomerAllocationId()) %>" />
			<portlet:param name="commodity" value="<%=entry.getCommodity() %>" />
			<portlet:param name="redirect" value="<%=currentURL %>" />
</portlet:renderURL>

<aui:button href="<%=editURL %>" value="label-apply"></aui:button>
</c:if>

