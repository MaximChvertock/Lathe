<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<div id="grid-view" class="products-grid fade tab-pane in active">

    <div class="product-grid-holder">
        <div class="row no-margin">

            <c:forEach var="tire" items="${tireListForm.tireList}" varStatus="status">

                <div class="col-xs-12 col-sm-4 no-margin product-item-holder hover">


                    <div class="product-item">

                            <%--<div class="ribbon red"><span>sale</span></div>--%>

                        <div class="image">
                            <img alt=""
                                 src="${appProperties['content.images.url']}/${tire.image.fileName}"
                                 data-echo="${appProperties['content.images.url']}/${tire.image.fileName}"
                                 width="128" height="128"/>
                        </div>

                        <div class="body">

                                <%--<div class="label-discount green">-50% sale</div>--%>

                            <div class="title">
                                <a href="${pageContext.servletContext.contextPath}/shop/tires/single?tire-id=${tire.id}">${tire.name}</a>
                            </div>
                            <div class="brand">${tire.brand}</div>
                        </div>

                        <%--<div class="prices">--%>
                                    <%--&lt;%&ndash;<div class="price-prev">$1399.00</div>&ndash;%&gt;--%>
                                    <%--<div class="price-current pull-right">${tire.price}</div>--%>
                                    <%--</div>--%>

                        <div class="hover-area">
                            <div class="add-cart-button">
                                <a href="${pageContext.servletContext.contextPath}/shop/tires/add-to-cart?tire-id=${tire.id}&redirect=shop/tires"
                                   class="le-button"><spring:message code="cart.button.add"/></a>
                            </div>
                            <div class="wish-compare">
                                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                                <a class="btn-add-to-compare"
                                   href="${pageContext.servletContext.contextPath}/shop/tires/add-to-compare?tire-id=${tire.id}&redirect=shop/tires"><spring:message
                                        code="compare.list.button"/></a>
                            </div>
                        </div>

                    </div><!-- /.product-item -->


                </div>
                <!-- /.product-item-holder -->

            </c:forEach>
        </div><!-- /.row -->
    </div><!-- /.product-grid-holder -->

    <%@ include file="../Pagination.jsp" %>

</div>
<!-- /.products-grid #grid-view -->
