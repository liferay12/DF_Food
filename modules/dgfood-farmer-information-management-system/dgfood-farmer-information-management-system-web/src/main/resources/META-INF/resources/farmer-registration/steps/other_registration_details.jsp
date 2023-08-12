<%@page import="bd.gov.dgfood.common.util.constants.SeasonConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.UnitConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="bd.gov.dgfood.common.util.constants.FormSectionLabelsConstant"%>
<%@page import="bd.gov.dgfood.common.util.constants.FileConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.AddressConstants"%>
<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@ include file="../../init.jsp" %>

<%
	String acceptedImageExtensions = StringUtil.merge(FileConstants.JPG_JPEG_PNG, StringPool.COMMA_AND_SPACE);
	String acceptedDocumentExtensions = StringUtil.merge(FileConstants.PDF_DOC_DOCX, StringPool.COMMA_AND_SPACE);
%>

<!-- Farmer Basic Information -->
<dgfood-ui:basic-fields nameFields="true" maritalStatusField="true" genderField="true" addressField="false" addressType=""/>
<aui:row>
	<aui:col width="50">
		<label for="<%=ParameterConstants.KRISHOK_CARD_NUMBER %>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_KRISHOK_CARD_NUMBER %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:input name="<%=ParameterConstants.KRISHOK_CARD_NUMBER %>" cssClass="validate preview" label="" type="text" >
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

<!-- Farmers Permanent address fields -->
<dgfood-ui:basic-fields nameFields="false" maritalStatusField="false" genderField="false" 
	addressField="true" addressType="<%=AddressConstants.ADDRESS_PERMANENT %>"/>
	

<!-- Farmers present address fields -->
<dgfood-ui:basic-fields nameFields="false" maritalStatusField="false" genderField="false" 
	addressField="true" addressType="<%=AddressConstants.ADDRESS_PRESENT %>"/>

<!-- Farmers Cultivable Land Information -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.CULTIVABLE_LAND_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<!-- Season 1 -->
	<aui:col width="30">
		<label for="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME %>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_NAME %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME %>" cssClass="validate preview" label="" >
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_NAME %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getCultivableLandSeasonList()%>" var="cultivableLandSeason">
				<aui:option value="${cultivableLandSeason }" label="label-${cultivableLandSeason }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="30">
		<label for="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA %>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_AREA %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:input name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA %>" cssClass="validate preview" label="" type="number" />
	</aui:col>
	<aui:col width="30">
		<label for="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_UNIT %>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_UNIT %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_UNIT %>" cssClass="validate preview" label="" >
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_UNIT %>"></aui:option>
			<c:forEach items="<%=UnitConstants.getCultivableLandUnitList()%>" var="cultivableLandUnit">
				<aui:option value="${cultivableLandUnit }" label="label-${cultivableLandUnit }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<!-- Season 2 -->
	<aui:col width="30">
		<label for="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME %>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_NAME %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME %>" cssClass="validate preview" label="" >
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_NAME %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getCultivableLandSeasonList()%>" var="cultivableLandSeason">
				<aui:option value="${cultivableLandSeason }" label="label-${cultivableLandSeason }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="30">
		<label for="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA%>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:input name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA%>" cssClass="validate preview" label="" type="number" />
	</aui:col>
	<aui:col width="30">
		<label for="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_UNIT %>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_UNIT %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_UNIT %>" cssClass="validate preview" label="" >
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_UNIT %>"></aui:option>
			<c:forEach items="<%=UnitConstants.getCultivableLandUnitList()%>" var="cultivableLandUnit">
				<aui:option value="${cultivableLandUnit }" label="label-${cultivableLandUnit }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<!-- Season 3 -->
	<aui:col width="30">
		<label for="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME %>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_NAME %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME %>" cssClass="validate preview" label="" >
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_NAME %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getCultivableLandSeasonList()%>" var="cultivableLandSeason">
				<aui:option value="${cultivableLandSeason }" label="label-${cultivableLandSeason }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="30">
		<label for="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA%>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:input name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA%>" cssClass="validate preview" label="" type="number" />
	</aui:col>
	<aui:col width="30">
		<label for="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_UNIT %>"><dgfood-ui:message
			key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_UNIT %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
		<aui:select name="<%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_UNIT %>" cssClass="validate preview" label="" >
			<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_UNIT %>"></aui:option>
			<c:forEach items="<%=UnitConstants.getCultivableLandUnitList()%>" var="cultivableLandUnit">
				<aui:option value="${cultivableLandUnit }" label="label-${cultivableLandUnit }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
</aui:row>
	
<!-- Farmers File fields -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.ATTACHMENTS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.PROFILE_PHOTOGRAPH %>" required="true"
			accept='<%=acceptedImageExtensions%>' multiple="<%=false%>"
			maxSize='<%=FileConstants.TWO_MB%>' 
			previewContainerId='<%=liferayPortletResponse.getNamespace() + ParameterConstants.PROFILE_PHOTOGRAPH+"_preview"%>'/>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.KRISHI_CARD %>" required="false"
			accept='<%=acceptedImageExtensions%>' multiple="<%=false%>"
			maxSize='<%=FileConstants.TWO_MB%>' 
			previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.KRISHI_CARD+"_preview"%>'/>
	</aui:col>
</aui:row>

	
<aui:fieldset label="">
	<!-- Button to navigate to the next step -->
	<aui:button-row>
		<aui:button id="backToNidDetails" type="button" cssClass="btn" value="<%=CustomLanguageUtil.get(request,"label-back")%>" 
			onClick="showNextOrPreviousStep('other_registration_details','nid_details', false, 'new-farmer-registration', 'fims_reg_step', 'fims_reg_step_hide', false);" />
		<aui:button id="nextToSummaryPage" type="button" cssClass="btn btn-primary"
			value="<%=CustomLanguageUtil.get(request,"label-next")%>" 
			onClick="showNextOrPreviousStep('other_registration_details','summary_page', true, 'new-farmer-registration', 'fims_reg_step', 'fims_reg_step_hide', true);" />
	</aui:button-row>
</aui:fieldset>
