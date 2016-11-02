<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<!-- ========================================= PRODUCT FILTER ========================================= -->
<div class="widget">
    <h1>Product Filters</h1>
    <div class="body bordered">

        <form:form
                action="${pageContext.servletContext.contextPath}/shop/lathe"
                method="post"
                modelAttribute="latheFilter">

            <div class="category-latheFilter">


                <!-- brands -->
                <label class="custom-collapse" for="qqq"><h2><spring:message code="brands"/></h2></label>
                <input id="qqq" type="checkbox">

                <div class="category-productFilter">
                    <ul>
                        <c:forEach var="manufacturer" items="${manufacturerList}">
                            <li>
                                <form:checkbox class="le-checkbox" path="latheManufacturers" value="${manufacturer}"/>
                                <label>${brand}</label>
                            </li>
                        </c:forEach>
                    </ul>

                </div>
                <!-- /brands -->

                <%--<!-- types -->--%>
                <%--<label class="custom-collapse" for="types"><h2><spring:message code="types"/></h2></label>--%>
                <%--<input id="types" type="checkbox">--%>

                <%--<div class="category-productFilter">--%>
                    <%--<ul>--%>
                        <%--<c:forEach var="type" items="${typeList}">--%>
                            <%--<li>--%>
                                <%--<form:checkbox class="le-checkbox" path="tireTypes" value="${type}"/>--%>
                                <%--<label>${type}</label>--%>
                            <%--</li>--%>
                        <%--</c:forEach>--%>
                    <%--</ul>--%>

                <%--</div>--%>
                <%--<!-- /types -->--%>

                <%--<!-- widths -->--%>
                <%--<label class="custom-collapse" for="widths"><h2><spring:message code="widths"/></h2></label>--%>
                <%--<input id="widths" type="checkbox">--%>

                <%--<div class="category-productFilter">--%>
                    <%--<ul>--%>
                        <%--<c:forEach var="width" items="${widthList}">--%>
                            <%--<li>--%>
                                <%--<form:checkbox class="le-checkbox" path="tireWidths" value="${width}"/>--%>
                                <%--<label>${width}</label>--%>
                            <%--</li>--%>
                        <%--</c:forEach>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<!-- /widths -->--%>

                <%--<!-- profiles -->--%>
                <%--<label class="custom-collapse" for="profiles"><h2><spring:message code="profiles"/></h2></label>--%>
                <%--<input id="profiles" type="checkbox">--%>

                <%--<div class="category-productFilter">--%>
                    <%--<ul>--%>
                        <%--<c:forEach var="profile" items="${profileList}">--%>
                            <%--<li>--%>
                                <%--<form:checkbox class="le-checkbox" path="tireProfiles" value="${profile}"/>--%>
                                <%--<label>${profile}</label>--%>
                            <%--</li>--%>
                        <%--</c:forEach>--%>
                    <%--</ul>--%>

                <%--</div>--%>
                <%--<!-- /profiles -->--%>

                <%--<!-- diameters -->--%>
                <%--<label class="custom-collapse" for="diameters"><h2><spring:message code="diameters"/></h2></label>--%>
                <%--<input id="diameters" type="checkbox">--%>

                <%--<div class="category-productFilter">--%>
                    <%--<ul>--%>
                        <%--<c:forEach var="diameter" items="${diameterList}">--%>
                            <%--<li>--%>
                                <%--<form:checkbox class="le-checkbox" path="tireDiameters" value="${diameter}"/>--%>
                                <%--<label>${diameter}</label>--%>
                            <%--</li>--%>
                        <%--</c:forEach>--%>
                    <%--</ul>--%>

                <%--</div>--%>
                <%--<!-- /diameters -->--%>

            </div>
            <!-- /.category-latheFilter -->


            <div class="latheFilter">
                <h2><spring:message code="price"/></h2>
                <hr>
                <div class="price-range-holder">

                    <input id="price-id"
                           type="text"
                           class="price-slider"
                           name="price"
                           value="<fmt:formatNumber type="number" pattern="############.##" value="${latheFilter.minPrice}" />,<fmt:formatNumber type="number" pattern="############.##" value="${latheFilter.maxPrice}" />"
                           data-slider-min="<fmt:formatNumber type="number" pattern="############.##" value="${minPrice}" />"
                           data-slider-max="<fmt:formatNumber type="number" pattern="############.##" value="${maxPrice}" />"
                           data-slider-step="1"
                           data-slider-value="[<fmt:formatNumber type="number" pattern="############.##" value="${latheFilter.minPrice}" />,<fmt:formatNumber type="number" pattern="############.##" value="${latheFilter.maxPrice}" />]"/>

                    <span class="price-min-max"></span>

                </div>

            </div>
            <!-- /.price-latheFilter -->

            <span class="productFilter-button">
                <div class="buttons-holder">
                    <span>
                        <input type="submit" class="le-button med" value="Filter"/>
                    </span>
                    <a href="${pageContext.servletContext.contextPath}/shop/lathe/filter-clear">clear</a>
                </div>
            </span>
        </form:form>

    </div><!-- /.body -->
</div>
<!-- /.widget -->
<!-- ========================================= PRODUCT FILTER : END ========================================= -->

