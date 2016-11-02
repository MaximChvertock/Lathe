<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<!-- breadcrumbs -->
<div class="breadcrumbs">
    <ul>
        <li class="home">
            <a href="${pageContext.servletContext.contextPath}/shop"><spring:message code="home"/></a>
        </li>
        <li>
            <a href="${pageContext.servletContext.contextPath}/admin/tires"><spring:message code="tires"/></a>
        </li>
        <li>
            <a href="${pageContext.servletContext.contextPath}/admin/tires/orders"><spring:message code="orders"/></a>
        </li>
    </ul>
</div>
<!-- /breadcrumbs -->
