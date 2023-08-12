
<%@page import="bd.gov.dgfood.common.util.constants.GenderConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.MaritalStatusConstants"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="bd.gov.dgfood.common.services.model.Address"%>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="init.jsp" %>

<%
	String redirect = ParamUtil.getString(request, "redirect"); 

SalesCustomer customer = (SalesCustomer) request.getAttribute("CUSTOMER");
Address address = (Address) request.getAttribute("OFFICE_ADDRESS");

boolean disable = false;

// if(Validator.isNotNull(customer)){
// 	disable = true;
// }
%>
<portlet:actionURL name="/customer/add_entry" var="addCustomerURL">

</portlet:actionURL>

<aui:form action="${addCustomerURL }" method="post" name="fm">

<aui:input name="salesCustomerId" type="hidden" value='<%=customer == null ? 0 : customer.getSalesCustomerId()%>'/>
<aui:input name="cmd" type="hidden" value='<%=customer == null ? Constants.ADD : Constants.UPDATE%>'/>

<aui:model-context bean="<%=customer%>" model="<%=SalesCustomer.class%>" />

<liferay-ui:error message="${errorKey}" exception="<%=DataValidationException.class %>"></liferay-ui:error>

<div class="form-group ${empty userType ? '' : 'hide' }">
		<label for="user-type"> <dgfood-ui:message key="user-type"></dgfood-ui:message></label>
		<aui:select name="userType" label="" value="${userType }">
		 <aui:option value="<%=CustomerPortletKeys.CREDIT %>"><dgfood-ui:message key="credit"></dgfood-ui:message></aui:option>
		 <aui:option value="<%=CustomerPortletKeys.OTHER_PRIORITY %>"><dgfood-ui:message key="other-priority"></dgfood-ui:message></aui:option>
		</aui:select>
</div>

<div class='form-group'>
	<h3 class="subtitle">
		<dgfood-ui:message key="label-basic-information"></dgfood-ui:message>
	</h3>
	
	<clay:row>

	<clay:col md="6" sm="6">

		<label for="title"> <dgfood-ui:message key="label-title"></dgfood-ui:message></label>
		<aui:select name="title" label="" showEmptyOption="true">
		 <aui:option value="Dr"><dgfood-ui:message key="dr"></dgfood-ui:message></aui:option>
		 <aui:option value="Mr"><dgfood-ui:message key="mr"></dgfood-ui:message></aui:option>
		 <aui:option value="Ms"><dgfood-ui:message key="ms"></dgfood-ui:message></aui:option>
		 <aui:option value="Mrs"><dgfood-ui:message key="mrs"></dgfood-ui:message></aui:option>
		 
			<aui:validator name="maxLength" errorMessage="error-label-title-max-length">5</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-title-min-length">2</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-title-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z]*$");
								return regex.test(val);
							}
			</aui:validator>
		 
		</aui:select>

	</clay:col>
	<clay:col md="6" sm="6">

		<label for="contactPersonName"> <dgfood-ui:message key="label-contact-person-name"></dgfood-ui:message><span class="txt-red">*</span></label>
		<aui:input name="contactPersonName" label="" value="contact Person Name">
		   <aui:validator name="required" errorMessage="error-label-contact-person-name-required" />	
		   	<aui:validator name="maxLength" errorMessage="error-label-contact-person-name-max-length">30</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-contact-person-name-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
			</aui:validator>
		</aui:input>

	</clay:col>


	<clay:col md="6" sm="6">

		<label for=mobileNumber> <dgfood-ui:message key="label-mobile-number"></dgfood-ui:message></label>
		<aui:input name="mobileNumber" label="">
			<aui:validator name="maxLength" errorMessage="error-label-mobile-number-max-length">10</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-mobile-number-min-length">10</aui:validator>
			<aui:validator name="number" errorMessage="error-label-mobile-number-enter-valid-number"/>
		</aui:input>

	</clay:col>
	<clay:col md="6" sm="6">

		<label for="emailAddress"> <dgfood-ui:message key="label-email-address"></dgfood-ui:message></label>
		<aui:input name="emailAddress" label="">
			<aui:validator name="email" errorMessage="error-label-email-address-format"/>
			<aui:validator name="maxLength" errorMessage="error-label-email-address-max-length">30</aui:validator>
		
		</aui:input>

	</clay:col>

	<clay:col md="6" sm="6">

		<label for="officeName"> <dgfood-ui:message key="label-office-name"></dgfood-ui:message><span class="txt-red">*</span></label>
		<aui:input name="officeName" label="" value="office name">
			<aui:validator name="required" errorMessage="error-label-office-name-required" />
			<aui:validator name="maxLength" errorMessage="error-label-office-name-max-length">30</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-office-name-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
			</aui:validator>	
		</aui:input>

	</clay:col>
	
	
	<clay:col md="6" sm="6">

		<label for="contactPersonDesignation"> <dgfood-ui:message key="label-contact-person-designation"></dgfood-ui:message><span class="txt-red">*</span></label>
		<aui:input name="contactPersonDesignation" label="" value="Lieutenant colonel">
			<aui:validator name="required" errorMessage="error-label-contact-person-designation-required" />
			<aui:validator name="maxLength" errorMessage="error-label-contact-person-designation-max-length">30</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-contact-person-designation-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
			</aui:validator>		
		</aui:input>

	</clay:col>
	
	

	<clay:col md="6" sm="6">

		<label for="organizationName"> <dgfood-ui:message key="label-organization-name"></dgfood-ui:message><span class="txt-red">*</span></label>
		<aui:select name="organizationName" label="" disabled="<%=disable %>">
			<aui:validator name="required" errorMessage="error-label-organization-name-required" />
			<aui:validator name="maxLength" errorMessage="error-label-organization-name-max-length">30</aui:validator>
			<aui:option value="army"><dgfood-ui:message key="army"></dgfood-ui:message></aui:option>
			<aui:option value="airforce"><dgfood-ui:message key="air-force"></dgfood-ui:message></aui:option>
			<aui:option value="navy"><dgfood-ui:message key="navy"></dgfood-ui:message></aui:option>
			<aui:option value="police"><dgfood-ui:message key="police"></dgfood-ui:message></aui:option>
						<aui:validator name="custom" errorMessage="error-label-organization-name-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
			</aui:validator>	
		</aui:select>

	</clay:col>
	<clay:col md="6" sm="6">

		<label for="organizationType"> <dgfood-ui:message key="label-organization-type"></dgfood-ui:message><span class="txt-red">*</span></label>
		<aui:select name="organizationType" label="" disabled="<%=disable %>">
		    <aui:validator name="maxLength" errorMessage="error-label-organization-type-max-length">30</aui:validator>
			<aui:validator name="required" errorMessage="error-label-organization-type-required" />
			<aui:option value="depoA"><dgfood-ui:message key="depo A"></dgfood-ui:message></aui:option>
			<aui:option value="depoB"><dgfood-ui:message key="depo B"></dgfood-ui:message></aui:option>
			<aui:option value="depoC"><dgfood-ui:message key="depo C"></dgfood-ui:message></aui:option>
			<aui:option value="depoD"><dgfood-ui:message key="depo D"></dgfood-ui:message></aui:option>
			<aui:option value="police"><dgfood-ui:message key="police"></dgfood-ui:message></aui:option>
						<aui:validator name="custom" errorMessage="error-label-organization-type-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z0-9\\s]*$");
								return regex.test(val);
							}
			</aui:validator>	
		</aui:select>

	</clay:col>

		<clay:col md="6" sm="6">
				<label for="gender"><dgfood-ui:message key="label-gender"></dgfood-ui:message><span class="txt-red">*</span></label>
				<aui:input name="gender" type="radio" label="" value="<%=GenderConstants.GENDER_MALE %>" checked="<%= customer != null ? customer.getGender() == GenderConstants.GENDER_MALE : true %>"></aui:input><dgfood-ui:message key="label-male"></dgfood-ui:message>
				<aui:input name="gender" type="radio" label="" value="<%=GenderConstants.GENDER_FEMALE %>" checked="<%= customer != null ? customer.getGender() == GenderConstants.GENDER_FEMALE : false %>"></aui:input><dgfood-ui:message key="label-female"></dgfood-ui:message>
				<aui:input name="gender" type="radio" label="" value="<%=GenderConstants.GENDER_OTHER %>" checked="<%= customer != null ? customer.getGender() == GenderConstants.GENDER_OTHER : false %>"></aui:input><dgfood-ui:message key="label-third-gender"></dgfood-ui:message>
		</clay:col>
		<clay:col md="6" sm="6"></clay:col>


	</clay:row>
</div>



<div class='form-group'>

<dgfood-ui:basic-fields addressField="true" addressType="office"/>
</div>

<aui:button-row>
<aui:button type='submit'></aui:button>
<aui:button type="cancel" href="<%=redirect %>"></aui:button>
</aui:button-row>
</aui:form>