<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashMap"%>
<%@page import="bd.gov.dgfood.common.services.model.Address"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="bd.gov.dgfood.taglib.servlet.taglib.NationalIdInformation"%>
<%@page import="bd.gov.dgfood.taglib.servlet.taglib.BasicInformation"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="bd.gov.dgfood.common.util.constants.ValidationConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.CategoryConstants"%>
<%@page import="bd.gov.dgfood.common.util.CategoryUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@page import="bd.gov.dgfood.common.util.constants.RiceTypeConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.SeasonConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.UnitConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.AddressConstants"%>
<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.FormSectionLabelsConstant"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@ include file="../../init.jsp" %>

<%
	List<AssetCategory> divisionList = CategoryUtil.fetchCategoriesbyVocabularyNameAndParentId(themeDisplay, CategoryConstants.LOCATION, CategoryConstants.ZERO);
	
	FarmerRegistration currentUserRegistrationRecord=null;
	NationalIdInformation nationalIdInformation=null;
	BasicInformation basicInformation=null;
	
	if(Validator.isNotNull(renderRequest.getAttribute("currentUserRegistrationRecord")))
	{
		currentUserRegistrationRecord=(FarmerRegistration)renderRequest.getAttribute("currentUserRegistrationRecord");
		basicInformation=new BasicInformation(currentUserRegistrationRecord.getFarmerName(), currentUserRegistrationRecord.getFatherName(), 
					currentUserRegistrationRecord.getMotherName(), currentUserRegistrationRecord.getGender(), currentUserRegistrationRecord.getMaritalStatus());
		nationalIdInformation = new NationalIdInformation(
				currentUserRegistrationRecord.getNationalId(), currentUserRegistrationRecord.getEmailAddress(),
				currentUserRegistrationRecord.getMobileNumber(),currentUserRegistrationRecord.getDateOfBirth());
	}
	
	Map<String, Address> farmerRegistrationAddress=new HashMap<String, Address>();
	BasicInformation permanentAddress=null;
	BasicInformation presentAddress=null;
	if(Validator.isNotNull(renderRequest.getAttribute("farmerRegistrationAddress")))
	{
		farmerRegistrationAddress = (Map<String, Address>) renderRequest.getAttribute("farmerRegistrationAddress");
		Map<Long,AssetCategory> addressCategories = CategoryUtil.getAddressCategories(new ArrayList<Address>(farmerRegistrationAddress.values()));
		
		permanentAddress=new BasicInformation(farmerRegistrationAddress.get(AddressConstants.ADDRESS_PERMANENT),addressCategories);
		presentAddress=new BasicInformation(farmerRegistrationAddress.get(AddressConstants.ADDRESS_PRESENT),addressCategories);
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
<!-- Current Season Information -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.FARMER_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<aui:input name="<%=ParameterConstants.CURRENT_SEASON %>" cssClass="validate isMandatory preview" value="<%=currentSeason %>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CURRENT_SEASON) %>" type="text" disabled="true" >
			<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-current-season")%>' />
			<aui:validator name="maxLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-max-length-twenty")%>'>20</aui:validator>
			<aui:validator name="minLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-min-length-one")%>'>1</aui:validator>
		</aui:input>
	</aui:col>
	<aui:col width="50">
		<aui:input name="<%=ParameterConstants.FOODGRAIN_TYPE %>" cssClass="validate isMandatory preview" value="<%=foodgrainType %>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.FOODGRAIN_TYPE) %>" type="text" disabled="true">
			<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-foodgrain-type")%>' />
			<aui:validator name="maxLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-max-length-twenty")%>'>20</aui:validator>
			<aui:validator name="minLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-min-length-one")%>'>1</aui:validator>
		</aui:input>
	</aui:col>
</aui:row>

<dgfood-ui:nid-fields isDisabled="true" value="<%=nationalIdInformation %>"/>

<!-- Farmer Basic Information -->
<dgfood-ui:basic-fields nameFields="true" maritalStatusField="true" genderField="true" 
	addressField="false" addressType="" isDisabled="true" value="<%=basicInformation %>"/>
<aui:row>
	<aui:col width="50">
		<aui:input name="<%=ParameterConstants.KRISHOK_CARD_NUMBER %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getKrishokCardNumber() %>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.KRISHOK_CARD_NUMBER) %>" type="text" disabled="true">
			<aui:validator name="maxLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-max-length-twenty")%>'>20</aui:validator>
			<aui:validator name="minLength"
				errorMessage='<%=CustomLanguageUtil.get(request,"label-error-min-length-one")%>'>1</aui:validator>
			<aui:validator name="custom" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-invalid-character")%>'>
				function(val, fieldNode, ruleValue) {
					var regex = new RegExp("^[a-zA-Z0-9\\s]*$");
					return regex.test(val);
				}
			</aui:validator>
		</aui:input>
	</aui:col>
</aui:row>

<!-- Farmers Cultivable Land Information -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.CULTIVABLE_LAND_SELL_LOCATION_INFORMATION %>" 
	languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<!-- Season 1 -->
	<aui:col width="25">
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getCultivableLandSeason1().get(ParameterConstants.NAME)%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME) %>" disabled="true">
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_NAME %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getCultivableLandSeasonList()%>" var="cultivableLandSeason">
				<aui:option value="${cultivableLandSeason }" label="label-${cultivableLandSeason }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="25">
		
		<aui:input name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getCultivableLandSeason1().get(ParameterConstants.AREA)%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA) %>" 
			type="number" disabled="true"/>
	</aui:col>
	<aui:col width="25">
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_UOM %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getCultivableLandSeason1().get(ParameterConstants.UOM)%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_1_UOM) %>" disabled="true">
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_UOM %>"></aui:option>
			<c:forEach items="<%=UnitConstants.getCultivableLandUnitList()%>" var="cultivableLandUnit">
				<aui:option value="${cultivableLandUnit }" label="label-${cultivableLandUnit }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="25">
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_RICE_TYPE %>" cssClass="validate preview"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_1_RICE_TYPE) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_1_RICE_TYPE) %>"></aui:option>
			<c:forEach items="<%=RiceTypeConstants.getCultivableLandRiceTypeList()%>" var="riceType">
				<aui:option value="${riceType }" label="label-${riceType }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<!-- Season 2 -->
	<aui:col width="25">
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getCultivableLandSeason2().get(ParameterConstants.NAME)%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME) %>" disabled="true">
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_NAME %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getCultivableLandSeasonList()%>" var="cultivableLandSeason">
				<aui:option value="${cultivableLandSeason }" label="label-${cultivableLandSeason }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="25">
		<aui:input name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getCultivableLandSeason2().get(ParameterConstants.AREA)%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA) %>" 
			type="number" disabled="true"/>
	</aui:col>
	<aui:col width="25">
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_UOM %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getCultivableLandSeason2().get(ParameterConstants.UOM)%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_2_UOM) %>" disabled="true">
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_UOM %>"></aui:option>
			<c:forEach items="<%=UnitConstants.getCultivableLandUnitList()%>" var="cultivableLandUnit">
				<aui:option value="${cultivableLandUnit }" label="label-${cultivableLandUnit }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="25">
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_RICE_TYPE %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_2_RICE_TYPE) %>">
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_2_RICE_TYPE) %>"></aui:option>
			<c:forEach items="<%=RiceTypeConstants.getCultivableLandRiceTypeList()%>" var="riceType">
				<aui:option value="${riceType }" label="label-${riceType }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<!-- Season 3 -->
	<aui:col width="25">
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getCultivableLandSeason3().get(ParameterConstants.NAME)%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME) %>" disabled="true">
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_NAME %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getCultivableLandSeasonList()%>" var="cultivableLandSeason">
				<aui:option value="${cultivableLandSeason }" label="label-${cultivableLandSeason }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="25">
		<aui:input name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getCultivableLandSeason3().get(ParameterConstants.AREA)%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA) %>" 
				type="number" disabled="true"/>
	</aui:col>
	<aui:col width="25">
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_UOM %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getCultivableLandSeason3().get(ParameterConstants.UOM)%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_3_UOM) %>" disabled="true">
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_UOM %>"></aui:option>
			<c:forEach items="<%=UnitConstants.getCultivableLandUnitList()%>" var="cultivableLandUnit">
				<aui:option value="${cultivableLandUnit }" label="label-${cultivableLandUnit }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="25">
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_RICE_TYPE %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_3_RICE_TYPE) %>">
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.CULTIVABLE_LAND_SEASON_3_RICE_TYPE) %>"></aui:option>
			<c:forEach items="<%=RiceTypeConstants.getCultivableLandRiceTypeList()%>" var="riceType">
				<aui:option value="${riceType }" label="label-${riceType }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
</aui:row>

<!-- Liked location details to sell foodgrain -->
<aui:row>
	<aui:col width="50">
		<aui:select name='<%=AddressConstants.ADDRESS_SELL_FOODGRAIN+ParameterConstants.REGION%>' 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.REGION) %>" 
			onChange='<%="populateAddressOption(this.id,'"+ParameterConstants.ZILLA+"','"+ AddressConstants.ADDRESS_SELL_FOODGRAIN+"');" %>'
			cssClass='<%= AddressConstants.ADDRESS_SELL_FOODGRAIN+"level-0" + " validate preview"%>' >
			<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-region-or-division")%>' />
			<aui:option selected="true">
				<%=CustomLanguageUtil.get(request,"label-select")%>
			</aui:option>
			<%if(Validator.isNotNull(divisionList)){
				for (AssetCategory divisionCategory : divisionList) {
			%>
				<aui:option value="<%=divisionCategory.getCategoryId()%>"
					label="<%=divisionCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}}
			%>
		</aui:select>
	</aui:col>

	<aui:col width="50">
		<aui:select name='<%=AddressConstants.ADDRESS_SELL_FOODGRAIN+ParameterConstants.ZILLA%>' 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.ZILLA) %>" 
			onChange='<%="populateAddressOption(this.id,'"+ParameterConstants.UPAZILA+"','"+ AddressConstants.ADDRESS_SELL_FOODGRAIN+"');" %>'
			cssClass='<%= AddressConstants.ADDRESS_SELL_FOODGRAIN+"level-1" + " validate preview"%>' >
			<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-district-or-zilla")%>' />
			<aui:option selected="true">
				<%=CustomLanguageUtil.get(request,"label-select")%>
			</aui:option>
		</aui:select>
	</aui:col>

	<aui:col width="50">
		<aui:select name='<%=AddressConstants.ADDRESS_SELL_FOODGRAIN+ParameterConstants.UPAZILA%>' 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.UPAZILA) %>" 
			onChange='<%="populateAddressOption(this.id,'"+ParameterConstants.UNION_OR_WARD+"','"+ AddressConstants.ADDRESS_SELL_FOODGRAIN+"');" %>'
			cssClass='<%= AddressConstants.ADDRESS_SELL_FOODGRAIN+"level-2" + " validate preview"%>' >
			<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-upazilla")%>' />
			<aui:option selected="true">
				<%=CustomLanguageUtil.get(request,"label-select")%>
			</aui:option>
		</aui:select>
	</aui:col>

	<aui:col width="50">
		<aui:select name='<%=AddressConstants.ADDRESS_SELL_FOODGRAIN+ParameterConstants.UNION_OR_WARD%>'
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.UNION_OR_WARD) %>" 
			cssClass='<%= AddressConstants.ADDRESS_SELL_FOODGRAIN+"level-3" + " validate preview"%>' >
			<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"error-label-union")%>' />
			<aui:option selected="true">
				<%=CustomLanguageUtil.get(request,"label-select")%>
			</aui:option>
		</aui:select>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="50">
		<aui:input name="<%=ParameterConstants.FARMER_CATEGORY %>" cssClass="validate preview" 
			value="<%=currentUserRegistrationRecord.getFarmerCategory()%>"
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.FARMER_CATEGORY) %>" type="text" disabled="true">
		</aui:input>
	</aui:col>
</aui:row>

<!-- Farmers Permanent address fields -->
<dgfood-ui:basic-fields nameFields="false" maritalStatusField="false" genderField="false" 
	addressField="true" addressType="<%=AddressConstants.ADDRESS_PERMANENT %>" isDisabled="true" value="<%=permanentAddress %>"/>
	

<!-- Farmers present address fields -->
<dgfood-ui:basic-fields nameFields="false" maritalStatusField="false" genderField="false" 
	addressField="true" addressType="<%=AddressConstants.ADDRESS_PRESENT %>" isDisabled="true" value="<%=presentAddress %>"/>

<!-- Bank Details -->
<dgfood-ui:bank-account-information/>

<aui:fieldset label="">
	<!-- Button to navigate to the next step -->
	<aui:button-row>
		<aui:button id="nextToFoodgrainProductionDetailsPage" type="button" cssClass="btn btn-primary" 
			value="<%=CustomLanguageUtil.get(request,"label-next")%>" 
			onClick="showNextOrPreviousStep('farmer_information','foodgrain_production_details', true, 'new-sales-proposal', 'fims_spa_step', 'fims_spa_step_hide', true);" />
	</aui:button-row>
</aui:fieldset>