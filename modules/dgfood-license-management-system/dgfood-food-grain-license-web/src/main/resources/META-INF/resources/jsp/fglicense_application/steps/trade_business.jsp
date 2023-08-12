<%@include file="../../init.jsp"%>

<%
String acceptedExtensions = StringUtil.merge(FileConstants.JPG_JPEG_PNG, StringPool.COMMA_AND_SPACE);
String acceptedDocumentExtensions = StringUtil.merge(FileConstants.PDF_DOC_DOCX, StringPool.COMMA_AND_SPACE);
%>

<h3>
	<liferay-ui:message key="label-trade-license-information" />
</h3>
<div class="row">
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.TRADE_LICENSE_NUMBER%>" 
			label="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_NUMBER%>"
			placeholder="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_NUMBER%>" 
			cssClass="validate preview" type="text" onblur="isTradeLicenseAvailable();"
			value="TRD9872" maxLength="30" minLength="1">
			<aui:validator name="alphanum" />
			<aui:validator name="required" errorMessage="error-label-trade-license-no" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
		</aui:input>
	</div>
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.TRADE_LICENSE_EXPIRY_DATE%>" 
			label="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_VALIDITY%>"
			placeholder="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_VALIDITY%>"
			cssClass="form-control validate preview" type="text" value="29-04-2023">
			<aui:validator name="required" errorMessage="error-label-trade-license-validity" />
			<aui:validator name="custom" errorMessage="error-label-date" >
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
		<aui:input name="<%=ParameterConstants.TAX_IDENTIFICATION_NUMBER%>" 
			label="<%=ParameterLabelConstants.LABEL_TAX_IDENTIFICATION_NO%>"
			placeholder="<%=ParameterLabelConstants.LABEL_TAX_IDENTIFICATION_NO%>"
			cssClass="form-control validate preview" type="text"
			value="TID2784" maxLength="30" minLength="1">
			<aui:validator name="alphanum" />
			<aui:validator name="required" errorMessage="error-label-tax-identification-no"/>
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER%>"  
			label="<%=ParameterLabelConstants.LABEL_BUSINESS_IDENTIFICATION_NO%>" 
			placeholder="<%=ParameterLabelConstants.LABEL_BUSINESS_IDENTIFICATION_NO%>"
			cssClass="form-control validate preview" type="text" 
			value="BID237822" maxLength="30" minLength="1">
			<aui:validator name="alphanum" />
			<aui:validator name="required" errorMessage="error-label-business-identification-no" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.TRADE_LICENSE_ISSUER_CODE%>" 
			label="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_ISSUER_CODE%>"
			placeholder="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_ISSUER_CODE%>"
			cssClass="form-control preview" type="text"
			value="723822" maxLength="30" minLength="1">
			<aui:validator name="alphanum" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.TRADE_LICENSE_ISSUER_CITY%>" 
			label="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_ISSUER_CITY%>"
			placeholder="<%=ParameterLabelConstants.LABEL_TRADE_LICENSE_ISSUER_CITY%>"
			cssClass="form-control preview"  type="text"
			value="Mumbai" maxLength="30" minLength="1">
			<aui:validator name="alpha" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
			</aui:validator>
		</aui:input>
	</div>
</div>

<h3>
	<liferay-ui:message key="label-business-information" />
</h3>
<div class="row">
<div class="col-6">
		<aui:input name="<%=ParameterConstants.BUSINESS_NAME%>" 
			label="<%=ParameterLabelConstants.LABEL_BUSINESS_NAME%>" 
			placeholder="<%=ParameterLabelConstants.LABEL_BUSINESS_NAME%>"
			cssClass="form-control preview" type="text"
			value="Mumbai" maxLength="30" minLength="1">
			<aui:validator name="alpha" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
			</aui:validator>
		</aui:input>
	</div>
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.BUSINESS_TYPE%>" 
			label="<%=ParameterLabelConstants.LABEL_BUSINESS_TYPE%>" 
			placeholder="<%=ParameterLabelConstants.LABEL_BUSINESS_TYPE%>"
			cssClass="form-control preview" type="text" 
			value="Mumbai" maxLength="30" minLength="1">
			<aui:validator name="alpha" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
			</aui:validator>
		</aui:input>
	</div>
	
	<dgfood-ui:basic-fields nameFields="false" maritalStatusField="false"
			genderField="false" addressField="true" addressType="business" />
</div>

<h3>
	<liferay-ui:message key="label-documents" />
</h3>
<div class="row">
	<div class="col-6">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.TRADE_LICENSE_DOCUMENT%>" required="true"
			accept='<%=acceptedExtensions%>' multiple="<%=false%>"
			maxSize='<%=FileConstants.TWO_MB%>' classes="validate"
			previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.TRADE_LICENSE_DOCUMENT+"_preview"%>'
		/>
	</div>
	<div class="col-6">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER_DOCUMENT%>" required="true"
			accept='<%=acceptedExtensions%>' multiple="<%=false%>"
			maxSize='<%=FileConstants.TWO_MB%>' classes="validate"
			previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER_DOCUMENT+"_preview"%>'
		/>
	</div>
	<div class="col-6">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.TAX_IDENTIFICATION_NUMBER_DOCUMENT%>" required="true"
			accept='<%=acceptedExtensions%>' multiple="<%=false%>"
			maxSize='<%=FileConstants.TWO_MB%>' classes="validate"
			previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.TAX_IDENTIFICATION_NUMBER_DOCUMENT+"_preview"%>'
		/>
	</div>
	<div class="col-6">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.BANK_STATEMENT_DOCUMENT%>" required="true"
			accept='<%=acceptedExtensions%>' multiple="<%=false%>"
			maxSize='<%=FileConstants.TWO_MB%>' 
			previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.BANK_STATEMENT_DOCUMENT+"_preview"%>'
		/>
	</div>
</div>

<aui:button-row>
	<aui:button id="backToBasicDetails" type="button" cssClass="btn"
		value="label-back" onClick="showNextOrPreviousStep('trade_business','basic_details', false, 'new-food-grain-license', 'application_step', 'application_step_hide', false);" />
	<aui:button id="nextToPreviewDetails" type="button" cssClass="btn btn-primary"
		value="label-next" onClick="showNextOrPreviousStep('trade_business','preview_details', true, 'new-food-grain-license', 'application_step', 'application_step_hide', true);" />
</aui:button-row>

<script>
$(document).ready(function(){
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
});
</script>