<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.FormSectionLabelsConstant"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@ include file="../../init.jsp" %>

<dgfood-ui:nid-fields />

<!-- Farmers password fields -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.PASSWORD_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<label for="<%=ParameterConstants.PASSWORD %>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_PASSWORD %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:input name="<%=ParameterConstants.PASSWORD %>" cssClass="validate isMandatory" label="" type="password">
			<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-password")%>' />
			<aui:validator name="maxLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-max-length-twenty")%>'>20</aui:validator>
			<aui:validator name="minLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-min-length-one")%>'>1</aui:validator>
			<aui:validator name="custom" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-invalid-character")%>'>
				function(val, fieldNode, ruleValue)  
				{
					var regex = new RegExp(/((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#%$&*!_*]))^(?!.*[\r\n\t\f\v ])/);
					return regex.test(val);
				}
			</aui:validator>
		</aui:input>
	</aui:col>
	<aui:col width="50">
		<label for="<%= ParameterConstants.CONFIRM_PASSWORD%>"><dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CONFIRM_PASSWORD %>" 
		languageId="<%=themeDisplay.getLanguageId()%>" /><span class="txt-red">*</span></label>
		<aui:input name="<%= ParameterConstants.CONFIRM_PASSWORD%>" cssClass="validate isMandatory" label=""  
		type="password" >
			<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-password")%>' />	
			<aui:validator name="maxLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-max-length-twenty")%>'>20</aui:validator>
			<aui:validator name="minLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-min-length-one")%>'>1</aui:validator>
			<aui:validator name="custom" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-invalid-character")%>'>
				function(val, fieldNode, ruleValue)  
				{
					var regex = new RegExp(/((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#%$&*!_*]))^(?!.*[\r\n\t\f\v ])/);
					return regex.test(val);
				}
			</aui:validator>
			<aui:validator name="equalTo" errorMessage="label-error-confirm-password-not-same">'#<portlet:namespace /><%=ParameterConstants.PASSWORD %>'</aui:validator>
		</aui:input>
	</aui:col>
</aui:row>

<aui:fieldset label="">
	<!-- Button to navigate to the next step -->
	<aui:button-row>
		<aui:button id="nextToSummaryPage" type="button" cssClass="btn btn-primary" 
			value="<%=CustomLanguageUtil.get(request,"label-next")%>" onClick="showNextOrPreviousStep('nid_details','other_registration_details', true, 'new-farmer-registration', 'fims_reg_step', 'fims_reg_step_hide', true);" />
	</aui:button-row>
</aui:fieldset>