<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.FormSectionLabelsConstant"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@ include file="/bank_account_information/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
boolean isDisabled=false;
if(Validator.isNotNull(request.getAttribute("dgfood-ui:isDisabled")))
{
	isDisabled = (Boolean)request.getAttribute("dgfood-ui:isDisabled");
}
try{
	boolean showAlertMessage = (Boolean)request.getAttribute("dgfood-ui:page-access-status-verifier:showAlertMessage");

%>

	<h3><%=CustomLanguageUtil.get(request,FormSectionLabelsConstant.BANK_DETAILS)%></h3>
	
	<aui:row>
		<aui:col width="50">
			<aui:input name="<%=ParameterConstants.ACCOUNT_NUMBER %>" cssClass="validate isMandatory" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.ACCOUNT_NUMBER) %>" type="text" 
				disabled="<%=isDisabled %>">
				<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-bank-acount-number")%>' />
				<aui:validator name="maxLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"label-error-max-length-twenty")%>'>20</aui:validator>
				<aui:validator name="minLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"label-error-min-length-one")%>'>1</aui:validator>
			</aui:input>
		</aui:col>
		<aui:col width="50">
			<aui:input name="<%=ParameterConstants.BANK_NAME %>" cssClass="validate isMandatory" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.BANK_NAME) %>" type="text" disabled="<%=isDisabled %>">
				<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-bank-name")%>' />
				<aui:validator name="maxLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"label-error-max-length-twenty")%>'>50</aui:validator>
				<aui:validator name="minLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"label-error-min-length-one")%>'>1</aui:validator>
			</aui:input>
		</aui:col>
		<aui:col width="50">
			<aui:input name="<%=ParameterConstants.BRANCH_NAME %>" cssClass="validate isMandatory" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.BRANCH_NAME) %>" type="text" disabled="<%=isDisabled %>">
				<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-branch-name")%>' />
				<aui:validator name="maxLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"label-error-max-length-twenty")%>'>50</aui:validator>
				<aui:validator name="minLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"label-error-min-length-one")%>'>1</aui:validator>
			</aui:input>
		</aui:col>
		<aui:col width="50">
			<aui:input name="<%=ParameterConstants.ROUTING_CODE %>" cssClass="validate isMandatory" 
				label="<%=CustomLanguageUtil.get(request,"label-"+ParameterConstants.ROUTING_CODE) %>" type="text" disabled="<%=isDisabled %>">
				<aui:validator name="required" errorMessage='<%=CustomLanguageUtil.get(request,"label-error-branch-code")%>' />
				<aui:validator name="maxLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"label-error-max-length-twenty")%>'>20</aui:validator>
				<aui:validator name="minLength"
					errorMessage='<%=CustomLanguageUtil.get(request,"label-error-min-length-one")%>'>1</aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>

<%
}catch(Exception e){
	e.printStackTrace();
}
%>