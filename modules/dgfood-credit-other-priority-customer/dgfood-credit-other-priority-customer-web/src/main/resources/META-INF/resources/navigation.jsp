<liferay-portlet:renderURL var="searchURL">
</liferay-portlet:renderURL>

<aui:form action="${searchURL}" name="fm1" method="GET" role="search">

    <clay:row>	
        <clay:col md="3" sm="6">

       
            <label for="startDate"><dgfood-ui:message key="label-from-date"></dgfood-ui:message></label>
            <aui:input name="startDate" label=""  type="Date" placeholder="select" value="<%=startDate %>"/>

        </clay:col>
        <clay:col md="3" sm="6">
        
            <label for="endDate"><dgfood-ui:message key="label-to-date"></dgfood-ui:message></label>
            <aui:input name="endDate" label=""   type="Date" placeholder="select" value="<%=endDate %>"/>

        </clay:col>
        
                <clay:col md="3" sm="6">

						<label for="organizationName"><dgfood-ui:message
								key="label-organization-name"></dgfood-ui:message></label>
						<aui:select name="organizationName" label="" value="<%=organizationName %>">
							<aui:option value="">
								<dgfood-ui:message key="select"></dgfood-ui:message>
							</aui:option>
							<aui:option value="army">
								<dgfood-ui:message key="army"></dgfood-ui:message>
							</aui:option>
							<aui:option value="airforce">
								<dgfood-ui:message key="airforce"></dgfood-ui:message>
							</aui:option>
							<aui:option value="navy">
								<dgfood-ui:message key="navy"></dgfood-ui:message>
							</aui:option>
							<aui:option value="ploice">
								<dgfood-ui:message key="ploice"></dgfood-ui:message>
							</aui:option>
						</aui:select>

			</clay:col>

        <clay:col md="3" sm="6">

						<label for="status"><dgfood-ui:message
								key="label-status"></dgfood-ui:message></label>
						<aui:select name="status" label="" value="<%=status %>">
							<aui:option value="-1">
								<dgfood-ui:message key="select"></dgfood-ui:message>
							</aui:option>
							<aui:option value="0">
								<dgfood-ui:message key="<%=StatusConstants.LABEL_APPROVED%>"></dgfood-ui:message>
							</aui:option>
							<aui:option value="1">
								<dgfood-ui:message key="<%=StatusConstants.LABEL_PENDING %>"></dgfood-ui:message>
							</aui:option>
							<aui:option value="4">
								<dgfood-ui:message key="<%=StatusConstants.LABEL_REJECTED %>"></dgfood-ui:message>
							</aui:option>
						</aui:select>

			</clay:col>

        <clay:col md="3" sm="6" >
           
                <aui:button  type="submit" value='label-search' ></aui:button>
                <aui:button  href="<%=searchURL %>" type="reset" value="label-reset"></aui:button>

        </clay:col>


    </clay:row>
    
    <%=PortletLifeCycleUtil._getSearchData(searchURL.toString()) %>

	</aui:form>  
