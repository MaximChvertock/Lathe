<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<!-- filter -->
<div class="filter">
    <form:form
            class="formBox"
            action="${pageContext.servletContext.contextPath}/admin/tires"
            method="post"
            modelAttribute="filter">

        <!-- cols -->
        <div class="cols cols3">

            <!-- col1 -->
            <div class="col1">

                <!-- price -->
                <div class="lab">
                    <label><spring:message code="price"/></label>
                </div>
                <div class="clearfix">
                    <div class="lab">
                        <label><spring:message code="min"/></label>
                    </div>
                    <div class="con">
                        <input type="number" class="input"
                               value="${filter.minPrice}"
                               name="minPrice"
                               id="filter-price-min-id"
                               min="${defProperties['tire.price.min.default']}"
                               max="${defProperties['tire.price.max.default']}"
                               step="${defProperties['tire.price.step.default']}"/>
                    </div>
                </div>
                <div class="clearfix">
                    <div class="lab">
                        <label><spring:message code="max"/></label>
                    </div>
                    <div class="con">
                        <input type="number" class="input"
                               value="${filter.maxPrice}"
                               name="maxPrice"
                               id="filter-price-max-id"
                               min="${defProperties['tire.price.min.default']}"
                               max="${defProperties['tire.price.max.default']}"
                               step="${defProperties['tire.price.step.default']}"/>
                    </div>
                </div>
                <!-- /price -->

            </div>
            <!-- /col1 -->

            <!-- col2 -->
            <div class="col2">
            </div>
            <!-- /col2 -->

            <!-- col3 -->
            <div class="col3">

                <!-- mainmenu -->
                <div class="mainmenu">

                    <!-- brands -->
                    <li><a href="#"><spring:message code="brands"/></a>
                        <ul class="submenu">
                            <c:forEach var="brand" items="${brandList}">
                            <span class="clearfix checkbox">
                                <span class="con">
                                    <label>
                                        <form:checkbox path="tireBrands" value="${brand}"/>${brand}
                                    </label>
                                </span>
                            </span>
                            </c:forEach>
                        </ul>
                    </li>
                    <!-- /brands -->

                    <!-- types -->
                    <li><a href="#"><spring:message code="types"/></a>
                        <ul class="submenu">
                            <c:forEach var="type" items="${typeList}">
                            <span class="clearfix checkbox">
                                <span class="con">
                                    <label>
                                        <form:checkbox path="tireTypes" value="${type}"/>${type}
                                    </label>
                                </span>
                            </span>
                            </c:forEach>
                        </ul>
                    </li>
                    <!-- /types -->

                    <!-- widths -->
                    <li><a href="#"><spring:message code="widths"/></a>
                        <ul class="submenu">
                            <c:forEach var="width" items="${widthList}">
                            <span class="clearfix checkbox">
                                <span class="con">
                                    <label>
                                        <form:checkbox path="tireWidths" value="${width}"/>${width}
                                    </label>
                                </span>
                            </span>
                            </c:forEach>
                        </ul>
                    </li>
                    <!-- /widths -->

                    <!-- profiles -->
                    <li><a href="#"><spring:message code="profiles"/></a>
                        <ul class="submenu">
                            <c:forEach var="profile" items="${profileList}">
                            <span class="clearfix checkbox">
                                <span class="con">
                                    <label>
                                        <form:checkbox path="tireProfiles" value="${profile}"/>${profile}
                                    </label>
                                </span>
                            </span>
                            </c:forEach>
                        </ul>
                    </li>
                    <!-- /profiles -->

                    <!-- diameters -->
                    <li><a href="#"><spring:message code="diameters"/></a>
                        <ul class="submenu">
                            <c:forEach var="diameter" items="${diameterList}">
                            <span class="clearfix checkbox">
                                <span class="con">
                                    <label>
                                        <form:checkbox path="tireDiameters" value="${diameter}"/>${diameter}
                                    </label>
                                </span>
                            </span>
                            </c:forEach>
                        </ul>
                    </li>
                    <!-- /diameter -->

                </div>
                <!-- /mainmenu -->

            </div>
            <!-- /col3 -->

        </div>
        <!-- /cols -->

        <a href="${pageContext.servletContext.contextPath}/admin/tires/filter-clear"><spring:message
                code="filter.clear"/></a>

        <div class="btn-submit"><!-- Submit form -->
            <input type="submit" value="Show" class="button"/>
        </div>
    </form:form>
</div>
<!-- /filter -->

