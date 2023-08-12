<%@page import="bd.gov.dgfood.credit.other.priority.customer.constants.CustomerPortletKeys"%>
<%@ include file="init.jsp" %>


<h1> OP </h1>
<liferay-util:include page="/view.jsp" servletContext="<%=application %>">
	<liferay-util:param name="userType" value="<%=CustomerPortletKeys.OTHER_PRIORITY %>"></liferay-util:param>
	<liferay-util:param name="title" value="label-other-priority-customer-list"></liferay-util:param>
</liferay-util:include>