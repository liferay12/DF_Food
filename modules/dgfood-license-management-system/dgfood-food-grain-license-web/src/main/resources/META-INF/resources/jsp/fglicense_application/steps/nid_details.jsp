<%@include file="../../init.jsp"%>

<!-- National Id Details & Password Capturing TLD   -->
<dgfood-ui:nid-fields />
<!-- OTP TLD   -->
<dgfood-ui:otp otpEntered="" />

<h3><liferay-ui:message key="label-password-information" /></h3>
<div class="row">
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.PASSWORD %>" 
			label="<%=ParameterLabelConstants.LABEL_PASSWORD %>"
			cssClass="form-control validate isMandatory" type="password">
			<aui:validator name="required" errorMessage="label-error-password" />
			<aui:validator name="maxLength"
				errorMessage="label-error-max-length-twenty">20</aui:validator>
			<aui:validator name="minLength"
				errorMessage="label-error-min-length-one">1</aui:validator>
			<aui:validator name="custom" errorMessage="label-error-invalid-character">
				function(val, fieldNode, ruleValue)  
				{
					var regex = new RegExp(/((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#%$&*!_*]))^(?!.*[\r\n\t\f\v ])/);
					return regex.test(val);
				}
			</aui:validator>
		</aui:input>
	</div>
	<div class="col-6">
		<aui:input name="<%= ParameterConstants.CONFIRM_PASSWORD%>" 
		label="<%=ParameterLabelConstants.LABEL_CONFIRM_PASSWORD %>"
		cssClass="form-control validate isMandatory" type="password" >
			<aui:validator name="required" errorMessage="label-error-password" />	
			<aui:validator name="maxLength"
				errorMessage="label-error-max-length-twenty">20</aui:validator>
			<aui:validator name="minLength"
				errorMessage="label-error-min-length-one">1</aui:validator>
			<aui:validator name="custom" errorMessage="label-error-invalid-character">
				function(val, fieldNode, ruleValue)  
				{
					var regex = new RegExp(/((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#%$&*!_*]))^(?!.*[\r\n\t\f\v ])/);
					return regex.test(val);
				}
			</aui:validator>
			<aui:validator name="equalTo" errorMessage="label-error-confirm-password-not-same">'#<portlet:namespace /><%=ParameterConstants.PASSWORD %>'</aui:validator>
		</aui:input>
	</div>	
</div>

<aui:button-row>
	<aui:button id="nextToBasicDetails" type="button" cssClass="btn btn-primary" value="label-next"
			onClick="validateNationalIdAndGenerateOTP('nid_details', true, 'new-food-grain-license');" />
	<button id="showModal" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop" hidden />
</aui:button-row>