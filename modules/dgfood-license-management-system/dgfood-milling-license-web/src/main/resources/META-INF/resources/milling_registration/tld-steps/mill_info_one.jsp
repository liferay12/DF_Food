<%@include file="../../init.jsp"%>
<%
	String acceptedImageExtensions = "image/*";
	String acceptedmagePDFExtensions = "image/*,application/pdf";

	List<AssetCategory> divisionList = new ArrayList<AssetCategory>();

	if (Validator.isNotNull(request.getAttribute("divisionList"))) {
		divisionList = (List<AssetCategory>) request.getAttribute("divisionList");
	}
%>

<h3>
	<liferay-ui:message key="mill-operator-information"></liferay-ui:message>
</h3>

<div class="row">
	<div class="col-12">
		<label for="operateOwnMill"><liferay-ui:message key="mill-operated-by-you-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="operateOwnMill" checked="true" type="radio" label="yes" value="1"></aui:input>
		<aui:input name="operateOwnMill" type="radio" label="no" value="0"></aui:input>
	</div>

	<div class="col-12">
		<label for="millOperatingThroughThirdParty"><liferay-ui:message key="mill-operated-through-third-party-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="millOperatingThroughThirdParty" checked="true" type="radio" label="yes" value="1"></aui:input>
		<aui:input name="millOperatingThroughThirdParty" type="radio" label="no" value="0"></aui:input>
	</div>
	
	<div class="col-6">
		<label for="operatorName"><liferay-ui:message
				key="operatorName-label"></liferay-ui:message></label>
		<aui:input name="operatorName" cssClass="form-control"
			id="operatorName" label="" type="text"
			placeholder="operatorName-label" value="Ketan" maxLength="30"
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
		<label for="operatorNationalId"><liferay-ui:message
				key="operatorNationalId-label"></liferay-ui:message></label>
		<aui:input name="operatorNationalId" cssClass="form-control"
			id="operatorNationalId" label="" type="text" placeholder="operatorNationalId-label"
			value="12345678912345679" maxLength="17" minLength="13">
			<aui:validator name="custom"
				errorMessage="operatorNationalId-length-error-label">
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
		<label for="operatorRunningBusinessFromYears"><liferay-ui:message
				key="operatorRunningBusinessFromYears-label"></liferay-ui:message></label>
		<aui:input name="operatorRunningBusinessFromYears" cssClass="form-control"
			id="operatorRunningBusinessFromYears" label="" type="text" placeholder="zip-label"
			value="3" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">2</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for=operatorPhotograph><liferay-ui:message
				key="operatorphotograph-document"></liferay-ui:message></label>
		<aui:input type="file" name="operatorPhotograph" 
			accept='<%=acceptedImageExtensions%>' label="" onchange="setUploadSize(this)">
			<aui:validator name="acceptFiles">'jpg,png'</aui:validator>
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
	
	<div class="col-12">
		<label for="publicRepresentative"><liferay-ui:message key="publicRepresentative-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="publicRepresentative" checked="true" type="radio" label="yes" value="1"></aui:input>
		<aui:input name="publicRepresentative" type="radio" label="no" value="0"></aui:input>
	</div>

	<div class="col-12">
		<label for="workInGovernment"><liferay-ui:message key="work-in-goverment-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="workInGovernment" checked="true" type="radio" label="yes" value="1"></aui:input>
		<aui:input name="workInGovernment" type="radio" label="no" value="0"></aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="mill-information"></liferay-ui:message>
</h3>
<div class="row">
	<div class="col-12">
		<label for="millName"><liferay-ui:message
				key="millName-label"></liferay-ui:message></label>
		<aui:input name="millName" cssClass="form-control"
			id="millName" label="" type="text"
			placeholder="millName-label" value="Atta Chakki Mill" maxLength="30"
			minLength="1">
			<aui:validator name="maxLength"
				errorMessage="name-maxlength-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="name-minlength-error-label">1</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-3">
		<label for="millLength"><liferay-ui:message
				key="millLength-label"></liferay-ui:message></label>
		<aui:input name="millLength" cssClass="form-control"
			id="millLength" label="" type="text" placeholder="millHeight-label"
			value="15" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-3">
		<label for="millHeight"><liferay-ui:message
				key="millHeight-label"></liferay-ui:message></label>
		<aui:input name="millHeight" cssClass="form-control"
			id="millHeight" label="" type="text" placeholder="millHeight-label"
			value="20" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-3">
		<label for="millWidth"><liferay-ui:message
				key="millWidth-label"></liferay-ui:message></label>
		<aui:input name="millWidth" cssClass="form-control"
			id="millWidth" label="" type="text" placeholder="millHeight-label"
			value="17" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	<div class="col-3">
		<label for="millStorage"><liferay-ui:message
				key="millStorage-label"></liferay-ui:message></label>
		<aui:input name="millStorage" cssClass="form-control"
			id="millStorage" label="" type="text" placeholder="zip-label"
			value="500" maxLength="2" minLength="1">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">4</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">1</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-12">
		<label for="millType"><liferay-ui:message key="type-of-mill-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="millType" checked="true" type="radio" label="husking-label" value="0"></aui:input>
		<aui:input name="millType" type="radio" label="semi-automatic-label" value="1"></aui:input>
		<aui:input name="millType" type="radio" label="automatic-label" value="2"></aui:input>
	</div>

	<div class="col-12">
		<label for="millFloorPaved"><liferay-ui:message key="mill-floor-paved-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="millFloorPaved" checked="true" type="radio" label="yes" value="1"></aui:input>
		<aui:input name="millFloorPaved" type="radio" label="no" value="0"></aui:input>
	</div>
	
	<div class="col-12">
		<label for="riceType"><liferay-ui:message key="type-of-rice-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="riceType" checked="true" type="radio" label="atop" value="1"></aui:input>
		<aui:input name="riceType" type="radio" label="boiled" value="2"></aui:input>
	</div>
	
	<div class="col-6">
		<label for="incomeTaxDocument"><liferay-ui:message
				key="income-tax-document"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input type="file" name="incomeTaxDocument" 
			accept='<%=acceptedImageExtensions%>' label="" required="true" cssClass="validate"
			onchange="setUploadSize(this)">
			<aui:validator name="required" errorMessage="file-required-error-label" />
			<aui:validator name="acceptFiles">'jpg,png'</aui:validator>
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
 	
	<div class="col-6">
		<label for="signatureThumbImpression"><liferay-ui:message
				key="signature-thumb-impression-document"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input type="file" name="signatureThumbImpression" 
			accept='<%=acceptedmagePDFExtensions%>' label="" required="true" cssClass="validate"
			onchange="setUploadSize(this)">
			<aui:validator name="required" errorMessage="file-required-error-label" />
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
	
	<div class="col-6">
		<label for="tradeLicenseNumberPhotocopy"><liferay-ui:message
				key="trade-license-number-document"></liferay-ui:message></label>
		<aui:input type="file" name="tradeLicenseNumberPhotocopy" 
			accept='<%=acceptedmagePDFExtensions%>' label="" onchange="setUploadSize(this)">
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
	
	<div class="col-6">
		<label for="relevantDocument"><liferay-ui:message
				key="relevant-document"></liferay-ui:message></label>
		<aui:input type="file" name="relevantDocument" multiple="true" label=""
			onchange="setUploadSize(this)">
			<aui:validator name="acceptFiles">'jpg,png,pdf,docx'</aui:validator>
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
</div>

<h3><liferay-ui:message key="mill-address-information"></liferay-ui:message></h3>

<div class="row">
	<div class="col-6">
		<label for="millRegion"><liferay-ui:message
				key="region-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="millRegion" name="millRegion"
			onChange="populateAddressOption(this.id, 'millZilla');" label="" cssClass="validate milllevel-0">
			<aui:validator name="required" errorMessage="region-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
			<%
				for (AssetCategory divisionCategory : divisionList) {
			%>
			<aui:option value="<%=divisionCategory.getCategoryId()%>"
				label="<%=divisionCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="millZilla"><liferay-ui:message
				key="zilla-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="millZilla" name="millZilla"
			onChange="populateAddressOption(this.id,'millUpazilla');" label="" cssClass="validate milllevel-1">
			<aui:validator name="required" errorMessage="zilla-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="millUpazilla"><liferay-ui:message
				key="upazilla-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="millUpazilla" name="millUpazilla"
			onChange="populateAddressOption(this.id,'millUnion');" label="" cssClass="validate milllevel-2">
			<aui:validator name="required" errorMessage="upazilla-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="millUnion"><liferay-ui:message
				key="union-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="millUnion" name="millUnion" label=""
			onChange="populateAddressOption(this.id,'millWard');" cssClass="validate milllevel-3">
			<aui:validator name="required" errorMessage="union-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="millVillage"><liferay-ui:message
				key="village-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="millVillage" cssClass="form-control validate"
			id="millVillage" label="" type="text" placeholder="village-label"
			value="Delhi" maxLength="30" minLength="1">
			<aui:validator name="required" errorMessage="village-error-label" />
			<aui:validator name="alpha" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
			<aui:validator name="custom" errorMessage="name-character-error">
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z\\s]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<label for="millWard"><liferay-ui:message key="ward-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:select id="millWard" name="millWard" label=""
			onChange="populateAddressOption(this.id,'millPostOffice');" cssClass="validate milllevel-4">
			<aui:validator name="required" errorMessage="ward-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="millZipCode"><liferay-ui:message
				key="zip-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="millZipCode" cssClass="form-control validate"
			id="millZipCode" label="" type="text" placeholder="zip-label"
			value="479232" maxLength="6" minLength="4">
			<aui:validator name="required" errorMessage="zip-error-label" />
			<aui:validator name="maxLength"
				errorMessage="zip-maxlength-error-label">6</aui:validator>
			<aui:validator name="minLength"
				errorMessage="zip-minlength-error-label">4</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="millPostOffice"><liferay-ui:message
				key="post-office-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="millPostOffice" cssClass="form-control validate"
			id="millPostOffice" label="" type="text"
			placeholder="millPostOffice-label" value="POS273" maxLength="10"
			minLength="5">
			<aui:validator name="alphanum"/>
			<aui:validator name="required"
				errorMessage="millPostOffice-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-ten-error-label">10</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">5</aui:validator>
		</aui:input>
	</div>

	<div class="col-12">
		<label for="millAddress"><liferay-ui:message
				key="mill-address-label"></liferay-ui:message></label>
		<aui:input name="millAddress" cssClass="form-control validate"
			id="millAddress" label="" type="text"
			placeholder="mill-address-label" value="Spring Woods Lane" maxLength="50"
			minLength="10">
			<aui:validator name="required"
				errorMessage="mill-address-error-label" />
			<aui:validator name="maxLength"
				errorMessage="millAddress-maxlength-error-label">50</aui:validator>
			<aui:validator name="minLength"
				errorMessage="millAddress-minlength-error-label">10</aui:validator>
		</aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="bank-account-information"></liferay-ui:message>
</h3>

<div class="row">
	
	<div class="col-6">
		<label for="bankAccountNumber"><liferay-ui:message
				key="bankAccountNumber-label"></liferay-ui:message></label>
		<aui:input name="bankAccountNumber" cssClass="form-control"
			id="bankAccountNumber" label="" type="text" placeholder="bankAccountNumber-label"
			value="1174933923" maxLength="16" minLength="10">
			<aui:validator name="maxLength"
				errorMessage="maxlength-error-label">16</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-error-label">10</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<label for="bankAccountHolderName"><liferay-ui:message
				key="bankAccountHolderName-label"></liferay-ui:message></label>
		<aui:input name="bankAccountHolderName" cssClass="form-control"
			id="bankAccountHolderName" label="" type="text"
			placeholder="bankAccountHolderName-label" value="Ravi Teja" maxLength="30"
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
		<label for="bankName"><liferay-ui:message
				key="bankName-label"></liferay-ui:message></label>
		<aui:input name="bankName" cssClass="form-control"
			id="bankName" label="" type="text"
			placeholder="bankName-label" value="Central Bank" maxLength="30"
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
	
	<div class="col-12">
		<label for="bankBranchNameAndAddress"><liferay-ui:message
				key="bank-branch-name-address-label"></liferay-ui:message></label>
		<aui:input name="bankBranchNameAndAddress" cssClass="form-control"
			id="bankBranchNameAndAddress" label="" type="text"
			placeholder="mill-address-label" value="Complex Floor 3" maxLength="50"
			minLength="10">
			<aui:validator name="maxLength"
				errorMessage="bankAddress-maxlength-error-label">50</aui:validator>
			<aui:validator name="minLength"
				errorMessage="bankAddress-minlength-error-label">10</aui:validator>
		</aui:input>
	</div>
</div>

<aui:button-row>
	<aui:button id="backToNidInfo" value='back'
		onClick="showNextOrPreviousStep('personal_info');"></aui:button>
	<aui:button id="nextToMillInfoTwo" value='next'
		onClick="validateFields('mill_info_one','mill_info_two');"></aui:button>
</aui:button-row>