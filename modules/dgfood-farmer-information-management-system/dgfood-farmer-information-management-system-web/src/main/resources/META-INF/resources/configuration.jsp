<%@page import="bd.gov.dgfood.farmer.information.management.system.web.util.FarmerManagementWebUtil"%>
<%@page import="java.util.List"%>
<%@page import="bd.gov.dgfood.common.util.constants.PortletPreferencesConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>" var="configurationActionURL" />
<div class="container-fluid">
	<aui:form action="<%=configurationActionURL%>" method="post" name="fimsPortletConfigurationsForm">
		<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />

		<liferay-portlet:renderURL portletConfiguration="<%=true%>" var="configurationRenderURL" />

		<aui:input name="redirect" type="hidden" value="<%=configurationRenderURL%>" />
		
		<aui:row>
			<aui:col width="50">
				<label for="<%=ParameterConstants.LANDING_PAGE %>"><dgfood-ui:message
					key="<%=ParameterLabelConstants.LABEL_LANDING_PAGE %>" languageId="<%=themeDisplay.getLanguageId()%>" /></label>
				<aui:select name="<%=ParameterConstants.LANDING_PAGE %>" cssClass="validate" label="" 
					value="<%=(String)portletPreferences.getValue(ParameterConstants.LANDING_PAGE, PortletPreferencesConstants.STATUS_TRACKER_FORM) %>">
					<aui:option selected="true" value="" label="<%=ParameterLabelConstants.LABEL_LANDING_PAGE %>"></aui:option>
					<c:forEach items="<%=FarmerManagementWebUtil.getlandingPagesList()%>" var="landingPage">
						<aui:option value="${landingPage }" label="${landingPage }"></aui:option>
					</c:forEach>
				</aui:select>
			</aui:col>
		</aui:row>

		<aui:fieldset>
			
		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>
	</aui:form>
</div>