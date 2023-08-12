<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dgfood" uri="http://bd.gov.dgfood/tld/ui" %>
<%@ attribute name="key" required="true" description="label key" %>
<%@ attribute name="parameters" required="false" description="parameters to insert into label" type="java.lang.String"%>
<c:set var="labeltext" value="${labels.get(key)}" />

<c:choose>
    <c:when test="${empty labeltext}">key: ${key}</c:when>
    <c:otherwise>${zain:replaceParameters(labeltext, parameters)}</c:otherwise>
</c:choose>
