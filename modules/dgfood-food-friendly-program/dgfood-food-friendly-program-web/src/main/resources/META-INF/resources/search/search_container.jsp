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
boolean dashboard = ParamUtil.getBoolean(request, "dashboard",false);
boolean ffpDealerLinking = ParamUtil.getBoolean(request, "ffpDealerLinking",false);
boolean paginate = ParamUtil.getBoolean(request, "paginate",true);
Format dateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy");
%>


<liferay-ui:search-container  
    rowChecker="${emptyOnClickRowChecker }"
    emptyResultsMessage="no-entries-were-found" 
    id="ffpSearchContainer"
    searchContainer="${customSearchContainer}">

<liferay-ui:search-container-row
        className="bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary"
        keyProperty="beneficiaryId" modelVar="entry" escapedModel="<%=true%>">



		<liferay-ui:search-container-column-text name="card-no" cssClass=""
			property="cardNumber" />

		<liferay-ui:search-container-column-text name="beneficary-name"
			cssClass="" property="name" />

		<liferay-ui:search-container-column-text name="application-date"
			cssClass="" value="<%=dateFormat.format(entry.getCreateDate())%>" />

		<liferay-ui:search-container-column-text name="nid" cssClass=""
			value="<%=String.valueOf(entry.getNationalId())%>" />

		<liferay-ui:search-container-column-text name="dob" cssClass=""
			value="<%=dateFormat.format(entry.getDateOfBirth())%>" />
			
		 <c:if test="${showStatus}">
		         <liferay-ui:search-container-column-status property="status" cssClass="" />
         </c:if>

		<c:if test="${actions}">

			<liferay-ui:search-container-column-jsp cssClass="" name="action"
				path="/search/action.jsp" />

		</c:if>

	</liferay-ui:search-container-row>

    <liferay-ui:search-iterator
                paginate="<%=paginate %>"
				displayStyle="list"
				markupView="lexicon"
				searchContainer="<%= searchContainer %>"
	 />
</liferay-ui:search-container>





