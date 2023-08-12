//Global veriables

//Div Variable
var currentDiv="nid_details";
var nextDiv="basic_details";

//Date Variable
var today = new Date();

//Portlet Namespace
var namespace=$("#portletNamespace").val();

//Food Grain License Form Name
var licenseFormId=$("#licenseFormName").val();

//Show & Hide Div CSS class Name
var stepCssClassName="application_step";
var hideCssClassName="application_step_hide";


//food grain license form fields initialization and other event bindings 
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
		if(confirmPasswordVal!= undefined || confirmPasswordVal!= ''){
			var formValidator = Liferay.Form.get(namespace+"new-food-grain-license").formValidator;
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
//Validate fields
//set values to preview
function showNextOrPreviousStep(currentDivId, nextDivId, validateDiv, liferayFormId, stepCssClass, hideCssClas, syncSummaryPage)
{
	if(validateDiv && !validateDivInput(currentDivId, true, liferayFormId))
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

function validateNationalIdAndGenerateOTP(currentDivId, validateDiv, liferayFormId){
	
	if(validateDiv && !validateDivInput(currentDivId, true, liferayFormId))
	{
		return;
	}
		
	validateNationalId();
}

//Validate National ID
//On success calls GenerateOTP function in OTP TLD JSP.
function validateNationalId(){
	
	console.debug("entered...validateNationalId");
	var nidNumber=$("#"+namespace+"nationalId").val();
	var mobileNumber=$("#"+namespace+"mobileNumber").val();
	
	var validateNationalIdInfoFormJSONData={};
	validateNationalIdInfoFormJSONData[namespace+"nationalId"]=nidNumber;
	AUI().use('aui-io-request', function(A){
		A.io.request($("#"+namespace+"validateNationalIdURL").val(), {
			method: 'post',
			dataType: 'json',
			data: validateNationalIdInfoFormJSONData,
			on: {
				success: function(data) {
					console.debug("NationalId from validation response");
					var validationResponse = this.get('responseData');
					console.debug(validationResponse)
					if(validationResponse != null && !validationResponse.isNationalIdExist){
						$("#"+namespace+"nationalIdExistError").hide();
						$("#"+namespace+"nationalIdValidationInternalError").hide();
						console.debug("true");
						
						$("#"+"showModal").click();
						 
						//OTP TLD JSP Call
						callOtpFunction(mobileNumber);
					}
					else if(validationResponse != null && validationResponse.isNationalIdExist )
					{
						$("#"+namespace+"nationalIdExistError").show();
						$("#"+namespace+"nationalIdValidationInternalError").hide();
						console.debug("false");
						$('#closeModal').click();
						return false;
					}
					else
					{
						$("#"+namespace+"nationalIdValidationInternalError").show();
						console.debug("false");
						$('#closeModal').click();
						return false;
					}
				}
			}
		});
	});
}

//On click of this button in OTP TLD JSP otpResponse will get called.
//This is created to remove the tight coupling
$("#"+"verifyOtpBtn").on("click", function() {
	if(otpResponse()){
		populateNationalIDDetails();
	}
});

//Following method will be called to ge the OTP verification Response
//This works in async way
async function otpResponse() {
	let result = false;
	try{
		result = await checkOtp();
	}
	catch(error){
		console.error(error);
	}
	return result;
}


//To Fetch & Populate the Basic & Permanent Details fields in the Form.
function populateNationalIDDetails(){
	
	console.debug("entered...populateBasicDetails");
	var nidNumber=$("#"+namespace+"nationalId").val();
	var dob=$("#"+namespace+"dateOfBirth").val();
	var mobileNumber=$("#"+namespace+"mobileNumber").val();
	var populateNationalIDDetailsJSONData={};
	
	populateNationalIDDetailsJSONData[namespace+"nationalId"]=nidNumber;
	populateNationalIDDetailsJSONData[namespace+"dateOfBirth"]=dob;
	populateNationalIDDetailsJSONData[namespace+"mobileNumber"]=mobileNumber;
	
	AUI().use('aui-io-request', function(A){
		A.io.request($("#"+namespace+"populateNationalIdDetailsURL").val(), {
			method: 'post',
			dataType: 'json',
			data: populateNationalIDDetailsJSONData,
			on: {
				success: function(data) {
					var populateResponse = this.get('responseData');
					console.debug(populateResponse);
					if(populateResponse != null && populateResponse.isNationalIdValid && populateResponse.isNationalIdDetailsValid){
						$("#"+namespace+"invalidNationalIdError").hide();
						$("#"+namespace+"invalidNationalIdDetailsError").hide();
						
						var basicDetails = populateResponse.basicDetails;
						var profilePreview = populateResponse.profilePreview;
						var profileDocument = populateResponse.profileDocument;
						
						console.debug(basicDetails);
						
						//Populate Basic Details in the Form.
						if(Object.keys(basicDetails).length > 0){
							for(var key in basicDetails){
								console.debug("#"+namespace + key);
								console.debug(basicDetails[key]);
								$("#"+namespace + key).val(basicDetails[key]);
								
								$('input[name="'+namespace + key+'"]').val([basicDetails[key]]);
								$('input:radio[name='+namespace + key+']').prop("readonly", true);
							}
						}
						
						//Populate NID Photo Preview in the Form.
						if(Object.keys(profilePreview).length > 0){
							for(var key in profilePreview){
								$("#" + key + "Preview").attr("src",profilePreview[key]);
								$("#" + key + "Summary").attr("src",profilePreview[key]);
							}
						}
						
						if(Object.keys(profileDocument).length > 0){
							for(var key in profileDocument){
								$("#"+namespace + key).val(profileDocument[key]);
							}
						}
						
						//Populate Address Details in the Form.
						var addressDetails = populateResponse.addressDetails;
						
						if(Object.keys(addressDetails).length > 1){
						
							var dropdownDetails = addressDetails.dropdownDetails;
							var inputDetails = addressDetails.inputDetails;
							
							console.debug(dropdownDetails);
							console.debug(inputDetails);
							
							if(Object.keys(inputDetails).length > 0){
								for(var key in inputDetails){
									$("#"+namespace + key).val(inputDetails[key]);
									$("#"+namespace + key).prop("readonly", true);
								}
							}
							
							if(Object.keys(dropdownDetails).length > 5){
								for(var parentKey in dropdownDetails){
									var key = dropdownDetails[parentKey].key;
									var value = dropdownDetails[parentKey].value;
									console.debug(dropdownDetails[parentKey]);
									$("#"+namespace + parentKey)
									.find('option')
									.remove()
									.end()
									.append("<option selected='true' value='"+key+"'>"+ value +"</option>");
									
									//TODO: Following is not working, need to check some different approach to make the dropdown fields readonly.
									$("#"+namespace + parentKey).prop("readonly", true);
								}
							}
						}
						
						
						//Following line will close the Modal of OTP.
						$('#closeModal').click();
						
						//Following line will jump to next step in form.
						showNextOrPreviousStep(currentDiv, nextDiv, false, licenseFormId, stepCssClassName, hideCssClassName, true);
					
					}else if(populateResponse != null && !populateResponse.isNationalIdDetailsValid){
						$("#"+namespace+"invalidNationalIdDetailsError").show();
						$('#closeModal').click();
						return false;
					}else if(populateResponse != null && !populateResponse.isNationalIdValid){
						$("#"+namespace+"invalidNationalIdError").show();
						$('#closeModal').click();
						return false;
					}
				}
			}
		});
	});
}