<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/allocation/init.jsp" %>
<%-- <%@include file="init.jsp" %> --%>
<%
long salesCustomerAllocationId = ParamUtil.getLong(request, "salesCustomerAllocationId");
String commodity = ParamUtil.getString(request, "commodity");
String redirect = ParamUtil.getString(request, "redirect");
%>

<portlet:actionURL name="/indent/add_entry" var="addEntryURL">

</portlet:actionURL>

<aui:form action="${addEntryURL}" name="fm1" method="post" >

<aui:input name="salesCustomerAllocationId"  type="hidden" value="<%=salesCustomerAllocationId %>"></aui:input>

<clay:row>	

        <clay:col md="6" sm="6">
       		 <aui:input name="commodity" label="label-commodity" disabled="true" value="<%=commodity %>"></aui:input>
        </clay:col>
        
         <clay:col md="6" sm="6">
        	 <aui:input name="requiredDeliveryDate" label="label-delivery-date" value="22/10/2022"></aui:input>
        </clay:col>
        
         <clay:col md="6" sm="6">
       		  <aui:input name="quantity" label="label-quantity" value="10"></aui:input>
        </clay:col>
        
         <clay:col md="6" sm="6">
        	 <aui:select name="quantityUnit" label="label-quantity-Unit">
        	   <aui:option label="label-kilogram" value="KG"></aui:option>
        	   <aui:option label="label-metric-ton" value="MT"></aui:option>
        	 </aui:select>
        </clay:col>
</clay:row>

<aui:button-row>

 <aui:button  type="submit" ></aui:button>
 <aui:button  href="<%=redirect %>" type="cancel"></aui:button>

</aui:button-row>

</aui:form>