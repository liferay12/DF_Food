<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="bd.gov.dgfood.common.services.model.Indent"%>
<%@include file="/allocation/init.jsp" %>


<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Indent entry = (Indent)row.getObject();
%>

<portlet:renderURL var="detailViewURL">
			<portlet:param name="mvcPath" value="/allocation/indent_view.jsp" />
			<portlet:param name="indentId" value="<%=String.valueOf(entry.getIndentId()) %>" />
			<portlet:param name="redirect" value="<%=currentURL %>" />
</portlet:renderURL>

<liferay-ui:icon url="<%=detailViewURL %>" icon="view" markupView="lexicon"
	message="" />


