<%@include file="/ffpb_dealer_link/init.jsp" %>
<c:choose>
	<c:when  test='<%= FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId, FoodFriendlyProgramConstants.DEALER_BENEFICIARY_LINK) %>'>


<%
FFPBDisplayContext ffpRegistrationDisplayContext = new FFPBDisplayContext(request, liferayPortletRequest, liferayPortletResponse);
pageContext.setAttribute("emptyOnClickRowChecker",new EmptyOnClickRowChecker(liferayPortletResponse));
pageContext.setAttribute("customSearchContainer",ffpRegistrationDisplayContext.getSearch());
pageContext.setAttribute("actions",true);
request.setAttribute("linking", true);
%>


<portlet:renderURL var="searchURL">
        <portlet:param name="mvcPath" 
        value="/ffpb_dealer_link/list.jsp" />
</portlet:renderURL>


<portlet:renderURL var="linkURL">			
			<portlet:param name="mvcPath" value="/ffpb_dealer_link/ffpb_dealer_link_list.jsp" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
</portlet:renderURL>

<aui:form action="${searchURL}" name="fm">
	<clay:row>
		<clay:col md="2" sm="6">

			<label for="fromDate"><liferay-ui:message key="from-date"></liferay-ui:message></label>
			<aui:input name="fromDate" label="" value="" type="Date"
				placeholder="select" />

		</clay:col>
		<clay:col md="2" sm="6">

			<label for="toDate"><liferay-ui:message key="to-date"></liferay-ui:message></label>
			<aui:input name="toDate" label="" value="" type="Date"
				placeholder="select" />

		</clay:col>

		<clay:col md="2" sm="6">

			<label for="nationalId"><liferay-ui:message key="national-id"></liferay-ui:message></label>
			<aui:input name="nationalId" label="" value="" placeholder="enter-here" />

		</clay:col>

		<clay:col md="2" sm="6">

			<label for="status"><liferay-ui:message
					key="status"></liferay-ui:message></label>
			<aui:select name="status" label="">
				<aui:option value="-1">
					<liferay-ui:message key="select"></liferay-ui:message>
				</aui:option>
				<aui:option value="0">
					<liferay-ui:message key="approved"></liferay-ui:message>
				</aui:option>
				<aui:option value="1">
					<liferay-ui:message key="pending"></liferay-ui:message>
				</aui:option>
				<aui:option value="4">
					<liferay-ui:message key="rejected"></liferay-ui:message>
				</aui:option>
				<aui:option value="3">
					<liferay-ui:message key="inactive"></liferay-ui:message>
				</aui:option>
			</aui:select>

		</clay:col>

		<clay:col md="2" sm="6">

			<label for="cardNumber"><liferay-ui:message key="card-number"></liferay-ui:message></label>
			<aui:input name="cardNumber" label="" value="" placeholder="enter-here" />

		</clay:col>
		<clay:col md="2" sm="6">
		</clay:col>

		<clay:col md="2" sm="6">

			<label for="name"><liferay-ui:message key="name"></liferay-ui:message></label>
			<aui:input name="name" label="" value="" placeholder="search" />

		</clay:col>

		<clay:col md="2" sm="6">

			<label for="gender"><liferay-ui:message
					key="gender"></liferay-ui:message></label>
			<aui:select name="gender" label="">
				<aui:option value="-1">
					<liferay-ui:message key="select"></liferay-ui:message>
				</aui:option>
				<aui:option value="0">
					<liferay-ui:message key="male"></liferay-ui:message>
				</aui:option>
				<aui:option value="1">
					<liferay-ui:message key="female"></liferay-ui:message>
				</aui:option>
				<aui:option value="2">
					<liferay-ui:message key="third-gender"></liferay-ui:message>
				</aui:option>
			</aui:select>




		</clay:col>

		<clay:col md="2" sm="6">

			<label for="mapping"><liferay-ui:message
					key="mapping"></liferay-ui:message></label>
			<aui:select name="mapping" label="">
				<aui:option value="-1">
					<liferay-ui:message key="select"></liferay-ui:message>
				</aui:option>
				<aui:option value="0">
					<liferay-ui:message key="linked-beneficiaries"></liferay-ui:message>
				</aui:option>
				<aui:option value="1">
					<liferay-ui:message key="non-linked-beneficiares"></liferay-ui:message>
				</aui:option>
			</aui:select>

		</clay:col>


			<aui:button-row>
				<aui:button type="submit" value='search'></aui:button>
				<aui:button type="reset"></aui:button>
			</aui:button-row>


	</clay:row>


</aui:form>   

<!--  Search container  -->

<aui:input name="checkAll" type="checkbox" onClick="checkAll(event);"/>

<aui:form method="post" name="fm1">
      <aui:input name="linkIds" type="hidden"/>
      <%@include file="/search/search_container.jsp" %>
</aui:form>
<aui:button-row>
	<aui:button  value='link' onClick="linkFFPBDealer();"></aui:button>	
</aui:button-row>

	</c:when>
	<c:otherwise>
		<div class="alert alert-danger text-center">
			<div>
				<liferay-ui:message
					key="access-denied" />
			</div>
	</c:otherwise>
</c:choose>


<aui:script>
	var linkFFPBDealer = function () {

			var searchContainerFM = document.<portlet:namespace />fm1;
			
			var ids = Liferay.Util.listCheckedExcept(
							searchContainerFM,
							'<portlet:namespace />allRowIds'
						);
            console.log('ids..',ids);
            
			if (searchContainerFM && ids) {
				Liferay.Util.postForm(searchContainerFM, {
					data: {
						linkIds: ids,
					},

					<portlet:renderURL  var="linkFFPBDealerURL">
					    <portlet:param name="mvcRenderCommandName" value="/link/ffpb_dealer" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
					</portlet:renderURL>

					url: '<%= linkFFPBDealerURL %>',
				});
			}

	};

function checkAll(event){

      const checkboxStatus = event.currentTarget.checked;

      Liferay.componentReady('<portlet:namespace />ffpSearchContainer').then(
            (searchContainer) => {
            
            if (checkboxStatus) {
                searchContainer.select.toggleAllRows(true);
            }
            else {
                searchContainer.select.toggleAllRows(false);
            }
        
    })
    
}

</aui:script>




