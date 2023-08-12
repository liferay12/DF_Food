<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker"%>
<%@ include file="../init.jsp" %>
<%
	Format dateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy");
%>
<liferay-ui:search-container rowChecker="${emptyOnClickRowChecker }"
				emptyResultsMessage="no-entries-were-found" id="farmerRegistrationsSearchContainer"
				searchContainer="${farmerRegistrationsSearchContainer}">

	<liferay-ui:search-container-row
		className="bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration"
		keyProperty="farmerRegistrationId" modelVar="farmerRegistrationApplication" escapedModel="<%=true%>">
		
		<portlet:renderURL var="farmerRegistrationDetailedViewURL">
			<portlet:param name="mvcRenderCommandName" value="<%=FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_DETAILED_VIEW_RENDER_COMMAND%>"/>
			<portlet:param name="farmerRegistrationId" value="<%=String.valueOf(farmerRegistrationApplication.getFarmerRegistrationId())%>"/>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text 
			name='<%=CustomLanguageUtil.get(request,ParameterLabelConstants.LABEL_APPLICATION_NUMBER)%>'
			cssClass="table-cell-expand-small table-cell-minw-150"
			value="<%=farmerRegistrationApplication.getApplicationNumber() %>" href="<%=farmerRegistrationDetailedViewURL %>"/>
		
		<liferay-ui:search-container-column-text 
			name='<%=CustomLanguageUtil.get(request,ParameterLabelConstants.LABEL_FARMER_NAME)%>'
			cssClass="table-cell-expand-small table-cell-minw-150"
			value="<%=farmerRegistrationApplication.getFarmerName()%>" />

		<liferay-ui:search-container-column-text 
			name='<%=CustomLanguageUtil.get(request,ParameterLabelConstants.LABEL_NATIONAL_ID)%>'
			cssClass="table-cell-expand-small table-cell-minw-150"
			value="<%=farmerRegistrationApplication.getNationalId()%>" />
			
		<liferay-ui:search-container-column-text 
			name='<%=CustomLanguageUtil.get(request,ParameterLabelConstants.LABEL_CREATED_DATE)%>'
			cssClass="table-cell-expand-small table-cell-minw-150"
			value="<%=dateFormat.format(farmerRegistrationApplication.getCreateDate())%>" />

		<liferay-ui:search-container-column-text 
			name='<%=CustomLanguageUtil.get(request,ParameterLabelConstants.LABEL_FARMER_CATEGORY)%>'
			cssClass="table-cell-expand-small table-cell-minw-150"
			value="<%=farmerRegistrationApplication.getFarmerCategory()%>" />

		<liferay-ui:search-container-column-text
			name='<%=CustomLanguageUtil.get(request,ParameterLabelConstants.LABEL_STATUS)%>'
			cssClass="table-cell-expand-small table-cell-minw-150" >
			<dgfood-ui:alert status="<%= farmerRegistrationApplication.getStatus()%>" type="status"/>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%=true %>"
		displayStyle="list" markupView="lexicon"
		searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>





