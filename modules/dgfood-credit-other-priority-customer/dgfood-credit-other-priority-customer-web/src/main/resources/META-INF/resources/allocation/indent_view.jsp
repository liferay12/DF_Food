<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="bd.gov.dgfood.common.services.service.IndentLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.common.services.model.Indent"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@include file="/allocation/init.jsp" %>
<%-- <%@include file="init.jsp" %> --%>


<% 
long indentId = ParamUtil.getLong(request, "indentId");
Indent indent = IndentLocalServiceUtil.getIndent(indentId);
String redirect = ParamUtil.getString(request, "redirect");
%>

<clay:row>

<clay:col md="6" sm="6">

<strong><%=CustomLanguageUtil.get(request, "label-commodity") %>  : </strong>  <span> <%= indent.getCommodity() %> </span>

</clay:col>

<clay:col md="6" sm="6">
<strong><%=CustomLanguageUtil.get(request, "label-quantity") %>  : </strong>  <span><%= indent.getQuantity() + indent.getQuantityUnit() %></span>

</clay:col>

<clay:col md="6" sm="6">
<strong><%=CustomLanguageUtil.get(request, "label-create-date") %>  : </strong>  <span><%= indent.getCreateDate() %></span>
</clay:col>

<clay:col md="6" sm="6">
<strong><%=CustomLanguageUtil.get(request, "label-delivery-date") %>  : </strong>  <span><%= indent.getRequiredDeliveryDate() %></span>
</clay:col>

<clay:col md="6" sm="6">
<strong><%=CustomLanguageUtil.get(request, "label-status") %>  : </strong>  <span><%= StatusConstants.getStatusLabel(indent.getStatus())  %></span>
</clay:col>

<clay:col md="6" sm="6">
<strong><%=CustomLanguageUtil.get(request, "label-payment-status") %>  : </strong>  <span><%= StatusConstants.getStatusLabel(1) %></span>
</clay:col>

</clay:row>

 <aui:button  href="<%=redirect %>" type="cancel"></aui:button>