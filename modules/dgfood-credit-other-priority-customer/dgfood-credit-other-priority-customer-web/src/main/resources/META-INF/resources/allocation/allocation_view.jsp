<%@page import="bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerAllocationLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation"%>
<%@page import="bd.gov.dgfood.common.services.service.IndentLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.common.services.model.Indent"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/allocation/init.jsp" %>

<%
long salesCustomerAllocationId = ParamUtil.getLong(request, "salesCustomerAllocationId");
SalesCustomerAllocation allocation = SalesCustomerAllocationLocalServiceUtil.getSalesCustomerAllocation(salesCustomerAllocationId);
String redirect = ParamUtil.getString(request, "redirect");
%>

<clay:row>
	
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-year"></dgfood-ui:message> : <span> <%=allocation.getYear() %> </span>
	</clay:col>
	
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-sales-organization"></dgfood-ui:message> : <span>  <%=allocation.getSalesOrganization() %> </span>
	</clay:col>
	
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-yearly-allocation-qty"></dgfood-ui:message> : <span>  <%=allocation.getYearlyQty() + StringPool.SPACE + allocation.getYearlyQtyUnit()%> </span>
	</clay:col>
	
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-monthly-allocation-qty"></dgfood-ui:message> : <span>  <%=allocation.getMonthlyQty() + StringPool.SPACE + allocation.getMonthlyQtyUnit()%> </span>
	</clay:col>

	
</clay:row>


<h3> <dgfood-ui:message key="label-indent-list" /> </h3>


<liferay-ui:search-container  
    emptyResultsMessage="no-entries-were-found" 
    total="<%=IndentLocalServiceUtil.getIndentsCount(salesCustomerAllocationId)%>"
    id="indent" >

   <liferay-ui:search-container-results
		results="<%=IndentLocalServiceUtil.getIndents(salesCustomerAllocationId, searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>


<liferay-ui:search-container-row
        className="bd.gov.dgfood.common.services.model.Indent"
        keyProperty="indentId" modelVar="indent" escapedModel="<%=true%>">

		<liferay-ui:search-container-column-text name="label-commodity" cssClass=""
			property="commodity" />
			
		<liferay-ui:search-container-column-text name="label-orded-qty" cssClass=""
			value="<%= indent.getQuantity() + StringPool.SPACE + indent.getQuantityUnit()%>" />
			
			<liferay-ui:search-container-column-date name="label-create-date" property="createDate"/>

		<liferay-ui:search-container-column-status name="label-status"
			cssClass="" property="status"/>
		
		

		<liferay-ui:search-container-column-jsp  name="label-action" 
				path="/allocation/indent_action.jsp" />

	</liferay-ui:search-container-row>

    <liferay-ui:search-iterator
				displayStyle="list"
				markupView="lexicon"
	 />
</liferay-ui:search-container>


 <aui:button  href="<%=redirect %>" type="cancel"></aui:button>

