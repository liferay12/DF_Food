<%@page import="bd.gov.dgfood.common.util.constants.SeasonConstants"%>
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

<!-- Actual production of Foodgrain in the past seasons  -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.ACTUAL_FOODGRAIN_PRODUCTION_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<!-- Season 1 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.PAST_PROD_DATA_SEASON_1_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.PAST_PROD_DATA_SEASON_1_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getPastSeasonYearsList()%>" var="pastSeasonYear">
				<aui:option value="${pastSeasonYear }" label="label-${pastSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<aui:col width="30">
		<aui:input name="<%=ParameterConstants.PAST_PROD_DATA_SEASON_1_FOODGRAIN_QUANTITY %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.FOODGRAIN_QUANTITY) %>" type="number" />
	</aui:col>

	<!-- Season 2 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.PAST_PROD_DATA_SEASON_2_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.PAST_PROD_DATA_SEASON_2_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getPastSeasonYearsList()%>" var="pastSeasonYear">
				<aui:option value="${pastSeasonYear }" label="label-${pastSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<aui:col width="30">
		<aui:input name="<%=ParameterConstants.PAST_PROD_DATA_SEASON_2_FOODGRAIN_QUANTITY %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.FOODGRAIN_QUANTITY) %>" type="number" />
	</aui:col>

	<!-- Season 3 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.PAST_PROD_DATA_SEASON_3_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.PAST_PROD_DATA_SEASON_3_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getPastSeasonYearsList()%>" var="pastSeasonYear">
				<aui:option value="${pastSeasonYear }" label="label-${pastSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<aui:col width="30">
		<aui:input name="<%=ParameterConstants.PAST_PROD_DATA_SEASON_3_FOODGRAIN_QUANTITY %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.FOODGRAIN_QUANTITY) %>" type="number" />
	</aui:col>
</aui:row>

<!-- Projected production of Foodgrain in the past seasons  -->
<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.PROJECTED_FOODGRAIN_PRODUCTION_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<!-- Season 1 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_1_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_1_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSucceedingSeasonYearsList()%>" var="succeedingSeasonYear">
				<aui:option value="${succeedingSeasonYear }" label="label-${succeedingSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<aui:col width="30">
		<aui:input name="<%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_1_FOODGRAIN_QUANTITY %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.FOODGRAIN_QUANTITY) %>" type="number" />
	</aui:col>

	<!-- Season 2 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_2_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_2_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSucceedingSeasonYearsList()%>" var="succeedingSeasonYear">
				<aui:option value="${succeedingSeasonYear }" label="label-${succeedingSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<aui:col width="30">
		<aui:input name="<%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_2_FOODGRAIN_QUANTITY %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.FOODGRAIN_QUANTITY) %>" type="number" />
	</aui:col>

	<!-- Season 3 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_3_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_3_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSucceedingSeasonYearsList()%>" var="succeedingSeasonYear">
				<aui:option value="${succeedingSeasonYear }" label="label-${succeedingSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<aui:col width="30">
		<aui:input name="<%=ParameterConstants.SUCCEEDING_PROD_DATA_SEASON_3_FOODGRAIN_QUANTITY %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.FOODGRAIN_QUANTITY) %>" type="number" />
	</aui:col>
</aui:row>

<!-- WQSC of Previous 4 sesons -->

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.PREVIOUS_WQSC_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="30">
		<label for="<%=ParameterConstants.IS_GRAIN_PROCURED_IN_LAST_4_SEASONS%>">
			<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.IS_GRAIN_PROCURED_IN_LAST_4_SEASONS)%><span class="txt-red">*</span>
		</label>
		<aui:input name="<%=ParameterConstants.IS_GRAIN_PROCURED_IN_LAST_4_SEASONS%>" cssClass="validate preview" type="radio" 
			label='<%=CustomLanguageUtil.get(request,"label-yes")%>' value="<%=true %>"></aui:input>
		<aui:input name="<%=ParameterConstants.IS_GRAIN_PROCURED_IN_LAST_4_SEASONS%>" cssClass="validate preview" type="radio" 
			label='<%=CustomLanguageUtil.get(request,"label-no")%>' value="<%=false %>"></aui:input>
	</aui:col>
</aui:row>

<aui:row>
	<!-- Season 1 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getPastSeasonYearsList()%>" var="pastSeasonYear">
				<aui:option value="${pastSeasonYear }" label="label-${pastSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col width="30">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_WQSC %>" required="false"
			accept='<%=acceptedDocumentExtensions%>' multiple="<%=false%>"
			maxSize='<%=FileConstants.TWO_MB%>' 
			previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.FOODGRAIN_PROCURED_SEASON_1_WQSC+"_preview"%>'/>
	</aui:col>

	<!-- Season 2 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getPastSeasonYearsList()%>" var="pastSeasonYear">
				<aui:option value="${pastSeasonYear }" label="label-${pastSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<aui:col width="30">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_WQSC %>" required="false"
		accept='<%=acceptedDocumentExtensions%>' multiple="<%=false%>"
		maxSize='<%=FileConstants.TWO_MB%>' 
		previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.FOODGRAIN_PROCURED_SEASON_2_WQSC+"_preview"%>'/>
	</aui:col>

	<!-- Season 3 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getPastSeasonYearsList()%>" var="pastSeasonYear">
				<aui:option value="${pastSeasonYear }" label="label-${pastSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<aui:col width="30">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_WQSC %>" required="false"
		accept='<%=acceptedDocumentExtensions%>' multiple="<%=false%>"
		maxSize='<%=FileConstants.TWO_MB%>' 
		previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.FOODGRAIN_PROCURED_SEASON_3_WQSC+"_preview"%>'/>
	</aui:col>
	
	<!-- Season 4 -->
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_NAME %>" cssClass="validate preview" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>" >
			<aui:option selected="true" value="" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.SEASON_NAME) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getSeasonsList()%>" var="seasonName">
				<aui:option value="${seasonName }" label="label-${seasonName }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	
	<aui:col width="30">
		<aui:select name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_YEAR %>" cssClass="validate preview" 
		label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>" >
			<aui:option selected="true" value="" 
			label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.YEAR) %>"></aui:option>
			<c:forEach items="<%=SeasonConstants.getPastSeasonYearsList()%>" var="pastSeasonYear">
				<aui:option value="${pastSeasonYear }" label="label-${pastSeasonYear }"></aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>

	<aui:col width="30">
		<dgfood-ui:attachment-upload  name="<%=ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_WQSC %>" required="false"
		accept='<%=acceptedDocumentExtensions%>' multiple="<%=false%>"
		maxSize='<%=FileConstants.TWO_MB%>' 
		previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.FOODGRAIN_PROCURED_SEASON_4_WQSC+"_preview"%>'/>
	</aui:col>
</aui:row>


<aui:fieldset label="">
	<!-- Button to navigate to the next step -->
	<aui:button-row>
		<aui:button id="backToFarmerInformation" type="button" cssClass="btn" value="<%=CustomLanguageUtil.get(request,"label-back")%>" 
			onClick="showNextOrPreviousStep('foodgrain_production_details','farmer_information', false, 'new-sales-proposal', 'fims_spa_step', 'fims_spa_step_hide', false);" />
		<aui:button id="nextToSummaryPage" type="button" cssClass="btn btn-primary"
			value="<%=CustomLanguageUtil.get(request,"label-next")%>" 
			onClick="showNextOrPreviousStep('foodgrain_production_details','summary_page', true, 'new-sales-proposal', 'fims_spa_step', 'fims_spa_step_hide', true);" />
	</aui:button-row>
</aui:fieldset>
