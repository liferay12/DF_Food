<%@ include file="../init.jsp"%>

<%
	List<FGLicenseInfo> fgLicenseInfosList = new ArrayList<>();
	if (Validator.isNotNull(pageContext.getAttribute(ParameterConstants.FOODGRAIN_LICENSE_LIST_PARAM))) {

		fgLicenseInfosList = (List<FGLicenseInfo>) pageContext
				.getAttribute(ParameterConstants.FOODGRAIN_LICENSE_LIST_PARAM);
	}

	long fgLicenseInfosCount = 0;
	if (Validator.isNotNull(pageContext.getAttribute(ParameterConstants.FOODGRAIN_LICENSE_COUNT_PARAM))) {

		fgLicenseInfosCount = (long) pageContext.getAttribute(ParameterConstants.FOODGRAIN_LICENSE_COUNT_PARAM);
	}
%>

<liferay-ui:search-container rowChecker="${emptyOnClickRowChecker }"
	emptyResultsMessage="label-no-fglicense-were-found"
	id="fglicenseRegistrationSearchContainer" iteratorURL="${portletURL}"
	total="${fgLicenseInfosCount}">

	<liferay-ui:search-container-results results="<%=fgLicenseInfosList %>" />
	<liferay-ui:search-container-row
		className="bd.gov.dgfood.license.management.system.model.FGLicenseInfo"
		modelVar="fglicenseApplication">

		<portlet:renderURL var="fglDetailedViewURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=FoodGrainLicenseConstants.FOODGRAIN_LICENSE_DETAILS_COMMAND%>" />
			<portlet:param name="<%=ParameterConstants.APPLICATION_NUMBER%>"
				value="<%=fglicenseApplication.getApplicationNumber()%>" />
			<portlet:param name="<%=ParameterConstants.STATUS%>"
				value="<%=String.valueOf(fglicenseApplication.getStatus())%>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			name="label-application-number"
			value="<%=fglicenseApplication.getApplicationNumber()%>"
			href="<%=fglDetailedViewURL%>" />
		<liferay-ui:search-container-column-text name="label-application-date"
			value="<%=Validator.isNotNull(fglicenseApplication.getCreateDate())
									? DateFormatterUtil.parseDate(fglicenseApplication.getCreateDate(),
											DateConstants.DD_MM_YYYY)
									: StringPool.BLANK%>" />
		<liferay-ui:search-container-column-text name="label-applicant-name"
			value="<%=fglicenseApplication.getApplicantName()%>" />
		<liferay-ui:search-container-column-text
			name="label-foodgrain-license-number"
			value="<%=fglicenseApplication.getFoodgrainLicenseNumber()%>" />
		<liferay-ui:search-container-column-text name="label-license-type"
			value="<%=fglicenseApplication.getApplicationType()%>" />
		<liferay-ui:search-container-column-text name="label-upzila"
			value="<%=fglicenseApplication.getUpazila()%>" />
		<liferay-ui:search-container-column-text name="label-business-type"
			value="<%=fglicenseApplication.getBusinessType()%>" />
		<liferay-ui:search-container-column-status name="label-status"
			status="<%=fglicenseApplication.getStatus()%>" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>
