<%@ include file="init.jsp"%>

<portlet:renderURL var="webCamURL">
    <portlet:param name="jspPage" value="/webcam.jsp" />
</portlet:renderURL>
<aui:button value="Webcam Module" type="submit" onClick="<%= webCamURL.toString() %>"></aui:button>

<portlet:renderURL var="downloadLinkURL">
    <portlet:param name="jspPage" value="/downloadlink.jsp" />
</portlet:renderURL>
<aui:button value="Download Link Module" type="submit" onClick="<%= downloadLinkURL.toString() %>"></aui:button>
