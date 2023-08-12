<%@page import="bd.gov.dgfood.common.util.language.CustomLanguageUtil"%>
<%@page import="bd.gov.dgfood.taglib.util.WorflowTaskSubmissionUtil"%>
<%@page import="bd.gov.dgfood.common.util.constants.StatusConstants"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ResourceBundle"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="bd.gov.dgfood.configuration.OTPConfiguration"%>
<%@page import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:resourceURL var="vargetOTPForUser" id="vargetOTPForUser">
	<portlet:param name="action" value="vargetOTPForUser" />
</portlet:resourceURL>


<portlet:resourceURL var="resendOTP" id="vargetOTPForUser">
	<portlet:param name="action" value="resendOTP" />
</portlet:resourceURL>

<portlet:resourceURL var="verifyOtp" id="vargetOTPForUser">
	<portlet:param name="action" value="verifyOtp" />
</portlet:resourceURL>


