<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.web.portlet.util.SCUtil"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerAllocationLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.service.persistence.SalesCustomerAllocationUtil"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@ include file="/allocation/init.jsp" %>

<%
long salesCustomerCode = SCUtil.getSalesCustomerCode(user.getUserId());
String commodity = ParamUtil.getString(request, "commodity");
int year = ParamUtil.getInteger(request, "year");
System.out.println("commodity "+commodity);
%>

<%@ include file="/allocation/navigation.jsp" %>

<liferay-ui:search-container  
    emptyResultsMessage="no-entries-were-found" 
    total="<%=SalesCustomerAllocationLocalServiceUtil.searchCount(-1, commodity, salesCustomerCode)%>"
    id="allocation" >
    
    <liferay-ui:search-container-results
		results="<%= SalesCustomerAllocationLocalServiceUtil.search(-1, commodity, salesCustomerCode, searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

<liferay-ui:search-container-row
        className="bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomerAllocation"
        keyProperty="salesCustomerAllocationId" modelVar="salesCustomerAllocation" escapedModel="<%=true%>">

		<liferay-ui:search-container-column-text name="label-year" cssClass=""
			property="year" />
			
		<liferay-ui:search-container-column-text name="label-allocation-number" cssClass=""
			property="allocationNumber" />

		<liferay-ui:search-container-column-text name="label-commodity"
			cssClass="" property="commodity" />
			
		<liferay-ui:search-container-column-text name="label-yearly-allocation-qty"
			cssClass="" property="yearlyQty" />

		<liferay-ui:search-container-column-date name="label-create-date" property="createDate"/>

		<liferay-ui:search-container-column-jsp  name="label-action" 
				path="/allocation/action.jsp" />

	</liferay-ui:search-container-row>

    <liferay-ui:search-iterator
				displayStyle="list"
				markupView="lexicon"
	 />
</liferay-ui:search-container>