<%@include file="../../init.jsp"%>
<%
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	String acceptedImageExtensions = "image/*";
	String acceptedmagePDFExtensions = "image/*,application/pdf";

	List<AssetCategory> divisionList = new ArrayList<AssetCategory>();
	List<AssetCategory> permanantZillaList = new ArrayList<AssetCategory>();
	List<AssetCategory> permanantUpazillaList = new ArrayList<AssetCategory>();
	List<AssetCategory> permanantUnionList = new ArrayList<AssetCategory>();
	List<AssetCategory> permanantWardList = new ArrayList<AssetCategory>();

	List<AssetCategory> presentZillaList = new ArrayList<AssetCategory>();
	List<AssetCategory> presentUpazillaList = new ArrayList<AssetCategory>();
	List<AssetCategory> presentUnionList = new ArrayList<AssetCategory>();
	List<AssetCategory> presentWardList = new ArrayList<AssetCategory>();

	if (Validator.isNotNull(request.getAttribute("divisionList"))) {
		divisionList = (List<AssetCategory>) request.getAttribute("divisionList");
	}

	FGLicense fgLicense = (FGLicense) request.getAttribute("fgLicense");
	Address permanantAddress = (Address) request.getAttribute("permanantAddress");
	Address presentAddress = (Address) request.getAttribute("presentAddress");
	HashMap<String,Attachment> attachmentEntryMap = (HashMap<String,Attachment>) request.getAttribute("attachmentEntryMap");

	if (Validator.isNotNull(request.getAttribute("permanantZillaList"))) {
		permanantZillaList = (List<AssetCategory>) request.getAttribute("permanantZillaList");
	}

	if (Validator.isNotNull(request.getAttribute("permanantUpazillaList"))) {
		permanantUpazillaList = (List<AssetCategory>) request.getAttribute("permanantUpazillaList");
	}

	if (Validator.isNotNull(request.getAttribute("permanantUnionList"))) {
		permanantUnionList = (List<AssetCategory>) request.getAttribute("permanantUnionList");
	}

	if (Validator.isNotNull(request.getAttribute("permanantWardList"))) {
		permanantWardList = (List<AssetCategory>) request.getAttribute("permanantWardList");
	}

	if (Validator.isNotNull(request.getAttribute("presentZillaList"))) {
		presentZillaList = (List<AssetCategory>) request.getAttribute("presentZillaList");
	}

	if (Validator.isNotNull(request.getAttribute("presentUpazillaList"))) {
		presentUpazillaList = (List<AssetCategory>) request.getAttribute("presentUpazillaList");
	}

	if (Validator.isNotNull(request.getAttribute("presentUnionList"))) {
		presentUnionList = (List<AssetCategory>) request.getAttribute("presentUnionList");
	}

	if (Validator.isNotNull(request.getAttribute("presentWardList"))) {
		presentWardList = (List<AssetCategory>) request.getAttribute("presentWardList");
	}
%>
<h3>
	<liferay-ui:message key="basic-information"></liferay-ui:message>
</h3>
<div class="row">
	<div class="col-6">
		<label for="applicantName"><liferay-ui:message
				key="applicantName-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="applicantName" cssClass="form-control validate"
			id="applicantName" label="" type="text"
			placeholder="applicantName-label"
			value="<%=fgLicense != null ? fgLicense.getApplicantName() : StringPool.BLANK%>"
			maxLength="30" minLength="1" readOnly="readOnly">
			<aui:validator name="required"
				errorMessage="applicantName-error-label" />
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
		<label for="fatherName"><liferay-ui:message
				key="fatherName-label"></liferay-ui:message></label>
		<aui:input name="fatherName" cssClass="form-control validate"
			id="fatherName" label="" type="text" placeholder="fatherName-label"
			readOnly="readOnly"
			value="<%=fgLicense != null ? fgLicense.getFatherName() : StringPool.BLANK%>"
			maxLength="30" minLength="1">
			<aui:validator name="required" errorMessage="fatherName-error-label" />
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
		<label for="motherName"><liferay-ui:message
				key="motherName-label"></liferay-ui:message></label>
		<aui:input name="motherName" cssClass="form-control validate"
			id="motherName" label="" type="text" placeholder="motherName-label"
			readOnly="readOnly"
			value="<%=fgLicense != null ? fgLicense.getMotherName() : StringPool.BLANK%>"
			maxLength="30" minLength="1">
			<aui:validator name="required" errorMessage="motherName-error-label" />
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
		<label for="gender"><liferay-ui:message key="gender-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="gender" checked="true" type="radio"
			label="gender-male" value="0"></aui:input>
		<aui:input name="gender" type="radio" label="gender-female" value="1"></aui:input>
		<aui:input name="gender" type="radio" label="gender-other" value="2"></aui:input>
	</div>

	<div class="col-6">
		<label for="maritalStatus"><liferay-ui:message
				key="marital-status-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="maritalStatus" checked="true" type="radio"
			label="marital-status-unmarried" value="0"></aui:input>
		<aui:input name="maritalStatus" type="radio"
			label="marital-status-married" value="1"></aui:input>
		<aui:input name="maritalStatus" type="radio"
			label="marital-status-divorced" value="2"></aui:input>
		<aui:input name="maritalStatus" type="radio"
			label="marital-status-widow" value="3"></aui:input>
		<aui:input name="maritalStatus" type="radio"
			label="marital-status-widower" value="4"></aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="permanent-address-information"></liferay-ui:message>
</h3>
<div class="row">
	<div class="col-6">
		<label for="permanentRegion"><liferay-ui:message
				key="region-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="permanentRegion" name="permanentRegion"
			onChange="populateAddressOption(this.id, 'permanentZilla')" label=""
			cssClass="validate permanentlevel-0"
			value="<%=permanantAddress != null ? permanantAddress.getRegionId() : StringPool.BLANK%>">
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
		<label for="permanentZilla"><liferay-ui:message
				key="zilla-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="permanentZilla" name="permanentZilla"
			onChange="populateAddressOption(this.id,'permanentUpazilla')"
			label="" cssClass="validate permanentlevel-1"
			value="<%=permanantAddress != null ? permanantAddress.getDistrictId() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="zilla-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
			<%
				for (AssetCategory permanantZillaCategory : permanantZillaList) {
			%>
			<aui:option value="<%=permanantZillaCategory.getCategoryId()%>"
				label="<%=permanantZillaCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="permanentUpazilla"><liferay-ui:message
				key="upazilla-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="permanentUpazilla" name="permanentUpazilla"
			onChange="populateAddressOption(this.id, 'permanentUnion')" label=""
			cssClass="validate permanentlevel-2"
			value="<%=permanantAddress != null ? permanantAddress.getUpazillaId() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="upazilla-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
			<%
				for (AssetCategory permanantUpazillaCategory : permanantUpazillaList) {
			%>
			<aui:option value="<%=permanantUpazillaCategory.getCategoryId()%>"
				label="<%=permanantUpazillaCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="permanentUnion"><liferay-ui:message
				key="union-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="permanentUnion" name="permanentUnion"
			onChange="populateAddressOption(this.id,'permanentWard');" label=""
			cssClass="validate permanentlevel-3"
			value="<%=permanantAddress != null ? permanantAddress.getUnionId() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="union-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
			<%
				for (AssetCategory permanantUnionCategory : permanantUnionList) {
			%>
			<aui:option value="<%=permanantUnionCategory.getCategoryId()%>"
				label="<%=permanantUnionCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="permanentVillage"><liferay-ui:message
				key="village-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="permanentVillage" cssClass="form-control validate"
			id="permanentVillage" label="" type="text"
			placeholder="village-label" maxLength="30" minLength="1"
			value="<%=permanantAddress != null ? permanantAddress.getVillage() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="village-error-label" />
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
		<label for="permanentWard"><liferay-ui:message
				key="ward-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="permanentWard" name="permanentWard" label=""
			onChange="populateAddressOption(this.id, 'permanentPostOffice');"
			cssClass="validate permanentlevel-4"
			value="<%=permanantAddress != null ? permanantAddress.getWard() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="ward-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
			<%
				for (AssetCategory permanantWardCategory : permanantWardList) {
			%>
			<aui:option value="<%=permanantWardCategory.getCategoryId()%>"
				label="<%=permanantWardCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="permanentZipCode"><liferay-ui:message
				key="zip-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="permanentZipCode" cssClass="form-control validate"
			id="permanentZipCode" label="" type="text" placeholder="zip-label"
			maxLength="5" minLength="4"
			value="<%=permanantAddress != null ? permanantAddress.getZipcode() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="zip-error-label" />
			<aui:validator name="maxLength"
				errorMessage="zip-maxlength-error-label">5</aui:validator>
			<aui:validator name="minLength"
				errorMessage="zip-minlength-error-label">4</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>

	<div class="col-6">
		<label for="permanentPostOffice"><liferay-ui:message
				key="post-office-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="permanentPostOffice" cssClass="form-control validate"
			id="permanentPostOffice" label="" type="text"
			placeholder="permanentPostOffice-label" maxLength="10" minLength="5"
			value="<%=permanantAddress != null ? permanantAddress.getPostoffice() : StringPool.BLANK%>">
			<aui:validator name="alphanum" />
			<aui:validator name="required"
				errorMessage="permanentPostOffice-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-ten-error-label">10</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">5</aui:validator>
		</aui:input>
	</div>

	<div class="col-12">
		<label for="permanentHouseAddress"><liferay-ui:message
				key="house-address-label"></liferay-ui:message></label>
		<aui:input name="permanentHouseAddress"
			cssClass="form-control validate" id="permanentHouseAddress" label=""
			type="text" placeholder="house-address-label" maxLength="50"
			minLength="10"
			value="<%=permanantAddress != null ? permanantAddress.getAddress() : StringPool.BLANK%>">
			<aui:validator name="required"
				errorMessage="house-address-error-label" />
			<aui:validator name="maxLength"
				errorMessage="houseAddress-maxlength-error-label">50</aui:validator>
			<aui:validator name="minLength"
				errorMessage="houseAddress-minlength-error-label">10</aui:validator>
		</aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="present-address-information"></liferay-ui:message>
</h3>

<div class="row">

	<div class="col-6">
		<label for="sameAsPermanentAddress"><liferay-ui:message
				key="same-as-permanent-address"></liferay-ui:message></label>
		<aui:input name="sameAsPermanentAddress" id="sameAsPermanentAddress"
			label="" type="checkbox">
		</aui:input>
	</div>

	<div class="col-6"></div>

	<div class="col-6">
		<label for="presentRegion"><liferay-ui:message
				key="region-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="presentRegion" name="presentRegion"
			onChange="populateAddressOption(this.id, 'presentZilla');" label=""
			cssClass="validate presentlevel-0"
			value="<%=presentAddress != null ? presentAddress.getRegionId() : StringPool.BLANK%>">
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
		<label for="presentZilla"><liferay-ui:message
				key="zilla-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="presentZilla" name="presentZilla"
			onChange="populateAddressOption(this.id,'presentUpazilla');" label=""
			cssClass="validate presentlevel-1"
			value="<%=presentAddress != null ? presentAddress.getDistrictId() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="zilla-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
			<%
				for (AssetCategory presentZillaCategory : presentZillaList) {
			%>
			<aui:option value="<%=presentZillaCategory.getCategoryId()%>"
				label="<%=presentZillaCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="presentUpazilla"><liferay-ui:message
				key="upazilla-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="presentUpazilla" name="presentUpazilla"
			onChange="populateAddressOption(this.id,'presentUnion');" label=""
			cssClass="validate presentlevel-2"
			value="<%=presentAddress != null ? presentAddress.getUpazillaId() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="upazilla-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
			<%
				for (AssetCategory presentUpazillaCategory : presentUpazillaList) {
			%>
			<aui:option value="<%=presentUpazillaCategory.getCategoryId()%>"
				label="<%=presentUpazillaCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="presentUnion"><liferay-ui:message
				key="union-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select id="presentUnion" name="presentUnion" label=""
			onChange="populateAddressOption(this.id,'presentWard');"
			cssClass="validate presentlevel-3"
			value="<%=presentAddress != null ? presentAddress.getUnionId() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="union-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
			<%
				for (AssetCategory presentUnionCategory : presentUnionList) {
			%>
			<aui:option value="<%=presentUnionCategory.getCategoryId()%>"
				label="<%=presentUnionCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="presentVillage"><liferay-ui:message
				key="village-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="presentVillage" cssClass="form-control validate"
			id="presentVillage" label="" type="text" placeholder="village-label"
			maxLength="30" minLength="1"
			value="<%=presentAddress != null ? presentAddress.getVillage() : StringPool.BLANK%>">
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
		<label for="presentWard"><liferay-ui:message key="ward-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:select id="presentWard" name="presentWard" label=""
			onChange="populateAddressOption(this.id,'presentPostOffice');"
			cssClass="validate presentlevel-4"
			value="<%=presentAddress != null ? presentAddress.getWard() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="ward-error-label" />
			<aui:option selected="true">
				<liferay-ui:message key='select-label' />
			</aui:option>
			<%
				for (AssetCategory presentWardCategory : presentWardList) {
			%>
			<aui:option value="<%=presentWardCategory.getCategoryId()%>"
				label="<%=presentWardCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<label for="presentZipCode"><liferay-ui:message
				key="zip-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="presentZipCode" cssClass="form-control validate"
			id="presentZipCode" label="" type="text" placeholder="zip-label"
			maxLength="6" minLength="4"
			value="<%=presentAddress != null ? presentAddress.getZipcode() : StringPool.BLANK%>">
			<aui:validator name="required" errorMessage="zip-error-label" />
			<aui:validator name="maxLength"
				errorMessage="zip-maxlength-error-label">6</aui:validator>
			<aui:validator name="minLength"
				errorMessage="zip-minlength-error-label">4</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>

	<div class="col-6">
		<label for="presentPostOffice"><liferay-ui:message
				key="post-office-label"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="presentPostOffice" cssClass="form-control validate"
			id="presentPostOffice" label="" type="text"
			placeholder="presentPostOffice-label" maxLength="10" minLength="5"
			value="<%=presentAddress != null ? presentAddress.getPostoffice() : StringPool.BLANK%>">
			<aui:validator name="alphanum" />
			<aui:validator name="required"
				errorMessage="presentPostOffice-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-ten-error-label">10</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">5</aui:validator>
		</aui:input>
	</div>

	<div class="col-12">
		<label for="presentHouseAddress"><liferay-ui:message
				key="house-address-label"></liferay-ui:message></label>
		<aui:input name="presentHouseAddress" cssClass="form-control validate"
			id="presentHouseAddress" label="" type="text"
			placeholder="house-address-label" maxLength="50" minLength="10"
			value="<%=presentAddress != null ? presentAddress.getAddress() : StringPool.BLANK%>">
			<aui:validator name="required"
				errorMessage="house-address-error-label" />
			<aui:validator name="maxLength"
				errorMessage="houseAddress-maxlength-error-label">50</aui:validator>
			<aui:validator name="minLength"
				errorMessage="houseAddress-minlength-error-label">10</aui:validator>
		</aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="trade-license-information"></liferay-ui:message>
</h3>
<div class="row">
	<div class="col-6">
		<label for="tradeLicenseNumber"><liferay-ui:message
				key="tradeLicenseNo-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="tradeLicenseNumber" cssClass="form-control validate"
			id="tradeLicenseNumber" label="" type="text"
			placeholder="tradeLicenseNo-label"
			value="<%=fgLicense != null ? fgLicense.getTradeLicenseNumber() : StringPool.BLANK%>"
			maxLength="30" minLength="1">
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
			type="text" placeholder="tradeLicenseValidity-label"
			value="<%=fgLicense != null ? dateFormat.format(fgLicense.getTradeLicenseValidity()) : StringPool.BLANK%>">
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

	<div class="col-6">
		<label for="taxIdentificationNumber"><liferay-ui:message
				key="taxIdentificationNo-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="taxIdentificationNumber"
			cssClass="form-control validate" id="taxIdentificationNumber"
			label="" type="text" placeholder="taxIdentificationNo-label"
			value="<%=fgLicense != null ? fgLicense.getTaxIdentificationNumber() : StringPool.BLANK%>"
			maxLength="30" minLength="1">
			<aui:validator name="alphanum" />
			<aui:validator name="required"
				errorMessage="taxIdentificationNumber-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<label for="businessIdentificationNumber"><liferay-ui:message
				key="businessIdentificationNo-label"></liferay-ui:message><span
			class="txt-red">*</span></label>
		<aui:input name="businessIdentificationNumber"
			cssClass="form-control validate" id="businessIdentificationNumber"
			label="" type="text" placeholder="businessIdentificationNo-label"
			value="<%=fgLicense != null ? fgLicense.getBusinessIdentificationNumber() : StringPool.BLANK%>"
			maxLength="30" minLength="1">
			<aui:validator name="alphanum" />
			<aui:validator name="required"
				errorMessage="businessIdentificationNumber-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<label for="tradeLicenseIssuerCode"><liferay-ui:message
				key="tradeLicenseIssuerCode-label"></liferay-ui:message></label>
		<aui:input name="tradeLicenseIssuerCode" cssClass="form-control"
			id="tradeLicenseIssuerCode" label="" type="text"
			placeholder="tradeLicenseIssuerCode-label"
			value="<%=fgLicense != null ? fgLicense.getTradeLicenseIssuerCode() : StringPool.BLANK%>"
			maxLength="30" minLength="1">
			<aui:validator name="alphanum" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<label for="tradeLicenseIssuerCity"><liferay-ui:message
				key="tradeLicenseIssuerCity-label"></liferay-ui:message></label>
		<aui:input name="tradeLicenseIssuerCity" cssClass="form-control"
			id="tradeLicenseIssuerCity" label="" type="text"
			placeholder="tradeLicenseIssuerCity-label"
			value="<%=fgLicense != null ? fgLicense.getTradeLicenseIssuerCity() : StringPool.BLANK%>"
			maxLength="30" minLength="1">
			<aui:validator name="alpha" />
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
</div>

<%-- <h3>
	<liferay-ui:message key="document-information"></liferay-ui:message>
</h3>
<div>
	<div class="row">
		<div class="col-4">
			<label for="tradeLicenseNumberPhotocopy"><liferay-ui:message
					key="trade-license-number-document"></liferay-ui:message><span
				class="txt-red">*</span></label>
		</div>
		<div class="col-4">
			<%
				if (Validator.isNotNull(attachmentEntryMap) && attachmentEntryMap.size() > 0) {
					for (Map.Entry<String, Attachment> entry : attachmentEntryMap.entrySet()) {
						if (entry.getKey().equalsIgnoreCase(DocumentLibraryConstants.ATTACHMENT_TRADE_LICENSE_PHOTO)) {

							String photoSrc = DLUploadUtil.getFileURL(themeDisplay, entry.getValue().getFileEntryID());
			%>
			<a id="<portlet:namespace/>tradeLicenseNumberPhotocopyLink"
				href="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				target="_blank"> <img
				id="<portlet:namespace/>tradeLicenseNumberPhotocopyImg"
				src="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				style="width: 200px; height: 200px;"></img>
			</a>
			<%
				}
					}
				}
			%>
		</div>
		<div class="col-4">
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
	</div>

	<div class="row">
		<div class="col-4">
			<label for="businessIdentificationNumberPhotocopy"><liferay-ui:message
					key="business-identification-number-document"></liferay-ui:message><span
				class="txt-red">*</span></label>
		</div>
		<div class="col-4">
			<%
				if (Validator.isNotNull(attachmentEntryMap) && attachmentEntryMap.size() > 0) {
					for (Map.Entry<String, Attachment> entry : attachmentEntryMap.entrySet()) {
						if (entry.getKey()
								.equalsIgnoreCase(DocumentLibraryConstants.ATTACHMENT_BUSINESS_IDENTIFICATION_PHOTO)) {

							String photoSrc = DLUploadUtil.getFileURL(themeDisplay, entry.getValue().getFileEntryID());
			%>
			<a id="<portlet:namespace/>businessIdentificationNumberPhotocopyLink"
				href="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				target="_blank"> <img
				id="<portlet:namespace/>businessIdentificationNumberPhotocopyImg"
				src="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				style="width: 200px; height: 200px;"></img>
			</a>
			<%
				}
					}
				}
			%>
		</div>
		<div class="col-4">
			<aui:input type="file" name="businessIdentificationNumberPhotocopy"
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
	</div>

	<div class="row">
		<div class="col-4">
			<label for="taxIdentificationNumberPhotocopy"><liferay-ui:message
					key="tax-identification-number-document"></liferay-ui:message><span
				class="txt-red">*</span></label>
		</div>
		<div class="col-4">
			<%
				if (Validator.isNotNull(attachmentEntryMap) && attachmentEntryMap.size() > 0) {
					for (Map.Entry<String, Attachment> entry : attachmentEntryMap.entrySet()) {
						if (entry.getKey().equalsIgnoreCase(DocumentLibraryConstants.ATTACHMENT_TAX_IDENTIFICATION_PHOTO)) {

							String photoSrc = DLUploadUtil.getFileURL(themeDisplay, entry.getValue().getFileEntryID());
			%>
			<a id="<portlet:namespace/>taxIdentificationNumberPhotocopyLink"
				href="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				target="_blank"> <img
				id="<portlet:namespace/>taxIdentificationNumberPhotocopyImg"
				src="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				style="width: 200px; height: 200px;"></img>
			</a>
			<%
				}
					}
				}
			%>
		</div>
		<div class="col-4">
			<aui:input type="file" name="taxIdentificationNumberPhotocopy"
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
	</div>

	<div class="row">
		<div class="col-4">
			<label for="bankStatementDocument"><liferay-ui:message
					key="bank-statement-document"></liferay-ui:message></label>
		</div>
		<div class="col-4">
			<%
				if (Validator.isNotNull(attachmentEntryMap) && attachmentEntryMap.size() > 0) {
					for (Map.Entry<String, Attachment> entry : attachmentEntryMap.entrySet()) {
						if (entry.getKey().equalsIgnoreCase(DocumentLibraryConstants.ATTACHMENT_BANK_STATEMENT)) {

							String photoSrc = DLUploadUtil.getFileURL(themeDisplay, entry.getValue().getFileEntryID());
			%>
			<a id="<portlet:namespace/>bankStatementDocumentLink"
				href="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				target="_blank"> <img
				id="<portlet:namespace/>bankStatementDocumentImg"
				src="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				style="width: 200px; height: 200px;"></img>
			</a>
			<%
				}
					}
				}
			%>
		</div>
		<div class="col-4">
			<aui:input type="file" name="bankStatementDocument"
				accept='<%=acceptedmagePDFExtensions%>' label=""
				onchange="setUploadSize(this)">
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
	</div>

	<div class="row">
		<div class="col-4">
			<label for="relevantDocument"><liferay-ui:message
					key="relevant-document"></liferay-ui:message></label>
		</div>
		<div class="col-4">
			<%
				if (Validator.isNotNull(attachmentEntryMap) && attachmentEntryMap.size() > 0) {
					for (Map.Entry<String, Attachment> entry : attachmentEntryMap.entrySet()) {
						if (entry.getKey().equalsIgnoreCase(DocumentLibraryConstants.ATTACHMENT_RELEVANT_DOCUMENT)) {

							String photoSrc = DLUploadUtil.getFileURL(themeDisplay, entry.getValue().getFileEntryID());
			%>
			<a id="<portlet:namespace/>relevantDocumentLink"
				href="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				target="_blank"> <img
				id="<portlet:namespace/>relevantDocumentImg"
				src="<%=(Validator.isNotNull(photoSrc) && !photoSrc.isEmpty()) ? photoSrc : StringPool.BLANK%>"
				style="width: 200px; height: 200px;"></img>
			</a>
			<%
				}
					}
				}
			%>
		</div>
		<div class="col-4">
			<aui:input type="file" name="relevantDocument" multiple="true"
				label="" onchange="setUploadSize(this)">
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
</div> --%>
<aui:button-row>
	<aui:button id="backToSigleView" value='back' href='#'></aui:button>
	<aui:button id="submitDetails" value='submit-request'
		onClick="validateFields('basic_info');"></aui:button>
</aui:button-row>
<script>
$(document).ready(function(){

	//To remove the error text even after the value has been updated in dropdown.
	var helper = "Helper";
	  $("#<portlet:namespace/>permanentRegion").on('change', function(){
		  var value = $("#<portlet:namespace/>permanentRegion").val();
		  if(value!=""){
			  $("#<portlet:namespace/>permanentRegion"+ helper).remove();
		  }
	  });
		$("#<portlet:namespace/>permanentZilla").on('change', function(){
			var value = $("#<portlet:namespace/>permanentZilla").val();
			  if(value!=""){
				  $("#<portlet:namespace/>permanentZilla"+ helper).remove();
			  }
	  });
		$("#<portlet:namespace/>permanentUpazilla").on('change', function(){
			var value = $("#<portlet:namespace/>permanentUpazilla").val();
			  if(value!=""){
				  $("#<portlet:namespace/>permanentUpazilla"+ helper).remove();
			  }
	  });
		$("#<portlet:namespace/>permanentUnion").on('change', function(){
			var value = $("#<portlet:namespace/>permanentUnion").val();
			  if(value!=""){
				  $("#<portlet:namespace/>permanentUnion"+ helper).remove();
			  }
	  });
		$("#<portlet:namespace/>permanentWard").on('change', function(){
			var value = $("#<portlet:namespace/>permanentWard").val();
			  if(value!=""){
				  $("#<portlet:namespace/>permanentWard"+ helper).remove();
			  }
	  });
		/* $("#<portlet:namespace/>permanentPostOffice").on('change', function(){
			var value = $("#<portlet:namespace/>permanentPostOffice").val();
			  if(value!=""){
				  $("#<portlet:namespace/>permanentPostOffice"+ helper).remove();
			  }
	  }); */

	  // Initialize select2 for all the populate dropdowns
	  $("#<portlet:namespace/>permanentRegion").select2({
		  width: "100%"
	  });
		$("#<portlet:namespace/>permanentZilla").select2({
		  width: "100%"
	  });
		$("#<portlet:namespace/>permanentUpazilla").select2({
		  width: "100%"
	  });
		$("#<portlet:namespace/>permanentUnion").select2({
		  width: "100%"
	  });
		$("#<portlet:namespace/>permanentWard").select2({
		  width: "100%"
	  });
		/* $("#<portlet:namespace/>permanentPostOffice").select2({
		  width: "100%"
	  }); */

	//To remove the error text even after the value has been updated in dropdown.
	var helper = "Helper";
	  $("#<portlet:namespace/>presentRegion").on('change', function(){
		  var value = $("#<portlet:namespace/>presentRegion").val();
		  if(value!=""){
			  $("#<portlet:namespace/>presentRegion"+ helper).remove();
		  }
	  });
		$("#<portlet:namespace/>presentZilla").on('change', function(){
			var value = $("#<portlet:namespace/>presentZilla").val();
			  if(value!=""){
				  $("#<portlet:namespace/>presentZilla"+ helper).remove();
			  }
	  });
		$("#<portlet:namespace/>presentUpazilla").on('change', function(){
			var value = $("#<portlet:namespace/>presentUpazilla").val();
			  if(value!=""){
				  $("#<portlet:namespace/>presentUpazilla"+ helper).remove();
			  }
	  });
		$("#<portlet:namespace/>presentUnion").on('change', function(){
			var value = $("#<portlet:namespace/>presentUnion").val();
			  if(value!=""){
				  $("#<portlet:namespace/>presentUnion"+ helper).remove();
			  }
	  });
		$("#<portlet:namespace/>presentWard").on('change', function(){
			var value = $("#<portlet:namespace/>presentWard").val();
			  if(value!=""){
				  $("#<portlet:namespace/>presentWard"+ helper).remove();
			  }
	  });
		/* $("#<portlet:namespace/>presentPostOffice").on('change', function(){
			var value = $("#<portlet:namespace/>presentPostOffice").val();
			  if(value!=""){
				  $("#<portlet:namespace/>presentPostOffice"+ helper).remove();
			  }
	  }); */
	
	  // Initialize select2 for all the populate dropdowns
	  $("#<portlet:namespace/>presentRegion").select2({
		  width: "100%"
	  });
		$("#<portlet:namespace/>presentZilla").select2({
		  width: "100%"
	  });
		$("#<portlet:namespace/>presentUpazilla").select2({
		  width: "100%"
	  });
		$("#<portlet:namespace/>presentUnion").select2({
		  width: "100%"
	  });
		$("#<portlet:namespace/>presentWard").select2({
		  width: "100%"
	  });
		/* $("#<portlet:namespace/>presentPostOffice").select2({
		  width: "100%"
	  }); */
});
	 
	$("#<portlet:namespace/>sameAsPermanentAddress").on('change',function() {
						
		var helper = "Helper";
		toggleState = $("#<portlet:namespace/>sameAsPermanentAddress").is(':checked');
		console.log("toggleState - " + toggleState);

		//To Remove old data in the preview
		$("#<portlet:namespace/>presentRegion");
		$("#<portlet:namespace/>presentZilla");
		$("#<portlet:namespace/>presentUpazilla");
		$("#<portlet:namespace/>presentUnion");
		$("#<portlet:namespace/>presentVillage").removeAttr('readOnly', 'readOnly');
		$("#<portlet:namespace/>presentWard");
		$("#<portlet:namespace/>presentZipCode").removeAttr('readOnly', 'readOnly');
		$("#<portlet:namespace/>presentPostOffice");
		$("#<portlet:namespace/>presentHouseAddress").removeAttr('readOnly', 'readOnly');

		if (toggleState == true) {

			//Present Address
			if ($("#<portlet:namespace/>permanentRegion").val() != '') {
				var optionsHTML = $("#<portlet:namespace/>permanentRegion").html();
				$("#<portlet:namespace/>presentRegion").html(optionsHTML);
				$("#<portlet:namespace/>presentRegion").val($("#<portlet:namespace/>permanentRegion").val());
				
				//To remove the error label if any
				var value = $("#<portlet:namespace/>presentRegion").val();
				  if(value!=""){
					  $("#<portlet:namespace/>presentRegion"+ helper).remove();
				  }
			}
			
			//Populate the list of Address option and then assign the values.
			if ($("#<portlet:namespace/>permanentZilla").val() != '') {
				var optionsHTML = $("#<portlet:namespace/>permanentZilla").html();
				$("#<portlet:namespace/>presentZilla").html(optionsHTML);
				$("#<portlet:namespace/>presentZilla").val($("#<portlet:namespace/>permanentZilla").val());
				
				//To remove the error label if any
				var value = $("#<portlet:namespace/>presentZilla").val();
				  if(value!=""){
					  $("#<portlet:namespace/>presentZilla"+ helper).remove();
				  }
			}
			if ($("#<portlet:namespace/>permanentUpazilla").val() != '') {
				var optionsHTML = $("#<portlet:namespace/>permanentUpazilla").html();
				$("#<portlet:namespace/>presentUpazilla").html(optionsHTML);
				$("#<portlet:namespace/>presentUpazilla").val($("#<portlet:namespace/>permanentUpazilla").val());
				
				//To remove the error label if any
				var value = $("#<portlet:namespace/>presentUpazilla").val();
				  if(value!=""){
					  $("#<portlet:namespace/>presentUpazilla"+ helper).remove();
				  }
			}
			if ($("#<portlet:namespace/>permanentUnion").val() != '') {
				var optionsHTML = $("#<portlet:namespace/>permanentUnion").html();
				$("#<portlet:namespace/>presentUnion").html(optionsHTML);
				$("#<portlet:namespace/>presentUnion").val($("#<portlet:namespace/>permanentUnion").val());
				
				//To remove the error label if any
				var value = $("#<portlet:namespace/>presentUnion").val();
				  if(value!=""){
					  $("#<portlet:namespace/>presentUnion"+ helper).remove();
				  }
			}
			if ($("#<portlet:namespace/>permanentVillage").val() != '') {
				$("#<portlet:namespace/>presentVillage").val($("#<portlet:namespace/>permanentVillage").val()).attr('readOnly', 'readOnly');
				
				//To remove the error label if any
				var value = $("#<portlet:namespace/>presentVillage").val();
				  if(value!=""){
					  $("#<portlet:namespace/>presentVillage"+ helper).remove();
				  }
			}
			if ($("#<portlet:namespace/>permanentWard").val() != '') {
				var optionsHTML = $("#<portlet:namespace/>permanentWard").html();
				$("#<portlet:namespace/>presentWard").html(optionsHTML);
				$("#<portlet:namespace/>presentWard").val($("#<portlet:namespace/>permanentWard").val());
				
				//To remove the error label if any
				var value = $("#<portlet:namespace/>presentWard").val();
				  if(value!=""){
					  $("#<portlet:namespace/>presentWard"+ helper).remove();
				  }
			}
			if ($("#<portlet:namespace/>permanentZipCode").val() != '') {
				$("#<portlet:namespace/>presentZipCode").val($("#<portlet:namespace/>permanentZipCode").val()).attr('readOnly', 'readOnly');
				
				//To remove the error label if any
				var value = $("#<portlet:namespace/>presentZipCode").val();
				  if(value!=""){
					  $("#<portlet:namespace/>presentZipCode"+ helper).remove();
				  }
			}
			if ($("#<portlet:namespace/>permanentPostOffice").val() != '') {
				var optionsHTML = $("#<portlet:namespace/>permanentPostOffice").html();
				$("#<portlet:namespace/>presentPostOffice").html(optionsHTML);
				$("#<portlet:namespace/>presentPostOffice").val($("#<portlet:namespace/>permanentPostOffice").val());
				
				//To remove the error label if any
				var value = $("#<portlet:namespace/>presentPostOffice").val();
				  if(value!=""){
					  $("#<portlet:namespace/>presentPostOffice"+ helper).remove();
				  }
			}
			if ($("#<portlet:namespace/>permanentHouseAddress").val() != '') {
				$("#<portlet:namespace/>presentHouseAddress").val($("#<portlet:namespace/>permanentHouseAddress").val()).attr('readOnly', 'readOnly');
				
				//To remove the error label if any
				var value = $("#<portlet:namespace/>presentHouseAddress").val();
				  if(value!=""){
					  $("#<portlet:namespace/>presentHouseAddress"+ helper).remove();
				  }
			}
		}
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