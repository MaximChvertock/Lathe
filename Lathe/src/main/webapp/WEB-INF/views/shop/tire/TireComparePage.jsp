<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<!DOCTYPE html>
<html lang="en">
<%@ include file="../HeadTag.jsp" %>
<body>

<div class="wrapper">

    <%@ include file="../TopNavigation.jsp" %>

    <%@ include file="../Header.jsp" %>

    <div class="main-content" id="main-content">

        <div class="container">
            <div class="inner-xs">
                <div class="page-header">
                    <h2 class="page-title">
                        <spring:message code="page.tire.compare.title"/>
                    </h2>
                </div>
            </div><!-- /.section-page-title -->

            <div class="table-responsive inner-bottom-xs inner-top-xs">

                <table class="table table-bordered table-striped compare-list">

                    <thead>

                    <tr>
                        <td>&nbsp;</td>
                        <c:forEach var="tire" items="${compareList.tires}">
                            <td class="text-center">
                                <div class="image-wrap">
                                    <a data-product_id="39"
                                       href="${pageContext.servletContext.contextPath}/shop/tires/remove-from-compare?tire-id=${tire.id}&redirect=shop/tires/compare"
                                       class="remove-link"><i class="fa fa-times-circle"></i></a>
                                    <img width="220" height="154" alt="${tire.name}"
                                         class="attachment-yith-woocompare-image"
                                         src="${appProperties['content.images.url']}/${tire.image.fileName}">
                                </div>
                                <p><strong>${tire.name}</strong></p>
                            </td>
                        </c:forEach>
                    </tr>


                    <tr class="tr-add-to-cart">
                        <td>&nbsp;</td>
                        <c:forEach var="tire" items="${compareList.tires}">
                            <td class="text-center">
                                <div class="add-cart-button">
                                    <a class="le-button add_to_cart_button  product_type_simple"
                                       href="${pageContext.servletContext.contextPath}/shop/tires/add-to-cart?tire-id=${tire.id}&redirect=shop/tires/compare"><spring:message
                                            code="cart.button.add"/></a>
                                </div>
                            </td>
                        </c:forEach>
                    </tr>

                    </thead>

                    <tbody>

                    <tr class="comparison-item price">
                        <th><spring:message code="price"/></th>
                        <c:forEach var="tire" items="${compareList.tires}">
                            <td class="comparison-item-cell odd product_39">
                                <span class="amount">${tire.price}</span>
                            </td>
                        </c:forEach>
                    </tr>

                    <tr class="comparison-item description">
                        <th><spring:message code="description"/></th>
                        <c:forEach var="tire" items="${compareList.tires}">
                            <td class="comparison-item-cell odd product_39">
                                <p>${tire.description}</p>
                            </td>
                        </c:forEach>
                    </tr>

                    <tr class="comparison-item stock">
                        <th><spring:message code="in_stock"/></th>
                        <c:forEach var="tire" items="${compareList.tires}">
                            <td class="comparison-item-cell odd product_39">
                                <span class="label label-success"><span class="">${tire.inStock}</span></span>
                            </td>
                        </c:forEach>
                    </tr>

                    <tr class="price repeated">
                        <th><spring:message code="price"/></th>
                        <c:forEach var="tire" items="${compareList.tires}">
                            <td class="odd product_39"><span class="amount">${tire.price}</span></td>
                        </c:forEach>
                    </tr>

                    </tbody>
                </table>
            </div><!-- /.table-responsive -->
        </div><!-- /.container -->

    </div>

    <%@ include file="../Footer.jsp" %>

    <%@ include file="../JavaScriptPostLoad.jsp" %>

</body>
</html>
