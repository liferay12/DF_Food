<%@include file="/ffpb_registration/init.jsp" %>

<h3> <liferay-ui:message key="ffp-beneficiary-form-submitted-successfully"></liferay-ui:message> </h3>
<h4> <liferay-ui:message key="your-application-no"></liferay-ui:message> #${applicationNumber}.</h4>
<h5> <liferay-ui:message key="also-sent-this-details-on-beneficiary-mobile-no"></liferay-ui:message></h5>


<portlet:renderURL var="listURL">
        <portlet:param name="mvcPath" 
        value="/ffpb_admin/ffpb_list.jsp" />
         <portlet:param name="jsp" 
        value="list" />
</portlet:renderURL>

<aui:button  type="button" href="<%= listURL %>" value='go-to-list'></aui:button>