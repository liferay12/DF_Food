<%@include file="../init.jsp"%>

<style>
.application_step_hide {
	display: none
}
</style>

<liferay-ui:error message="${errorKey}" exception="<%=DataValidationException.class %>"></liferay-ui:error>

<portlet:actionURL var="submitFoodGrainLicenseURL" 
	name="<%=FoodGrainLicensePortletKeys.SUBMIT_NEW_FG_LICENSE_MVC_ACTION_COMMAND%>" />

<liferay-portlet:resourceURL id="<%=FoodGrainLicensePortletKeys.POPULATE_NATIONAL_ID_DETAILS_MVC_RESOURCE_COMMAND%>" 
	var="populateNationalIdDetailsURL" copyCurrentRenderParameters="false" />

<liferay-portlet:resourceURL id="<%=FoodGrainLicensePortletKeys.VALIDATE_NATIONAL_ID_RESOURCE_COMMAND%>" 
	var="validateNationalIdURL" copyCurrentRenderParameters="false" />

<liferay-portlet:resourceURL id="<%=FoodGrainLicensePortletKeys.VERIFY_CAPTCHA_MVC_RESOURCE_COMMAND%>" 
	var="validateCaptchaURL" copyCurrentRenderParameters="false" />

<div id="<portlet:namespace/>nationalIdExistError" style="display: none;">
	<clay:alert message="error-label-national-id-exist"  style="danger" title="Error" />
</div>

<div id="<portlet:namespace/>nationalIdValidationInternalError" style="display: none;">
	<clay:alert message="error-label-national-id-validation-internal-exception" style="danger" title="Error" />
</div>

<div id="<portlet:namespace/>invalidNationalIdError" style="display: none;">
	<clay:alert message="error-label-national-id-invalid"  style="danger" title="Error" />
</div>

<div id="<portlet:namespace/>invalidNationalIdDetailsError" style="display: none;">
	<clay:alert message="error-label-national-id-details-invalid"  style="danger" title="Error" />
</div>
	
<aui:form name="new-food-grain-license" action="<%=submitFoodGrainLicenseURL%>" method="post" enctype="multipart/form-data">

	<input type="hidden" id="portletNamespace" value="<portlet:namespace/>" />
	<input type="hidden" id="licenseFormName" value="new-food-grain-license" />
	<aui:input type="hidden" value="${validateNationalIdURL}" name="validateNationalIdURL"/>
	<aui:input type="hidden" value="${validateCaptchaURL}" name="validateCaptchaURL"/>
	<aui:input type="hidden" value="${populateNationalIdDetailsURL}" name="populateNationalIdDetailsURL"/>

	<div class="application_step" id='<portlet:namespace/>nid_details'>
		<liferay-util:include page="/jsp/fglicense_application/steps/nid_details.jsp" servletContext="<%=application%>" />
	</div>

	<div class="application_step_hide application_step" id='<portlet:namespace/>basic_details'>
		<liferay-util:include page="/jsp/fglicense_application/steps/basic_details.jsp" servletContext="<%=application%>" />
	</div>
	
	<div class="application_step_hide application_step" id='<portlet:namespace/>trade_business'>
		<liferay-util:include page="/jsp/fglicense_application/steps/trade_business.jsp" servletContext="<%=application%>" />
	</div>
	
	<div class="application_step_hide application_step" id='<portlet:namespace/>preview_details'>
		<liferay-util:include page="/jsp/fglicense_application/steps/preview_details.jsp" servletContext="<%=application%>" />
	</div>
	
</aui:form>

<liferay-portlet:resourceURL id="<%=FoodGrainLicensePortletKeys.GET_ASSET_CATEGORIES_RESOURCE_COMMAND%>" 
		var="getAssetCategoriesURL" copyCurrentRenderParameters="false" />
<aui:input type="hidden" name="getAssetCategoriesURL" value="<%=getAssetCategoriesURL%>" />

<script src="<%=request.getContextPath()%>/js/main.js?v=1.1"></script>
<script src="<%=request.getContextPath()%>/js/fglicense-application.js?v=1.1"></script>
<script src="<%=request.getContextPath()%>/js/test-script.js?v=1.1"></script>