<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<div id="grid-view" class="products-grid fade tab-pane in active">

    <div class="product-grid-holder">
        <div class="row no-margin">

            <c:forEach var="lathe" items="${latheListForm.latheList}" varStatus="status">

                <div class="col-xs-12 col-sm-4 no-margin product-item-holder hover">


                    <div class="product-item">

                            <%--<div class="ribbon red"><span>sale</span></div>--%>

                        <div class="image">
                            <%--<img alt=""--%>
                                 <%--src="${appProperties['content.images.url']}/${lathe.image.fileName}"--%>
                                 <%--data-echo="${appProperties['content.images.url']}/${lathe.image.fileName}"--%>
                                 <%--width="128" height="128"/>--%>

                                <%--TEMPORARY--%>
                                <img alt=""
                                     src="${appProperties['content.images.url']}/MillTap_700_1.jpg"
                                     data-echo="${appProperties['content.images.url']}/MillTap_700_1.jpg"
                                     width="128" height="128"/>
                        </div>

                        <div class="body">

                                <%--<div class="label-discount green">-50% sale</div>--%>

                            <div class="title">
                                <a href="${pageContext.servletContext.contextPath}/shop/lathe/single?lathe-id=${lathe.id}">${lathe.model}</a>
                            </div>
                            <div class="brand">${lathe.manufacturer}</div>
                        </div>

                        <%--<div class="prices">--%>
                                    <%--&lt;%&ndash;<div class="price-prev">$1399.00</div>&ndash;%&gt;--%>
                                    <%--<div class="price-current pull-right">${lathe.price}</div>--%>
                                    <%--</div>--%>

                        <div class="hover-area">
                            <div class="add-cart-button">
                                <a href="${pageContext.servletContext.contextPath}/shop/lathe/add-to-cart?lathe-id=${lathe.id}&redirect=shop/lathe"
                                   class="le-button"><spring:message code="cart.button.add"/></a>
                            </div>
                            <div class="wish-compare">
                                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                                <a class="btn-add-to-compare"
                                   href="${pageContext.servletContext.contextPath}/shop/lathe/add-to-compare?lathe-id=${lathe.id}&redirect=shop/lathe"><spring:message
                                        code="compare.list.button"/></a>
                            </div>
                        </div>

                    </div><!-- /.product-item -->


                </div>
                <!-- /.product-item-holder -->

            </c:forEach>
        </div><!-- /.row -->
    </div><!-- /.product-grid-holder -->

    <%@ include file="LathePagination.jsp" %>

</div>
<!-- /.products-grid #grid-view -->
