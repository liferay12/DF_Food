<%@ include file="init.jsp" %>

<%
PortletURL portletURL = PortletURLBuilder.createRenderURL(renderResponse).setMVCPath("/select_user.jsp").buildPortletURL();
String actionURL = portletURL.toString();
String keywords = ParamUtil.getString(request, "keywords");

OrderByComparator<User> orderByComparator = null;
%>

<clay:management-toolbar
	clearResultsURL="<%= actionURL %>"
	searchActionURL="<%= actionURL %>"
	namespace="<%= liferayPortletResponse.getNamespace() %>"
	searchFormName="searchFm"
	selectable="<%= false %>"
	showSearch="<%= true %>"
	showCreationMenu="<%= false %>"
/>

<aui:form action="<%= currentURLObj %>" cssClass="container-fluid container-fluid-max-xl" method="post" name="selectUserFm">
<liferay-ui:search-container
	iteratorURL="<%= currentURLObj %>"
	emptyResultsMessage="no-results-found"
	total="<%= UserLocalServiceUtil.searchCount(company.getCompanyId(), keywords, WorkflowConstants.STATUS_APPROVED, null) %>"
	var="userSearchContainer"
>

<liferay-ui:search-container-results
			results="<%= UserLocalServiceUtil.search(company.getCompanyId(), keywords, WorkflowConstants.STATUS_APPROVED, null,userSearchContainer.getStart(), userSearchContainer.getEnd(), orderByComparator) %>"
		/>
		
	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.model.User"
		escapedModel="<%= true %>"
		keyProperty="userId"
		modelVar="user"
	>
		<liferay-ui:search-container-column-text
		        name="name"
				value="<%=user.getFullName() %>"
				 cssClass="table-cell-expand-smallest capitalize"
			/>
			
		<liferay-ui:search-container-column-text>
		
		<aui:button
						cssClass="selector-button"
						data='<%=
							HashMapBuilder.<String, Object>put(
								"entityid", user.getUserId()
							).put(
								"entityname", user.getFullName()
							).build()
						%>'
						value="choose"
					/>
		
		</liferay-ui:search-container-column-text>
			
			
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		markupView="lexicon"
		searchContainer="<%= userSearchContainer %>"
	/>
</liferay-ui:search-container>
</aui:form>
