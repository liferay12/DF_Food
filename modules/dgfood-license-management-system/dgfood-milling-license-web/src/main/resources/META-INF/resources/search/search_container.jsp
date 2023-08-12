<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.license.management.system.constants.LicenseConstants"%>
<%@page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker"%>
<%@include file="/search/init.jsp" %>

<style>

#table-responsive{
 overflow-y: scroll;
 height: 350px; 
}
</style>

<%
String keywords = ParamUtil.getString(request, "keywords");
boolean paginate = ParamUtil.getBoolean(request, "paginate",true);
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
int listSize = (int)request.getAttribute("listSize");
%>

		<% 
			if(listSize > 0){
		%>
				<portlet:resourceURL id="/generatereport" var="generateReportURL">
					<portlet:param name="<%=ParameterConstants.FROM_DATE%>" value="${fromDate}" />
					<portlet:param name="<%=ParameterConstants.TO_DATE%>" value="${toDate}" />
					<portlet:param name="<%=ParameterConstants.STATUS%>" value="${status}" />
					<portlet:param name="keywords" value="${keywords}" />
				</portlet:resourceURL>
			
				<liferay-util:buffer var="onClickFn">
					 submitForm(document.hrefFm, '<%=generateReportURL + "&compress=0&etag=0&strip=0"%>');
				</liferay-util:buffer>	
				
				<div class="row">
							<div class="col-md-12">
								<a  class="btn btn-info exportBtn" style="color: #ffffff;" onclick="<%=onClickFn%>">Excel</a>
							</div>	
				</div>		
				<%}%>


<liferay-ui:search-container  
    rowChecker="${emptyOnClickRowChecker }"
    emptyResultsMessage="no-entries-were-found" 
    id="millingSearchContainer"
    searchContainer="${customSearchContainer}">

<liferay-ui:search-container-row
        className="bd.gov.dgfood.license.management.system.model.MillingLicense"
        keyProperty="millingLicenseId" modelVar="entry" escapedModel="<%=true%>">

		<liferay-ui:search-container-column-text name="operator-name"
			cssClass="table-cell-expand-small table-cell-minw-150"
			property="operatorName" />

		<liferay-ui:search-container-column-text name="mobile-number"
			cssClass="table-cell-expand-small table-cell-minw-150"
			value="<%=String.valueOf(entry.getMillDetails().get(LicenseConstants.MILL_NAME))%>" />

		<liferay-ui:search-container-column-text name="application-date"
			cssClass="table-cell-expand-small table-cell-minw-150"
			value="<%=dateFormat.format(entry.getCreateDate())%>" />

		<liferay-ui:search-container-column-text name="operatorNid"
			cssClass="table-cell-expand-small table-cell-minw-150"
			value="<%=String.valueOf(entry.getOperatorNationalId())%>" />

		<liferay-ui:search-container-column-text
			name="operator-running-business-from"
			cssClass="table-cell-expand-small table-cell-minw-150"
			value="<%=entry.getOperatorRunningBusinessFromYrs()%>" />

		<liferay-ui:search-container-column-status name="currentstatus"
			cssClass="table-cell-expand-small table-cell-minw-150"
			status="<%=(int) entry.getStatus()%>" />
			
		<liferay-ui:search-container-column-jsp cssClass="table-cell-expand-small table-cell-minw-150"
    		name="action"
			path="/search/action.jsp" />

	</liferay-ui:search-container-row>

    <liferay-ui:search-iterator
                paginate="<%=paginate %>"
				displayStyle="list"
				markupView="lexicon"
				searchContainer="<%= searchContainer %>"
	 />
</liferay-ui:search-container>





