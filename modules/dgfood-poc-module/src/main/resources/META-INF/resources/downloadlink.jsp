<%@ include file="init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%
 List<User> users = UserLocalServiceUtil.getUsers(-1,-1);
 System.out.println(users.size());
%>
<portlet:resourceURL var="exportCSVURL">
	<portlet:param name="export" value="exportCSV" />
</portlet:resourceURL>

<portlet:actionURL var="userCSVDataUploadURL" name="userCSVDataUpload"></portlet:actionURL>
<h2>Data Export & Import as CSV </h2>

	<aui:button name="Export" value="Export Data" onClick="submit();"></aui:button>
	<aui:script>
		function submit() {
				Liferay.Util.fetch('<%=exportCSVURL %>')
				
		}
	
	</aui:script>

<br />

<form action="${userCSVDataUploadURL}" enctype="multipart/form-data" method="post" id="csvDataFileForm">
	<div>
		<label>Upload User Data CSV :</label>
		<input type="file" name='<portlet:namespace/>csvDataFile' id="csvDataFile"></input>
	</div>
	<div>
		<input type="submit"></input>
	</div>
</form>
<liferay-ui:search-container total="<%=users.size()%>" var="searchContainer" delta="10" deltaConfigurable="true" 
  emptyResultsMessage="Oops. There  Are No Users To Display, Please add Users">
  
 <liferay-ui:search-container-results results="<%=ListUtil.subList(users, searchContainer.getStart(),searchContainer.getEnd())%>" />
  <liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User" modelVar="user" keyProperty="userId" >
   <liferay-ui:search-container-column-text name="User Id" value="${user.userId}"/>
   <liferay-ui:search-container-column-text name="First Name" property="firstName"/>
   <liferay-ui:search-container-column-text name="Last Name" property="lastName"/>
   <liferay-ui:search-container-column-text name="Email Id" value="${user.emailAddress}"/>
  </liferay-ui:search-container-row>
 <liferay-ui:search-iterator />

</liferay-ui:search-container>