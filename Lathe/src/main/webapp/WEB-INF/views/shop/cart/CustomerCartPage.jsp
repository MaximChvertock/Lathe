<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../HeadTag.jsp" %>
<body>

<div class="wrapper">

    <%@ include file="../TopNavigation.jsp" %>

    <%@ include file="../Header.jsp" %>


    <section id="category-grid">

        <div class="container">

            <!-- ========================================= CONTENT ========================================= -->
            <div class="col-xs-12 col-md-9 items-holder no-margin">

                <c:forEach var="tireItem" items="${customerCart.tires}">
                    <div class="row no-margin cart-item">

                        <div class="col-xs-12 col-sm-2 no-margin">
                            <a href="#" class="thumb-holder">
                                <img class="lazy" alt="${tireItem.tire.name}"
                                     src="${appProperties['content.images.url']}/${tireItem.tire.image.fileName}"
                                     width="73" height="73"/>
                            </a>
                        </div>

                        <div class="col-xs-12 col-sm-5 ">
                            <div class="title">
                                <a href="#">${tireItem.tire.name}</a>
                            </div>
                            <div class="brand">${tireItem.tire.brand}</div>
                        </div>

                        <div class="col-xs-12 col-sm-3 no-margin">
                            <div class="quantity">
                                <div class="le-quantity">
                                        <%--<form>--%>
                                        <%--<a class="minus" href="#reduce"></a>--%>
                                        <%--<input name="quantity" readonly="readonly" type="text"--%>
                                        <%--value="${tireItem.quantity}"/>--%>
                                        <%--<a class="plus" href="#add"></a>--%>
                                        <%--</form>--%>
                                    <form>
                                            <%--<a name="reduce${tireItem.tire.id}"></a>--%>
                                        <a class="minus"
                                           href="#reduce"
                                           onclick="window.location.assign('${pageContext.servletContext.contextPath}/shop/tires/remove-from-cart?tire-id=${tireItem.tire.id}&redirect=shop/cart');"
                                        ></a>
                                        <input name="quantity" readonly="readonly" type="text"
                                               value="${tireItem.quantity}"/>
                                            <%--<a name="add"></a>--%>
                                        <a class="plus"
                                           href="#add"
                                           onclick="window.location.assign('${pageContext.servletContext.contextPath}/shop/tires/add-to-cart?tire-id=${tireItem.tire.id}&redirect=shop/cart');"></a>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="col-xs-12 col-sm-2 no-margin">
                            <div class="price">
                                    ${tireItem.tire.price}
                            </div>
                            <a class="close-btn"
                               href="${pageContext.servletContext.contextPath}/shop/tires/remove-from-cart?tire-id=${tireItem.tire.id}&redirect=shop/cart"></a>
                        </div>

                    </div>
                    <!-- /.cart-item -->
                </c:forEach>
            </div>
            <!-- ========================================= CONTENT : END ========================================= -->

            <!-- ========================================= SIDEBAR ========================================= -->

            <div class="col-xs-12 col-md-3 no-margin sidebar ">
                <div class="widget cart-summary">
                    <h1 class="border"><spring:message code="page.cart.sidebar.title"/></h1>
                    <div class="body">
                        <%--<ul class="tabled-data no-border inverse-bold">--%>
                        <%--<li>--%>
                        <%--<label><spring:message code="page.cart.sidebar.subtotal"/></label>--%>
                        <%--<div class="value pull-right">${customerCart.totalPrice}</div>--%>
                        <%--</li>--%>
                        <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<label>shipping</label>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="value pull-right">free shipping</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                        <%--</ul>--%>
                        <ul id="total-price" class="tabled-data inverse-bold no-border">
                            <li>
                                <label><spring:message code="page.cart.sidebar.order_total"/></label>
                                <div class="value pull-right">${customerCart.totalPrice}</div>
                            </li>
                        </ul>
                        <div class="buttons-holder">
                            <a class="le-button big"
                               href="${pageContext.servletContext.contextPath}/shop/tires/checkout"><spring:message
                                    code="checkout"/></a>
                            <a class="simple-link block"
                               href="${pageContext.servletContext.contextPath}/shop"><spring:message
                                    code="continue_shopping"/></a>
                        </div>
                    </div>
                </div><!-- /.widget -->

                <%--<div id="cupon-widget" class="widget">--%>
                <%--<h1 class="border">use coupon</h1>--%>
                <%--<div class="body">--%>
                <%--<form>--%>
                <%--<div class="inline-input">--%>
                <%--<input data-placeholder="enter coupon code" type="text"/>--%>
                <%--<button class="le-button" type="submit">Apply</button>--%>
                <%--</div>--%>
                <%--</form>--%>
                <%--</div>--%>
                <%--</div><!-- /.widget -->--%>
            </div><!-- /.sidebar -->

            <!-- ========================================= SIDEBAR : END ========================================= -->


        </div><!-- /.container -->

    </section><!-- /#category-grid -->

    <%@ include file="../Footer.jsp" %>

</div><!-- /.wrapper -->

<%@ include file="../JavaScriptPostLoad.jsp" %>

</body>
</html>
