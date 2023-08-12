<%@ include file="/attachment_preview/init.jsp" %>


<%
String cssClass = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-preview:cssClass"));
String contextPath = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-preview:contextPath"));
String title = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-preview:title"));
String previewURL = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-preview:previewURL"));
String extension = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-preview:extension"));
String downloadURL = null;
	if (Validator.isNotNull(previewURL) && Validator.isNotNull(extension)) {
		downloadURL = previewURL;
		if (FileConstants.PDF_DOC_DOCX.contains("." + extension)){
			previewURL = contextPath + "/images/" + extension + ".png";
		}

	}

%>



<a href='<%=downloadURL%>' download="<%=title%>" class="<%=cssClass%>"> 
	<img alt="<%= title%>" src='<%=previewURL%>' style='width: 100px; height: 100px;'></img>
</a>

