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

            <!-- ========================================= SIDEBAR ========================================= -->
            <div class="col-xs-12 col-sm-3 no-margin sidebar narrow">

                <%@ include file="TireFilter.jsp" %>
                <%--<div class="widget">--%>
                <%--<div class="simple-banner">--%>
                <%--<a href="#"><img alt="" class="img-responsive" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/banner/banner-simple.jpg"/></a>--%>
                <%--</div>--%>
                <%--</div>--%>


                <!-- ========================================= FEATURED PRODUCTS ========================================= -->
                <%--<div class="widget">--%>
                <%--<h1 class="border">Featured Products</h1>--%>
                <%--<ul class="product-list">--%>

                <%--<li class="sidebar-product-list-item">--%>
                <%--<div class="row">--%>
                <%--<div class="col-xs-4 col-sm-4 no-margin">--%>
                <%--<a href="#" class="thumb-holder">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-small-01.jpg"/>--%>
                <%--</a>--%>
                <%--</div>--%>
                <%--<div class="col-xs-8 col-sm-8 no-margin">--%>
                <%--<a href="#">Netbook Acer </a>--%>
                <%--<div class="price">--%>
                <%--<div class="price-prev">$2000</div>--%>
                <%--<div class="price-current">$1873</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</li><!-- /.sidebar-product-list-item -->--%>

                <%--<li class="sidebar-product-list-item">--%>
                <%--<div class="row">--%>
                <%--<div class="col-xs-4 col-sm-4 no-margin">--%>
                <%--<a href="#" class="thumb-holder">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-small-02.jpg"/>--%>
                <%--</a>--%>
                <%--</div>--%>
                <%--<div class="col-xs-8 col-sm-8 no-margin">--%>
                <%--<a href="#">PowerShot Elph 115 16MP Digital Camera</a>--%>
                <%--<div class="price">--%>
                <%--<div class="price-prev">$2000</div>--%>
                <%--<div class="price-current">$1873</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</li><!-- /.sidebar-product-list-item -->--%>

                <%--<li class="sidebar-product-list-item">--%>
                <%--<div class="row">--%>
                <%--<div class="col-xs-4 col-sm-4 no-margin">--%>
                <%--<a href="#" class="thumb-holder">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-small-03.jpg"/>--%>
                <%--</a>--%>
                <%--</div>--%>
                <%--<div class="col-xs-8 col-sm-8 no-margin">--%>
                <%--<a href="#">PowerShot Elph 115 16MP Digital Camera</a>--%>
                <%--<div class="price">--%>
                <%--<div class="price-prev">$2000</div>--%>
                <%--<div class="price-current">$1873</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</li><!-- /.sidebar-product-list-item -->--%>

                <%--<li class="sidebar-product-list-item">--%>
                <%--<div class="row">--%>
                <%--<div class="col-xs-4 col-sm-4 no-margin">--%>
                <%--<a href="#" class="thumb-holder">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-small-01.jpg"/>--%>
                <%--</a>--%>
                <%--</div>--%>
                <%--<div class="col-xs-8 col-sm-8 no-margin">--%>
                <%--<a href="#">Netbook Acer </a>--%>
                <%--<div class="price">--%>
                <%--<div class="price-prev">$2000</div>--%>
                <%--<div class="price-current">$1873</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</li><!-- /.sidebar-product-list-item -->--%>

                <%--<li class="sidebar-product-list-item">--%>
                <%--<div class="row">--%>
                <%--<div class="col-xs-4 col-sm-4 no-margin">--%>
                <%--<a href="#" class="thumb-holder">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-small-02.jpg"/>--%>
                <%--</a>--%>
                <%--</div>--%>
                <%--<div class="col-xs-8 col-sm-8 no-margin">--%>
                <%--<a href="#">PowerShot Elph 115 16MP Digital Camera</a>--%>
                <%--<div class="price">--%>
                <%--<div class="price-prev">$2000</div>--%>
                <%--<div class="price-current">$1873</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</li><!-- /.sidebar-product-list-item -->--%>

                <%--</ul><!-- /.product-list -->--%>
                <%--</div><!-- /.widget -->--%>
                <!-- ========================================= FEATURED PRODUCTS : END ========================================= -->

            </div>
            <!-- ========================================= SIDEBAR : END ========================================= -->


            <!-- ========================================= CONTENT ========================================= -->
            <div class="col-xs-12 col-sm-9 no-margin wide sidebar">

                <!-- recommended-products -->
                <%--<section id="recommended-products" class="carousel-holder hover small">--%>

                <%--<div class="title-nav">--%>
                <%--<h2 class="inverse">Recommended Products</h2>--%>
                <%--<div class="nav-holder">--%>
                <%--<a href="#prev" data-target="#owl-recommended-products"--%>
                <%--class="slider-prev btn-prev fa fa-angle-left"></a>--%>
                <%--<a href="#next" data-target="#owl-recommended-products"--%>
                <%--class="slider-next btn-next fa fa-angle-right"></a>--%>
                <%--</div>--%>
                <%--</div><!-- /.title-nav -->--%>

                <%--<div id="owl-recommended-products" class="owl-carousel product-grid-holder">--%>
                <%--<div class="no-margin carousel-item product-item-holder hover size-medium">--%>
                <%--<div class="product-item">--%>
                <%--<div class="ribbon red"><span>sale</span></div>--%>
                <%--<div class="image">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-11.jpg"/>--%>
                <%--</div>--%>
                <%--<div class="body">--%>
                <%--<div class="title">--%>
                <%--<a href="single-product.html">LC-70UD1U 70" class aquos 4K ultra HD</a>--%>
                <%--</div>--%>
                <%--<div class="brand">sharp</div>--%>
                <%--</div>--%>
                <%--<div class="prices">--%>
                <%--<div class="price-current text-right">$1199.00</div>--%>
                <%--</div>--%>
                <%--<div class="hover-area">--%>
                <%--<div class="add-cart-button">--%>
                <%--<a href="single-product.html" class="le-button">add to cart</a>--%>
                <%--</div>--%>
                <%--<div class="wish-compare">--%>
                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                <%--<a class="btn-add-to-compare" href="#">compare</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div><!-- /.carousel-item -->--%>

                <%--<div class="no-margin carousel-item product-item-holder hover size-medium">--%>
                <%--<div class="product-item">--%>
                <%--<div class="ribbon blue"><span>new!</span></div>--%>
                <%--<div class="image">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-12.jpg"/>--%>
                <%--</div>--%>
                <%--<div class="body">--%>
                <%--<div class="title">--%>
                <%--<a href="single-product.html">cinemizer OLED 3D virtual reality TV Video</a>--%>
                <%--</div>--%>
                <%--<div class="brand">zeiss</div>--%>
                <%--</div>--%>
                <%--<div class="prices">--%>

                <%--<div class="price-current text-right">$1199.00</div>--%>
                <%--</div>--%>
                <%--<div class="hover-area">--%>
                <%--<div class="add-cart-button">--%>
                <%--<a href="single-product.html" class="le-button">add to cart</a>--%>
                <%--</div>--%>
                <%--<div class="wish-compare">--%>
                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                <%--<a class="btn-add-to-compare" href="#">compare</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div><!-- /.carousel-item -->--%>

                <%--<div class="no-margin carousel-item product-item-holder hover size-medium">--%>
                <%--<div class="product-item">--%>
                <%--<div class="image">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-13.jpg"/>--%>
                <%--</div>--%>
                <%--<div class="body">--%>
                <%--<div class="title">--%>
                <%--<a href="single-product.html">s2340T23" full HD multi-Touch Monitor</a>--%>
                <%--</div>--%>
                <%--<div class="brand">dell</div>--%>
                <%--</div>--%>
                <%--<div class="prices">--%>
                <%--<div class="price-current text-right">$1199.00</div>--%>
                <%--</div>--%>
                <%--<div class="hover-area">--%>
                <%--<div class="add-cart-button">--%>
                <%--<a href="single-product.html" class="le-button">add to cart</a>--%>
                <%--</div>--%>
                <%--<div class="wish-compare">--%>
                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                <%--<a class="btn-add-to-compare" href="#">compare</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div><!-- /.carousel-item -->--%>

                <%--<div class="no-margin carousel-item product-item-holder hover size-medium">--%>
                <%--<div class="product-item">--%>
                <%--<div class="ribbon blue"><span>new!</span></div>--%>
                <%--<div class="image">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-14.jpg"/>--%>
                <%--</div>--%>
                <%--<div class="body">--%>
                <%--<div class="title">--%>
                <%--<a href="single-product.html">kardon BDS 7772/120 integrated 3D</a>--%>
                <%--</div>--%>
                <%--<div class="brand">harman</div>--%>
                <%--</div>--%>
                <%--<div class="prices">--%>
                <%--<div class="price-current text-right">$1199.00</div>--%>
                <%--</div>--%>
                <%--<div class="hover-area">--%>
                <%--<div class="add-cart-button">--%>
                <%--<a href="single-product.html" class="le-button">add to cart</a>--%>
                <%--</div>--%>
                <%--<div class="wish-compare">--%>
                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                <%--<a class="btn-add-to-compare" href="#">compare</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div><!-- /.carousel-item -->--%>

                <%--<div class="no-margin carousel-item product-item-holder hover size-medium">--%>
                <%--<div class="product-item">--%>
                <%--<div class="ribbon green"><span>bestseller</span></div>--%>
                <%--<div class="image">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-15.jpg"/>--%>
                <%--</div>--%>
                <%--<div class="body">--%>
                <%--<div class="title">--%>
                <%--<a href="single-product.html">netbook acer travel B113-E-10072</a>--%>
                <%--</div>--%>
                <%--<div class="brand">acer</div>--%>
                <%--</div>--%>
                <%--<div class="prices">--%>
                <%--<div class="price-current text-right">$1199.00</div>--%>
                <%--</div>--%>
                <%--<div class="hover-area">--%>
                <%--<div class="add-cart-button">--%>
                <%--<a href="single-product.html" class="le-button">add to cart</a>--%>
                <%--</div>--%>
                <%--<div class="wish-compare">--%>
                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                <%--<a class="btn-add-to-compare" href="#">compare</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div><!-- /.carousel-item -->--%>

                <%--<div class="no-margin carousel-item product-item-holder hover size-medium">--%>
                <%--<div class="product-item">--%>
                <%--<div class="image">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-16.jpg"/>--%>
                <%--</div>--%>
                <%--<div class="body">--%>
                <%--<div class="title">--%>
                <%--<a href="single-product.html">iPod touch 5th generation,64GB, blue</a>--%>
                <%--</div>--%>
                <%--<div class="brand">apple</div>--%>
                <%--</div>--%>
                <%--<div class="prices">--%>
                <%--<div class="price-current text-right">$1199.00</div>--%>
                <%--</div>--%>
                <%--<div class="hover-area">--%>
                <%--<div class="add-cart-button">--%>
                <%--<a href="single-product.html" class="le-button">add to cart</a>--%>
                <%--</div>--%>
                <%--<div class="wish-compare">--%>
                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                <%--<a class="btn-add-to-compare" href="#">compare</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div><!-- /.carousel-item -->--%>

                <%--<div class="no-margin carousel-item product-item-holder hover size-medium">--%>
                <%--<div class="product-item">--%>
                <%--<div class="image">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-13.jpg"/>--%>
                <%--</div>--%>
                <%--<div class="body">--%>
                <%--<div class="title">--%>
                <%--<a href="single-product.html">s2340T23" full HD multi-Touch Monitor</a>--%>
                <%--</div>--%>
                <%--<div class="brand">dell</div>--%>
                <%--</div>--%>
                <%--<div class="prices">--%>
                <%--<div class="price-current text-right">$1199.00</div>--%>
                <%--</div>--%>
                <%--<div class="hover-area">--%>
                <%--<div class="add-cart-button">--%>
                <%--<a href="single-product.html" class="le-button">add to cart</a>--%>
                <%--</div>--%>
                <%--<div class="wish-compare">--%>
                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                <%--<a class="btn-add-to-compare" href="#">compare</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div><!-- /.carousel-item -->--%>

                <%--<div class="no-margin carousel-item product-item-holder hover size-medium">--%>
                <%--<div class="product-item">--%>
                <%--<div class="ribbon blue"><span>new!</span></div>--%>
                <%--<div class="image">--%>
                <%--<img alt="" src="assets/images/blank.gif"--%>
                <%--data-echo="assets/images/products/product-14.jpg"/>--%>
                <%--</div>--%>
                <%--<div class="body">--%>

                <%--<div class="title">--%>
                <%--<a href="single-product.html">kardon BDS 7772/120 integrated 3D</a>--%>
                <%--</div>--%>
                <%--<div class="brand">harman</div>--%>
                <%--</div>--%>
                <%--<div class="prices">--%>

                <%--<div class="price-current text-right">$1199.00</div>--%>
                <%--</div>--%>
                <%--<div class="hover-area">--%>
                <%--<div class="add-cart-button">--%>
                <%--<a href="single-product.html" class="le-button">add to cart</a>--%>
                <%--</div>--%>
                <%--<div class="wish-compare">--%>
                <%--<a class="btn-add-to-wishlist" href="#">add to wishlist</a>--%>
                <%--<a class="btn-add-to-compare" href="#">compare</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div><!-- /.carousel-item -->--%>

                <%--</div><!-- /#recommended-products-carousel .owl-carousel -->--%>
                <%--</section><!-- /.carousel-holder -->--%>
                <!-- /recommended-products -->

                <%@ include file="TireList.jsp" %>

            </div><!-- /.col -->
            <!-- ========================================= CONTENT : END ========================================= -->


        </div><!-- /.container -->

    </section><!-- /#category-grid -->

    <%@ include file="../Footer.jsp" %>

</div><!-- /.wrapper -->

<%@ include file="../JavaScriptPostLoad.jsp" %>

</body>
</html>
