<%@include file="/milling_registration/init.jsp"%>

<%-- <%@include file="/js/main.js"%> --%>
<%
	FGLicense fgLicense = (FGLicense) request.getAttribute("fgLicense");
%>	

<portlet:actionURL var="submitFormDataURL"
	name="<%=MillingLicensePortletKeys.SUBMIT_NEW_MILLING_MVC_ACTION_COMMAND%>">
	<portlet:param name="foodGrainLicenseId" value="<%=String.valueOf(fgLicense.getFgLicenseId())%>" />
</portlet:actionURL>

<portlet:resourceURL var="validateCaptchaURL"
	id="<%=MillingLicensePortletKeys.VERIFY_CAPTCHA_MVC_RESOURCE_COMMAND%>" />
	
<style>
.application_step_hide {
	display: none
}
</style>

<aui:form name="form" action="<%=submitFormDataURL%>" method="post"
	enctype="multipart/form-data">

	<input type="hidden" id="portletNamespace" value="<portlet:namespace/>" />
	
	<div class="application_step"
		id='<portlet:namespace/>personal_info'>
		<liferay-util:include page="/milling_registration/tld-steps/personal_info.jsp"
			servletContext="<%=application%>" />
	</div>
	
	<div class="application_step_hide application_step"
		id='<portlet:namespace/>mill_info_one'>
		<liferay-util:include page="/milling_registration/tld-steps/mill_info_one.jsp"
			servletContext="<%=application%>" />
	</div>
	
	<div class="application_step_hide application_step"
		id='<portlet:namespace/>mill_info_two'>
		<liferay-util:include page="/milling_registration/tld-steps/mill_info_two.jsp"
			servletContext="<%=application%>" />
	</div>
	<div class="application_step_hide application_step"
		id='<portlet:namespace/>preview_info'>
		<liferay-util:include page="/milling_registration/tld-steps/preview_info.jsp"
			servletContext="<%=application%>" />
	</div>
</aui:form>

<script>
$(document).ready(function(){
	var namespace = $("#portletNamespace").val();
});	

//============================Navigation Next & Previous Code========================//
//Will be used to go to Next Step or Previous Step
function showNextOrPreviousStep(id){
	   console.log('id',id);
	   const list = document.querySelectorAll('.application_step');
	  
	   Array.prototype.forEach.call(list,(e)=>{   
	        e.classList.add('application_step_hide');       
	   })
	   
	   document.getElementById("<portlet:namespace/>" + id).classList.remove('application_step_hide');
	}
	
//============================Field Validation Code========================//
//Will be used to Validate the Form Fields
function validateFields(currentDivId, nextDivId) {

	console.log("current Div "+currentDivId);
	
	var currentDiv = $("#<portlet:namespace/>" + currentDivId);
	var currentInputList = currentDiv.find(".validate");
	
	//To get the captchaText input field and add it into the currentInputList for validation.
	var captchaInput = currentDiv.find("input[name=<portlet:namespace/>captchaText]");
	if(captchaInput.length > 0 && captchaInput.length < 2){
		currentInputList.push(captchaInput[0]);
	}
	
	var currentFormValidator = Liferay.Form
	.get("<portlet:namespace/>" + "form").formValidator;
	for (i = 0; i < currentInputList.length; i++) {
		var currentInput = currentInputList[i];
		currentFormValidator.validateField(currentInput.id); 
	}
	if (currentFormValidator.hasErrors()) {
		currentFormValidator.focusInvalidField();
	} else {
		if(captchaInput.length > 0 && !captchaInput.val() == ''){
			captchaValidation(captchaInput, nextDivId);
		}else{
			showNextOrPreviousStep(nextDivId);
		}
	}
}

//============================Captcha Validation Code========================//
//Will be used to Validate the Captcha text
function captchaValidation(input, nextDivId){
		
	var isCaptchaValid = false;
	var captchaText={};
    captchaText["<portlet:namespace/>captchaText"] = input.val();
	AUI().use('aui-io-request', function(A){
		A.io.request('<%=validateCaptchaURL%>', {
		    method: 'post',
			dataType: 'json',
			data: captchaText,
			on: {
				success: function(data) {
					console.log("captcha validation response ");
					var captchaValidationResponse = this.get('responseData');
					console.log(captchaValidationResponse);
					if(captchaValidationResponse != null){
						var isCaptchaValid=captchaValidationResponse.isCaptchaValid;
						if(isCaptchaValid){
							console.log("Captcha Validation Successful.");
							console.log("nextDivId "+nextDivId);
							if(nextDivId == "final_step"){
								Liferay.Form.get("<portlet:namespace/>form").form.submit();
							}else{
								showNextOrPreviousStep(nextDivId);
							}
						}else{
							console.log("Captcha Validation Unsuccessful.");
						}
					}
				}
			}
		});
	});
}

//File Size Check and Image preview set
var uploadSize=true;
function setUploadSize(fileInput)
{	

  console.log("Set Upload Size...");
  var size=0;
  var htmlData = $(".multipleDocs").html();
 
  var multiple = $("#"+fileInput.id).attr('multiple');
  console.log(multiple);
  if(multiple == "multiple"){
	  htmlData = "";
  }
  
  for(var num1=0; num1<fileInput.files.length; num1++) 
  {
	  var file= fileInput.files[num1];
	  var fileExt = file.name.split('.').pop();
	  console.log("File Extension - "+fileExt);
	  var id = fileInput.id + "Img";
	  var idLink = fileInput.id + "Link";
	  var idRemoveDiv = fileInput.id + "RemoveDiv";
	  
	  console.log("File Name - "+file.name+" File Size - "+file.size+" fileInput.id"+fileInput.id);
	 
	 if(file.size>2000000){
    	  uploadSize=false;
    	}else{
    		 uploadSize=true;
    		 if(multiple == "multiple"){
    			 
        		$("#"+id+num1).on('change', function(){
        			URL.revokeObjectURL($("#"+id).attr("src"));
        		});
        		
        		if(fileExt == "pdf"){
        			htmlData = htmlData + "<a href='"+URL.createObjectURL(file)+"' target='_blank' ><img id='<portlet:namespace/>"+id+num1+"' src='<%=request.getContextPath()%>/images/pdf.png' style='width:147px;height:195px;'></img></a>";
        		}else if(fileExt == "docx"){
        			htmlData = htmlData + "<a href='"+URL.createObjectURL(file)+"' target='_blank' download='"+file.name+"' ><img id='<portlet:namespace/>"+id+num1+"' src='<%=request.getContextPath()%>/images/docx.jpg' style='width:147px;height:195px;'></img></a>";
        		}else{
        			htmlData = htmlData + "<a href='"+URL.createObjectURL(file)+"' target='_blank' ><img id='<portlet:namespace/>"+id+num1+"' src='"+URL.createObjectURL(file)+"' style='width:200px;height:200px;'></img></a>";
        		}
    			 
    		 }else{
    			 
    			 if(fileExt == "docx"){
    				 $("#"+idLink).attr("href", URL.createObjectURL(file)).attr("download", URL.createObjectURL(file));
    			 }else{
    				 $("#"+idLink).attr("href", URL.createObjectURL(file));
    			 }
    			 
    			 if(fileExt == "pdf"){
    				 $("#"+id).attr("src", '<%=request.getContextPath()+"/images/pdf.png"%>');
    			 }else if(fileExt == "docx"){
    				 $("#"+id).attr("src", '<%=request.getContextPath()+"/images/docx.jpg"%>');
    			 }else{
    				 $("#"+id).attr("src", URL.createObjectURL(file));
    			 }
    			 
        		 $("#"+id).on('change', function(){
        			 
        			 URL.revokeObjectURL($("#"+idLink).attr("href"));
        			 URL.revokeObjectURL($("#"+id).attr("src"));
        		 });
    		 }
    		 $("#"+idRemoveDiv).show();
    	}
	 size+=file.size;
  }
  $(".multipleDocs").html(htmlData);
}

//============================Address Population Code========================//

function populateAddressOption(currentDropdownId, nextDropdownId) {

var classNames = $('#<portlet:namespace/>'+nextDropdownId).attr("class").split(" ");

for(var num = 0; num < classNames.length; num++){
	var clsName = classNames[num];
	if(clsName.includes("level")){
		var addressType = clsName.split("-")[0];
		var level = clsName.split("-")[1];
		var maxlevel = 5;
		emptyDropdown(addressType,level, maxlevel);
	}
}

var address=[];
var currentDropdownValue = $("#"+currentDropdownId).val();
var langid = themeDisplay.getLanguageId();
if(currentDropdownValue !="" || currentDropdownValue != null){
	
	 return AUI().use('aui-io-request', function(A){
		A.io.request(themeDisplay.getPortalURL()+'/o/tld/get-all-categories', {
			method: 'get',
			dataType: 'json',
			data:{
				categoryId: currentDropdownValue,
				languageId: langid
			  },
			on: {
			success: function(data) {

			var dataObj = this.get('responseData');
			if(dataObj != null){

				address = dataObj["options"];

				$(address).each(function(val, key) {
					$('#<portlet:namespace/>'+nextDropdownId).append("<option value='" + key.id + "'>" + key.name + "</option>");
				});
			}
		}
		}
		});
	});
}
}

//============================Empty Address Fields Code========================//

function emptyDropdown(addressType, level, maxlevel) {
	
	for(var num = level; num <= maxlevel; num++){
		$('.'+addressType+'-'+num)
		.find('option')
		.remove()
		.end()
		.append('<option selected="true" value=""><liferay-ui:message key="select-label" /></option>');
	}
}
</script>