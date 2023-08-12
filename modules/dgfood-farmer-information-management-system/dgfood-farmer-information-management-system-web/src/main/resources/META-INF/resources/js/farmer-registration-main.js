$(document).ready(function() {

	//Update the input values in Preview/summary page
	$("#"+namespace+'new-farmer-registration').find(".preview").on("change",function(){
		previewInputData(this);
	});
});

//Validate and retrieve data from National Id Server
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
		A.io.request($("#"+namespace+"validateFarmerNationalIdURL").val(), {
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