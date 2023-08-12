<%@ include file="/init.jsp" %>

<portlet:renderURL var="grievanceListURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<liferay-ui:success key="label-grievance-reply-submitted-successfully" message="<%=CustomLanguageUtil.get(request,"label-grievance-reply-submitted-successfully")%>"/>

<aui:button-row>
	<aui:button type="button" value='<%=CustomLanguageUtil.get(request,"label-go-to-grievance-list")%>' href="<%=grievanceListURL%>">
	</aui:button>
</aui:button-row>