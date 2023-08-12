<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>

<%@ taglib uri="http://bd.gov.dgfood/tld/ui" prefix="dgfood-ui"%>

<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.CategoryConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.asset.kernel.service.AssetVocabularyLocalService"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalService"%>

<%@page import="bd.gov.dgfood.common.util.constants.RoleConstants"%>
<%@page import="bd.gov.dgfood.common.util.DLUploadUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.DateConstants"%>
<%@page import="bd.gov.dgfood.common.util.DateFormatterUtil"%>
<%@page import="bd.gov.dgfood.common.util.CategoryUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="bd.gov.dgfood.common.services.model.Grievance"%>
<%@page import="bd.gov.dgfood.common.services.service.GrievanceLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="java.util.Locale"%>
<%@page import="bd.gov.dgfood.grievance.utility.ApplicationDisplayTerms"%>
<%@page import="bd.gov.dgfood.grievance.utility.ApplicationSearchContainer"%>
<%@page import="javax.portlet.WindowState"%>

<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="bd.gov.dgfood.common.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="bd.gov.dgfood.common.util.constants.FileConstants"%>
<%@page import="com.liferay.petra.string.StringPool"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-portlet:renderURL var="viewList">
		    <liferay-portlet:param name="mvcPath" value="/list.jsp" />
</liferay-portlet:renderURL>
