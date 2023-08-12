<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay"%>
<%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="dgfood-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-frontend:defineObjects />

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>


<% 
int currentYear = GetterUtil.getInteger(request.getAttribute("currentYear"), -1); 
%>
        