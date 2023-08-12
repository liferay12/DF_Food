<%@include file="../../init.jsp"%>

<h3><liferay-ui:message key="label-preview" /></h3>
<br />
<h3>
	<liferay-ui:message key="label-basic-information" />
</h3>
<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_NATIONAL_ID%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.NATIONAL_ID %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_EMAIL_ADDRESS%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.EMAIL_ADDRESS %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_MOBILE_NUMBER%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.MOBILE_NUMBER %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_DATE_OF_BIRTH%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.DATE_OF_BIRTH %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_APPLICANT_NAME%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.APPLICANT_NAME %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_FATHER_NAME%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.FATHER_NAME %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_MOTHER_NAME%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.MOTHER_NAME %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_GENDER%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.GENDER %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_MARITAL_STATUS%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.MARITAL_STATUS %>_preview'></span>
	</div>
	<div class='col-6'>
		<img id="<%=ParameterConstants.NID_PROFILE_PHOTOGRAPH + "Summary"%>" style='width: 100px; height: 100px;'></img>
	</div>
</div>


<h3>
	<liferay-ui:message key="label-trade-license-information" />
</h3>
<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_NUMBER%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TRADE_LICENSE_NUMBER %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_VALIDITY%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TRADE_LICENSE_EXPIRY_DATE %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_TAX_IDENTIFICATION_NO%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TAX_IDENTIFICATION_NUMBER %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_BUSINESS_IDENTIFICATION_NO%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_ISSUER_CODE%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TRADE_LICENSE_ISSUER_CODE %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_ISSUER_CITY%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TRADE_LICENSE_ISSUER_CITY %>_preview'></span>
	</div>
</div>

<h3>
	<liferay-ui:message key="label-trade-license-information" />
</h3>
<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_BUSINESS_NAME%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.BUSINESS_NAME %>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_BUSINESS_TYPE%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.BUSINESS_TYPE %>_preview'></span>
	</div>
	<div class='col-12'>
		<liferay-ui:message key="label-address" />:
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.REGION %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.ZILLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.UPAZILA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.CITY_METROPOLIS %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.UNION%>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.VILLAGE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.WARD %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.ZIP_CODE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.POST_OFFICE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.HOUSE_ADDRESS %>_preview'></span>
	</div>
</div>

<h3>
	<liferay-ui:message key="label-permanent-address" />
</h3>

<div class='row'>
	<div class='col-6'>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.REGION %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZILLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UPAZILA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.CITY_METROPOLIS %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UNION%>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.VILLAGE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.WARD %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZIP_CODE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.POST_OFFICE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.HOUSE_ADDRESS %>_preview'></span>
	</div>
</div>

<h3>
	<liferay-ui:message key="label-present-address" />
</h3>
<div class='row'>
	<div class='col-6'>
		<div class='col-6'>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.REGION %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.ZILLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.UPAZILA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.CITY_METROPOLIS %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.UNION%>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.VILLAGE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.WARD %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.ZIP_CODE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.POST_OFFICE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.HOUSE_ADDRESS %>_preview'></span>
	</div>
	</div>
</div>

<h3>
	<liferay-ui:message key="label-documents" />
</h3>
<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_DOCUMENT%>" />
		<span id='<portlet:namespace/><%=ParameterConstants.TRADE_LICENSE_DOCUMENT%>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_BUSINESS_IDENTIFICATION_DOCUMENT%>" />
		<span id='<portlet:namespace/><%=ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER_DOCUMENT%>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_TAX_IDENTIFICATION_DOCUMENT%>" />
		<span id='<portlet:namespace/><%=ParameterConstants.TAX_IDENTIFICATION_NUMBER_DOCUMENT%>_preview'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="<%=ParameterLabelConstants.LABEL_BANK_STATEMENT_DOCUMENT%>" />
		<span id='<portlet:namespace/><%=ParameterConstants.BANK_STATEMENT_DOCUMENT%>_preview'></span>
	</div>
</div>

<div class="col-6">
	<aui:input name="<%=ParameterConstants.ACKNOWLEDGE%>" label="" type="checkbox" cssClass="validate isMandatory">
		<aui:validator name="required" errorMessage="label-please-acknowledge" /> 
	</aui:input>
</div>

<div class="col-6">
	<liferay-captcha:captcha />
</div>

<aui:button-row>
	<aui:button id="backToTradeBusiness" type="button" cssClass="btn" value="label-back"
				onClick="showNextOrPreviousStep('preview_details','trade_business', false, 'new-food-grain-license', 'application_step', 'application_step_hide', false);" />
	<aui:button id="submitFoodGrainLicenseForm" type="button" cssClass="btn btn-primary" 
				value="label-submit" onClick="validateCaptcha('new-food-grain-license');"/>
</aui:button-row>