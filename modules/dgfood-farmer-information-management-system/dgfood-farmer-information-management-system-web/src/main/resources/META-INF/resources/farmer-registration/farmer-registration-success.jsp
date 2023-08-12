<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%
String farmerApplicationNumber = ParamUtil.getString(request, ParameterConstants.APPLICATION_NUMBER);

%>
<div class="success-page-head text-center">
  <div class="row">
    <div class="col-md-2 col-12"></div>
    <div class="col-md-8 col-12">
      <h1>
        <dgfood-ui:message
			key="label-farmer-registration-success" languageId="<%=themeDisplay.getLanguageId()%>" />
      </h1>
      <h3>
         <dgfood-ui:message
			key="label-farmer-registration-application-number" languageId="<%=themeDisplay.getLanguageId()%>" />:
			<span id="applicationNumner"><%=farmerApplicationNumber%></span>
      </h3>
    </br></br>
    </div>
    <div class="col-md-2 col-12"></div>
  </div>
</div>
