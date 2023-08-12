<%@include file="../../init.jsp"%>
<%
	FGLicense fgLicense = (FGLicense) request.getAttribute("fgLicense");
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
%>
<h3>
	<liferay-ui:message key="food-grain-license-information"></liferay-ui:message>
</h3>

<div class="row">
	<div class="col-6">
		<label for="foodGrainLicenseNumber"><liferay-ui:message
				key="foodGrainLicenseNumber-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="foodGrainLicenseNumber"
			cssClass="form-control validate" id="foodGrainLicenseNumber" label=""
			type="text" placeholder="foodGrainLicenseNumber-label"
			value="<%=fgLicense != null ? fgLicense.getFoodGrainLicenseNo() : StringPool.BLANK%>"
			maxLength="30" minLength="1">
			<aui:validator name="number" />
			<aui:validator name="required"
				errorMessage="foodGrainLicenseNumber-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<label for="foodGrainLicenseIssueDate"><liferay-ui:message
				key="foodGrainLicenseIssueDate-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="foodGrainLicenseIssueDate"
			cssClass="form-control validate" id="foodGrainLicenseIssueDate"
			label="" type="text" placeholder="foodGrainLicenseIssueDate-label"
			value="<%=fgLicense != null ? dateFormat.format(fgLicense.getFoodGrainLicenseIssueDate())
						: StringPool.BLANK%>">
			<aui:validator name="required"
				errorMessage="foodGrainLicenseIssueDate-error-label" />
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
		<label for="foodGrainLicenseValidity"><liferay-ui:message
				key="foodGrainLicenseValidity-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="foodGrainLicenseValidity"
			cssClass="form-control validate" id="foodGrainLicenseValidity"
			label="" type="text" placeholder="foodGrainLicenseValidity-label"
			value="<%=fgLicense != null ? dateFormat.format(fgLicense.getFoodGrainLicenseValidity())
						: StringPool.BLANK%>">
			<aui:validator name="required"
				errorMessage="foodGrainLicenseValidity-error-label" />
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

<h3>
	<liferay-ui:message key="spouse-related-information"></liferay-ui:message>
</h3>
<div class="row">
	
	<div class="col-12">
		<label for="maritalStatus"><liferay-ui:message key="marital-status-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="maritalStatus" checked="true" type="radio" label="marital-status-unmarried" value="1"></aui:input>
		<aui:input name="maritalStatus" type="radio" label="marital-status-married" value="2"></aui:input>
		<aui:input name="maritalStatus" type="radio" label="marital-status-divorced" value="3"></aui:input>
		<aui:input name="maritalStatus" type="radio" label="marital-status-widow" value="4"></aui:input>
		<aui:input name="maritalStatus" type="radio" label="marital-status-widower" value="5"></aui:input>
	</div>
	
	<div class="col-6">
		<label for="spouseName"><liferay-ui:message
				key="spouseName-label"></liferay-ui:message></label>
		<aui:input name="spouseName" cssClass="form-control"
			id="spouseName" label="" type="text"
			placeholder="spouseName-label" value="Neha" maxLength="30"
			minLength="1">
			<aui:validator name="maxLength"
				errorMessage="name-maxlength-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="name-minlength-error-label">1</aui:validator>
			<aui:validator name="custom" errorMessage="invalid-character-error">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
				</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<label for="spouseFatherName"><liferay-ui:message
				key="spouseFatherName-label"></liferay-ui:message></label>
		<aui:input name="spouseFatherName" cssClass="form-control"
			id="spouseFatherName" label="" type="text" placeholder="spouseFatherName-label"
			value="Mahesh" maxLength="30" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
			<aui:validator name="custom" errorMessage="invalid-character-error">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
				</aui:validator>
		</aui:input>
	</div>
	<div class="col-6">
		<label for="spouseNationalId"><liferay-ui:message
				key="spouseNationalId-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="spouseNationalId" cssClass="form-control validate"
			id="spouseNationalId" label="" type="text" placeholder="spouseNationalId-label"
			value="12345678912345678" maxLength="17" minLength="13">
			<aui:validator name="required" errorMessage="spouseNationalId-error-label" />
			<aui:validator name="custom"
				errorMessage="spouseNationalId-length-error-label">
					    function(val, fieldNode, ruleValue) {
					    	var valLength = val.length;
					    	var result = false;
							
							if(valLength == 13 || valLength == 17){
								result = true;
							}else{
								console.log("National Id must be 13 or 17 digit long.");
								result = false;
							}				
							return result;					
					    }
				</aui:validator>
			<aui:validator name="maxLength"
				errorMessage="maxlength-seventeen-error-label">17</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-thirteen-error-label">13</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>

	<div class="col-6">
		<label for="spouseDateOfBirth"><liferay-ui:message
				key="spouseDateOfBirth-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="spouseDateOfBirth" cssClass="form-control validate"
			id="spouseDateOfBirth" label="" onkeydown="return false" type="text"
			placeholder="spouseDateOfBirth-label" value="20-04-1999">
			<aui:validator name="required" errorMessage="spouseDateOfBirth-error-label" />
			<aui:validator name="custom" errorMessage="age-error-label">
					    function(val, fieldNode, ruleValue) {
					    	
					    	var parts = val.split("-");
					    	var today = new Date();
					    	var result = false;
					    	var birthDate = new Date(parts[1] + "/" + parts[0] + "/" + parts[2]);
							
							var age = today.getFullYear() - birthDate.getFullYear();
							var m = today.getMonth() - birthDate.getMonth();
							
							if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) 
							{
								age--;
							}
							if (age >= 18) {
								console.log("Age is Greater than 18");
								result = true;
							} 
							else 
							{
								console.log("Age is Less than 18");
								result = false;
							}				
							return result;					
					    }
				</aui:validator>
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

<aui:button-row>
	<aui:button id="backToDashboardView" value='back' href='#'></aui:button>
	<aui:button id="nextToMillInfoOne" value='next'
		onClick="validateFields('personal_info','mill_info_one');"></aui:button>
</aui:button-row>