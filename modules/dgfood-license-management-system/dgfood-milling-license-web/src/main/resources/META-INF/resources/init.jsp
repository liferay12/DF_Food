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
<%@ taglib uri="http://bd.gov.dgfood/tld/ui" prefix="dgfood-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<%@page import="bd.gov.dgfood.milling.license.constants.MillingLicensePortletKeys"%>
<%@page import="bd.gov.dgfood.milling.license.web.internal.display.context.MillingLicenseDisplayContext"%>
<%@page import="bd.gov.dgfood.license.management.system.model.MillingLicense"%>
<%@page import="bd.gov.dgfood.license.management.system.model.FGLicense"%>
<%@page import="bd.gov.dgfood.common.services.model.Address"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
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
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="bd.gov.dgfood.common.util.constants.DocumentLibraryConstants"%>
<%@page import="bd.gov.dgfood.common.services.model.Attachment"%>
<%@page import="bd.gov.dgfood.common.util.DLUploadUtil"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"
integrity="sha512-T/tUfKSV1bihCnd+MxKD0Hm1uBBroVYBOYSk1knyvQ9VyZJpc/ALb4P0r6ubwVPSGB2GvjeoMAJJImBG12TiaQ=="
crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"
integrity="sha512-mSYUmp1HYZDFaVKK//63EcZq4iFWFjxSL+Z3T/aCt4IO9Cejm03q3NKKYN6pFQzY0SBOr8h+eCIAZHPXcpZaNw=="
crossorigin="anonymous" referrerpolicy="no-referrer" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.bn.min.js"
integrity="sha512-NZcAbRCbE+ob6yV1WuHKEVFZ1TwvyPBysVgNLAVcNtWAwdNrxLXEuJlev0trqCpaNjqo7d4ylCWfpP2wnVDnnw=="
crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<!-- Select2 CSS -->	
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css" rel="stylesheet" /> 
<!-- Select2 JS --> 
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>