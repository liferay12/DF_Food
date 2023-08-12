<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.DocumentLibraryConstants"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="bd.gov.dgfood.common.util.constants.MaritalStatusConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.GenderConstants"%>
<%@page import="bd.gov.dgfood.common.services.model.Attachment"%>
<%@page import="bd.gov.dgfood.common.services.model.Address"%>
<%@page import="javax.portlet.RenderRequest"%>
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
<%@ include file="../init.jsp" %>

<%
	FarmerRegistration farmerRegistration = (FarmerRegistration)renderRequest.getAttribute("farmerRegistration");
	
	List<Address> farmerRegistrationAddressList=new ArrayList<Address>();
	if(Validator.isNotNull( renderRequest.getAttribute("farmerRegistrationAddressList")))
	{
		farmerRegistrationAddressList = (List<Address>) renderRequest.getAttribute("farmerRegistrationAddressList");
	}
	
	List<Attachment> farmerRegistrationAttachmentList = new ArrayList<Attachment>();
	if(Validator.isNotNull(renderRequest.getAttribute("farmerRegistrationAttachmentList")))
	{
		farmerRegistrationAttachmentList = (List<Attachment>) renderRequest.getAttribute("farmerRegistrationAttachmentList");
	}
	
	Map<Long, AssetCategory> farmerRegistrationAddressCategories=new HashMap<Long, AssetCategory>();
	if(Validator.isNotNull(renderRequest.getAttribute("farmerRegistrationAddressCategories")))
	{
		farmerRegistrationAddressCategories = (Map<Long, AssetCategory>) renderRequest.getAttribute("farmerRegistrationAddressCategories");
	}
%>

<h2>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.APPLICATION_STATUS %>" languageId="<%=themeDisplay.getLanguageId().toString()%>" />
</h2>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.NID_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_NATIONAL_ID%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.NATIONAL_ID %>_preview'><%=farmerRegistration.getNationalId() %></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_EMAIL_ADDRESS%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.EMAIL_ADDRESS %>_preview'><%=farmerRegistration.getEmailAddress() %></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MOBILE_NUMBER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MOBILE_NUMBER %>_preview'><%=farmerRegistration.getMobileNumber() %></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_DATE_OF_BIRTH%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.DATE_OF_BIRTH %>_preview'><%=farmerRegistration.getDateOfBirth() %></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.BASIC_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_FARMER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.APPLICANT_NAME %>_preview'><%=farmerRegistration.getFarmerName() %></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_FATHER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.FATHER_NAME %>_preview'><%=farmerRegistration.getFatherName() %></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MOTHER_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MOTHER_NAME %>_preview'><%=farmerRegistration.getMotherName() %></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_GENDER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.GENDER %>_preview'><%=GenderConstants.getGenderLabel(farmerRegistration.getGender()) %></span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MARITAL_STATUS%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.MARITAL_STATUS %>_preview'>
			<%=MaritalStatusConstants.getMaritalStatusLabel(farmerRegistration.getMaritalStatus()) %>
		</span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_KRISHOK_CARD_NUMBER%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.KRISHOK_CARD_NUMBER %>_preview'><%=farmerRegistration.getKrishokCardNumber() %></span>
	</aui:col>
</aui:row>

<h3>
	<dgfood-ui:message key="<%=FormSectionLabelsConstant.CULTIVABLE_LAND_INFORMATION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
</h3>
<aui:row>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_NAME %>_preview'>
			<%=farmerRegistration.getCultivableLandSeason1().get(ParameterConstants.NAME) %>
		</span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_1_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_AREA %>_preview'>
			<%=farmerRegistration.getCultivableLandSeason1().get(ParameterConstants.AREA) %>
		</span>  &nbsp;
		<span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_1_UNIT %>_preview'>
			<%=farmerRegistration.getCultivableLandSeason1().get(ParameterConstants.UNIT) %>
		</span>
	</aui:col>

	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_NAME %>_preview'>
			<%=farmerRegistration.getCultivableLandSeason2().get(ParameterConstants.NAME) %>
		</span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_2_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_AREA %>_preview'>
			<%=farmerRegistration.getCultivableLandSeason2().get(ParameterConstants.AREA) %>
		</span>  &nbsp;
		<span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_2_UNIT %>_preview'>
			<%=farmerRegistration.getCultivableLandSeason2().get(ParameterConstants.UNIT) %>
		</span>
	</aui:col>

	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_NAME%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_NAME %>_preview'>
			<%=farmerRegistration.getCultivableLandSeason3().get(ParameterConstants.NAME) %>
		</span>
	</aui:col>
	<aui:col width="50">
		<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CULTIVABLE_LAND_SEASON_3_AREA%>" languageId="<%=themeDisplay.getLanguageId()%>"/>
		: <span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_AREA %>_preview'>
			<%=farmerRegistration.getCultivableLandSeason3().get(ParameterConstants.AREA) %>
		</span>  &nbsp;
		<span id='<portlet:namespace/><%=ParameterConstants.CULTIVABLE_LAND_SEASON_3_UNIT %>_preview'>
			<%=farmerRegistration.getCultivableLandSeason3().get(ParameterConstants.UNIT) %>
		</span>
	</aui:col>
</aui:row>

<c:if test="<%=Validator.isNotNull(farmerRegistrationAddressList) %>">  
		<% for(Address farmerRegistrationAddress: farmerRegistrationAddressList){ %>
		<h3>
			<dgfood-ui:message key="<%=farmerRegistrationAddress.getAddressType() %>" languageId="<%=themeDisplay.getLanguageId()%>" />
		</h3>
		
		<aui:row>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_REGION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.REGION %>_preview'>
					<%=(farmerRegistrationAddressCategories.containsKey(farmerRegistrationAddress.getRegion()))
					? farmerRegistrationAddressCategories.get(farmerRegistrationAddress.getRegion())
							.getTitle(themeDisplay.getLocale()): StringPool.BLANK %>
				</span>
			</aui:col>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_ZILLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZILLA %>_preview'>
					<%=(farmerRegistrationAddressCategories.containsKey(farmerRegistrationAddress.getDistrict()))
					? farmerRegistrationAddressCategories.get(farmerRegistrationAddress.getDistrict())
							.getTitle(themeDisplay.getLocale()): StringPool.BLANK %>
				</span>
			</aui:col>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_UPAZILA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UPAZILA %>_preview'>
					<%=(farmerRegistrationAddressCategories.containsKey(farmerRegistrationAddress.getUpazilla()))
					? farmerRegistrationAddressCategories.get(farmerRegistrationAddress.getUpazilla())
							.getTitle(themeDisplay.getLocale()): StringPool.BLANK %>
				</span>
			</aui:col>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_CITY_CORPORATION_OR_MUNICIPALITY %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY %>_preview'>
					<%=(farmerRegistrationAddressCategories.containsKey(farmerRegistrationAddress.getCityCorporationOrMunicipality()))
					? farmerRegistrationAddressCategories.get(farmerRegistrationAddress.getCityCorporationOrMunicipality())
							.getTitle(themeDisplay.getLocale()): StringPool.BLANK %>
				</span>
			</aui:col>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_UNION_OR_WARD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.UNION_OR_WARD %>_preview'>
					<%=(farmerRegistrationAddressCategories.containsKey(farmerRegistrationAddress.getUnionOrWard()))
					? farmerRegistrationAddressCategories.get(farmerRegistrationAddress.getUnionOrWard())
							.getTitle(themeDisplay.getLocale()): StringPool.BLANK %>
				</span>
			</aui:col>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_ZIP_CODE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.ZIP_CODE %>_preview'>
					<%= (Validator.isNotNull(farmerRegistrationAddress.getZipCode()))
					? farmerRegistrationAddress.getZipCode() : StringPool.BLANK %>
				</span>
			</aui:col>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_POST_OFFICE %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.POST_OFFICE %>_preview'>
					<%= (Validator.isNotNull(farmerRegistrationAddress.getPostOffice()))
					? farmerRegistrationAddress.getPostOffice() : StringPool.BLANK %>
				</span>
			</aui:col>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_VILLAGE_OR_ROAD %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.VILLAGE_OR_ROAD %>_preview'>
					<%= (Validator.isNotNull(farmerRegistrationAddress.getVillageOrRoad()))
					? farmerRegistrationAddress.getVillageOrRoad() : StringPool.BLANK %>
				</span>
			</aui:col>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_MOUZA_OR_MOHOLLA %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.MOUZA_OR_MOHOLLA %>_preview'>
					<%= (Validator.isNotNull(farmerRegistrationAddress.getMouzaOrMoholla()))
					? farmerRegistrationAddress.getMouzaOrMoholla() : StringPool.BLANK %>
				</span>
			</aui:col>
			<aui:col width="50">
				<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_HOUSE_ADDRESS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				: <span id='<portlet:namespace/><%=AddressConstants.ADDRESS_PERMANENT+ParameterConstants.HOUSE_ADDRESS %>_preview'>
					<%= (Validator.isNotNull(farmerRegistrationAddress.getAddress()))
					? farmerRegistrationAddress.getAddress() : StringPool.BLANK %>
				</span>
			</aui:col>
		</aui:row>
	<%} %>
</c:if>

<c:if test="<%=Validator.isNotNull(farmerRegistrationAttachmentList) %>"> 
	<h3>
		<dgfood-ui:message key="<%=FormSectionLabelsConstant.ATTACHMENTS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
	</h3> 
	<clay:row>
		<% for(Attachment farmerAttachment: farmerRegistrationAttachmentList){ %>
			<clay:col md="6" sm="12">
				<h5><dgfood-ui:message
					key="<%=farmerAttachment.getCategory() %>" languageId="<%=themeDisplay.getLanguageId()%>" /></h5>
				<dgfood-ui:attachment-preview   title='<%= farmerAttachment.getTitle()%>' 
		          previewURL='<%=farmerAttachment.getMetadata() != null ? (String)farmerAttachment.getMetadata().get(DocumentLibraryConstants.PREVIEW_URL) : null%>' 
		          extension='<%=farmerAttachment.getMetadata() != null ? (String)farmerAttachment.getMetadata().get(DocumentLibraryConstants.EXTENSION) : null%>'/>
			</clay:col>
		<% } %>
	</clay:row>
</c:if>

<c:if test="<%= farmerRegistration.getStatus() == StatusConstants.STATUS_PENDING %>">

	<portlet:renderURL var="wsURL">
	        <portlet:param name="mvcPath" value="/workflow_submission.jsp" />
	</portlet:renderURL>
	
	
	<dgfood-ui:workflow-task
	 className="<%=FarmerRegistration.class.getName() %>" 
	 classPK="<%=farmerRegistration.getFarmerRegistrationId() %>" 
	 redirect="<%=wsURL %>" 
	 />
 
</c:if>