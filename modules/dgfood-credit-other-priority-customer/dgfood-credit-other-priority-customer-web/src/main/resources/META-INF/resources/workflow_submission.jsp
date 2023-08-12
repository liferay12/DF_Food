<%@include file="init.jsp"%>

<portlet:renderURL var="listURL">
</portlet:renderURL>


<h1>
	<dgfood-ui:message key="label-your-submission-is-captured"></dgfood-ui:message>
</h1>

 <aui:button  href="<%=listURL %>" value="list" ></aui:button>