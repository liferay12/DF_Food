<%@page import="bd.gov.dgfood.farmer.information.management.system.web.constants.FarmerInformationManagementSystemConstants"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="bd.gov.dgfood.common.util.constants.PortletPreferencesConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@ include file="/init.jsp" %>

<% 
	PortletPreferences preference = renderRequest.getPreferences();
	String landingPage = preference.getValue(ParameterConstants.LANDING_PAGE,
			PortletPreferencesConstants.STATUS_TRACKER_FORM);
%>

<c:if test="<%=landingPage.equalsIgnoreCase(PortletPreferencesConstants.STATUS_TRACKER_FORM) %>"> 
	<liferay-util:include page="<%=FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_STATUS_FORM_JSP %>" servletContext="<%= application %>" />
</c:if>

<c:if test="<%=landingPage.equalsIgnoreCase(PortletPreferencesConstants.FARMER_REGISTRATION_FORM) %>"> 
	<liferay-util:include page="<%=FarmerInformationManagementSystemConstants.FARMER_REGISTRATION_FORM_JSP %>" servletContext="<%= application %>" />
</c:if>

<c:if test="<%=themeDisplay.isSignedIn() && landingPage.equalsIgnoreCase(PortletPreferencesConstants.REGISTRATION_APPLICATIONS_LIST_VIEW) %>"> 
	<liferay-util:include page="<%=FarmerInformationManagementSystemConstants.FARMER_REGISTRATIONS_LIST_JSP %>" servletContext="<%= application %>" />
</c:if>

<c:if test="<%=themeDisplay.isSignedIn() && landingPage.equalsIgnoreCase(PortletPreferencesConstants.SALES_PROPOSAL_FORM) %>"> 
	<liferay-util:include page="<%=FarmerInformationManagementSystemConstants.SALES_PROPOSAL_FORM_JSP %>" servletContext="<%= application %>" />
</c:if>