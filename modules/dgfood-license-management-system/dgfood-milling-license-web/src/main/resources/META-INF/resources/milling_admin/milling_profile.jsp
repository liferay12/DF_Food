<%@page import="bd.gov.dgfood.license.management.system.constants.LicenseConstants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/milling_admin/init.jsp" %>

<%
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	MillingLicense millingLicense = (MillingLicense) request.getAttribute("millingLicense");
	FGLicense fgLicense = (FGLicense) request.getAttribute("fgLicense");
	Address millingAddress = (Address) request.getAttribute("millingAddress");
	HashMap<String,Attachment> attachmentEntryMap = (HashMap<String,Attachment>) request.getAttribute("attachmentEntryMap");
%>

<br />
<h3>Preview</h3>
<br />
<h3>
	<liferay-ui:message key="food-grain-license-information"></liferay-ui:message>
</h3>
<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="foodGrainLicenseNumber-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_foodGrainLicenseNumber'><%=fgLicense != null && fgLicense.getFoodGrainLicenseNo() != null ? fgLicense.getFoodGrainLicenseNo() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="foodGrainLicenseIssueDate-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_foodGrainLicenseIssueDate'><%=fgLicense != null && fgLicense.getFoodGrainLicenseIssueDate() != null ? dateFormat.format(fgLicense.getFoodGrainLicenseIssueDate()) : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="foodGrainLicenseValidity-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_foodGrainLicenseValidity'><%=fgLicense != null && fgLicense.getFoodGrainLicenseValidity() !=null ? dateFormat.format(fgLicense.getFoodGrainLicenseValidity()) : StringPool.BLANK%></span>
	</div>
</div>

<h3>
	<liferay-ui:message key="spouse-information"></liferay-ui:message>
</h3>
<div class="row">
	<div class='col-6'>
		<liferay-ui:message key="maritalStatus-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_maritalStatus'><%=millingLicense != null ? millingLicense.getMaritalStatus() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="spouseName-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_spouseName'><%=millingLicense != null ? millingLicense.getSpouseName() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="spouseFatherName-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_spouseFatherName'><%=millingLicense != null ? millingLicense.getSpouseFatherName() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="spouseNationalId-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_spouseNationalId'><%=millingLicense != null ? millingLicense.getSpouseNationalId() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="spouseDateOfBirth-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_spouseDateOfBirth'><%=millingLicense != null ? dateFormat.format(millingLicense.getSpouseDateOfBirth()) : StringPool.BLANK%></span>
	</div>
</div>


<h3>
	<liferay-ui:message key="mill-operator-information"></liferay-ui:message>
</h3>
<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="operatorName-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_operatorName'><%=millingLicense != null ? millingLicense.getOperatorName() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="operatorNationalId-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_operatorNationalId'><%=millingLicense != null ? millingLicense.getOperatorNationalId() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="operatorRunningBusinessFromYears-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_operatorRunningBusinessFromYears'><%=millingLicense != null ? millingLicense.getOperatorRunningBusinessFromYrs() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="operatorPhotograph-document"></liferay-ui:message>
		<a id="<portlet:namespace/>operatorPhotographLink" href="" target="_blank" >
			<img id="<portlet:namespace/>operatorPhotographImg"></img>
		</a>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="ownMillOperates-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_ownMillOperates'><%=millingLicense != null ? millingLicense.getOperateOwnMill() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millerThirdParty-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millerThirdParty'><%=millingLicense != null ? millingLicense.getMillOperatingThroughThirdParty() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="publicRepresentative-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_publicRepresentative'><%=millingLicense != null ? millingLicense.getPublicRepresentative() : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="workInGovt-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_workInGovt'><%=millingLicense != null ? millingLicense.getWorkInGovernment() : StringPool.BLANK%></span>
	</div>
</div>

<h3>
	<liferay-ui:message key="mill-information"></liferay-ui:message>
</h3>

<div class='row'>
	<div class='col-6'>
		<liferay-ui:message key="millName-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millName'><%=millingLicense != null && millingLicense.getMillDetails() != null ? 
				millingLicense.getMillDetails().get(LicenseConstants.MILL_NAME) : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millLength-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millLength'><%=millingLicense != null && millingLicense.getMillDetails() != null ? 
				millingLicense.getMillDetails().get(LicenseConstants.MILL_LENGTH) : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millHeight-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millHeight'><%=millingLicense != null && millingLicense.getMillDetails() != null ? 
				millingLicense.getMillDetails().get(LicenseConstants.MILL_HEIGHT) : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millWidth-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millWidth'><%=millingLicense != null && millingLicense.getMillDetails() != null ? 
				millingLicense.getMillDetails().get(LicenseConstants.MILL_WIDTH) : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millStorage-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millStorage'><%=millingLicense != null && millingLicense.getMillDetails() != null ? 
				millingLicense.getMillDetails().get(LicenseConstants.MILL_STORAGE) : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="typeOfMill-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_typeOfMill'><%=millingLicense != null && millingLicense.getMillDetails() != null ? 
				millingLicense.getMillDetails().get(LicenseConstants.MILL_TYPE) : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millFloorPaved-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millFloorPaved'><%=millingLicense != null && millingLicense.getMillDetails() != null ? 
				millingLicense.getMillDetails().get(LicenseConstants.MILL_FLOOR_PAVED) : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="typeOfRice-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_typeOfRice'><%=millingLicense != null && millingLicense.getMillDetails() != null ? 
				millingLicense.getMillDetails().get(LicenseConstants.RICE_TYPE) : StringPool.BLANK%></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="incomeTaxDocument-document"></liferay-ui:message>
		<a id="<portlet:namespace/>incomeTaxDocumentLink" href="" target="_blank" >
			<img id="<portlet:namespace/>incomeTaxDocumentImg"></img>
		</a>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="signatureThumbImpression-document"></liferay-ui:message>
		<a id="<portlet:namespace/>signatureThumbImpressionLink" href="" target="_blank" >
			<img id="<portlet:namespace/>signatureThumbImpressionImg"></img>
		</a>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="tradeLicenseNumberPhotocopy-document"></liferay-ui:message>
		<a id="<portlet:namespace/>tradeLicenseNumberPhotocopyLink" href="" target="_blank" >
			<img id="<portlet:namespace/>tradeLicenseNumberPhotocopyImg"></img>
		</a>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="relevant-document"></liferay-ui:message>
		<div class="multipleDocs">
		
		</div>
	</div>
</div>
	
<h3><liferay-ui:message key="mill-address-information"></liferay-ui:message></h3>

<div class='row'>
	
	<div class='col-6'>
		<liferay-ui:message key="millRegion-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millRegion'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millZilla-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millZilla'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millUpazilla-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millUpazilla'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millUnion-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millUnion'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millVillage-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millVillage'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millWard-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millWard'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millZipCode-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millZipCode'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millPostOffice-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millPostOffice'></span>
	</div>
	<div class='col-6'>
		<liferay-ui:message key="millAddress-label"></liferay-ui:message>
		: <span id='<portlet:namespace/>preview_millAddress'></span>
	</div>
</div>
