<%@page import="bd.gov.dgfood.common.services.service.GrievanceLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.RoleConstants"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="bd.gov.dgfood.grievance.utility.ApplicationDisplayTerms"%>
<%@page import="bd.gov.dgfood.grievance.utility.ApplicationSearchContainer"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ include file="/init.jsp" %>


<liferay-ui:success key="grievance-submitted-successfully" message="<%=CustomLanguageUtil.get(request,"grievance-submitted-successfully")%>"/>

<liferay-ui:error key="grievance-submission-failed" message="<%=CustomLanguageUtil.get(request,"grievance-submission-failed")%>"/>

<portlet:renderURL var="searchURL" windowState="<%=WindowState.NORMAL.toString()%>">
	 <portlet:param name="navigation" value="1" />
</portlet:renderURL>		
			
<%try{
			boolean isAdmin = false;
			if(renderRequest.isUserInRole(RoleConstants.UCF)){
				isAdmin = true;
			}
			
			String grievanceApplicationNumber = (String)renderRequest.getAttribute(ParameterConstants.APPLICATION_NUMBER);
			PortletURL portletURL = renderResponse.createRenderURL();
			ApplicationSearchContainer applicationSearchContainer = new ApplicationSearchContainer(renderRequest, portletURL);
			ApplicationDisplayTerms displayTerms = (ApplicationDisplayTerms)applicationSearchContainer.getDisplayTerms();
		%>
		<%
		if(Validator.isNotNull(grievanceApplicationNumber)){
		%>
		Grievance Application Number : <%=grievanceApplicationNumber %>
		<%			
		}
		%>		
<aui:form id="formSearch" action="<%=searchURL%>" method="post">

	<liferay-ui:search-container delta="10" deltaConfigurable="yes" searchContainer="<%=applicationSearchContainer%>">
		 
		 <dgfood-ui:message key="search-filter"/>
		 
		<liferay-ui:search-form page="/grievance-search.jsp" servletContext="<%=application%>" />
		
		<dgfood-ui:message key="grievance-list"/>
		
		<liferay-ui:search-container-results>
			<%
			String searchKey = displayTerms.getKeywords();
			int status = GetterUtil.getInteger(displayTerms.getStatus());
			long grievanceUser = displayTerms.getGrievanceUser();
			long grievanceCategory = displayTerms.getGrievanceCategory();
			String fromDate = displayTerms.getFromDate();
			String toDate = displayTerms.getToDate();
			
			List<Grievance>	listPerPage = GrievanceLocalServiceUtil.getGrievanceList(searchKey, fromDate, toDate, grievanceCategory, grievanceUser, status, applicationSearchContainer.getStart(), applicationSearchContainer.getEnd(), themeDisplay.getUserId(), isAdmin);
		//	applicationSearchContainer.setResults(listPerPage);
		//	applicationSearchContainer.setTotal((int)GrievanceLocalServiceUtil.getGrievanceCount(searchKey, fromDate, toDate, grievanceCategory, grievanceUser, status, themeDisplay.getUserId(), isAdmin));
			applicationSearchContainer.setResultsAndTotal(listPerPage);
			if(!listPerPage.isEmpty()){
				%>
				<portlet:resourceURL id="/generatereport" var="generateReportURL">
					<portlet:param name="<%=ParameterConstants.FROM_DATE%>" value="<%=fromDate %>" />
					<portlet:param name="<%=ParameterConstants.TO_DATE%>" value="<%=toDate %>" />
					<portlet:param name="<%=ParameterConstants.STATUS%>" value="<%=String.valueOf(status) %>" />
				</portlet:resourceURL>
			
				<liferay-util:buffer var="onClickFn">
					 submitForm(document.hrefFm, '<%=generateReportURL + "&compress=0&etag=0&strip=0"%>');
				</liferay-util:buffer>	
				
				<div class="row">
							<div class="col-md-12">
								<a  class="btn btn-info exportBtn" style="color: #ffffff;" onclick="<%=onClickFn%>"><dgfood-ui:message key="download"/></a>
							</div>	
				</div>		
				<%}%>
				
				<%if(renderRequest.isUserInRole(RoleConstants.FARMER) ||
						renderRequest.isUserInRole(RoleConstants.FOOD_GRAIN_LICENSE)){ %>
				<portlet:renderURL var="addGrievance">
				    <portlet:param name="mvcRenderCommandName" value="/grievance/add" />
				</portlet:renderURL>
				
				<aui:button-row>
				    <aui:button onClick="<%=addGrievance.toString()%>" value="add-new-grievance"></aui:button>
				</aui:button-row>
				<%} %>
		</liferay-ui:search-container-results>
		
		<liferay-ui:search-container-row
			className="bd.gov.dgfood.common.services.model.Grievance" keyProperty="grievanceId"
			modelVar="grievanceModel">
			
			<liferay-ui:search-container-column-text name="grievance-application-number">
			<%=grievanceModel.getGrievanceNumber()%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="grievance-category-label">
			<%=CategoryUtil.fetchCategoryNamebyCategoryId(grievanceModel.getGrievanceCategory(), themeDisplay.getLocale())%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="user-type-label">
			<%=CategoryUtil.fetchCategoryNamebyCategoryId(grievanceModel.getUserType(), themeDisplay.getLocale())%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="name-of-user-label">
			<%=grievanceModel.getUserName()%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="mobile-number-label">
			<%=grievanceModel.getMobileNumber()%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="complaint-details-label">
			<%=StringUtil.trimLargeStringWithPunctuation(grievanceModel.getComplaintDetails(), 10)%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="status">
			<dgfood-ui:alert status="<%= grievanceModel.getStatus()%>" type="status"/>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="create-date">
			<%=DateFormatterUtil.parseDate(grievanceModel.getCreateDate(), DateConstants.DD_MMM_YYYY)%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-jsp name="action" path="/label-action.jsp"></liferay-ui:search-container-column-jsp>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
</aui:form>

<%
}catch(Exception e){
	e.printStackTrace();
}
%>