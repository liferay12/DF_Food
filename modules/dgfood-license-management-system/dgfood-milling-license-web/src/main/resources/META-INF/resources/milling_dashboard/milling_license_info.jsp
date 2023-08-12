<%@include file="/milling_dashboard/init.jsp"%>

<%
MillingLicense millingLicense = (MillingLicense) request.getAttribute("millingLicense");
String back = ParamUtil.getString(request, "backURL");
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
%>

<portlet:renderURL var="duplicateMillingLicenseFormDataURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MillingLicensePortletKeys.RENEWAL_DUPLICATE_MILLING_MVC_RENDER_COMMAND%>" />
	<portlet:param name="millingLicenseId"
		value="<%=String.valueOf(millingLicense.getMillingLicenseId())%>" />
	<portlet:param name="backURL"
		value="<%=themeDisplay.getURLCurrent()%>" />
	<portlet:param name="backURL"
		value="duplicate" />
</portlet:renderURL>
<portlet:renderURL var="millingLicenseRenewalFormDataURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MillingLicensePortletKeys.RENEWAL_DUPLICATE_MILLING_MVC_RENDER_COMMAND%>" />
	<portlet:param name="millingLicenseId"
		value="<%=String.valueOf(millingLicense.getMillingLicenseId())%>" />
	<portlet:param name="backURL"
		value="<%=themeDisplay.getURLCurrent()%>" />
	<portlet:param name="backURL"
		value="renewal" />
</portlet:renderURL>

<div class='row'>
	<div class='col-6'>
		<div>
			<liferay-ui:message key="milling-license-number-label"></liferay-ui:message>
			: <span><%=millingLicense != null ? millingLicense.getMillingLicenseNumber() : StringPool.BLANK%></span>
		</div>
		
		<div>
			<liferay-ui:message key="license-date-of-issue-label"></liferay-ui:message>
		: <span><%=millingLicense != null && millingLicense.getMillingLicenseIssuedDate() != null ? dateFormat.format(millingLicense.getMillingLicenseIssuedDate()) : StringPool.BLANK%></span>
		</div>
		
		<div>
			<liferay-ui:message key="milling-license-expiry-date-label"></liferay-ui:message>
		: <span><%=millingLicense != null && millingLicense.getMillingLicenseExpiryDate() != null ? dateFormat.format(millingLicense.getMillingLicenseExpiryDate()) : StringPool.BLANK%></span>
		</div>
		
		<div>
			<aui:button-row>
				<aui:button type="button" href="<%=millingLicenseRenewalFormDataURL%>"
					value='license-renewal'>
				</aui:button>
				<aui:button type="button" href="<%=duplicateMillingLicenseFormDataURL%>"
					value='duplicate-license'>
				</aui:button>
			</aui:button-row>
		</div>
	</div>
</div>

<h3>
	<liferay-ui:message key="license-applicaton-history"></liferay-ui:message>
</h3>
<div class='row'>
	<div class="col-6">
	</div>
	<div class="col-6">
	</div>
</div>

