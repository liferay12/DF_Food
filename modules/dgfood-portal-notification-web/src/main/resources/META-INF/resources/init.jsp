
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


<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-frontend:defineObjects />


<%@page import="com.liferay.portal.kernel.model.UserNotificationEvent"%>
<%@page import="java.util.List"%>

<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.kernel.notifications.UserNotificationManagerUtil"%>
<%@page import="com.liferay.portal.kernel.notifications.UserNotificationFeedEntry"%>
<%@page import="com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>