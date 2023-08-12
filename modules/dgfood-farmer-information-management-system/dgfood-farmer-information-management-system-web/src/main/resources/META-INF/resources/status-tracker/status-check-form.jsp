<%@page import="bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration"%>
<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.exception.NoSuchFarmerRegistrationException"%>
<%@page import="bd.gov.dgfood.common.util.validator.DataValidationException"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<%
	FarmerRegistration farmerRegistration=null;
	if(Validator.isNotNull( renderRequest.getAttribute("farmerRegistration")))
	{
		farmerRegistration = (FarmerRegistration)renderRequest.getAttribute("farmerRegistration");
	}
%>

<portlet:renderURL var="checkApplicationStatusURL" >
	<portlet:param name="mvcRenderCommandName"  value="<%=FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_STATUS_RENDER_COMMAND%>" />
</portlet:renderURL>

<liferay-portlet:resourceURL id="<%=FarmerInformationManagementSystemConstants.VALIDATE_CAPTCHA_RESOURCE_COMMAND%>" 
	var="validateCaptchaURL" copyCurrentRenderParameters="false" />

<liferay-ui:error message="${errorKey}" exception="<%=DataValidationException.class %>"></liferay-ui:error>
<liferay-ui:error message="${errorKey}" exception="<%=NoSuchFarmerRegistrationException.class %>"></liferay-ui:error>

<c:if test="<%=Validator.isNotNull(farmerRegistration) %>"> 
	<c:if test="<%=farmerRegistration.getStatus() == StatusConstants.STATUS_APPROVED %>"> 
		<clay:alert message="<%=CustomLanguageUtil.get(request,"label-farmer-registration-status-approved")%>" 
			style="success" title="Approved" />
	</c:if>
	<c:if test="<%=farmerRegistration.getStatus() == StatusConstants.STATUS_REJECTED %>"> 
		<clay:alert message="<%=CustomLanguageUtil.get(request,"label-farmer-registration-status-rejected")%>" 
			style="danger" title="Rejected" />
	</c:if>
	<c:if test="<%=farmerRegistration.getStatus() == StatusConstants.STATUS_PENDING %>"> 
		<clay:alert message="<%=CustomLanguageUtil.get(request,"label-farmer-registration-status-pending")%>" 
			style="warning" title="Pending" />
	</c:if>
</c:if>
<aui:form action="<%=checkApplicationStatusURL%>" method="post" name="application-status-check-form">

	<input type="hidden" value="<portlet:namespace/>" id="portletNamespace"/>
	<aui:input type="hidden" value="${validateCaptchaURL}" name="validateCaptchaURL"/>

	<aui:row>
		<aui:col  width="50">
			<aui:input name="inputType" checked="true" type="radio" id="inputTypeNationalId"
				label='<%=CustomLanguageUtil.get(request,"label-nationalId")%>' value="<%=ParameterConstants.NATIONAL_ID %>">
				<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-input-type")%>' />
			</aui:input>
			<aui:input name="inputType" type="radio" id="inputTypeApplicationNumber"
				label='<%=CustomLanguageUtil.get(request,"label-application-number")%>' value="<%=ParameterConstants.APPLICATION_NUMBER %>" >
				<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-input-type")%>' />
			</aui:input>
		</aui:col>
	</aui:row>

	<div class="row">
		<div class="col-6" id='<portlet:namespace/>nationalId_div'>
			<label for="nationalId"><dgfood-ui:message
				key="label-nationalId" languageId="<%=themeDisplay.getLanguageId()%>" /><span class="txt-red">*</span></label>
			<aui:input name="<%=ParameterConstants.NATIONAL_ID %>" cssClass="form-control validate"
				label="" type="text" placeholder='<%=CustomLanguageUtil.get(request,"label-nationalId")%>'
				value="" maxLength="17" minLength="13">
				<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-nationalId")%>' >
					function() {
                        return document.getElementById('<portlet:namespace />inputTypeNationalId').checked;
                	}
				</aui:validator>
				<aui:validator name="custom" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-length-nationalId")%>' >
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
					errorMessage='<%=CustomLanguageUtil.get(request,"error-label-max-length-seventeen")%>'>17</aui:validator>
				<aui:validator name="minLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"error-label-min-length-thirteen")%>'>13</aui:validator>
				<aui:validator name="number" />
			</aui:input>
		</div>

		<div class="col-6"
			id='<portlet:namespace/>applicationNumber_div'>
			<label for="<%=ParameterConstants.APPLICATION_NUMBER %>"><dgfood-ui:message
					key="<%=ParameterLabelConstants.LABEL_APPLICATION_NUMBER %>" languageId="<%=themeDisplay.getLanguageId()%>" /><span
				class="txt-red">*</span></label>
			<aui:input name="<%=ParameterConstants.APPLICATION_NUMBER %>" cssClass="form-control validate"
				label="" type="text" placeholder='<%=CustomLanguageUtil.get(request,"label-application-number")%>' 
				value="" maxLength="20" minLength="1">
				<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-application-number")%>' >
					function() {
                        return document.getElementById('<portlet:namespace />inputTypeApplicationNumber').checked;
                	}
				</aui:validator>
				<aui:validator name="maxLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"error-label-max-length-twenty")%>'>20</aui:validator>
				<aui:validator name="minLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"error-label-min-length-one")%>'>1</aui:validator>
				<aui:validator name="alphanum" />
			</aui:input>
		</div>

		<div class="col-6">
			<label for="<%=ParameterConstants.DATE_OF_BIRTH %>"><dgfood-ui:message
					key="<%=ParameterLabelConstants.LABEL_DATE_OF_BIRTH %>" languageId="<%=themeDisplay.getLanguageId()%>" /><span class="txt-red">*</span></label>
			<aui:input name="<%=ParameterConstants.DATE_OF_BIRTH %>" cssClass="form-control validate"
				label="" onkeydown="return false" type="text"
				placeholder='<%=CustomLanguageUtil.get(request,"label-date-of-birth")%>' value="">
				<aui:validator name="required"
					errorMessage='<%=CustomLanguageUtil.get(request,"error-label-date-of-birth")%>' />
				<aui:validator name="custom" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-age")%>'>
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
				<aui:validator name="custom" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-date")%>'>
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

	<aui:row>
		<aui:col width="50">
			<liferay-captcha:captcha />
			<p  class="text-danger" id="<portlet:namespace/>captchaInvalidError" style="display: none;">
				<dgfood-ui:message key="error-label-invalid-captcha" languageId="<%=themeDisplay.getLanguageId()%>" />
			</p>
		</aui:col>
	</aui:row>

	<aui:button-row>
		<aui:button type="button" value='<%=CustomLanguageUtil.get(request,"label-submit")%>' onClick="submitStatusCheckForm();" ></aui:button>
	</aui:button-row>
</aui:form>

<script src="<%=request.getContextPath()%>/js/status-check.js"></script>