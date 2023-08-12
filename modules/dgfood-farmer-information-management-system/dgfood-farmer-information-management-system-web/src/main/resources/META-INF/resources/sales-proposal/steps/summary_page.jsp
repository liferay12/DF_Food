<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="bd.gov.dgfood.common.util.CategoryUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="bd.gov.dgfood.common.services.model.Address"%>
<%@page import="java.util.Map"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration"%>
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

<%
	FarmerRegistration currentUserRegistrationRecord=null;
	
	if(Validator.isNotNull(renderRequest.getAttribute("currentUserRegistrationRecord")))
	{
		currentUserRegistrationRecord=(FarmerRegistration)renderRequest.getAttribute("currentUserRegistrationRecord");
	}
	
	Map<String, Address> farmerRegistrationAddress=new HashMap<String, Address>();
	if(Validator.isNotNull(renderRequest.getAttribute("farmerRegistrationAddress")))
	{
		farmerRegistrationAddress = (Map<String, Address>) renderRequest.getAttribute("farmerRegistrationAddress");
		Map<Long,AssetCategory> addressCategories = CategoryUtil.getAddressCategories(new ArrayList<Address>(farmerRegistrationAddress.values()));
	}
	
	String currentSeason=StringPool.BLANK;
	if(Validator.isNotNull(renderRequest.getAttribute("currentSeason")))
	{
		currentSeason=(String)renderRequest.getAttribute("currentSeason");
	}
	
	String foodgrainType=StringPool.BLANK;
	if(Validator.isNotNull(renderRequest.getAttribute("foodgrainType")))
	{
		foodgrainType=(String)renderRequest.getAttribute("foodgrainType");
	}
%>

<h2>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.PREVIEW %>" languageId="<%=themeDisplay.getLanguageId().toString()%>" />
</h2>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.BASIC_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CURRENT_SEASON%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CURRENT_SEASON %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FOODGRAIN_TYPE%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_TYPE %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.NATIONAL_ID%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.NATIONAL_ID %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.EMAIL_ADDRESS%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.EMAIL_ADDRESS %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.MOBILE_NUMBER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MOBILE_NUMBER %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.DATE_OF_BIRTH%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.DATE_OF_BIRTH %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FARMER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.APPLICANT_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FATHER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FATHER_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.MOTHER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MOTHER_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.GENDER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.GENDER %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.MARITAL_STATUS%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MARITAL_STATUS %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.KRISHOK_CARD_NUMBER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.KRISHOK_CARD_NUMBER %>_preview'></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.CULTIVABLE_LAND_SELL_LOCATION_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA %>_preview'></span>  &nbsp;
		<span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_UOM %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_1_RICE_TYPE%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_RICE_TYPE %>_preview'></span>
	</aui:col>

	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA %>_preview'></span>  &nbsp;
		<span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_UOM %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_2_RICE_TYPE%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_RICE_TYPE %>_preview'></span>
	</aui:col>

	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA %>_preview'></span>  &nbsp;
		<span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_UOM %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_3_RICE_TYPE%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_RICE_TYPE %>_preview'></span>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.REGION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_SELL_FOODGRAIN+ParameterConstants.REGION %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.ZILLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_SELL_FOODGRAIN+ParameterConstants.ZILLA %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.UPAZILA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_SELL_FOODGRAIN+ParameterConstants.UPAZILA %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.UNION_OR_WARD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_SELL_FOODGRAIN+ParameterConstants.UNION_OR_WARD %>_preview'></span>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FARMER_CATEGORY %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=ParameterConstants.FARMER_CATEGORY %>_preview'></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=AddressConstants.ADDRESS_PERMANENT %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.REGION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.REGION %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.ZILLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZILLA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.UPAZILA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UPAZILA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.UNION_OR_WARD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UNION_OR_WARD %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.ZIP_CODE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZIP_CODE %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.POST_OFFICE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.POST_OFFICE %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.VILLAGE_OR_ROAD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.VILLAGE_OR_ROAD %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.MOUZA_OR_MOHOLLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.HOUSE_ADDRESS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.HOUSE_ADDRESS %>_preview'></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=AddressConstants.ADDRESS_PRESENT %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.REGION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.REGION %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.ZILLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.ZILLA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.UPAZILA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.UPAZILA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.UNION_OR_WARD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.UNION_OR_WARD %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.ZIP_CODE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.ZIP_CODE %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.POST_OFFICE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.POST_OFFICE %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.VILLAGE_OR_ROAD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.VILLAGE_OR_ROAD %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.MOUZA_OR_MOHOLLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.HOUSE_ADDRESS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PRESENT+ParameterConstants.HOUSE_ADDRESS %>_preview'></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.BANK_DETAILS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.ACCOUNT_NUMBER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.ACCOUNT_NUMBER %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.BANK_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.BANK_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.BRANCH_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.BRANCH_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.ROUTING_CODE%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.ROUTING_CODE %>_preview'></span>
	</aui:col>
</aui:row>

<!-- Actual production of Foodgrain in the past seasons  -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.ACTUAL_FOODGRAIN_PRODUCTION_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<!-- Season 1 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PAST_PROD_DATA_SEASON_1_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PAST_PROD_DATA_SEASON_1_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FOODGRAIN_QUANTITY%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PAST_PROD_DATA_SEASON_1_FOODGRAIN_QUANTITY %>_preview'></span>
	</aui:col>

	<!-- Season 2 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PAST_PROD_DATA_SEASON_2_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PAST_PROD_DATA_SEASON_2_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FOODGRAIN_QUANTITY%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PAST_PROD_DATA_SEASON_2_FOODGRAIN_QUANTITY %>_preview'></span>
	</aui:col>

	<!-- Season 3 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PAST_PROD_DATA_SEASON_3_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PAST_PROD_DATA_SEASON_3_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FOODGRAIN_QUANTITY%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.PAST_PROD_DATA_SEASON_3_FOODGRAIN_QUANTITY %>_preview'></span>
	</aui:col>

</aui:row>

<!-- Projected production of Foodgrain in the past seasons  -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.PROJECTED_FOODGRAIN_PRODUCTION_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<!-- Season 1 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_1_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_1_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FOODGRAIN_QUANTITY%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_1_FOODGRAIN_QUANTITY %>_preview'></span>
	</aui:col>

	<!-- Season 2 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_2_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_2_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FOODGRAIN_QUANTITY%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_2_FOODGRAIN_QUANTITY %>_preview'></span>
	</aui:col>

	<!-- Season 3 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_3_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_3_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.FOODGRAIN_QUANTITY%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_3_FOODGRAIN_QUANTITY %>_preview'></span>
	</aui:col>
</aui:row>

<!-- WQSC of Previous 4 sesons -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.PREVIOUS_WQSC_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<!-- Season 1 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.WQSC%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_WQSC %>_preview'></span>
	</aui:col>

	<!-- Season 2 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.WQSC%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_WQSC %>_preview'></span>
	</aui:col>

	<!-- Season 3 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.WQSC%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_WQSC %>_preview'></span>
	</aui:col>

	<!-- Season 4 -->
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.SEASON_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_NAME %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.YEAR%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_YEAR %>_preview'></span>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:message key="<%="label-"+ParameterConstants.WQSC%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_WQSC %>_preview'></span>
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
				onClick="showNextOrPreviousStep('summary_page','foodgrain_production_details', false, 'new-sales-proposal', 'fims_spa_step', 'fims_spa_step_hide', false);" />
			<aui:button id="submitFarmerRegistrationForm" type="button" cssClass="btn btn-primary" 
				value="<%=CustomLanguageUtil.get(request,"label-submit") %>" onClick="validateCaptcha('new-sales-proposal');"/>
		</aui:button-row>
	</aui:fieldset>
</aui:fieldset-group>
