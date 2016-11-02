<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<div class="col-xs-12 col-md-3 top-cart-row no-margin">
    <div class="top-cart-row-container">


        <div class="wishlist-compare-holder">
            <%--<div class="wishlist ">--%>
            <%--<a href="#"><i class="fa fa-heart"></i> wishlist <span class="value">(21)</span> </a>--%>
            <%--</div>--%>
            <div class="compare">
                <a href="${pageContext.servletContext.contextPath}/shop/tires/compare"><i
                        class="fa fa-exchange"></i><spring:message code="compare.list.title"/><span
                        class="value">(${compareList.tires.size()})</span> </a>
            </div>
        </div>

        <!-- ============================================================= SHOPPING CART DROPDOWN ============================================================= -->
        <div class="top-cart-holder dropdown animate-dropdown">

            <div class="basket">

                <a class="dropdown-toggle" data-toggle="dropdown" href="#">

                    <div class="basket-item-count">
                        <span class="count">${customerCart.productsAmount}</span>
                        <img src="<c:url value="/resources/shop/assets/images/icon-cart.png"/>" alt=""/>
                    </div>

                    <div class="total-price-basket">
                        <span class="lbl"><spring:message code="cart.title"/></span>
                                    <span class="total-price">
                                        <span class="sign"><spring:message code="cart.curency.sign"/></span>
                                        <span class="value">${customerCart.totalPrice}</span>
                                    </span>
                    </div>
                </a>


                <ul class="dropdown-menu">
                    <c:forEach var="tireItem" items="${customerCart.tires}">
                        <li>
                            <div class="basket-item">
                                <div class="row">
                                    <div class="col-xs-4 col-sm-4 no-margin text-center">
                                        <div class="thumb">
                                            <img alt=""
                                                 src="${appProperties['content.images.url']}/${tireItem.tire.image.fileName}"
                                                 data-echo="${appProperties['content.images.url']}/${tireItem.tire.image.fileName}"
                                                 width="73" height="73"/>
                                        </div>
                                    </div>
                                    <div class="col-xs-8 col-sm-8 no-margin">
                                        <div class="title">${tireItem.tire.name}x${tireItem.quantity}</div>
                                        <div class="price">${tireItem.tire.price}</div>
                                    </div>
                                </div>

                                <a class="close-btn"
                                   href="${pageContext.servletContext.contextPath}/shop/tires/remove-from-cart?tire-id=${tireItem.tire.id}"></a>
                            </div>
                        </li>
                    </c:forEach>

                    <li class="checkout">
                        <div class="basket-item">
                            <div class="row">
                                <div class="col-xs-12 col-sm-6">
                                    <a href="${pageContext.servletContext.contextPath}/shop/cart"
                                       class="le-button inverse"><spring:message
                                            code="cart.button.view"/></a>
                                </div>
                                <div class="col-xs-12 col-sm-6">
                                    <a href="${pageContext.servletContext.contextPath}/shop/tires/checkout"
                                       class="le-button"><spring:message
                                            code="cart.button.checkout"/></a>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>


            </div><!-- /.basket -->
        </div><!-- /.top-cart-holder -->
    </div><!-- /.top-cart-row-container -->
    <!-- ============================================================= SHOPPING CART DROPDOWN : END ============================================================= -->

</div>
<!-- /.top-cart-row -->