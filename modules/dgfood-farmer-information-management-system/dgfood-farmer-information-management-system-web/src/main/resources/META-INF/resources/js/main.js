//Global veriables
var currentDiv="nid_details";
var today = new Date();
var namespace=$("#portletNamespace").val();

//farmer registration form fields initialization and other event bindings 
$(document).ready(function() {

	//Set captcha as Mandatory field
	$("#"+namespace+"captchaText").addClass("validate");
	$("#"+namespace+"captchaText").addClass("isMandatory");
	

	//Hide captcha error on change
	$("#"+namespace+"captchaText").on("change",function(){
		$("#"+namespace+"captchaInvalidError").hide();
	});
	
	//Re-Validate Confirm Password when password is changed
	$("#"+namespace+"password").on("change",function() {
		var confirmPasswordVal=$("#"+namespace+"confirmPassword").val();
		if(confirmPasswordVal!= undefined || confirmPasswordVal!= '')
		{
			var formValidator = Liferay.Form.get(namespace+"new-farmer-registration").formValidator;
			formValidator.validateField(namespace+"confirmPassword");
		}
	});
});

//Validate the requested div inputs and Enable/Diable based on the validation
function validateDivInput(validationDivId,validateCompleteDiv,liferayFormId)
{
	var validationDiv=$("#"+namespace+validationDivId);
	var validDiv=true;
	var	currentFormValidator;
	try {
		currentFormValidator=Liferay.Form.get(namespace+liferayFormId).formValidator;
	} catch (error) {
		console.error(error);
	}
	currentFormValidator.resetAllFields();
	var currentInputList=validationDiv.find(".validate");
	for (i = 0; i < currentInputList.length; i++) {
		var currentInputId=currentInputList[i].id;
		var currentInputValue=currentInputList[i].value;
		if(currentInputList[i].type=="radio")
		{
			currentInputValue=$("input[name="+currentInputList[i].name+"]:checked").val();
		}

		if(validateCompleteDiv || (currentInputValue!=undefined && currentInputValue!=''))
		{
			currentFormValidator.validateField(currentInputId);
		}
		else if($("#"+currentInputId).hasClass("isMandatory"))
		{
			validDiv=false;
		}
	}
	if(validDiv && !currentFormValidator.hasErrors())
	{
		return true;
	}
	else
	{
		if(currentFormValidator.hasErrors())
		{
			try {
				currentFormValidator.focusInvalidField();
			} catch (error) {
				console.debug(error);
			}
		}
		return false;
	}
}

//Navigate to next/previous step
function showNextOrPreviousStep(currentDivId, nextDivId, validateDiv, liferayFormId, stepCssClass, hideCssClas, syncSummaryPage)
{
	if(validateDiv && !validateDivInput(currentDivId,true, liferayFormId))
	{
		return;
	}

	if(syncSummaryPage)
	{
		$("#"+namespace+liferayFormId).find(".preview").each(function(){
			previewInputData(this);
		});
	}
	
	const list = document.querySelectorAll('.'+stepCssClass);
	Array.prototype.forEach.call(list,(e)=>{   
        e.classList.add(hideCssClas);       
	})
	
	$("#"+namespace+nextDivId).removeClass(hideCssClas);
	currentDiv=nextDivId;
}

//Preview the current input in summary  page
function previewInputData(currentInput)
{
	var currentInpuType=currentInput.type;
	var currntInputValue;
	if(currentInpuType=='text' || currentInpuType == 'number')
	{
		currntInputValue=currentInput.value;
		$("#"+currentInput.id+"_preview").html(currntInputValue);
	}
	else if((currentInpuType=='select2' || currentInpuType == 'select-one') && currentInput.value!='' && currentInput.selectedOptions.length>0)
	{
		currntInputValue=currentInput.selectedOptions[0].innerHTML.trim();
		$("#"+currentInput.id+"_preview").html(currntInputValue);
	}
	else if(currentInpuType=='radio')
	{
		currntInputValue=currentInput.value;
		$("#"+currentInput.name+"_preview").html(currntInputValue);
	}
}

//Validate Captcha
function validateCaptcha(formId)
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
							Liferay.Form.get(namespace+formId).form.submit()
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

//On Click method for National Id Validation (As per Tag-lib impl)
function validateFields(currentDiv,nexDiv)
{

}