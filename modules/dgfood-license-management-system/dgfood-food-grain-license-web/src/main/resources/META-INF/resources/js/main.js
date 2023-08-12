//Will Be used for common JS.
//Global veriables
var currentDiv="nid_details";
var today = new Date();
var namespace=$("#portletNamespace").val();

//farmer registration form fields initialization and other event bindings 
$(document).ready(function() {
	alert("Hey Buddy...");

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

	//Update the input values in Preview/summary page
	$("#"+namespace+'new-food-grain-license').find(".preview").on("change",function(){
		var currentInpuType=this.type;
		var currntInputValue;
		if(currentInpuType=='text' || currentInpuType == 'number')
		{
			currntInputValue=this.value;
			$("#"+this.id+"_preview").html(currntInputValue);
		}
		else if((currentInpuType=='select2' || currentInpuType == 'select-one') && this.selectedOptions.length>0)
		{
			currntInputValue=this.selectedOptions[0].innerHTML.trim();
			$("#"+this.id+"_preview").html(currntInputValue);
		}
		else if(currentInpuType=='radio')
		{
			currntInputValue=this.value;
			$("#"+this.name+"_preview").html(currntInputValue);
		}
	});
});

//Validate the requested div inputs and Enable/Diable based on the validation
function validateDivInput(validationDivId,validateCompleteDiv)
{
	var validationDiv=$("#"+namespace+validationDivId);
	var validDiv=true;
	var	currentFormValidator;
	try {
		currentFormValidator=Liferay.Form.get(namespace+'new-food-grain-license').formValidator;
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
function showNextOrPreviousStep(currentDivId, nextDivId)
{
	if(currentDivId!=undefined && currentDivId!='' && !validateDivInput(currentDivId,true))
	{
		return;
	}
	
	const list = document.querySelectorAll('.application_step');
	Array.prototype.forEach.call(list,(e)=>{   
        e.classList.add('application_step_hide');       
	})
	
	$("#"+namespace+nextDivId).removeClass("application_step_hide");
	currentDiv=nextDivId;
}

//Validate and retrieve data from NID Server

$("#"+namespace+"nextToBasicInfo").on("click",function(){
	validateNationalId();
});

function validateNationalId()
{
	var mobileNumber=$("#"+namespace+"mobileNumber").val();
	var dob=$("#"+namespace+"dateOfBirth").val();
	var nidNumber=$("#"+namespace+"nationalId").val();
	var validateNationalIdInfoFormJSONData={};
	validateNationalIdInfoFormJSONData[namespace+"nationalId"]=nidNumber;
	validateNationalIdInfoFormJSONData[namespace+"dateOfBirth"]=dob;
	validateNationalIdInfoFormJSONData[namespace+"mobileNumber"]=mobileNumber;
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
					if(validationResponse != null && !validationResponse.isNationalIdExist ){

						$("#"+namespace+"nationalIdExistError").hide();
						$("#"+namespace+"nationalIdValidationInternalError").hide();
					}
					else if(validationResponse != null && validationResponse.isNationalIdExist )
					{
						$("#"+namespace+"nationalIdExistError").show();
						$("#"+namespace+"nationalIdValidationInternalError").hide();
					}
					else
					{
						$("#"+namespace+"nationalIdValidationInternalError").show();
					}

				}
			}
		
		});
	});
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
							Liferay.Form.get(namespace+'new-food-grain-license').form.submit()
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

$("#populateProfileDetails").click(function(){
	populateProfileDetails();
})
function populateProfileDetails(){
	
	console.log("entered...");
	
	var tradeLicenseNumber=$("#"+namespace+"tradeLicenseNumber").val();
	var applicationNumber=$("#"+namespace+"applicationNumber").val();
	var populateProfileDetailsJSONData={};
	populateProfileDetailsJSONData[namespace+"tradeLicenseNumber"]=tradeLicenseNumber;
	populateProfileDetailsJSONData[namespace+"applicationNumber"]=applicationNumber;
	AUI().use('aui-io-request', function(A){
		A.io.request($("#"+namespace+"populateProfileDetailsURL").val(), {
			method: 'post',
			dataType: 'json',
			data: populateProfileDetailsJSONData,
			on: {
				success: function(data) {
					var populateResponse = this.get('responseData');
					console.log(populateResponse);
					if(populateResponse != null && !populateResponse.isTradeLicenseNumberMatched){
						$("#"+namespace+"profileDetails").hide();
						$("#"+namespace+"licenseDetails").hide();
						$("#"+namespace+"enteredTradeLicenseError").show();
					}else if(populateResponse != null && populateResponse.isTradeLicenseNumberMatched){
						$("#"+namespace+"enteredTradeLicenseError").hide();
						var profile = populateResponse.profileObject;
						var profileAttachment = populateResponse.profileAttachment;
						var license = populateResponse.licenseObject;
						
						for(var key in profile){
							console.log(key + " - " + profile[key]);
							$("#"+namespace + key +"_preview").text(profile[key]);
						}
						
						console.log(license);
						
						if(license.length > 0){
							$("#"+namespace+"licenseDetails").show();
							for(var key in license){
								$("#"+namespace + key +"_preview").text(license[key]);
							}
						}
						
						for(var key in profileAttachment){
							if(profileAttachment[key] == "true"){
								console.log(key + " - " + profileAttachment[key]);
								$("#"+namespace + key +"_preview").attr('checked', true);
							}
						}
						$("#"+namespace+"profileDetails").show();
					}
				}
			}
		});
	});
	 
}

function populateBusinessDetails(applicationNumber, populateBusinessDetailsURL){
	
	console.log("entered...");
	console.log(applicationNumber);
	console.log(populateBusinessDetailsURL);
	var appNo = applicationNumber;
	var populateBusinessDetailsJSONData={};
	populateBusinessDetailsJSONData[namespace+"applicationNumber"]=appNo;
	AUI().use('aui-io-request', function(A){
		A.io.request(populateBusinessDetailsURL, {
			method: 'post',
			dataType: 'json',
			data: populateBusinessDetailsJSONData,
			on: {
				success: function(data) {
					var populateResponse = this.get('responseData');
					console.log(populateResponse);
					if(populateResponse != null && !populateResponse.isDetailsPresent){
						$("#"+namespace+"businessDetails").hide();
					}else if(populateResponse != null && populateResponse.isDetailsPresent){
						var business = populateResponse.businessObject;
						for(var key in business){
							$("#"+namespace + key +"_preview").text(business[key]);
						}
						$("#"+namespace+"businessDetails").show();
					}
				}
			}
		});
	});
}


$("#"+namespace+"myParah").click(function(){
	  alert("The paragraph was clicked.");
	});


