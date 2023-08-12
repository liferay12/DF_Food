<%@ include file="../init.jsp"%>

<%
	FGLicenseInfo fgLicenseInfo = null;
	if (Validator.isNotNull(renderRequest.getAttribute(FGLicenseInfo.class.getSimpleName()))) {

		fgLicenseInfo = (FGLicenseInfo) renderRequest.getAttribute(FGLicenseInfo.class.getSimpleName());
	}

	FGLicenseDetails fgLicenseDetails = null;
	if (Validator.isNotNull(renderRequest.getAttribute(FGLicenseDetails.class.getSimpleName()))) {

		fgLicenseDetails = (FGLicenseDetails) renderRequest
				.getAttribute(FGLicenseDetails.class.getSimpleName());
	}

	Address presentAddress = null;
	if (Validator.isNotNull(renderRequest.getAttribute(AddressConstants.ADDRESS_PRESENT))) {
		presentAddress = (Address) renderRequest.getAttribute(AddressConstants.ADDRESS_PRESENT);
	}

	Address permanentAddress = null;
	if (Validator.isNotNull(renderRequest.getAttribute(AddressConstants.ADDRESS_PERMANENT))) {
		permanentAddress = (Address) renderRequest.getAttribute(AddressConstants.ADDRESS_PERMANENT);
	}

	Address businessAddress = null;
	if (Validator.isNotNull(renderRequest.getAttribute(AddressConstants.ADDRESS_BUSINESS))) {
		businessAddress = (Address) renderRequest.getAttribute(AddressConstants.ADDRESS_BUSINESS);
	}

	List<Attachment> fglAttachments = new ArrayList<>();
	if (Validator.isNotNull(renderRequest.getAttribute(ParameterConstants.ATTACHMENTS))) {
		fglAttachments = (List<Attachment>) renderRequest.getAttribute(ParameterConstants.ATTACHMENTS);
	}
%>

<input type="hidden" value="<portlet:namespace/>" id="portletNamespace" />

<c:if test="<%=Validator.isNotNull(fgLicenseInfo)%>">

	<%
		String statusLabel = StatusConstants.getStatusLabel(fgLicenseInfo.getStatus());
			String cssClass = StringPool.BLANK;

			if (fgLicenseInfo.getStatus() == StatusConstants.STATUS_APPROVED) {
				cssClass = "alert alert-success";
			} else if (fgLicenseInfo.getStatus() == StatusConstants.STATUS_REJECTED) {
				cssClass = "alert alert-danger";
			} else if (fgLicenseInfo.getStatus() == StatusConstants.STATUS_PENDING) {
				cssClass = "alert alert-warning";
			}
	%>

	<div class="<%=cssClass%>" role="alert">
		<div class="col-6">
			<liferay-ui:message key="<%=StatusConstants.getStatusCssClass(fgLicenseInfo.getStatus())%>" />
		</div>
		<div class="col-6"></div>
	</div>

</c:if>

<script src="<%=request.getContextPath()%>/js/fglicense-list.js?v=1.1"></script>
