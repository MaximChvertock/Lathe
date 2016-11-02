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


    <div class="wrapper">

        <div id="single-product">
            <div class="container">

                <div class="no-margin col-xs-12 col-sm-6 col-md-5 gallery-holder">
                    <div class="product-item-holder size-big single-product-gallery small-gallery">

                        <div id="owl-single-product">
                            <div class="single-product-gallery-item" id="slide1">
                                <a data-rel="prettyphoto"
                                   href="${appProperties['content.images.url']}/${tire.image.fileName}">
                                    <img class="img-responsive" alt=""
                                         width="128" height="128"
                                         src="${appProperties['content.images.url']}/${tire.image.fileName}"
                                         data-echo="${appProperties['content.images.url']}/${tire.image.fileName}"/>
                                </a>
                            </div><!-- /.single-product-gallery-item -->

                            <%--<div class="single-product-gallery-item" id="slide2">--%>
                            <%--<a data-rel="prettyphoto"--%>
                            <%--href="${appProperties['content.images.url']}/${tire.image.fileName}">--%>
                            <%--<img class="img-responsive" alt=""--%>
                            <%--src="${appProperties['content.images.url']}/${tire.image.fileName}"--%>
                            <%--data-echo="${appProperties['content.images.url']}/${tire.image.fileName}"/>--%>
                            <%--</a>--%>
                            <%--</div><!-- /.single-product-gallery-item -->--%>

                            <%--<div class="single-product-gallery-item" id="slide3">--%>
                            <%--<a data-rel="prettyphoto"--%>
                            <%--href="${appProperties['content.images.url']}/${tire.image.fileName}">--%>
                            <%--<img class="img-responsive" alt=""--%>
                            <%--src="${appProperties['content.images.url']}/${tire.image.fileName}"--%>
                            <%--data-echo="${appProperties['content.images.url']}/${tire.image.fileName}"/>--%>
                            <%--</a>--%>
                            <%--</div><!-- /.single-product-gallery-item -->--%>

                        </div><!-- /.single-product-slider -->


                        <%--<div class="single-product-gallery-thumbs gallery-thumbs">--%>

                        <%--<div id="owl-single-product-thumbnails">--%>

                        <%--<a class="horizontal-thumb active" data-target="#owl-single-product" data-slide="0"--%>
                        <%--href="#slide1">--%>
                        <%--<img width="67" alt=""--%>
                        <%--src="${appProperties['content.images.url']}/${tire.image.fileName}"--%>
                        <%--data-echo="${appProperties['content.images.url']}/${tire.image.fileName}"/>--%>
                        <%--</a>--%>

                        <%--<a class="horizontal-thumb" data-target="#owl-single-product" data-slide="1"--%>
                        <%--href="#slide2">--%>
                        <%--<img width="67" alt=""--%>
                        <%--src="${appProperties['content.images.url']}/${tire.image.fileName}"--%>
                        <%--data-echo="${appProperties['content.images.url']}/${tire.image.fileName}"/>--%>
                        <%--</a>--%>

                        <%--<a class="horizontal-thumb" data-target="#owl-single-product" data-slide="2"--%>
                        <%--href="#slide3">--%>
                        <%--<img width="67" alt=""--%>
                        <%--src="${appProperties['content.images.url']}/${tire.image.fileName}"--%>
                        <%--data-echo="${appProperties['content.images.url']}/${tire.image.fileName}"/>--%>
                        <%--</a>--%>
                        <%----%>
                        <%--</div><!-- /#owl-single-product-thumbnails -->--%>

                        <%--<div class="nav-holder left hidden-xs">--%>
                        <%--<a class="prev-btn slider-prev" data-target="#owl-single-product-thumbnails"--%>
                        <%--href="#prev"></a>--%>
                        <%--</div><!-- /.nav-holder -->--%>

                        <%--<div class="nav-holder right hidden-xs">--%>
                        <%--<a class="next-btn slider-next" data-target="#owl-single-product-thumbnails"--%>
                        <%--href="#next"></a>--%>
                        <%--</div><!-- /.nav-holder -->--%>

                        <%--</div><!-- /.gallery-thumbs -->--%>

                    </div><!-- /.single-product-gallery -->

                </div><!-- /.gallery-holder -->


                <div class="no-margin col-xs-12 col-sm-7 body-holder">

                    <div class="body">

                        <%--<div class="star-holder inline">--%>
                        <%--<div class="star" data-score="4"></div>--%>
                        <%--</div>--%>

                        <div class="availability">
                            <span class="available">
                                <spring:message code="in_stock"/>
                            </span>
                        </div>

                        <div class="title">
                            <a href="#">${tire.name}</a>
                        </div>
                        <div class="brand">${tire.brand}</div>

                        <%--<div class="social-row">--%>
                        <%--<span class="st_facebook_hcount"></span>--%>
                        <%--<span class="st_twitter_hcount"></span>--%>
                        <%--<span class="st_pinterest_hcount"></span>--%>
                        <%--</div>--%>

                        <div class="buttons-holder">
                            <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                            <a class="btn-add-to-compare"
                               href="${pageContext.servletContext.contextPath}/shop/tires/add-to-compare?tire-id=${tire.id}"><spring:message
                                    code="compare.list.add"/></a>
                        </div>

                        <div class="excerpt">
                            <p>${tire.description}</p>
                        </div>

                        <div class="prices">
                            <div class="price-current">${tire.price}</div>
                            <%--<div class="price-prev">$2199.00</div>--%>
                        </div>

                        <div class="qnt-holder">
                            <div class="le-quantity">
                                <form>
                                    <a class="minus" href="#reduce"></a>
                                    <input name="quantity" readonly="readonly" type="text" value="1"/>
                                    <a class="plus" href="#add"></a>
                                </form>
                            </div>
                            <a id="addto-cart"
                               href="${pageContext.servletContext.contextPath}/shop/tires/add-to-cart?tire-id=${tire.id}&redirect=shop/tires/single"
                               class="le-button huge"><spring:message
                                    code="cart.button.add"/></a>
                        </div><!-- /.qnt-holder -->
                    </div><!-- /.body -->

                </div><!-- /.body-holder -->
            </div><!-- /.container -->
        </div><!-- /.single-product -->


        <!-- ========================================= SINGLE PRODUCT TAB ========================================= -->
        <section id="single-product-tab">
            <div class="container">
                <div class="tab-holder">

                    <ul class="nav nav-tabs simple">
                        <li class="active">
                            <a href="#description" data-toggle="tab"><spring:message code="description"/></a>
                        </li>
                        <li>
                            <a href="#additional-info" data-toggle="tab"><spring:message code="additional_info"/></a>
                        </li>
                    </ul><!-- /.nav-tabs -->

                    <div class="tab-content">
                        <div class="tab-pane active" id="description">
                            <p>${tire.description}</p>
                        </div><!-- /.tab-pane #description -->

                        <div class="tab-pane" id="additional-info">
                            <ul class="tabled-data">
                                <li>
                                    <label><spring:message code="brand"/></label>
                                    <div class="value">${tire.brand}</div>
                                </li>
                                <li>
                                    <label><spring:message code="type"/></label>
                                    <div class="value">${tire.type}</div>
                                </li>
                                <li>
                                    <label><spring:message code="width"/></label>
                                    <div class="value">${tire.width}</div>
                                </li>
                                <li>
                                    <label><spring:message code="profile"/></label>
                                    <div class="value">${tire.profile}</div>
                                </li>
                                <li>
                                    <label><spring:message code="diameter"/></label>
                                    <div class="value">${tire.diameter}</div>
                                </li>
                            </ul><!-- /.tabled-data -->
                        </div><!-- /.tab-pane #additional-info -->

                    </div><!-- /.tab-content -->

                </div><!-- /.tab-holder -->
            </div><!-- /.container -->
        </section><!-- /#single-product-tab -->
        <!-- ========================================= SINGLE PRODUCT TAB : END ========================================= -->


        <%@ include file="../Footer.jsp" %>

    </div><!-- /.wrapper -->

    <%@ include file="../JavaScriptPostLoad.jsp" %>

</body>
</html>
