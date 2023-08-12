<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@ taglib uri="http://bd.gov.dgfood/tld/ui" prefix="dgfood-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<!-- Liferay Standard  Imports -->
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.model.ModelHintsUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<!-- Script Linking -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"
	integrity="sha512-T/tUfKSV1bihCnd+MxKD0Hm1uBBroVYBOYSk1knyvQ9VyZJpc/ALb4P0r6ubwVPSGB2GvjeoMAJJImBG12TiaQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"
	integrity="sha512-mSYUmp1HYZDFaVKK//63EcZq4iFWFjxSL+Z3T/aCt4IO9Cejm03q3NKKYN6pFQzY0SBOr8h+eCIAZHPXcpZaNw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.bn.min.js"
	integrity="sha512-NZcAbRCbE+ob6yV1WuHKEVFZ1TwvyPBysVgNLAVcNtWAwdNrxLXEuJlev0trqCpaNjqo7d4ylCWfpP2wnVDnnw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<!-- Java Classes -->
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page
	import="bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicenseConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker"%>

<!-- Java Standard  Imports -->
<%@page import="java.text.Format"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<!-- Common Service & Util Imports -->
<%@page import="bd.gov.dgfood.common.services.model.Address"%>
<%@page import="bd.gov.dgfood.common.util.constants.DocumentLibraryConstants"%>
<%@page import="bd.gov.dgfood.common.services.model.Attachment"%>
<%@page import="bd.gov.dgfood.common.util.DLUploadUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.common.util.CategoryUtil"%>
<%@page import="bd.gov.dgfood.common.util.validator.DataValidationException"%>
<%@page import="bd.gov.dgfood.common.util.constants.MaritalStatusConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.GenderConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.FileConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.AddressConstants"%>
<%@page import="bd.gov.dgfood.common.services.model.AttachmentVersion"%>
<%@page import="bd.gov.dgfood.common.services.exception.NoSuchAttachmentException"%>
<%@page import="bd.gov.dgfood.common.services.exception.NoSuchAddressException"%>
<%@page import="bd.gov.dgfood.common.util.DateFormatterUtil"%>

<!-- Food Grain License Imports -->
<%@page import="bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys"%>
<%@page import="bd.gov.dgfood.license.management.system.exception.InvalidFGLicenseInformationException"%>

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

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="bd.gov.dgfood.common.util.constants.DateConstants"%>
<%@page import="bd.gov.dgfood.common.util.DateFormatterUtil"%>
<%@page import="bd.gov.dgfood.configuration.LocationUrlConfiguration"%>
<%@page
	import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.AddressConstants"%>
<%@page import="bd.gov.dgfood.common.services.model.Address"%>
<%@page import="bd.gov.dgfood.common.services.model.Attachment"%>
<%@page
	import="bd.gov.dgfood.license.management.system.model.FGLicenseDetails"%>
