<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys"%>
<%@page import="bd.gov.dgfood.common.util.constants.DateConstants"%>
<%@page import="bd.gov.dgfood.license.management.system.model.FGLicenseInfo"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page	import="bd.gov.dgfood.common.util.validator.DataValidationException"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="bd.gov.dgfood.common.util.constants.DocumentLibraryConstants"%>
<%@page import="bd.gov.dgfood.common.services.model.AttachmentVersion"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.common.services.exception.NoSuchAttachmentException"%>
<%@page import="bd.gov.dgfood.common.services.exception.NoSuchAddressException"%>
<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.FileConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="bd.gov.dgfood.common.util.DateFormatterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/jsp/init.jsp"%>

<%
	String acceptedExtensions = StringUtil.merge(FileConstants.JPG_JPEG_PNG, StringPool.COMMA_AND_SPACE);
	String acceptedDocumentExtensions = StringUtil.merge(FileConstants.PDF_DOC_DOCX, StringPool.COMMA_AND_SPACE);

	FGLicenseInfo fgLicense = (FGLicenseInfo) request.getAttribute("fgLicenseInfo");
	User fgUser = (User)request.getAttribute("fgUser");
	AttachmentVersion challanAttachment = (AttachmentVersion)request.getAttribute("challanAttachment");
	String back = ParamUtil.getString(request, "backURL");
	
%>
<%
		String statusLabel = StatusConstants.getStatusLabel(fgLicense.getStatus());
		String cssClass = StringPool.BLANK;

		if(fgLicense.getStatus() == StatusConstants.STATUS_APPROVED 
				|| fgLicense.getStatus() ==  StatusConstants.STATUS_LICENSE_ISSUED){
			cssClass = "alert alert-success";
		}else if(fgLicense.getStatus() == StatusConstants.STATUS_REJECTED){
			cssClass = "alert alert-danger";
		}else if(fgLicense.getStatus() == StatusConstants.STATUS_PENDING 
				|| fgLicense.getStatus() ==  StatusConstants.STATUS_PAYMENT_NOT_VERIFIED 
				|| fgLicense.getStatus() ==  StatusConstants.STATUS_FIRST_LEVEL_APPROVED){
			cssClass = "alert alert-warning";
		}else if(fgLicense.getStatus() == StatusConstants.STATUS_CHALLAN_UPLOADED){
			cssClass = "alert alert-info";
		}
%>

<portlet:actionURL var="submitPaymentChallanDataURL"
	name="<%=FoodGrainLicensePortletKeys.SUBMIT_PAYMENT_CHALLAN_FG_LICENSE_MVC_ACTION_COMMAND%>">
	<portlet:param name="<%=ParameterConstants.FGLICENSE_ID%>"
		value="<%=String.valueOf(fgLicense.getFgLicenseInfoId())%>" />
	<%-- <portlet:param name="<%=ParameterConstants.APPLICATION_TYPE%>"
		value="<%=LicenseConstants.LMS_NEW %>" /> --%>
</portlet:actionURL>

<liferay-portlet:resourceURL id="<%=FoodGrainLicensePortletKeys.POPULATE_PROFILE_DETAILS_MVC_RESOURCE_COMMAND%>" 
	var="populateProfileDetailsURL" copyCurrentRenderParameters="false" />
<aui:input type="hidden" name="populateProfileDetailsURL" value="<%=populateProfileDetailsURL%>" />


	<div class='row'>
		<div class="col-6">
			<aui:input name="nationalId" cssClass="form-control"
				id="nationalId" label="label-nationalId" readOnly="readOnly" type="text" placeholder="label-nationalId"
				value="<%=fgLicense != null ? fgLicense.getNationalId() : StringPool.BLANK%>">
			</aui:input>
		</div>
		
		<div class="col-6">
			<aui:input name="dateOfBirth" cssClass="form-control"
				id="dateOfBirth" label="label-date-of-birth" readOnly="readOnly" type="text"
				placeholder="label-date-of-birth"
				value="<%=user != null ? DateFormatterUtil.parseDate(fgUser.getBirthday(),DateConstants.DD_MM_YYYY) : StringPool.BLANK%>">
			</aui:input>
		</div>

	</div>
	
	<div class='row'>
		<h3>
			<span><%=fgLicense.getApplicationNumber()%></span>
		</h3>
	</div>
	
	<div class="<%=cssClass%> row" role="alert">
			<div class="col-6">
				<%=LanguageUtil.get(request, statusLabel)%>
			</div>
			<% 
				if(Validator.isNotNull(fgLicense) && 
						(fgLicense.getStatus() == StatusConstants.STATUS_REJECTED)){
					out.println(StatusConstants.STATUS_REJECTED);
			%>
				<div class="col-3">
					Workflow Comment
				</div>		
			<% 
				}
			%>
			<div class="col-6">
				<span><%=LanguageUtil.get(request,"label-applied-on")%> :</span>
				<span><%=DateFormatterUtil.parseDate(fgLicense.getCreateDate(),DateConstants.DD_MM_YYYY)%></span>
			</div>
		</div>
	
	<%
			if (Validator.isNotNull(fgLicense) && 
				(fgLicense.getStatus() == StatusConstants.STATUS_LICENSE_ISSUED 
			|| fgLicense.getStatus() == StatusConstants.STATUS_CHALLAN_UPLOADED)) {
		%>
		<div class="row">
			<div class='col-6'>
			<span><%=LanguageUtil.get(request,"label-applied-on")%> : </span>
				<dgfood-ui:message key="label-transaction-no" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span ><%-- <%=fgLicense != null ? fgLicense.getTransactionNumber() : StringPool.BLANK %> --%></span>
			</div>
		<%
		if (Validator.isNotNull(challanAttachment)) {
		%>
			<div class='col-6'>
	    		<dgfood-ui:message key="label-payment-challan-document" languageId="<%=themeDisplay.getLanguageId()%>" />
		          <dgfood-ui:attachment-preview   title='<%= challanAttachment.getTitle()%>' 
		          previewURL='<%=challanAttachment.getMetadata() != null ? (String)challanAttachment.getMetadata().get(DocumentLibraryConstants.PREVIEW_URL) : null%>' 
		          extension='<%=challanAttachment.getMetadata() != null ? (String)challanAttachment.getMetadata().get(DocumentLibraryConstants.EXTENSION) : null%>'/>
			</div>
		<%
			}
		
			if(fgLicense.getStatus() == StatusConstants.STATUS_LICENSE_ISSUED){
		%>
			<div>
				<span><dgfood-ui:message key="labe-note" languageId="<%=themeDisplay.getLanguageId()%>" /></span>
				<span><dgfood-ui:message key="label-please-collect-your-license-from-dg-food-office" languageId="<%=themeDisplay.getLanguageId()%>" /></span>
			</div>			
		<%		
		}
		%>
		</div>
		<%
			}else if (Validator.isNotNull(fgLicense) && (fgLicense.getStatus() == StatusConstants.STATUS_APPROVED 
										  || fgLicense.getStatus() == StatusConstants.STATUS_PAYMENT_NOT_VERIFIED)) {
		%>
		
		<aui:form name="form" action="<%=submitPaymentChallanDataURL%>" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-6">
					<label for="transactionNumber"><dgfood-ui:message
							key="label-transaction-no"
							languageId="<%=themeDisplay.getLanguageId()%>" /><span
						class="txt-red">*</span></label>
					<aui:input name="<%=ParameterConstants.TRANSACTION_NUMBER%>"
						cssClass="form-control validate" label="" type="text"
						placeholder="label-transaction-no"
						value="" maxLength="30" minLength="1">
						<aui:validator name="alphanum" />
						<aui:validator name="required"
							errorMessage="error-label-transaction-no" />
						<aui:validator name="maxLength"
							errorMessage="error-label-max-length-thirty">30</aui:validator>
						<aui:validator name="minLength"
							errorMessage="error-label-min-length-one">1</aui:validator>
					</aui:input>
				</div>
				<div class="col-6">
					<dgfood-ui:attachment-upload name="<%=ParameterConstants.CHALLAN_DOCUMENT%>"
						required="true" accept='<%=acceptedExtensions%>'
						multiple="<%=false%>" maxSize='<%=FileConstants.TWO_MB%>'
						previewContainerId='<%=liferayPortletResponse.getNamespace() + "challanDocumentContainer"%>' />
				</div>
				<div class='col-6'>
					<dgfood-ui:message key="label-payment-challan-document" languageId="<%=themeDisplay.getLanguageId()%>" />
					<div id="<portlet:namespace/>challanDocumentContainer"></div>
				</div>
			</div>
			<aui:button-row>
				<aui:button type="submit" value="label-submit"></aui:button>
				<aui:button type="cancel" value="label-back" href="<%=back%>"></aui:button>
			</aui:button-row>
		</aui:form>
		<%
			}
		%>
		
	
	<!-- Trade License No -->
	<portlet:renderURL var="populateProfileDetailsURL">
		<portlet:param name="mvcPath" value="/jsp/fglicense_status_check/profile_details.jsp" />
		<portlet:param name="fgLicense" value="<%=String.valueOf(fgLicense.getFgLicenseInfoId())%>" />
		<portlet:param name="fgUser" value="<%=String.valueOf(fgUser.getUserId())%>" />
		
	</portlet:renderURL>
	
	<div class='row'>
	<aui:form name="profile-details-form" action="<%=populateProfileDetailsURL.toString()%>" method="post" enctype="multipart/form-data">
		<aui:input type="hidden" name="applicationNumber" value="<%=fgLicense.getApplicationNumber()%>" />
		<div id="trade_div">
			<label for="tradeLicenseNumber"><dgfood-ui:message key="label-trade-license-no"
					languageId="<%=themeDisplay.getLanguageId()%>" /><span class="txt-red">*</span></label>
			<aui:input name="<%=ParameterConstants.TRADE_LICENSE_NUMBER%>"
				cssClass="validate preview" label="" type="text"
				placeholder="label-trade-license-no"
				value="" maxLength="30" minLength="1">
				<aui:validator name="alphanum" />
				<aui:validator name="required"
					errorMessage="error-label-trade-license-no" />
				<aui:validator name="maxLength"
					errorMessage="error-label-max-length-thirty">30</aui:validator>
				<aui:validator name="minLength"
					errorMessage="error-label-min-length-one">1</aui:validator>
			</aui:input>
		</div>
		<aui:button-row>
			<aui:button id="populateProfileDetails" type="submit" cssClass="btn btn-primary"
				value="label-submit" />
		</aui:button-row>
	</aui:form>
	</div>
	
	<div id="<portlet:namespace/>profileDetails" style="display: none;">
		<liferay-util:include page="/jsp/fglicense_status_check/profile_details.jsp"
		servletContext="<%= application %>" />
	</div>
	
	<div id="<portlet:namespace/>enteredTradeLicenseError" style="display: none;">
		<clay:alert message="error-label-trade-license-not-matched" 
			style="danger" title="Error" />
	</div>



<script src="<%=request.getContextPath()%>/js/main.js?v=1.1"></script>
