<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.web.display.context.FarmerRegistrationDisplayContext"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants"%>
<%@page import="bd.gov.dgfood.farmer.information.management.system.model.FarmerRegistration"%>
<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="java.util.List"%>

<%@page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker"%>
<%@ include file="../init.jsp" %>

<%
	FarmerRegistrationDisplayContext farmerRegistrationDisplayContext = new FarmerRegistrationDisplayContext(request, liferayPortletRequest, liferayPortletResponse);
	pageContext.setAttribute("farmerRegistrationsSearchContainer",farmerRegistrationDisplayContext.getSearch());
%>

<portlet:renderURL var="searchURL" />

<!-- Farmer Registration Search & Filter Form -->
<div id='dashboard_search_box'>
	<aui:form action="${searchURL}" name="farmerRegistratiomsSearchForm"
		cssClass="container-fluid-1280">
		<clay:row>
			<clay:col md="6" sm="12">
				<label for="<%=ParameterConstants.KEYWORDS%>">
					<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_KEYWORDS %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				</label>
				<aui:input name="<%=ParameterConstants.KEYWORDS %>" label="" value="" 
					placeholder='<%=CustomLanguageUtil.get(request,ParameterLabelConstants.LABEL_SEARCH)%>' />
			</clay:col>
			<clay:col md="3" sm="6">
				<label for="<%= ParameterConstants.FROM_DATE %>"><dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_FROM_DATE %>" 
					languageId="<%=themeDisplay.getLanguageId()%>"/></label>
				<aui:input name="<%=ParameterConstants.FROM_DATE %>" label="" value="" type="Date"
					placeholder='' />
			</clay:col>
			<clay:col md="3" sm="6">
				<label for="toDate"><dgfood-ui:message key="to-date" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
				<aui:input name="toDate" label="" value="" type="Date"
					placeholder='' />
			</clay:col>
			<clay:col md="3" sm="6">
				<label for="<%=ParameterConstants.NATIONAL_ID%>">
					<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_NATIONAL_ID %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				</label>
				<aui:input name="<%=ParameterConstants.NATIONAL_ID %>" label="" value="" 
					placeholder='<%=CustomLanguageUtil.get(request,ParameterLabelConstants.LABEL_SEARCH)%>' />
			</clay:col>
			<clay:col md="3" sm="6">
				<label for="<%=ParameterConstants.APPLICATION_NUMBER%>">
					<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_APPLICATION_NUMBER %>" languageId="<%=themeDisplay.getLanguageId()%>" />
				</label>
				<aui:input name="<%=ParameterConstants.APPLICATION_NUMBER %>" label="" value="" 
					placeholder='<%=CustomLanguageUtil.get(request,ParameterLabelConstants.LABEL_SEARCH)%>' />
			</clay:col>
			<clay:col md="3" sm="6">
				<label for="<%=ParameterConstants.STATUS%>"><dgfood-ui:message
						key="<%=ParameterLabelConstants.LABEL_STATUS %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
				<aui:select name="<%=ParameterConstants.STATUS %>" label="">
					<aui:option value="-1">
						<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_DROPDOWN_DEFAULT_OPTION %>" languageId="<%=themeDisplay.getLanguageId()%>" />
					</aui:option>
					<aui:option value="<%=StatusConstants.STATUS_APPROVED %>">
						<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_APPROVED %>" languageId="<%=themeDisplay.getLanguageId()%>" />
					</aui:option>
					<aui:option value="<%=StatusConstants.STATUS_PENDING %>">
						<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_PENDING %>" languageId="<%=themeDisplay.getLanguageId()%>" />
					</aui:option>
					<aui:option value="<%=StatusConstants.STATUS_REJECTED %>">
						<dgfood-ui:message key="<%=ParameterLabelConstants.LABEL_REJECTED %>" languageId="<%=themeDisplay.getLanguageId()%>" />
					</aui:option>
				</aui:select>
			</clay:col>
		</clay:row>
		<clay:row>
			<clay:col md="9" sm="6">
				<aui:button-row>
					<aui:button type="submit" value='<%=CustomLanguageUtil.get(request, ParameterLabelConstants.LABEL_SEARCH)%>' 
						id="farmerRegistrationSearchFormButton"></aui:button>
					<aui:button type="reset" value='<%=CustomLanguageUtil.get(request, ParameterLabelConstants.LABEL_RESET)%>'></aui:button>
				</aui:button-row>
			</clay:col>
		</clay:row>
	</aui:form>
</div>

<!-- Liferay Search Container -->
<clay:row>
	<clay:col md="12" sm="6">
		<div id="<portlet:namespace />farmer-registration-search-container">
			<%@include file="/farmer-registration-search-filter/farmer-registrations-search-container.jsp" %>
		</div>
	</clay:col>
</clay:row>