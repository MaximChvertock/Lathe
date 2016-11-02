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
        <!-- checkout-page -->
        <form:form
                action="${pageContext.servletContext.contextPath}/shop/tires/checkout/place-order?${_csrf.parameterName}=${_csrf.token}"
                modelAttribute="customerInfo" method="post">

            <section id="checkout-page">

                <div class="container">
                    <div class="col-xs-12 no-margin">

                        <div class="billing-address">
                            <h2 class="border h1"><spring:message code="checkout.title"/></h2>
                            <form>
                                <div class="row field-row">
                                    <div class="col-xs-12 col-sm-6">
                                        <label><spring:message code="checkout.first_name"/>*</label>
                                        <form:input class="le-input"
                                                    path="firstName"/>
                                        <span class="error" style="color:red;">${firstNameError}</span>
                                    </div>
                                    <div class="col-xs-12 col-sm-6">
                                        <label><spring:message code="checkout.last_name"/>*</label>
                                        <form:input class="le-input"
                                                    path="lastName"/>
                                        <form:errors path="lastName"/>
                                        <span class="error" style="color:red;">${lastNameError}</span>
                                    </div>
                                </div><!-- /.field-row -->

                                <div class="row field-row">
                                    <div class="col-xs-12">
                                        <label><spring:message code="checkout.company_name"/></label>
                                        <form:input class="le-input"
                                                    path="companyName"/>
                                        <%--<span class="error" style="color:red;">${companyNameError}</span>--%>
                                    </div>
                                </div><!-- /.field-row -->

                                <div class="row field-row">
                                    <div class="col-xs-12 col-sm-6">
                                        <label><spring:message code="checkout.address"/>*</label>
                                        <form:input class="le-input"
                                                    path="address"/>
                                        <span class="error" style="color:red;">${addressError}</span>
                                    </div>
                                    <div class="col-xs-12 col-sm-6">
                                        <label>&nbsp;<spring:message code="checkout.town"/></label>
                                        <form:input class="le-input"
                                                    path="town"/>
                                        <%--<span class="error" style="color:red;">${townError}</span>--%>
                                    </div>
                                </div><!-- /.field-row -->

                                <div class="row field-row">
                                    <div class="col-xs-12 col-sm-4">
                                        <label><spring:message code="checkout.postcode"/>*</label>
                                        <form:input class="le-input"
                                                    path="postcode"/>
                                        <span class="error" style="color:red;">${postcodeError}</span>
                                    </div>
                                    <div class="col-xs-12 col-sm-4">
                                        <label><spring:message code="checkout.email"/>*</label>
                                        <form:input class="le-input"
                                                    path="email"
                                                    type="email"/>
                                        <span class="error" style="color:red;">${emailError}</span>
                                    </div>

                                    <div class="col-xs-12 col-sm-4">
                                        <label><spring:message code="checkout.phone_number"/>*</label>
                                        <form:input class="le-input"
                                                    path="phoneNumber"/>
                                        <span class="error" style="color:red;">${phoneNumberError}</span>
                                    </div>
                                </div><!-- /.field-row -->

                                    <%--<div class="row field-row">--%>
                                    <%--<div id="create-account" class="col-xs-12">--%>
                                    <%--<input class="le-checkbox big" type="checkbox"/>--%>
                                    <%--<a class="simple-link bold" href="#">Create Account?</a> - you will receive email--%>
                                    <%--with--%>
                                    <%--temporary generated password after login you need to change it.--%>
                                    <%--</div>--%>
                                    <%--</div><!-- /.field-row -->--%>

                            </form>
                        </div><!-- /.billing-address -->


                            <%--<section id="shipping-address">--%>
                            <%--<h2 class="border h1">shipping address</h2>--%>
                            <%--<form>--%>
                            <%--<div class="row field-row">--%>
                            <%--<div class="col-xs-12">--%>
                            <%--<input class="le-checkbox big" type="checkbox"/>--%>
                            <%--<a class="simple-link bold" href="#">ship to different address?</a>--%>
                            <%--</div>--%>
                            <%--</div><!-- /.field-row -->--%>
                            <%--</form>--%>
                            <%--</section><!-- /#shipping-address -->--%>


                        <!-- your-order -->
                        <section id="your-order">
                            <h2 class="border h1"><spring:message code="checkout.order.title"/></h2>

                            <c:forEach var="tireItem" items="${customerCart.tires}">
                                <div class="row no-margin order-item">
                                    <div class="thumb">
                                        <img alt=""
                                             src="${appProperties['content.images.url']}/${tireItem.tire.image.fileName}"
                                             data-echo="${appProperties['content.images.url']}/${tireItem.tire.image.fileName}"
                                             width="73" height="73"/>
                                    </div>
                                    <div class="col-xs-12 col-sm-1 no-margin">
                                        <a href="#" class="qty">${tireItem.quantity} x</a>
                                    </div>

                                    <div class="col-xs-12 col-sm-9 ">
                                        <div class="title"><a href="#">${tireItem.tire.name} </a></div>
                                        <div class="brand">${tireItem.tire.brand}</div>
                                    </div>

                                    <div class="col-xs-12 col-sm-2 no-margin">
                                        <div class="price">${tireItem.tire.price}</div>
                                    </div>
                                </div>
                                <!-- /.order-item -->
                            </c:forEach>

                        </section>
                        <!-- /your-order -->

                        <!-- total-area -->
                        <div id="total-area" class="row no-margin">
                            <div class="col-xs-12 col-lg-4 col-lg-offset-8 no-margin-right">
                                <div id="subtotal-holder">
                                        <%--<ul class="tabled-data inverse-bold no-border">--%>
                                        <%--<li>--%>
                                        <%--<label>cart subtotal</label>--%>
                                        <%--<div class="value ">$8434.00</div>--%>
                                        <%--</li>--%>
                                        <%--<li>--%>
                                        <%--<label>shipping</label>--%>
                                        <%--<div class="value">--%>
                                        <%--<div class="radio-group">--%>
                                        <%--<input class="le-radio" type="radio" name="group1" value="free">--%>
                                        <%--<div class="radio-label bold">free shipping</div>--%>
                                        <%--<br>--%>
                                        <%--<input class="le-radio" type="radio" name="group1" value="local"--%>
                                        <%--checked>--%>
                                        <%--<div class="radio-label">local delivery<br><span--%>
                                        <%--class="bold">$15</span>--%>
                                        <%--</div>--%>
                                        <%--</div>--%>
                                        <%--</div>--%>
                                        <%--</li>--%>
                                        <%--</ul><!-- /.tabled-data -->--%>

                                    <ul id="total-field" class="tabled-data inverse-bold ">
                                        <li>
                                            <label><spring:message code="checkout.order.total"/></label>
                                            <div class="value">${customerCart.totalPrice}</div>
                                        </li>
                                    </ul><!-- /.tabled-data -->

                                </div><!-- /#subtotal-holder -->
                            </div><!-- /.col -->
                        </div>
                        <!-- /total-area -->

                            <%--<div id="payment-method-options">--%>
                            <%--<form>--%>
                            <%--<div class="payment-method-option">--%>
                            <%--<input class="le-radio" type="radio" name="group2" value="Direct">--%>
                            <%--<div class="radio-label bold ">Direct Bank Transfer<br>--%>
                            <%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce rutrum tempus--%>
                            <%--elit,--%>
                            <%--vestibulum vestibulum erat ornare id.</p>--%>
                            <%--</div>--%>
                            <%--</div><!-- /.payment-method-option -->--%>

                            <%--<div class="payment-method-option">--%>
                            <%--<input class="le-radio" type="radio" name="group2" value="cheque">--%>
                            <%--<div class="radio-label bold ">cheque payment</div>--%>
                            <%--</div><!-- /.payment-method-option -->--%>

                            <%--<div class="payment-method-option">--%>
                            <%--<input class="le-radio" type="radio" name="group2" value="paypal">--%>
                            <%--<div class="radio-label bold ">paypal system</div>--%>
                            <%--</div><!-- /.payment-method-option -->--%>
                            <%--</form>--%>
                            <%--</div><!-- /#payment-method-options -->--%>

                        <div class="place-order-button">
                            <button class="le-button big"><spring:message code="checkout.button.place_order"/></button>
                        </div><!-- /.place-order-button -->

                    </div><!-- /.col -->
                </div><!-- /.container -->

            </section>
        </form:form>
        <!-- /checkout-page -->

        <%@ include file="../Footer.jsp" %>

    </div><!-- /.wrapper -->

    <%@ include file="../JavaScriptPostLoad.jsp" %>

</body>
</html>
