<%@ include file="/init.jsp" %>

<%
List<AssetCategory> categoryList = (List<AssetCategory>)renderRequest.getAttribute(CategoryConstants.GRIEVANCE_TYPE);
String acceptedDocumentExtensions = com.liferay.petra.string.StringUtil.merge(FileConstants.PDF_DOC_DOCX, StringPool.COMMA_AND_SPACE);
%>
<portlet:actionURL var="submitFormDataURL" name="/grievance/register"></portlet:actionURL>
<aui:form name="grievanceRegistrationForm" action="<%=submitFormDataURL%>" method="post" enctype="multipart/form-data">

<div class="row">
				<div class="col-6">
					<label ><liferay-ui:message key="grievance-category-label" />*</label>
					<aui:select name="<%=ParameterConstants.GRIEVANCE_CATEGORY %>" label="">
						<aui:validator name="required" errorMessage="grievance-category-error-label" />
						<aui:option selected="true"><liferay-ui:message key='select-option' /></aui:option>
						<%categoryList  = (List<AssetCategory>)renderRequest.getAttribute(CategoryConstants.GRIEVANCE_TYPE);
											if(Validator.isNotNull(categoryList)){
                                    		for(AssetCategory assetCategory : categoryList){
                                    		%>
												    <aui:option value="<%=assetCategory.getCategoryId() %>"><%=assetCategory.getTitle(themeDisplay.getLocale()) %></aui:option>                       
											<%}}%>    
						</aui:select>
				</div>
				<div class="col-6">
					<label ><liferay-ui:message key="user-type-label" />*</label>
					<aui:select name="<%=ParameterConstants.GRIEVANCE_USER_TYPE %>" label="">
						<aui:validator name="required" errorMessage="user-type-error-label" />
						<aui:option selected="true"><liferay-ui:message key='select-option' /></aui:option>
						
						<%	categoryList  = (List<AssetCategory>)renderRequest.getAttribute(CategoryConstants.GRIEVANCE_USERS);
											if(Validator.isNotNull(categoryList)){
                                    		for(AssetCategory assetCategory : categoryList){
                                    		%>
												    <aui:option value="<%=assetCategory.getCategoryId() %>"><%=assetCategory.getTitle(themeDisplay.getLocale()) %></aui:option>                       
											<%}}%>    
					</aui:select>
				</div>
</div>

<div class="row">
				<div class="col-6">
					<label ><liferay-ui:message key="name-of-user-label" />*</label>
					<aui:input type="text" name="<%=ParameterConstants.GRIEVANCE_USER_NAME %>" label="" value="<%=themeDisplay.getUser().getFullName() %>">
						<aui:validator name="required" errorMessage="user-name-error-label" />
					</aui:input>
				</div>
				<div class="col-6">
						<label ><liferay-ui:message key="mobile-number-label" />*</label>
						<clay:icon symbol="hi-in" />
						<aui:input name="<%=ParameterConstants.MOBILE_NUMBER %>" label="" type="text" placeholder="type-here" 
			    			value="" maxLength="30" minLength="1">
			    			<aui:validator name="required" errorMessage="mobile-number-error-label" />
							<aui:validator name="alphanum"/>
						</aui:input>
				</div>
</div>

<div class="row">
			<div class="col-12">
					<label ><liferay-ui:message key="complaint-details-label" />*</label>
					<aui:input name="<%=ParameterConstants.GRIEVANCE_DETAILS %>" label="" type="textarea" placeholder="type-here" 
			    			value="" maxLength="3000" minLength="1">
			    			<aui:validator name="required" errorMessage="complaint-details-error-label" />
						</aui:input>
			</div>
</div>
<div class="row">
		<div class="col-12">
			<%-- <label ><liferay-ui:message key="attachments-label" /></label>
			<aui:input type="file" name="<%=ParameterConstants.ATTACHMENTS %>" label="" required="true" cssClass="validate">
			<aui:validator name="required" errorMessage="file-required-error-label" />
			<aui:validator name="acceptFiles">'jpg,png,pdf'</aui:validator>
			</aui:input> --%>
			
			<dgfood-ui:attachment-upload  name="<%=ParameterConstants.ATTACHMENTS %>" required="false"
			accept='<%=acceptedDocumentExtensions%>' multiple="<%=false%>"
			maxSize='<%=FileConstants.TWO_MB%>' 
			previewContainerId='<%= liferayPortletResponse.getNamespace() + ParameterConstants.ATTACHMENTS+"_preview"%>'/>
			
		</div>
</div>
		
<div class="row">
	<div class="col-12">
		<aui:button cssClass="login_btn" title="Submit" type="submit" value="<%=CustomLanguageUtil.get(request,"submit")%>" id="submit" />
		<aui:button cssClass="login_btn" title="Back" type="button"  href="<%=viewList%>" value="<%=CustomLanguageUtil.get(request,"back")%>" id="back" />
	</div>
</div>
</aui:form>