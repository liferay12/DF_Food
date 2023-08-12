<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="init.jsp"%>


<%
String userType = ParamUtil.getString(request, "userType"); 

%>

<portlet:renderURL var="listURL">
</portlet:renderURL>

<c:choose>

<c:when test="<%= userType.equalsIgnoreCase("credit")%>">
<h1>
	<dgfood-ui:message key="label-credit-customer-application-submitted-successfully"></dgfood-ui:message>
</h1>
</c:when>
<c:when test="<%= userType.equalsIgnoreCase("otherpriority")%>">
<h1>
	<dgfood-ui:message key="label-other-priority-customer-application-submitted-successfully"></dgfood-ui:message>
</h1>
</c:when>

<c:otherwise>
<h1>
	<dgfood-ui:message key="label-customer-application-submitted-successfully"></dgfood-ui:message>
</h1>
</c:otherwise>

</c:choose>


 <aui:button  href="<%=listURL %>" value="list" ></aui:button>