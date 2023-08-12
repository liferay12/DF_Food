
<%@page import="bd.gov.dgfood.credit.other.priority.customer.constants.CustomerConstants"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.web.portlet.security.permission.resource.CustomerPermission"%>
<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.GenderConstants"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="bd.gov.dgfood.common.services.model.Address"%>
<%@include file="init.jsp"%>

<%
	SalesCustomer customer = (SalesCustomer) request.getAttribute("CUSTOMER");
Address address = (Address) request.getAttribute("OFFICE_ADDRESS");
String redirect = ParamUtil.getString(request, "redirect");
System.out.println(" customer status ..... "+customer.getStatus());
%>

<dgfood-ui:alert status="<%=customer.getStatus()%>" type="alert" classPK="<%=customer.getSalesCustomerId()%>" className="<%=SalesCustomer.class.getName()%>"/>


<h3 class="subtitle">
	<dgfood-ui:message key="label-basic-information"></dgfood-ui:message>
</h3>
<clay:row>

	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-mobile-number"></dgfood-ui:message> : <span><%=customer.getMobileNumber() != null ?  customer.getMobileNumber() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-email-address"></dgfood-ui:message> : <span><%=customer.getEmailAddress() != null ?  customer.getEmailAddress() : StringPool.BLANK%></span>
	</clay:col>
	
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-title"></dgfood-ui:message> : <span><%=customer.getTitle() != null ?  customer.getTitle() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-contact-person-name"></dgfood-ui:message> : <span><%=customer.getContactPersonName()%></span>
	</clay:col>
	
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-office-name"></dgfood-ui:message> : <span><%=customer.getOfficeName()%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-contact-person-designation"></dgfood-ui:message> : <span><%=customer.getContactPersonDesignation()%></span>
	</clay:col>
	
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-organization-name"></dgfood-ui:message> : <span><%=customer.getOrganizationName()%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-organization-type"></dgfood-ui:message> : <span><%=customer.getOrganizationType()%></span>
	</clay:col>
	
	
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-gender"></dgfood-ui:message> : <span><%=GenderConstants.getGenderLabel(customer.getGender())%></span>
	</clay:col>
	<clay:col md="6" sm="6">	
	</clay:col>
		
</clay:row>

<h3 class="subtitle">
	<dgfood-ui:message key="label-office-address"></dgfood-ui:message>
</h3>
<clay:row>
<c:if test="${not empty address}">

<c:forEach items="${categories}" var="item">
    
    <c:if test="${item.getCategoryId() == address.getRegion()}">
   		 <clay:col md="6" sm="6">
			<dgfood-ui:message key="label-region-or-division"></dgfood-ui:message> : <span>${item.getTitle(themeDisplay.getLocale())}</span>
		</clay:col>
    </c:if>
    
   <c:if test="${item.getCategoryId() == address.getDistrict()}">
    	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-district-or-zilla"></dgfood-ui:message> : <span>${item.getTitle(themeDisplay.getLocale())}</span>
	</clay:col>
    </c:if>
    
     <c:if test="${item.getCategoryId() == address.getUpazilla()}">
    	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-upazilla"></dgfood-ui:message> : <span>${item.getTitle(themeDisplay.getLocale())}</span>
	</clay:col>
    </c:if>
    
     <c:if test="${item.getCategoryId() == address.getUnionOrWard()}">
    	<clay:col md="6" sm="6">
			<dgfood-ui:message key="label-union"></dgfood-ui:message> : <span>${item.getTitle(themeDisplay.getLocale())}</span>
	   </clay:col>
    </c:if>
	

</c:forEach>

	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-village-or-mohalla"></dgfood-ui:message> : <span>${address.getVillageOrRoad()}</span>
	</clay:col>
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-ward"></dgfood-ui:message> : <span>${address.getMouzaOrMoholla()}</span>
	</clay:col>
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-zip-code-or-post-code"></dgfood-ui:message> : <span>${address.getZipCode()}</span>
	</clay:col>
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-post-office"></dgfood-ui:message> : <span>${address.getPostOffice()}</span>
	</clay:col>
	<clay:col md="6" sm="6">
		<dgfood-ui:message key="label-house-address"></dgfood-ui:message> : <span>${address.getAddress()}</span>
	</clay:col>

</c:if>


</clay:row>




<c:if test="<%=customer.getStatus() == StatusConstants.STATUS_PENDING && CustomerPermission.contains(permissionChecker, scopeGroupId, CustomerConstants.REVIEW)%>">

<portlet:renderURL var="wsURL">
        <portlet:param name="mvcPath" value="/workflow_submission.jsp" />
</portlet:renderURL>


<dgfood-ui:workflow-task
 className="<%=SalesCustomer.class.getName()%>" 
 classPK="<%=customer.getSalesCustomerId() %>" 
 redirect="<%=wsURL %>" 
 />
 
</c:if>
 <aui:button  href="<%=redirect %>" value="label-back" ></aui:button>
