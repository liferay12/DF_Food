<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>

<%@ taglib uri="http://bd.gov.dgfood/tld/ui" prefix="dgfood-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<liferay-frontend:defineObjects />



<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="bd.gov.dgfood.food.friendly.program.model.FFPBeneficiary"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="bd.gov.dgfood.food.friendly.program.web.internal.display.context.FFPBDisplayContext"%>
<%@page import="java.text.Format"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="bd.gov.dgfood.food.friendly.program.web.internal.security.permission.resource.FoodFriendlyProgramPermission"%>
<%@page import="bd.gov.dgfood.food.friendly.program.constants.FoodFriendlyProgramConstants"%>

