<%@include file="/milling_dashboard/init.jsp"%>

<%-- <%@include file="/js/main.js"%> --%>

<%
	MillingLicense millingLicense = (MillingLicense) request.getAttribute("millingLicense");
%>
<portlet:actionURL var="submitDuplicateFormDataURL"
	name="<%=MillingLicensePortletKeys.SUBMIT_DUPLICATE_MILLING_MVC_ACTION_COMMAND%>">
	<portlet:param name="millingLicenseId"
		value="<%=String.valueOf(millingLicense.getMillingLicenseId())%>" />
</portlet:actionURL>
	
<style>
.application_step_hide {
	display: none
}
</style>

<aui:form name="form" action="<%=submitDuplicateFormDataURL%>" method="post"
	enctype="multipart/form-data">

	<input type="hidden" id="portletNamespace" value="<portlet:namespace/>" />
	<div class="application_step"
		id='<portlet:namespace/>duplicate_info'>
		<liferay-util:include page="/milling_dashboard/milling_duplicate/duplicate-steps/duplicate_info.jsp"
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