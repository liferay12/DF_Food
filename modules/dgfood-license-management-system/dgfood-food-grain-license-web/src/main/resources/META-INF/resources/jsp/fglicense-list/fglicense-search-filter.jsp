<%@ include file="../init.jsp"%>

<%
	pageContext.setAttribute(ParameterConstants.FOODGRAIN_LICENSE_LIST_PARAM,
			renderRequest.getAttribute(ParameterConstants.FOODGRAIN_LICENSE_LIST_PARAM));
	pageContext.setAttribute(ParameterConstants.FOODGRAIN_LICENSE_COUNT_PARAM,
			renderRequest.getAttribute(ParameterConstants.FOODGRAIN_LICENSE_COUNT_PARAM));

	String currentUserZilla = StringPool.BLANK;
	if (Validator.isNotNull(renderRequest.getAttribute(ParameterConstants.ZILLA))) {

		currentUserZilla = (String) renderRequest.getAttribute(ParameterConstants.ZILLA);
	}

	LocationUrlConfiguration locationUrlConfiguration = ConfigurationProviderUtil
			.getSystemConfiguration(LocationUrlConfiguration.class);
	String upazilaRestURL = StringPool.BLANK;
	if (Validator.isNotNull(locationUrlConfiguration)) {
		upazilaRestURL = locationUrlConfiguration.upazilaUrl();
	}
%>

<portlet:renderURL var="searchURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FoodGrainLicenseConstants.FOODGRAIN_LICENSE_SEARCH_COMMAND%>" />
</portlet:renderURL>

<input type="hidden" value="<portlet:namespace/>" id="portletNamespace" />
<aui:input type="hidden" value="<%=currentUserZilla%>"
	name="userZillaCode" />
<aui:input type="hidden" value="<%=upazilaRestURL%>"
	name="upazilaRestURL" />

<div id='dashboard_search_box'>
	<aui:form action="${searchURL}" name="fglicenseSearchForm"
		cssClass="container-fluid-1280">
		<clay:row>
			<clay:col md="3" sm="6">
				<aui:input name="<%=ParameterConstants.FROM_DATE%>"
					label="label-from-date" value="" type="text"  placeholder="label-default-date-format"/>
			</clay:col>
			<clay:col md="3" sm="6">
				<aui:input name="<%=ParameterConstants.TO_DATE%>"
					label="label-to-date" value="" type="text" placeholder="label-default-date-format"/>
			</clay:col>
			<clay:col md="3" sm="6">
				<aui:input name="applicationNumber" label="label-application-number"
					value="" placeholder="label-type-here" />
			</clay:col>

			<clay:col md="3" sm="6">
				<aui:select name="<%=ParameterConstants.STATUS%>"
					label="label-status">
					<aui:option value="<%=StatusConstants.STATUS_ANY%>">
						<liferay-ui:message key="label-select" />
					</aui:option>
					<aui:option value="<%=StatusConstants.STATUS_APPROVED%>">
						<liferay-ui:message
							key="<%=ParameterConstants.LABEL_PREFIX + StatusConstants.LABEL_APPROVED%>" />
					</aui:option>
					<aui:option value="<%=StatusConstants.STATUS_PENDING%>">
						<liferay-ui:message
							key="<%=ParameterConstants.LABEL_PREFIX + StatusConstants.LABEL_PENDING%>" />
					</aui:option>
					<aui:option value="<%=StatusConstants.STATUS_REJECTED%>">
						<liferay-ui:message
							key="<%=ParameterConstants.LABEL_PREFIX + StatusConstants.LABEL_REJECTED%>" />
					</aui:option>
				</aui:select>
			</clay:col>

			<clay:col md="3" sm="6">
				<aui:select name="<%=ParameterConstants.APPLICATION_TYPE%>"
					label="label-application-type">
					<aui:option value="">
						<liferay-ui:message key="label-select" />
					</aui:option>
					<aui:option value="<%=ParameterConstants.APPLICATION_TYPE_NEW%>">
						<liferay-ui:message
							key="<%=ParameterConstants.LABEL_PREFIX + ParameterConstants.APPLICATION_TYPE_NEW%>" />
					</aui:option>
					<aui:option
						value="<%=ParameterConstants.APPLICATION_TYPE_DUPLICATE%>">
						<liferay-ui:message
							key="<%=ParameterConstants.LABEL_PREFIX
										+ ParameterConstants.APPLICATION_TYPE_DUPLICATE%>" />
					</aui:option>
					<aui:option
						value="<%=ParameterConstants.APPLICATION_TYPE_RENEWAL%>">
						<liferay-ui:message
							key="<%=ParameterConstants.LABEL_PREFIX + ParameterConstants.APPLICATION_TYPE_RENEWAL%>" />
					</aui:option>
				</aui:select>
			</clay:col>
			<clay:col md="3" sm="6">
				<aui:select name="<%=ParameterConstants.UPAZILA%>"
					label="label-upazilla">
					<aui:option value="">
						<liferay-ui:message key="label-select" />
					</aui:option>

				</aui:select>
			</clay:col>
		</clay:row>
		<clay:row>
			<clay:col md="9" sm="6">
				<aui:button-row>
					<aui:button type="submit" value="label-search" id="search_filters"></aui:button>
					<aui:button type="reset" value="label-reset"></aui:button>
				</aui:button-row>
			</clay:col>
		</clay:row>
	</aui:form>
</div>

<div id="<portlet:namespace />dashboard-search-container">
	<%@include file="/jsp/fglicense-list/fglicense-search-container.jsp"%>
</div>

<script src="<%=request.getContextPath()%>/js/fglicense-list.js?v=1.1"></script>
