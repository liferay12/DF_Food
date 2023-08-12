<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@ page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker"%>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.model.ModelHintsUtil"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
