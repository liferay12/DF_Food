<%@page import="bd.gov.dgfood.farmer.information.management.system.exception.FarmerSalesProposalInternalErrorException"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants"%>
<%@page import="bd.gov.dgfood.common.util.validator.DataValidationException"%>
<%@ include file="../init.jsp" %>

<liferay-ui:error message="${errorKey}" exception="<%=DataValidationException.class %>"></liferay-ui:error>
<liferay-ui:error message="${errorKey}" exception="<%=FarmerSalesProposalInternalErrorException.class %>"></liferay-ui:error>

<portlet:actionURL var="submitSalesProposalURL" 
	name="<%=FarmerInformationManagementSystemConstants.SUBMIT_SALES_PROPOSAL_FORM_ACTION_COMMAND%>" />

<liferay-portlet:resourceURL id="<%=FarmerInformationManagementSystemConstants.VALIDATE_CAPTCHA_RESOURCE_COMMAND%>" 
	var="validateCaptchaURL" copyCurrentRenderParameters="false" />

<aui:form action="${submitSalesProposalURL}" method="post" name="new-sales-proposal" enctype="multipart/form-data">
	
	<input type="hidden" value="<portlet:namespace/>" id="portletNamespace"/>
	<aui:input type="hidden" value="${validateCaptchaURL}" name="validateCaptchaURL"/>
	
	<div class="fims_spa_step" id='<portlet:namespace/>farmer_information' >
	    <liferay-util:include page="/sales-proposal/steps/farmer_information.jsp" servletContext="<%= application %>" />
	</div>
	
	<div class="fims_spa_step fims_spa_step_hide" id='<portlet:namespace/>foodgrain_production_details'>
	    <liferay-util:include page="/sales-proposal/steps/foodgrain_production_details.jsp" servletContext="<%= application %>" />
	</div>
	
	<div class="fims_spa_step fims_spa_step_hide" id='<portlet:namespace/>summary_page'>
	    <liferay-util:include page="/sales-proposal/steps/summary_page.jsp" servletContext="<%= application %>" />
	</div>
</aui:form>  

<script src="<%=request.getContextPath()%>/js/select2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/main.js?v=1.1"></script>
<script src="<%=request.getContextPath()%>/js/sales-proposal-main.js?v=1.1"></script>
<script src="<%=request.getContextPath()%>/js/sales-proposal-test-script.js?v=1.1"></script>
