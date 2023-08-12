<%@page import="bd.gov.dgfood.common.util.constants.DateConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.DateFormatterUtil"%>
<%@page import="bd.gov.dgfood.taglib.servlet.taglib.NationalIdInformation"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@ include file="/nid_fields/init.jsp" %>

<%
boolean isDisabled=false;
if(Validator.isNotNull(request.getAttribute("dgfood-ui:isDisabled")))
{
	isDisabled = (Boolean)request.getAttribute("dgfood-ui:isDisabled");
}

NationalIdInformation nationalIdInformation=new NationalIdInformation();
if(Validator.isNotNull(request.getAttribute("dgfood-ui:nationalIdInformation")))
{
	nationalIdInformation = (NationalIdInformation)request.getAttribute("dgfood-ui:nationalIdInformation");
}


try{
boolean showAlertMessage = (Boolean)request.getAttribute("dgfood-ui:page-access-status-verifier:showAlertMessage");

%>

<h3><liferay-ui:message key="label-nid-information" /></h3>

<div class="row">
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.NATIONAL_ID%>" 
			label="<%=ParameterLabelConstants.LABEL_NATIONAL_ID%>"  
			placeholder="<%=ParameterLabelConstants.LABEL_NATIONAL_ID%>"
			value="<%=nationalIdInformation.getNationalId() %>"
			cssClass="form-control validate preview" disabled="<%=isDisabled %>"
			maxLength="17" minLength="10" type="text" >
			<aui:validator name="required" errorMessage="error-label-nationalId" />
			<aui:validator name="custom" errorMessage="error-label-length-nationalId" >
					    function(val, fieldNode, ruleValue) {
					    	var valLength = val.length;
					    	var result = false;
							
							if(valLength == 10 || valLength == 17){
								result = true;
							}else{
								console.log("National Id must be 10 or 17 digit long.");
								result = false;
							}				
							return result;					
					    }
				</aui:validator>
			<aui:validator name="maxLength"
				errorMessage="error-label-max-length-seventeen">17</aui:validator>
			<aui:validator name="minLength"
				errorMessage="error-label-min-length-ten">10</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.EMAIL_ADDRESS%>" 
			placeholder="<%=ParameterLabelConstants.LABEL_EMAIL_ADDRESS%>"
			label="<%=ParameterLabelConstants.LABEL_EMAIL_ADDRESS%>" 
			value="<%=nationalIdInformation.getEmailAddress() %>"
			cssClass="form-control validate preview" disabled="<%=isDisabled %>"
			type="text" maxLength="30">
			<aui:validator name="email" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.MOBILE_NUMBER%>" 
			label="<%=ParameterLabelConstants.LABEL_MOBILE_NUMBER%>"
			placeholder="<%=ParameterLabelConstants.LABEL_MOBILE_NUMBER%>"
			value="<%=nationalIdInformation.getNationalId() %>"
			cssClass="form-control validate preview" disabled="<%=isDisabled %>"
			type="text" maxLength="15" minLength="12">
			<aui:validator name="required"
				errorMessage="error-label-mobile-number" />
			<aui:validator name="maxLength"
				errorMessage="error-label-max-length-ten">15</aui:validator>
			<aui:validator name="minLength"
				errorMessage="error-label-min-length-ten">11</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>

	<div class="col-6">
			<aui:input name="<%=ParameterConstants.DATE_OF_BIRTH%>"  
				label="<%=ParameterLabelConstants.LABEL_DATE_OF_BIRTH%>"  
				placeholder="<%=ParameterLabelConstants.LABEL_DATE_OF_BIRTH%>"
				value="<%=DateFormatterUtil.parseDate(nationalIdInformation.getDateOfBirth() , DateConstants.DD_MM_YYYY)%>"
				cssClass="form-control validate preview" disabled="<%=isDisabled %>"
				type="text" onkeydown="return false" >
				<aui:validator name="required" errorMessage="error-label-date-of-birth" />
				<aui:validator name="custom" errorMessage="error-label-age">
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
</div>
	
<%-- <c:if test="<%=!isDisabled%>">
	<div class="col-6">
		<aui:button id="nextToBasicInfo" type="button" value="label-retrieve"
			onClick="validateFields('nid_info','basic_info');"></aui:button>
	</div>
</c:if> --%>

<script>
//============================DatePicker Code========================//

var selectedLanguage = themeDisplay.getLanguageId().split("_")[0];
console.log("selectedLanguage - " + selectedLanguage);
var today = new Date();
$("#<portlet:namespace/>dateOfBirth").datepicker({
	format : 'dd-mm-yyyy',
	pickTime : false,
	endDate : today,
	locale : selectedLanguage,
	language : selectedLanguage,
	autoclose:true
}).on('changeDate',function(e) {
	var dt = new Date(e.date).getDate() + '-' + (new Date(e.date).getMonth() + 1) + '-' + new Date(e.date).getFullYear();
	console.log("Selected Date - " + dt);
});

</script>
<%
}catch(Exception e){
e.printStackTrace();
}
%>