<%@page import="bd.gov.dgfood.common.util.PortletLifeCycleUtil"%>

<liferay-portlet:renderURL var="searchURL">
        <portlet:param name="mvcPath" value="/allocation/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="${searchURL}" name="fm1" method="GET" role="search">

    <clay:row>	
        <clay:col md="4" sm="6">

        <aui:input name="year" label="label-year"  type="text" placeholder="select" >
        	<aui:validator name="maxLength">4</aui:validator>
        	<aui:validator name="number"></aui:validator>
        </aui:input>

        </clay:col>

                <clay:col md="5" sm="6">

						<aui:select name="commodity" label="label-commodity">
							<aui:option value="">
								<liferay-ui:message key="select"></liferay-ui:message>
							</aui:option>
							<aui:option value="army">
								<liferay-ui:message key="wheat"></liferay-ui:message>
							</aui:option>
							<aui:option value="Rice">
								<liferay-ui:message key="rice"></liferay-ui:message>
							</aui:option>
							<aui:option value="navy">
								<liferay-ui:message key="flour"></liferay-ui:message>
							</aui:option>
							<aui:option value="ploice">
								<liferay-ui:message key="zink-rice"></liferay-ui:message>
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
