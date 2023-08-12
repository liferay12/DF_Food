<%@page import="bd.gov.dgfood.common.util.constants.RoleConstants"%>
<%@ include file="/init.jsp" %>

<div class="row">
	<div class="col-12">
		<aui:button cssClass="login_btn" title="Back" type="button"  href="<%=viewList%>" value="<%=CustomLanguageUtil.get(request,"back")%>" id="back" />
	</div>
</div>

<portlet:actionURL var="submitReplyDataURL" name="/grievance/reply"></portlet:actionURL>

<liferay-ui:error key="label-grievance-reply-submission-failed" message="<%=CustomLanguageUtil.get(request,"label-grievance-reply-submission-failed")%>"/>

<div id="contentDiv">
<%
long grievanceId = ParamUtil.getLong(request, "grievanceId");
String redirect = ParamUtil.getString(request, "redirect");
Grievance grievance = GrievanceLocalServiceUtil.fetchGrievance(grievanceId);
%>

<div class="row">
				<div class="col-6">
					<label ><liferay-ui:message key="grievance-category-label" /></label>
					<%=CategoryUtil.fetchCategoryNamebyCategoryId(grievance.getGrievanceCategory(), themeDisplay.getLocale())%>
				</div>
				<div class="col-6">
					<label ><liferay-ui:message key="user-type-label" /></label>
					<%=CategoryUtil.fetchCategoryNamebyCategoryId(grievance.getUserType(), themeDisplay.getLocale())%>
				</div>
</div>

<div class="row">
				<div class="col-6">
					<label ><liferay-ui:message key="name-of-user-label" /></label>
					<%=grievance.getUserName()%>
				</div>
				<div class="col-6">
						<label ><liferay-ui:message key="mobile-number-label" /></label>
						<clay:icon symbol="hi-in" /><%=grievance.getMobileNumber()%>
				</div>
</div>

<div class="row">
			<div class="col-12">
					<label ><liferay-ui:message key="complaint-details-label" /></label>
					<%=grievance.getComplaintDetails()%>
			</div>
</div>
<div class="row">
		<div class="col-12">
			<label ><liferay-ui:message key="attachments-label" /></label>
			<a target="_blank" href="<%=DLUploadUtil.getFileURL(themeDisplay, grievance.getAttachmentId())%>">View Attachment</a>
		</div>
</div>

<%if(renderRequest.isUserInRole(RoleConstants.UCF) && Validator.isNull(grievance.getResponseDetails())){%>
<aui:form name="grievanceReplyForm" action="<%=submitReplyDataURL%>" method="post" enctype="multipart/form-data">
<aui:input type="hidden" id="grievanceId" name="grievanceId" label="" value="<%=grievanceId %>"></aui:input>
<aui:input type="hidden" id="redirectURL" name="redirectURL" label="" value="<%=redirect %>"></aui:input>
<div class="row">
<div class="col-12">
<label ><liferay-ui:message key="reply-details-label" /></label>
		<aui:input name="responseDetails" cssClass="form-control" id="responseDetails" label="" type="textarea" placeholder="complaint-reply-placeholder" 
			value="" maxLength="3000" minLength="1">
			<aui:validator name="required" errorMessage="complaint-reply-error-label" />
		</aui:input>
</div>
</div>
<div class="row">
	<div class="col-12">
		<aui:button cssClass="login_btn" title="Reply" type="submit" value="Reply" id="reply" />
		<aui:button href="<%= redirect %>" title="Cancel" type="button" value="Cancel" id="cancel" />
	</div>
</div>
</aui:form>
<%}%>

<%if(!renderRequest.isUserInRole(RoleConstants.UCF) && Validator.isNull(grievance.getResponseDetails())){
%>
<br>
<div class="container">
<i>Your grievance is being reviewed by our officials and the status will be updated soon.</i>
</div>
<%}else if(Validator.isNotNull(grievance.getResponseDetails())){%>
<div class="container">
Response Details : <%=grievance.getResponseDetails()%>
</div>
<div class="container">
Response By : <%=grievance.getResponseBy()%>
</div>
<div class="container">
Response Date : <%=DateFormatterUtil.parseDate(grievance.getResponseDate(),DateConstants.DD_MMM_YYYY)%>
</div>
<%}%>
</div>
