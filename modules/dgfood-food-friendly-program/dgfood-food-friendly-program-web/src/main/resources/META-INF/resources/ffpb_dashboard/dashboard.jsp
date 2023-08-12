<%@include file="/ffpb_dashboard/init.jsp"%>

<style>


/* width */
::-webkit-scrollbar {
	width: 5px;
}

/* Track */
::-webkit-scrollbar-track {
	background: #f1f1f1;
}

/* Handle */
::-webkit-scrollbar-thumb {
	background: #888;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
	background: #555;
}

thead, tbody { display: block; }

tbody {
    height: 300px;      
    overflow-y: auto;    
    overflow-x: hidden;  
}
</style>
<c:choose>
	<c:when test='<%=FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId, FoodFriendlyProgramConstants.VIEW_DASHBOARD)%>'>

<%
FFPBDisplayContext ffpRegistrationDisplayContext = new FFPBDisplayContext(request, liferayPortletRequest, liferayPortletResponse);
pageContext.setAttribute("customSearchContainer",ffpRegistrationDisplayContext.getSearch());
%>


		<portlet:renderURL var="addBeneficiaryURL">
			<portlet:param name="mvcPath"
				value="/ffpb_registration/registration.jsp" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>" />
		</portlet:renderURL>

		<portlet:renderURL var="searchURL">
			<portlet:param name="mvcRenderCommandName" value="/uc_uno/view" />
		</portlet:renderURL>

		<%@include file="/ffpb_dashboard/dashboard_cards.jsp"%>

		<div id='dashboard_search_box'>
			<aui:form action="${searchURL}" name="fm"
				cssClass="container-fluid-1280">
				<clay:row>

					<clay:col md="3" sm="6">

						<label for="fromDate"><liferay-ui:message key="from-date"></liferay-ui:message></label>
						<aui:input name="fromDate" label="" value="12/12/1222" type="Date"
							placeholder="select" />

					</clay:col>
					<clay:col md="3" sm="6">

						<label for="toDate"><liferay-ui:message key="to-date"></liferay-ui:message></label>
						<aui:input name="toDate" label="" value="" type="Date"
							placeholder="select" />

					</clay:col>

					<clay:col md="4" sm="6">
						<label for="keywords"><liferay-ui:message key="keywords"></liferay-ui:message></label>
						<aui:input name="keywords" label="" value="" placeholder="search" />
					</clay:col>


				</clay:row>

				<aui:button-row>
					<aui:button type="button" value='search' id="search_filters"></aui:button>
					<aui:button type="reset"></aui:button>
				</aui:button-row>


			</aui:form>


		</div>

		<c:if test='<%=FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId,FoodFriendlyProgramConstants.ADD_BENEFICIARY)%>'>

			<aui:button href="${addBeneficiaryURL}" value='add-beneficiary'></aui:button>

		</c:if>
		<clay:row>

			<clay:col md="10" sm="6" >
			
				<div id="<portlet:namespace />dashboard-search-container">				
					<%@include file="/search/search_container.jsp" %>
					
				</div>
			</clay:col>

		</clay:row>


<dgfood-ui:ajax-search-container 
containerId='<%=liferayPortletResponse.getNamespace() + "dashboard-search-container"%>'
resourceId="/ffp/dashboard_list"
formId='<%=liferayPortletResponse.getNamespace() + "fm"%>'
buttonId='<%= liferayPortletResponse.getNamespace() + "search_filters"%>'
/>


	</c:when>
	<c:otherwise>
		<div class="alert alert-danger text-center">
			<div>
				<liferay-ui:message
					key="access-denied" />
			</div>
	</c:otherwise>
</c:choose>

