
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay"%>

<%@
taglib uri="http://liferay.com/tld/react" prefix="react" %>

<%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>


<%@ taglib uri="http://liferay.com/tld/data-engine" prefix="liferay-data-engine" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-frontend:defineObjects />


<%@page import="bd.gov.dgfood.location.selector.web.constants.LocationSelectorPortletKeys"%>
<%@page import="bd.gov.dgfood.configuration.LocationUrlConfiguration"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="bd.gov.dgfood.common.services.service.UserLocationLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.common.services.model.UserLocation"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>

<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.HttpComponentsUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption"%>
<%@page import="com.liferay.list.type.service.ListTypeEntryLocalServiceUtil"%>
<%@page import="com.liferay.list.type.model.ListTypeEntry"%>
<%@page import="java.util.List"%>



<%@page import="bd.gov.dgfood.common.services.exception.UserLocationAlreadyExistException"%>
<%@page import="bd.gov.dgfood.common.services.exception.NoLocationExistException"%>
<%@page import="com.liferay.portal.kernel.exception.NoSuchUserException"%>
<%@page import="bd.gov.dgfood.common.services.exception.LocationAssignedException"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.util.HashMapBuilder"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>

<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu"%>

<%@page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker"%>

