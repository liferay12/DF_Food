<%@page import="com.liferay.portal.kernel.model.Company"%>
<%@page import="com.liferay.portal.kernel.service.CompanyLocalServiceUtil"%>
<%@include file="/jsp/init.jsp"%>
<style>
.field_hide {
	display: none
}
</style>

<%	String back = ParamUtil.getString(request, "backURL"); %>

<portlet:renderURL var="submitInputDataForStatusURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FoodGrainLicensePortletKeys.FG_LICENSE_STATUS_MVC_RENDER_COMMAND%>" />
	<portlet:param name="backURL"
		value="<%=themeDisplay.getURLCurrent()%>" />
</portlet:renderURL>

<liferay-ui:error message="${errorKey}" exception="<%=Exception.class %>" />
	
<liferay-ui:error key="error-label-no-fglicense-found" message="error-label-no-fglicense-found" />


<aui:form name="form" action="<%=submitInputDataForStatusURL%>" method="post">

	<div class="row">
		<div class="col-6" id='<portlet:namespace/>nationalId_div'>
			<aui:input name="nationalId" cssClass="form-control validate" id="nationalId" label="label-nationalId" type="text"
				placeholder="label-nationalId" value="9892098920" maxLength="17" minLength="10">
				<aui:validator name="required" errorMessage="error-label-nationalId" />
				<aui:validator name="custom" errorMessage="error-label-length-nationalId">
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
				<aui:validator name="maxLength" errorMessage="error-label-max-length-seventeen">17</aui:validator>
				<aui:validator name="minLength" errorMessage="error-label-min-length-thirteen">10</aui:validator>
				<aui:validator name="number" />
			</aui:input>
		</div>
	</div>
	<div class="row">
		<div class="col-6" id='<portlet:namespace/>applicationNumber_div'>
			<aui:input name="applicationNumber" cssClass="form-control validate" id="applicationNumber" label="label-application-number" type="text"
				placeholder="label-application-number" value="12890AA" maxLength="20" minLength="1">
				<aui:validator name="required" errorMessage="error-label-application-number" />
				<aui:validator name="maxLength" errorMessage="error-label-max-length-twenty">20</aui:validator>
				<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
				<aui:validator name="alphanum" />
			</aui:input>
		</div>
	</div>
	<div class="row">
		<div class="col-6">
			<aui:input name="dateOfBirth" cssClass="form-control validate" id="dateOfBirth" label="label-date-of-birth" onkeydown="return false" type="text"
				placeholder="label-date-of-birth" value="07-08-1991">
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
				<aui:validator name="custom" errorMessage="error-label-date">
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
		<aui:button type="submit" value="label-submit"></aui:button>
		<aui:button type="cancel" value="label-back" href="<%=back%>"></aui:button>
	</aui:button-row>
	
</aui:form>
<script>
	var selectedLanguage = themeDisplay.getLanguageId().split("_")[0];
	console.log("selectedLanguage - " + selectedLanguage);
	var today = new Date();
	$("#<portlet:namespace/>dateOfBirth").datepicker({
		format : 'dd-mm-yyyy',
		pickTime : false,
		endDate : today,
		locale : selectedLanguage,
		language : selectedLanguage,
		autoclose : true
	}).on(
			'changeDate',
			function(e) {
				var dt = new Date(e.date).getDate() + '-'
						+ (new Date(e.date).getMonth() + 1) + '-'
						+ new Date(e.date).getFullYear();
				console.log("Selected Date - " + dt);
			});
</script>