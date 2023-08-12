<%@ include file="/init.jsp" %>
	
<%
ApplicationSearchContainer searchContainer = (ApplicationSearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
ApplicationDisplayTerms displayTerms = (ApplicationDisplayTerms)searchContainer.getDisplayTerms();
List<AssetCategory> categoryList = new ArrayList<AssetCategory>();
%>
	
    <portlet:renderURL var="searchURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
        <portlet:param name="mvcPath" value="/list.jsp" />
    </portlet:renderURL>

    <aui:nav-bar>
          <aui:nav-bar-search>
              <aui:form action="<%=searchURL%>" cssClass="floating-left" method="post" name="fm" onClick="search()">
				
						<div class="row">
							<div class="col-4">	
                				<aui:input type="Date" name="fromDate" label="from-date" cssClass="statusAllign" value="<%=displayTerms.getFromDate() %>" />
							</div>
							<div class="col-4">
                 				<aui:input type="Date" name="toDate" label="to-date" cssClass="toDate statusAllign" value="<%=displayTerms.getToDate() %>" />
                 			</div>
                 			<div class="col-4">
                 			<label ><liferay-ui:message key="grievance-status-label" /></label>
								<aui:select id="status" name="status" label="" cssClass="num">
								<aui:option selected="true"><liferay-ui:message key='select-option' /></aui:option>
								<aui:option value="1"><liferay-ui:message key="pending" /></aui:option>
								<aui:option value="18"><liferay-ui:message key="resolved" /></aui:option>                       
								</aui:select>
							</div>
							<!-- <div class="col-3">
                 				<liferay-ui:input-search markupView="lexicon" />
                 			</div> -->
                 		</div>
                 		<div class="row">
                 			<%if(renderRequest.isUserInRole(RoleConstants.UCF)){ %>
							<div class="col-4">	
                				<label ><liferay-ui:message key="grievance-user-label" /></label>
								<aui:select id="grievanceUser" name="grievanceUser" label="" cssClass="num">
								<aui:option selected="true"><liferay-ui:message key='select-option' /></aui:option>
								<%categoryList  = (List<AssetCategory>)renderRequest.getAttribute(CategoryConstants.GRIEVANCE_USERS);
												if(Validator.isNotNull(categoryList)){
	                                    		for(AssetCategory assetCategory : categoryList){
	                                    		%>
													    <aui:option value="<%=assetCategory.getCategoryId() %>"><%=assetCategory.getTitle(themeDisplay.getLocale()) %></aui:option>                       
								<%}}%>
								</aui:select>
							</div>
							<%}%>
							<div class="col-4">
                 				<label ><liferay-ui:message key="grievance-category-label" /></label>
								<aui:select id="grievanceCategory" name="grievanceCategory" label="" cssClass="num">
								<aui:option selected="true"><liferay-ui:message key='select-option' /></aui:option>
								<%categoryList  = (List<AssetCategory>)renderRequest.getAttribute(CategoryConstants.GRIEVANCE_TYPE);
												if(Validator.isNotNull(categoryList)){
	                                    		for(AssetCategory assetCategory : categoryList){
	                                    		%>
													    <aui:option value="<%=assetCategory.getCategoryId() %>"><%=assetCategory.getTitle(themeDisplay.getLocale()) %></aui:option>                       
								<%}}%>
								</aui:select>
                 			</div>
                 			<div class="col-4">
                 			<aui:button cssClass="login_btn" title="Search" type="submit" value="<%=CustomLanguageUtil.get(request,"search")%>"/>
							<aui:button cssClass="login_btn" title="Reset" type="button" onClick="<%=searchURL%>" value="<%=CustomLanguageUtil.get(request,"reset")%>" />
							</div>
		
                 		</div>
               </aui:form>
    		</aui:nav-bar-search>

    	</aui:nav-bar>