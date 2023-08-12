<%@include file="../../init.jsp"%>

<h3>Preview</h3>
<br />
<h3>
	<liferay-ui:message key="basic-information"></liferay-ui:message>
</h3>
<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="nationalId-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_nationalId'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="emailAddress-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_emailAddress'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="mobileNumber-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_mobileNumber'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="dateOfBirth-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_dateOfBirth'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="applicantName-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_applicantName'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="fatherName-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_fatherName'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="motherName-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_motherName'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="gender-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_gender'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="marital-status-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_maritalStatus'></span>
	</div>
</div>


<h3>
	<liferay-ui:message key="trade-license-information"></liferay-ui:message>
</h3>
<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="tradeLicenseNo-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_tradeLicenseNumber'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="tradeLicenseValidity-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_tradeLicenseValidity'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="taxIdentificationNo-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_taxIdentificationNumber'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="businessIdentificationNo-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_businessIdentificationNumber'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="tradeLicenseIssuerCode-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_tradeLicenseIssuerCode'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="tradeLicenseIssuerCity-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_tradeLicenseIssuerCity'></span>
	</div>
</div>

<div class='row'>
	<div class='col-6'>
		<h3>
			<liferay-ui:message key="permanent-address"></liferay-ui:message>
		</h3>
	</div>
	<div class='col-6'>
		<h3>
			<liferay-ui:message key="present-address"></liferay-ui:message>
		</h3>
	</div>

	<div class='col-6'>
		<div class='col-6'>
			<liferay-ui:message key="permanent-region"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_permanentRegion'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="permanent-zilla"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_permanentZilla'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="permanent-upazilla"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_permanentUpazilla'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="permanent-union"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_permanentUnion'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="permanent-village"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_permanentVillage'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="permanent-ward"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_permanentWard'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="permanent-zip-code"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_permanentZipCode'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="permanent-post-office"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_permanentPostOffice'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="permanent-house-address"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_permanentHouseAddress'></span>
		</div>
	</div>

	<div class='col-6'>
		<div class='col-6'>
			<liferay-ui:message key="present-region"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_presentRegion'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="present-zilla"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_presentZilla'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="present-upazilla"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_presentUpazilla'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="present-union"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_presentUnion'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="present-village"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_presentVillage'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="present-ward"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_presentWard'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="present-zip-code"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_presentZipCode'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="present-post-office"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_presentPostOffice'></span>
		</div>
		<div class='col-6'>
			<liferay-ui:message key="present-house-address"></liferay-ui:message>
			: <span id='<portlet:namespace/>preview_presentHouseAddress'></span>
		</div>
	</div>
</div>


<h3>
	<liferay-ui:message key="documents"></liferay-ui:message>
</h3>
<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="profile-photograph-document"></liferay-ui:message>
		<a id="<portlet:namespace/>profilePhotographLink" href="" target="_blank" >
			<img id="<portlet:namespace/>profilePhotographImg"></img>
		</a>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="trade-license-number-document"></liferay-ui:message>
		<a id="<portlet:namespace/>tradeLicenseNumberPhotocopyLink" href="" target="_blank" >
			<img id="<portlet:namespace/>tradeLicenseNumberPhotocopyImg"></img>
		</a>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="business-identification-number-document"></liferay-ui:message>
		<a id="<portlet:namespace/>businessIdentificationNumberPhotocopyLink" href="" target="_blank" >
			<img id="<portlet:namespace/>businessIdentificationNumberPhotocopyImg"></img>
		</a>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="tax-identification-number-document"></liferay-ui:message>
		<a id="<portlet:namespace/>taxIdentificationNumberPhotocopyLink" href="" target="_blank" >
			<img id="<portlet:namespace/>taxIdentificationNumberPhotocopyImg"></img>
		</a>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="bank-statement-document"></liferay-ui:message>
		<a id="<portlet:namespace/>bankStatementDocumentLink" href="" target="_blank" >
			<img id="<portlet:namespace/>bankStatementDocumentImg"></img>
		</a>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="relevant-document"></liferay-ui:message>
		<div class="multipleDocs">
		
		</div>
	</div>
</div>

<div class="col-6">
	<aui:input name="acknowledge" label="" type="radio" />
	<label><liferay-ui:message key="acknowledge"></liferay-ui:message></label>
</div>

<div class="col-6">
	<liferay-captcha:captcha />
</div>

<aui:button-row>
	<aui:button id="backToPreviewInfo" value='back'
		onClick="showNextOrPreviousStep('basic_info');"></aui:button>
	<aui:button id="nextToFinal" value='next'
		onClick="validateFields('preview_info','final_step');"></aui:button>
</aui:button-row>