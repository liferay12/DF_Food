<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.AddressConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.FormSectionLabelsConstant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@ include file="../../init.jsp" %>

<h2>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.PREVIEW %>" languageId="<%=themeDisplay.getLanguageId().toString()%>" />
</h2>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.NID_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_NATIONAL_ID%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.NATIONAL_ID %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_EMAIL_ADDRESS%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.EMAIL_ADDRESS %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MOBILE_NUMBER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MOBILE_NUMBER %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_DATE_OF_BIRTH%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.DATE_OF_BIRTH %>_preview'></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.BASIC_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_FARMER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.APPLICANT_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_FATHER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FATHER_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MOTHER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MOTHER_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_GENDER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.GENDER %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MARITAL_STATUS%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MARITAL_STATUS %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_KRISHOK_CARD_NUMBER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.KRISHOK_CARD_NUMBER %>_preview'></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.CULTIVABLE_LAND_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA %>_preview'></span>  &nbsp;
		<span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_UNIT%>_preview'></span>
	</aui:col>

	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA %>_preview'></span>  &nbsp;
		<span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_UNIT%>_preview'></span>
	</aui:col>

	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA %>_preview'></span>  &nbsp;
		<span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_UNIT%>_preview'></span>
	</aui:col>
</aui:row>


<h3>
	<dgfood-ui:message key="<%=AddressConstants.ADDRESS_PERMANENT %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_REGION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.REGION %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_ZILLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZILLA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_UPAZILA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UPAZILA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CITY_CORPORATION_OR_MUNICIPALITY %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_UNION_OR_WARD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UNION_OR_WARD %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_ZIP_CODE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZIP_CODE %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_POST_OFFICE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.POST_OFFICE %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_VILLAGE_OR_ROAD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.VILLAGE_OR_ROAD %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MOUZA_OR_MOHOLLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_HOUSE_ADDRESS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.HOUSE_ADDRESS %>_preview'></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=AddressConstants.ADDRESS_PRESENT %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_REGION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.REGION %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_ZILLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.ZILLA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_UPAZILA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.UPAZILA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CITY_CORPORATION_OR_MUNICIPALITY %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_UNION_OR_WARD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.UNION_OR_WARD %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_ZIP_CODE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.ZIP_CODE %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_POST_OFFICE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.POST_OFFICE %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_VILLAGE_OR_ROAD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.VILLAGE_OR_ROAD %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MOUZA_OR_MOHOLLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_HOUSE_ADDRESS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.HOUSE_ADDRESS %>_preview'></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.ATTACHMENTS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_PROFILE_PHOTOGRAPH%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PROFILE_PHOTOGRAPH %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_KRISHI_CARD%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.KRISHI_CARD %>_preview'></span>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="50">
		<liferay-captcha:captcha />
		<p  class="text-danger" id="<portlet:namespace/>captchaInvalidError" style="display: none;">
			<dgfood-ui:message key="error-label-invalid-captcha" languageId="<%=themeDisplay.getLanguageId()%>" />
		</p>
	</aui:col>
</aui:row>

<aui:fieldset-group markupView="lexicon">
	<aui:fieldset label="">
		<!-- Button to navigate to the next step -->
		<aui:button-row>
			<aui:button id="backToBasicInformation" type="button" cssClass="btn" value='<%=CustomLanguageUtil.get(request,"label-back")%>'
				onClick="showNextOrPreviousStep('summary_page','other_registration_details', false, 'new-farmer-registration', 'fims_reg_step', 'fims_reg_step_hide', false);" />
			<aui:button id="submitFarmerRegistrationForm" type="button" cssClass="btn btn-primary" 
				value="<%=CustomLanguageUtil.get(request,"label-submit") %>" onClick="validateCaptcha('new-farmer-registration');"/>
		</aui:button-row>
	</aui:fieldset>
</aui:fieldset-group>
