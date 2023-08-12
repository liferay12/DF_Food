<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants"%>
<%@page import="bd.gov.dgfood.common.util.validator.DataValidationException"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.exception.FarmerRegistrationInternalErrorException"%>
<%@ include file="../init.jsp" %>

<liferay-ui:error message="${errorKey}" exception="<%=DataValidationException.class %>"></liferay-ui:error>
<liferay-ui:error message="${errorKey}" exception="<%=FarmerRegistrationInternalErrorException.class %>"></liferay-ui:error>

<portlet:actionURL var="submitFarmerRegistrationURL" 
	name="<%=FarmerInformationManagementSystemConstants.SUBMIT_FARMER_REGISTRATION_FORM_ACTION_COMMAND%>" />

<liferay-portlet:resourceURL id="<%=FarmerInformationManagementSystemConstants.VALIDATE_NATIONAL_ID__RESOURCE_COMMAND%>" 
	var="validateFarmerNationalIdURL" copyCurrentRenderParameters="false" />

<liferay-portlet:resourceURL id="<%=FarmerInformationManagementSystemConstants.VALIDATE_CAPTCHA_RESOURCE_COMMAND%>" 
	var="validateCaptchaURL" copyCurrentRenderParameters="false" />

<div id="<portlet:namespace/>nationalIdExistError" style="display: none;">
	<clay:alert message="<%=CustomLanguageUtil.get(request,"error-label-national-id-exist")%>" 
		style="danger" title="Error" />
</div>

<div id="<portlet:namespace/>nationalIdValidationInternalError" style="display: none;">
	<clay:alert message="<%=CustomLanguageUtil.get(request,"error-label-national-id-validation-internal-exception")%>" 
		style="danger" title="Error" />
</div>

<aui:form action="${submitFarmerRegistrationURL}" method="post" name="new-farmer-registration" enctype="multipart/form-data">
	
	<input type="hidden" value="<portlet:namespace/>" id="portletNamespace"/>
	<aui:input type="hidden" value="${validateFarmerNationalIdURL}" name="validateFarmerNationalIdURL"/>
	<aui:input type="hidden" value="${validateCaptchaURL}" name="validateCaptchaURL"/>
	
	<div class="fims_reg_step" id='<portlet:namespace/>nid_details' data-submit-btn="<portlet:namespace/>nextToRegistrationDetails">
	    <liferay-util:include page="/farmer-registration/steps/nid_details.jsp" servletContext="<%= application %>" />
	</div>
	
	<div class="fims_reg_step fims_reg_step_hide" id='<portlet:namespace/>other_registration_details' data-submit-btn="<portlet:namespace/>nextToSummaryPage">
	    <liferay-util:include page="/farmer-registration/steps/other_registration_details.jsp" servletContext="<%= application %>" />
	</div>
	
	<div class="fims_reg_step fims_reg_step_hide" id='<portlet:namespace/>summary_page'>
	    <liferay-util:include page="/farmer-registration/steps/summary_page.jsp" servletContext="<%= application %>" />
	</div>
	
</aui:form>  

<liferay-portlet:resourceURL id="<%=FarmerInformationManagementSystemConstants.GET_ASSET_CATEGORIES_RESOURCE_COMMAND%>" 
		var="getAssetCategoriesURL" copyCurrentRenderParameters="false" />
<aui:input type="hidden" name="getAssetCategoriesURL" value="<%=getAssetCategoriesURL%>" />


<script src="<%=request.getContextPath()%>/js/select2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/main.js?v=1.1"></script>
<script src="<%=request.getContextPath()%>/js/farmer-registration-main.js?v=1.1"></script>
<script src="<%=request.getContextPath()%>/js/farmer-registration-test-script.js?v=1.1"></script>
