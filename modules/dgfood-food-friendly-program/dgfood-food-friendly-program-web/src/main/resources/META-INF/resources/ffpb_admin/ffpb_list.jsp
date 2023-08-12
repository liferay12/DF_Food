<%@include file="/ffpb_admin/init.jsp" %>


    <!-- <clay:button
    displayType="unstyled"
    icon="date"
/> -->
<c:choose>
	<c:when test='<%=FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId, FoodFriendlyProgramConstants.VIEW)%>'>

<%
FFPBDisplayContext ffpRegistrationDisplayContext = new FFPBDisplayContext(request, liferayPortletRequest, liferayPortletResponse);
pageContext.setAttribute("customSearchContainer",ffpRegistrationDisplayContext.getSearch());
pageContext.setAttribute("actions",true);
request.setAttribute("edit", true);
request.setAttribute("showStatus", true);
%>

<portlet:renderURL var="searchURL">
        <portlet:param name="mvcPath" 
        value="/ffpb_admin/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="addBeneficiaryURL">
    <portlet:param 
        name="mvcPath" 
        value="/ffpb_registration/registration.jsp" 
    />
    <portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>"/>
</portlet:renderURL>

<div id='ffpb_search_box'>
    <aui:form action="${searchURL}" name="fm">
    <clay:row>	
        <clay:col md="2" sm="6">
       
            <label for="fromDate"><liferay-ui:message key="from-date"></liferay-ui:message></label>
            <aui:input name="fromDate" label=""  value="" type="Date" placeholder="select"/>

        </clay:col>
        <clay:col md="2" sm="6">
        
            <label for="toDate"><liferay-ui:message key="to-date"></liferay-ui:message></label>
            <aui:input name="toDate" label=""  value="" type="Date" placeholder="select"/>

        </clay:col>

        <clay:col md="4" sm="6">

				<c:choose>
					<c:when test="${review }">

						<label for="status"><liferay-ui:message
								key="beneficiary-status"></liferay-ui:message></label>
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

					</c:when>
					<c:otherwise>

						<label for="keywords"><liferay-ui:message key="keywords"></liferay-ui:message></label>
						<aui:input name="keywords" label="" value="" placeholder="search" />

					</c:otherwise>

				</c:choose>

			</clay:col>

        <clay:col md="2" sm="6">
            <aui:button-row>
                <aui:button  type="submit" value='search' ></aui:button>
                <aui:button  type="reset" ></aui:button>
            </aui:button-row>
        </clay:col>


    </clay:row>
  <c:if test="${empty review }">

			<clay:row>

				<clay:col md="2" sm="6">

					<label for="status"><liferay-ui:message
							key="beneficiary-status"></liferay-ui:message></label>
					<aui:select name="status" label="" value="">
						<aui:option value="-1">
								<liferay-ui:message key="all"></liferay-ui:message>
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

					<label for="ffpCardNumber"><liferay-ui:message
							key="card-no"></liferay-ui:message></label>
					<aui:input name="cardNumber" label="" value=""
						placeholder="enter-here" />

				</clay:col>

				<clay:col md="2" sm="6">

					<label for="nationalId"><liferay-ui:message key="nid-no"></liferay-ui:message></label>
					<aui:input name="nationalId" label="" value=""
						placeholder="enter-here" />

				</clay:col> 

			</clay:row>
</c:if>

	</aui:form>   
</div>
<c:if test='<%=FoodFriendlyProgramPermission.contains(permissionChecker, scopeGroupId, FoodFriendlyProgramConstants.ADD_BENEFICIARY)%>'>
<aui:button  href="${addBeneficiaryURL}" value='add-beneficiary' ></aui:button>
</c:if>

<!-- Search container -->

<%@include file="/search/search_container.jsp" %>

	</c:when>
	<c:otherwise>
		<div class="alert alert-danger text-center">
			<div>
				<liferay-ui:message
					key="access-denied" />
			</div>
	</c:otherwise>
</c:choose>
