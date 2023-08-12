<%@include file="/fglicense_registration/init.jsp"%>

<%-- <%@include file="/js/main.js"%> --%>

<%
	FGLicense fgLicense = (FGLicense) request.getAttribute("fgLicense");
%>
<portlet:actionURL var="submitUpdatedFormDataURL"
	name="<%=FoodGrainLicensePortletKeys.SUBMIT_UPDATE_FG_LICENSE_MVC_ACTION_COMMAND%>">
	<portlet:param name="fgLicenseId"
		value="<%=String.valueOf(fgLicense.getFgLicenseId())%>" />
</portlet:actionURL>

<portlet:resourceURL var="validateCaptchaURL"
	id="<%=FoodGrainLicensePortletKeys.VERIFY_CAPTCHA_MVC_RESOURCE_COMMAND%>" />
	
<style>
.application_step_hide {
	display: none
}
</style>

<aui:form name="form" action="<%=submitUpdatedFormDataURL%>" method="post"
	enctype="multipart/form-data">

	<input type="hidden" id="portletNamespace" value="<portlet:namespace/>" />
	<div class="application_step"
		id='<portlet:namespace/>basic_info'>
		<liferay-util:include page="/fglicense_profile_update/steps/basic_info.jsp"
			servletContext="<%=application%>" />
	</div>
</aui:form>

<script>
$(document).ready(function(){
	var namespace = $("#portletNamespace").val();
});	
	
//============================Field Validation Code========================//
//Will be used to Validate the Form Fields
function validateFields(currentDivId) {

	console.log("current Div "+currentDivId);
	var currentDiv = $("#<portlet:namespace/>" + currentDivId);
	var currentInputList = currentDiv.find(".validate");
		
	var currentFormValidator = Liferay.Form
	.get("<portlet:namespace/>" + "form").formValidator;
	for (i = 0; i < currentInputList.length; i++) {
		var currentInput = currentInputList[i];
		currentFormValidator.validateField(currentInput.id); 
	}
	if (currentFormValidator.hasErrors()) {
		currentFormValidator.focusInvalidField();
	}else{
		Liferay.Form.get("<portlet:namespace/>form").form.submit();
	}
}
</script>