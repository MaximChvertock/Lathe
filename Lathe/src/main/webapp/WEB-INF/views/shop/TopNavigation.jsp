<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>


<!-- ============================================================= TOP NAVIGATION ============================================================= -->
<nav class="top-bar animate-dropdown">
    <div class="container">
        <div class="col-xs-12 col-sm-6 no-margin">
            <ul>
                <li><a href="${pageContext.servletContext.contextPath}/shop">Home</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#change-colors">Change Colors</a>

                    <ul class="dropdown-menu" role="menu">
                        <li role="presentation"><a role="menuitem" class="changecolor green-text" tabindex="-1"
                                                   href="#" title="Green color">Green</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor blue-text" tabindex="-1"
                                                   href="#" title="Blue color">Blue</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor red-text" tabindex="-1"
                                                   href="#" title="Red color">Red</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor orange-text" tabindex="-1"
                                                   href="#" title="Orange color">Orange</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor navy-text" tabindex="-1"
                                                   href="#" title="Navy color">Navy</a></li>
                        <li role="presentation"><a role="menuitem" class="changecolor dark-green-text" tabindex="-1"
                                                   href="#" title="Darkgreen color">Dark Green</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.servletContext.contextPath}/shop/tires/check-order"><spring:message
                        code="check-order.title"/></a></li>
                <%--<li><a href="blog.html">Blog</a></li>--%>
                <%--<li><a href="faq.html">FAQ</a></li>--%>
                <%--<li><a href="contact.html">Contact</a></li>--%>
                <%--<li class="dropdown">--%>
                <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#pages">Pages</a>--%>
                <%--<ul class="dropdown-menu" role="menu">--%>
                <%--<li><a href="index.html">Home</a></li>--%>
                <%--<li><a href="index-2.html">Home Alt</a></li>--%>
                <%--<li><a href="category-grid.html">Category - Grid/List</a></li>--%>
                <%--<li><a href="category-grid-2.html">Category 2 - Grid/List</a></li>--%>
                <%--<li><a href="single-product.html">Single Product</a></li>--%>
                <%--<li><a href="single-product-sidebar.html">Single Product with Sidebar</a></li>--%>
                <%--<li><a href="cart.html">Shopping Cart</a></li>--%>
                <%--<li><a href="checkout.html">Checkout</a></li>--%>
                <%--<li><a href="about.html">About Us</a></li>--%>
                <%--<li><a href="contact.html">Contact Us</a></li>--%>
                <%--<li><a href="blog.html">Blog</a></li>--%>
                <%--<li><a href="blog-fullwidth.html">Blog Full Width</a></li>--%>
                <%--<li><a href="blog-post.html">Blog Post</a></li>--%>
                <%--<li><a href="faq.html">FAQ</a></li>--%>
                <%--<li><a href="terms.html">Terms & Conditions</a></li>--%>
                <%--<li><a href="authentication.html">Login/Register</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>
            </ul>
        </div><!-- /.col -->

        <%--<div class="col-xs-12 col-sm-6 no-margin">--%>
        <%--<ul class="right">--%>
        <%--<c:choose>--%>
        <%--<c:when test="${not empty pageContext.request.userPrincipal}">--%>
        <%--<security:authorize--%>
        <%--access="hasRole('ROLE_MARKET_ECONOMIST') or hasRole('ROLE_MARKET_SPECIALIST')">--%>
        <%--<li>--%>
        <%--<a href="${pageContext.servletContext.contextPath}/admin/products">products</a>--%>
        <%--</li>--%>
        <%--</security:authorize>--%>
        <%--<security:authorize access="hasRole('ROLE_SALE_MANAGER') or hasRole('ROLE_SELLER')">--%>
        <%--<li>--%>
        <%--<a href="${pageContext.servletContext.contextPath}/admin/seller/orders">orders</a>--%>
        <%--</li>--%>
        <%--</security:authorize>--%>

        <%--<security:authorize access="hasRole('ROLE_DELIVERY')">--%>
        <%--<li>--%>
        <%--<a href="${pageContext.servletContext.contextPath}/admin/delivery/orders">for--%>
        <%--delivery</a>--%>
        <%--</li>--%>
        <%--</security:authorize>--%>

        <%--<security:authorize access="hasRole('ROLE_ADMIN')">--%>
        <%--<li>--%>
        <%--<a href="${pageContext.servletContext.contextPath}/admin/products">admin</a>--%>
        <%--</li>--%>

        <%--</security:authorize>--%>

        <%--<li>${pageContext.request.userPrincipal.name}</li>--%>
        <%--<li><a href="<c:url value="/logout"/>">Logout</a></li>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <%--<li><a href="${pageContext.servletContext.contextPath}/registration">Registration</a></li>--%>
        <%--<li><a href="${pageContext.servletContext.contextPath}/login">Login</a></li>--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>


        <li>
            <div id="user">
                <a href="?lang=en"> <spring:message code="language.en"/>
                </a> | <a href="?lang=ru"> <spring:message code="language.ru"/>
            </a>
            </div>
        </li>
        <%--</ul>--%>
        <%--</div>--%>


    </div><!-- /.container -->
</nav>
<!-- /.top-bar -->
<!-- ============================================================= TOP NAVIGATION : END ============================================================= -->

