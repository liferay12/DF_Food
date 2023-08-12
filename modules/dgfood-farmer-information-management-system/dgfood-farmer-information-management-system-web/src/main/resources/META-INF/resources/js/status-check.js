//Global veriables
var today = new Date();
var namespace=$("#portletNamespace").val();
var selectedLanguage = themeDisplay.getLanguageId().split("_")[0];

//farmer registration form fields initialization and other event bindings 
$(document).ready(function() {

	//Set captcha as Mandatory field
	$("#"+namespace+"captchaText").addClass("validate");
	$("#"+namespace+"captchaText").addClass("isMandatory");

	//Initiate Date of Birth input fields
	$("#"+namespace+"dateOfBirth").datepicker({
		format : 'dd-mm-yyyy',
		pickTime : false,
		endDate : today,
		locale : selectedLanguage,
		language : selectedLanguage,
		autoclose:true
	}).on('changeDate',function(e) {
		var dt = new Date(e.date).getDate() + '-' + (new Date(e.date).getMonth() + 1) + '-' + new Date(e.date).getFullYear();
		console.debug("Selected Date - " + dt);
	});
	

	//Hide captcha error on change
	$("#"+namespace+"captchaText").on("change",function(){
		$("#"+namespace+"captchaInvalidError").hide();
	});
});

//Validate the Form & Captcha and on successfull validation submit the form
function submitStatusCheckForm()
{
	var	currentFormValidator;
	try {
		currentFormValidator=Liferay.Form.get(namespace+'application-status-check-form').formValidator;
	} catch (error) {
		console.error(error);
	}
	currentFormValidator.resetAllFields();
	currentFormValidator.validate();
	if(currentFormValidator.hasErrors())
	{
		try {
			currentFormValidator.focusInvalidField();
		} catch (error) {
			console.debug(error);
		}
		return false;
	}

	validateCaptcha();
}

//Validate Captcha
function validateCaptcha()
{
	var captchaText={};
    captchaText[namespace+"captchaText"]=$("#"+namespace+"captchaText").val();
	var isCaptchaValid=false;
	AUI().use('aui-io-request', function(A){
		A.io.request($("#"+namespace+"validateCaptchaURL").val(), {
			method: 'post',
			dataType: 'json',
			data: captchaText,
			on: {
				success: function(data) {
					console.debug("captcha validation response ");
					var captchaValidationResponse = this.get('responseData');
					console.debug(captchaValidationResponse);
					if(captchaValidationResponse != null){
						if(captchaValidationResponse.isCaptchaValid)
						{
							isCaptchaValid= true;
							Liferay.Form.get(namespace+'application-status-check-form').form.submit()
						}
						else
						{
							$("#"+namespace+"captchaInvalidError").show();
							isCaptchaValid= false;
						}
					}
				}
			}
		
		});
	});
	return isCaptchaValid;
}