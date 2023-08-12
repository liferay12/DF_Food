<%@page import="bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.constants.CustomerConstants"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.web.portlet.security.permission.resource.CustomerPermission"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Objects"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.dynamic.data.mapping.model.DDMStructure"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page import="bd.gov.dgfood.credit.other.priority.customer.web.portlet.display.context.CustomerDisplayContext"%>

<%@page import="bd.gov.dgfood.common.util.PortletLifeCycleUtil"%>
<%@ include file="/init.jsp" %>


<%
Map<String, Object> contextObjects = new HashMap<>();


String userType = ParamUtil.getString(request, "userType");
System.out.println( " userType.... "+userType);

String title = ParamUtil.getString(request, "title");
String organizationName = ParamUtil.getString(request, "organizationName");
int status = ParamUtil.getInteger(request, "status", -1);
String startDate = ParamUtil.getString(request, "startDate");
String endDate = ParamUtil.getString(request, "endDate");

request.setAttribute("view", CustomerPermission.contains(permissionChecker, scopeGroupId, CustomerConstants.VIEW));
request.setAttribute("edit", CustomerPermission.contains(permissionChecker, scopeGroupId, CustomerConstants.UPDATE));


LinkedHashMap<String, Object> maps = new LinkedHashMap<String, Object>();
maps.put("userType", userType);

CustomerDisplayContext customerDisplayContext = new CustomerDisplayContext(request,liferayPortletRequest,liferayPortletResponse);

SearchContainer<SalesCustomer> searchContainer = customerDisplayContext.getSearch(maps);
%>	

	
<portlet:renderURL var="addNewURL">
    <portlet:param name="mvcPath"  value="/customer_registration.jsp" />
    <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>"/>
     <portlet:param name="redirect" value="<%=currentURL%>"/>
</portlet:renderURL>

<liferay-portlet:resourceURL copyCurrentRenderParameters="<%=false%>" id="/generatereport" var="generateReportURL">
     <portlet:param name="organizationName" value="<%=organizationName%>"/>
     <portlet:param name="status" value="<%=String.valueOf(status)%>"/>
     <portlet:param name="startDate" value="<%=startDate%>"/>
     <portlet:param name="endDate" value="<%=endDate%>"/>
     <portlet:param name="userType" value="<%=userType%>"/>
</liferay-portlet:resourceURL>

<%@ include file="/navigation.jsp" %>	



<%-- <liferay-util:buffer var="onClickFn"> --%>
<%-- 					 submitForm(document.getElementById('<portlet:namespace />fm1'), '<%=generateReportURL + "&compress=0&etag=0&strip=0"%>'); --%>
<%-- </liferay-util:buffer> --%>


<clay:row style="padding-bottom: 22px;padding-top: 30px;">
	<clay:col md="8">

	 	 <h4 style="padding-top: 12px;"> <dgfood-ui:message key="label-other-priority-customer-list"></dgfood-ui:message>

	</clay:col>
	
	<clay:col md="4" style="display: flex;justify-content: end;">
	
		<c:if test="<%=CustomerPermission.contains(permissionChecker, scopeGroupId, CustomerConstants.ADD) %>">
			<aui:button href="${addNewURL}" value='label-add-new'></aui:button>
		</c:if>
		<c:if test="<%=CustomerPermission.contains(permissionChecker, scopeGroupId, CustomerConstants.EXPORT) %>">
		    <aui:button value="label-excel" onclick="<%=liferayPortletResponse.getNamespace() + "exportPage();"%>"></aui:button>
		</c:if>
	</clay:col>

</clay:row>

<liferay-ui:search-container  
    emptyResultsMessage="no-entries-were-found" 
    id="customer"
    searchContainer="<%=searchContainer %>"
    var="customerSearchContainer"
    >

<liferay-ui:search-container-row
        className="bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer"
        keyProperty="salesCustomerId" modelVar="customer" escapedModel="<%=true%>">

		<liferay-ui:search-container-column-text name="label-organization-name" cssClass=""
			property="organizationName" />
			
		<liferay-ui:search-container-column-text name="label-organization-type" cssClass=""
			property="organizationType" />

		<liferay-ui:search-container-column-text name="label-contact-person-name"
			cssClass="" property="contactPersonName" />
			
		<liferay-ui:search-container-column-text name="label-user-id"
			cssClass="" property="userId" />

		<liferay-ui:search-container-column-date name="label-create-date" property="createDate"/>

		<liferay-ui:search-container-column-text name="label-status">
			 <dgfood-ui:alert status="<%= customer.getStatus()%>" type="status"/>
		</liferay-ui:search-container-column-text>
		

		<liferay-ui:search-container-column-jsp  name="label-action" 
				path="/action.jsp" />

	</liferay-ui:search-container-row>

    <liferay-ui:search-iterator
				displayStyle="list"
				markupView="lexicon"
	 />
</liferay-ui:search-container>

<aui:script>
		
	function <portlet:namespace />exportPage() {	
	var filename;
     Liferay.Util.fetch('<%= generateReportURL %>').then(function (response) {
				               console.log('response',response)
								var filenamePattern = /filename=\"(.*)\"/;
								var match = filenamePattern.exec(
									response.headers.get('content-disposition')
								);
								if (match) {
									filename = match[1];
								}
								return response.blob();
							})
							.then(function (blob) {
								var link = document.createElement('a');
								link.setAttribute(
									'href',
									URL.createObjectURL(blob)
								);
								if (filename) {
									link.setAttribute('download', filename);
								}
								link.click();
							})
							.catch(function (error) {
								Liferay.Util.openToast({
									message: Liferay.Language.get(
										'an-unexpected-system-error-occurred'
									),
									type: 'danger',
								});
							});
			}
</aui:script>		