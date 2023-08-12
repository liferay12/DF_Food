<%-- <%@page import="bd.gov.dgfood.taglib.util.CustomLanguageUtil"%> --%>
<%@page import="bd.gov.dgfood.common.services.model.DGFUsers"%>
<%@page import="bd.gov.dgfood.common.services.service.DGFUsersLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.common.services.model.UserDetails"%>
<%@page import="bd.gov.dgfood.common.services.service.UserDetailsLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.common.services.model.Address"%>
<%@page import="bd.gov.dgfood.common.services.service.AddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.license.management.system.service.FGLicenseInfoLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.license.management.system.model.FGLicenseDetails"%>
<%@page import="bd.gov.dgfood.license.management.system.service.FGLicenseDetailsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.DocumentLibraryConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.AddressConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.license.management.system.model.FGLicenseInfo"%>
<%@include file="/jsp/init.jsp"%>

<%
	String fgLicenseId = ParamUtil.getString(request,"fgLicense","0");
	FGLicenseInfo fgLicense=FGLicenseInfoLocalServiceUtil.getFGLicenseInfo(Long.valueOf(fgLicenseId));
	Address address = fgLicense != null?AddressLocalServiceUtil.getAddress(fgLicense.getBusinessAddressId()):null;
	FGLicenseDetails fgLicenseDetails = fgLicense!=null?FGLicenseDetailsLocalServiceUtil.getFGLicenseDetails(fgLicense.getFgLicenseMasterId()):null ;
	UserDetails userDetails = fgLicense!=null?UserDetailsLocalServiceUtil.findByNationalId(fgLicense.getNationalId()):null;
	DGFUsers dgfUsers = fgLicense!=null?DGFUsersLocalServiceUtil.findByNationalId(fgLicense.getNationalId()):null;
%>

<div id="<portlet:namespace/>licenseDetails" style="display: none;">
	<div class='col-6'>
		<%-- <dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_FOOD_GRAIN_LICENSE_NUMBER%>" languageId="<%=themeDisplay.getLanguageId()%>"/> --%>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOOD_GRAIN_LICENSE_NUMBER %>_preview'></span>
	</div>
	<div class='col-6'>
		<%-- <dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_FOOD_GRAIN_LICENSE_VALIDITY%>" languageId="<%=themeDisplay.getLanguageId()%>"/> --%>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOOD_GRAIN_LICENSE_VALIDITY %>_preview'></span>
	</div>
</div>

<h3>
	<dgfood-ui:message key="label-basic-information" />
</h3>
<div class='row'>
	<div class='col-6'>
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_NATIONAL_ID%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.NATIONAL_ID %>_preview'><%=fgLicense!=null?fgLicense.getNationalId():"" %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_EMAIL_ADDRESS%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.EMAIL_ADDRESS %>_preview'><%=dgfUsers!=null?dgfUsers.getEmail():"" %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MOBILE_NUMBER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MOBILE_NUMBER %>_preview'><%=dgfUsers!=null?dgfUsers.getMobileNumber():"" %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_DATE_OF_BIRTH%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.DATE_OF_BIRTH %>_preview'><%=dgfUsers!=null?dgfUsers.getBirthDate():"" %></span>
	</div>
	<div class='col-6'>
		<%-- <dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_APPLICANT_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/> --%>
		: <span id='<portlet:namespace/><%=ParameterConstants.APPLICANT_NAME %>_preview'><%=fgLicense.getApplicantName() %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_FATHER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FATHER_NAME %>_preview'><%=userDetails!=null?userDetails.getFatherName():"" %>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MOTHER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MOTHER_NAME %>_preview'><%=userDetails!=null?userDetails.getMotherName():"" %>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_GENDER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.GENDER %>_preview'><%=userDetails!=null?userDetails.getGender():"" %>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MARITAL_STATUS%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MARITAL_STATUS %>_preview'><%=dgfUsers!=null?dgfUsers.getMaritalStatus():"" %></span>
	</div>
</div>


<h3>
	<dgfood-ui:message key="label-trade-license-information" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<div class='row'>
	<div class='col-6'>
		<dgfood-ui:message key="label-trade-license-no" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TRADE_LICENSE_NUMBER %>_preview'><%=fgLicenseDetails!=null?fgLicenseDetails.getTradeLicenseNumber():"" %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="label-trade-license-validity" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TRADE_LICENSE_VALIDITY %>_preview'><%=fgLicenseDetails!=null?fgLicenseDetails.getTradeLicenseExpiryDate():"" %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="label-tax-identification-no" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TAX_IDENTIFICATION_NUMBER %>_preview'><%=fgLicenseDetails!=null?fgLicenseDetails.getTaxIdentificationNumber():"" %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="label-business-identification-no" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER %>_preview'><%=fgLicenseDetails!=null?fgLicenseDetails.getBusinessIdentificationNumber():"" %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="label-trade-license-issuer-code" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TRADE_LICENSE_ISSUER_CODE %>_preview'><%=fgLicenseDetails!=null?fgLicenseDetails.getTradeLicenseIssuerCode():"" %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="label-trade-license-issuer-city" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.TRADE_LICENSE_ISSUER_CITY %>_preview'><%=fgLicenseDetails!=null?fgLicenseDetails.getTradeLicenseIssuerCity():"" %></span>
	</div>
</div>

<h3>
	<dgfood-ui:message key="label-trade-license-information" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<div class='row'>
	<div class='col-6'>
		<dgfood-ui:message key="label-trade-license-no" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.BUSINESS_NAME %>_preview'><%=fgLicenseDetails!=null?fgLicenseDetails.getTradeLicenseNumber():"" %></span>
	</div>
	<div class='col-6'>
		<dgfood-ui:message key="label-trade-license-validity" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.BUSINESS_TYPE %>_preview'><%=fgLicenseDetails!=null?fgLicenseDetails.getTradeLicenseExpiryDate():"" %></span>
	</div>
	<div class='col-12'>
		<dgfood-ui:message key="label-address" languageId="<%=themeDisplay.getLanguageId()%>" />:
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.REGION %>_preview'><%=address!=null?address.getRegion():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.ZILLA %>_preview'>Test Zilla</span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.UPAZILA %>_preview'><%=address!=null?address.getUpazilla():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'><%=address!=null?address.getCityCorporationOrMunicipality():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.UNION_OR_WARD %>_preview'><%=address!=null?address.getUnionOrWard():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.ZIP_CODE %>_preview'><%=address!=null?address.getZipCode():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.POST_OFFICE %>_preview'><%=address!=null?address.getPostOffice():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.VILLAGE_OR_ROAD %>_preview'><%=address!=null?address.getVillageOrRoad():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'><%=address!=null?address.getMouzaOrMoholla():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_BUSINESS+ParameterConstants.HOUSE_ADDRESS %>_preview'><%=address!=null?address.getAddress():"" %></span>
	</div>
</div>

<h3>
	<dgfood-ui:message key="label-permanent-address" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>

<div class='row'>
	<div class='col-6'>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.REGION %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZILLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UPAZILA %>_preview'><%=userDetails!=null?userDetails.getNidUpzilla():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UNION_OR_WARD %>_preview'><%=userDetails!=null?userDetails.getNidUnion():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZIP_CODE %>_preview'><%=userDetails!=null?userDetails.getNidZipCode():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.POST_OFFICE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.VILLAGE_OR_ROAD %>_preview'><%=userDetails!=null?userDetails.getNidVillage():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.HOUSE_ADDRESS %>_preview'><%=userDetails!=null?userDetails.getHouseAddress():"" %></span>
	</div>
</div>

<h3>
	<dgfood-ui:message key="label-present-address" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<div class='row'>
	<div class='col-6'>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.REGION %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.ZILLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.UPAZILA %>_preview'><%=userDetails!=null?userDetails.getNidUpzilla():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.UNION_OR_WARD %>_preview'><%=userDetails!=null?userDetails.getNidUnion():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.ZIP_CODE %>_preview'><%=userDetails!=null?userDetails.getNidZipCode():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.POST_OFFICE %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.VILLAGE_OR_ROAD %>_preview'><%=userDetails!=null?userDetails.getNidVillage():"" %></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'></span>
		<span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.HOUSE_ADDRESS %>_preview'><%=userDetails!=null?userDetails.getHouseAddress():"" %></span>
	</div>
</div>

<h3>
	<dgfood-ui:message key="label-attachments" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<div class='row'>
	<div class='col-6'>
		<aui:input name='<%=ParameterConstants.PROFILE_PHOTOGRAPH + "_preview"%>' disabled="true"
		 type="checkbox" value="1"></aui:input>
		
		<aui:input name='<%=ParameterConstants.TRADE_LICENSE_DOCUMENT + "_preview"%>' disabled="true"
		 type="checkbox" value="1"></aui:input>
		
		<aui:input name='<%=ParameterConstants.TAX_IDENTIFICATION_NUMBER_DOCUMENT + "_preview"%>' disabled="true"
		 type="checkbox" value="1"></aui:input>
		
		<aui:input name='<%=ParameterConstants.BUSINESS_IDENTIFICATION_NUMBER_DOCUMENT + "_preview"%>' disabled="true"
		 type="checkbox" value="1"></aui:input>
		
		<aui:input name='<%=ParameterConstants.BANK_STATEMENT_DOCUMENT + "_preview"%>' disabled="true"
		 type="checkbox" value=""></aui:input>
		
		<aui:input name='<%=ParameterConstants.RELEVANT_DOCUMENT + "_preview"%>' disabled="true"
		 type="checkbox" value=""></aui:input> 
	</div>
</div>