<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@include file="../../init.jsp"%>
<%
	String acceptedImageExtensions = "image/*";
	String acceptedmagePDFExtensions = "image/*,application/pdf";
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");s
	MillingLicense millingLicense = (MillingLicense) request.getAttribute("millingLicense");
%>
<h3>
	<liferay-ui:message key="milling-license-renewal-label"></liferay-ui:message>
</h3>

<div class="row">
	<div class="col-6">
		<label for="millingLicenseNumber"><liferay-ui:message
				key="millingLicenseNumber-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="millingLicenseNumber" cssClass="form-control validate"
			id="millingLicenseNumber" label="" type="text"
			placeholder="millingLicenseNumber-label" value="<%=millingLicense != null ? millingLicense.getMillingLicenseNumber() : StringPool.BLANK%>" maxLength="30"
			minLength="1">
			<aui:validator name="number" />
			<aui:validator name="required"
				errorMessage="millingLicenseNumber-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="millingLicenseValidity"><liferay-ui:message
				key="millingLicenseValidity-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="millingLicenseValidity"
			cssClass="form-control validate" id="millingLicenseValidity" label=""
			type="text" placeholder="millingLicenseValidity-label"
			value="<%=millingLicense != null && millingLicense.getMillingLicenseExpiryDate() != null ? dateFormat.format(millingLicense.getMillingLicenseExpiryDate()) : StringPool.BLANK%>">
			<aui:validator name="required"
				errorMessage="millingLicenseValidity-error-label" />
			<aui:validator name="custom" errorMessage="date-error-label">
						    function(val, fieldNode, ruleValue) {
						    	
						    	var parts = val.split("-");
						    	var selectedDate = new Date(parts[1] + "/" + parts[0] + "/" + parts[2]);
								
								if(parts[1]=="" || parts[0]=="" || parts[2]=="" ){			
									return false;
								}else{
									if(parts[1] > 12 && parts[0] > 31){
										return false;
									}
									if(parts[2].length!=4){
										return false;
									}else if(parts[0].length!=2 && parts[1].length!=2){
										return false;
									}
									return true;
								}					
						    }
					</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="tradeLicenseNumber"><liferay-ui:message
				key="tradeLicenseNo-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="tradeLicenseNumber" cssClass="form-control validate"
			id="tradeLicenseNumber" label="" type="text"
			placeholder="tradeLicenseNo-label" value="" maxLength="30"
			minLength="1">
			<aui:validator name="alphanum" />
			<aui:validator name="required"
				errorMessage="tradeLicenseNumber-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="tradeLicenseValidity"><liferay-ui:message
				key="tradeLicenseValidity-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="tradeLicenseValidity"
			cssClass="form-control validate" id="tradeLicenseValidity" label=""
			type="text" placeholder="tradeLicenseValidity-label" value="">
			<aui:validator name="required"
				errorMessage="tradeLicenseValidity-error-label" />
			<aui:validator name="custom" errorMessage="date-error-label">
						    function(val, fieldNode, ruleValue) {
						    	
						    	var parts = val.split("-");
						    	var selectedDate = new Date(parts[1] + "/" + parts[0] + "/" + parts[2]);
								
								if(parts[1]=="" || parts[0]=="" || parts[2]=="" ){			
									return false;
								}else{
									if(parts[1] > 12 && parts[0] > 31){
										return false;
									}
									if(parts[2].length!=4){
										return false;
									}else if(parts[0].length!=2 && parts[1].length!=2){
										return false;
									}
									return true;
								}					
						    }
					</aui:validator>
		</aui:input>
	</div>
</div>

<div class="row">
	<div class="col-6">
		<label for="tradeLicenseNumberPhotocopy"><liferay-ui:message
				key="trade-license-number-document"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input type="file" name="tradeLicenseNumberPhotocopy"
			accept='<%=acceptedmagePDFExtensions%>' label="" required="true"
			cssClass="validate" onchange="setUploadSize(this)">
			<aui:validator name="required"
				errorMessage="file-required-error-label" />
			<aui:validator name="acceptFiles">'jpg,png,pdf'</aui:validator>
			<aui:validator name="custom" errorMessage="file-size-error-label">
				function(val,node,junction){
					if(uploadSize==true){
						return true;
					}else{
						return false;
					}
				}
			</aui:validator>
		</aui:input>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="trade-license-number-document"></liferay-ui:message>
		<a id="<portlet:namespace/>tradeLicenseNumberPhotocopyLink" href="" target="_blank" >
			<img id="<portlet:namespace/>tradeLicenseNumberPhotocopyImg"></img>
		</a>
	</div>
</div>
<div class="row">
	<div class="col-6">
		<label for="comments"><liferay-ui:message
				key="comments-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="comments" cssClass="form-control validate"
			id="comments" label="" type="textarea"
			placeholder="comments-label" value="" maxLength="500"
			minLength="1">
			<aui:validator name="alphanum" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-five-hundred-error-label">500</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">0</aui:validator>
		</aui:input>
	</div>
</div>
<aui:button-row>
	<aui:button id="backToSigleView" value='back' href='#'></aui:button>
	<aui:button id="submitDetails" value='submit-request'
		onClick="validateFields('renewal_info');"></aui:button>
</aui:button-row>
<script>
$(document).ready(function(){

	//To remove the error text even after the value has been updated in dropdown.
	var helper = "Helper";
	  $("#<portlet:namespace/>reasonOfDuplicateLicense").on('change', function(){
		  var value = $("#<portlet:namespace/>reasonOfDuplicateLicense").val();
		  if(value!=""){
			  $("#<portlet:namespace/>reasonOfDuplicateLicense"+ helper).remove();
		  }
	  });

	  // Initialize select2 for all the populate dropdowns
	  $("#<portlet:namespace/>reasonOfDuplicateLicense").select2({
		  width: "100%"
	  });
});
	 
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
		 
		 if(file.size>5242880){
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
	
	//============================Remove File Code========================//
	function removeFile(input){
		var id = input.replace("Remove", "");
		var fileInput = $("#"+id).val('');
		$("#"+input+"Div").hide();
		$("#"+id + "Link").attr("href",'');
		$("#"+id + "Img").attr("src",'');
		/* URL.revokeObjectURL($("#"+id + "Link").attr("href"));
		URL.revokeObjectURL($("#"+id + "Img").attr("src")); */
	}
	
	//============================DatePicker Code========================//

	var selectedLanguage = themeDisplay.getLanguageId().split("_")[0];
	var today = new Date();
	$("#<portlet:namespace/>tradeLicenseValidity").datepicker({
		format : 'dd-mm-yyyy',
		pickTime : false,
		startDate : today,
		locale : selectedLanguage,
		language : selectedLanguage,
		autoclose:true
	}).on('changeDate',function(e) {
		var dt = new Date(e.date).getDate() + '-' + (new Date(e.date).getMonth() + 1) + '-' + new Date(e.date).getFullYear();
		console.log("Selected Date - " + dt);
	});

</script>