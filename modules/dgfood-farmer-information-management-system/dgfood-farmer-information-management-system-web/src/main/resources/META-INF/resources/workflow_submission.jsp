<%@include file="init.jsp"%>

<portlet:renderURL var="landingPageURL" />

<h1>
	<dgfood-ui:message key="label-your-submission-is-captured"></dgfood-ui:message>
</h1>

 <aui:button  href="<%=landingPageURL %>" value="label-back-to-home" ></aui:button>