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

        <%--${order}--%>


        <section id="checkout-page">

            <div class="container">
                <div class="col-xs-12 no-margin">

                    <!-- your-order -->
                    <section id="your-order">
                        <h2 class="border h1"><spring:message code="checkout.order.title"/></h2>


                        <ul class="tabled-data">
                            <li>
                                <label><spring:message code="identificator"/></label>
                                <span class="value">${order.identificator}</span>
                            </li>
                            <li>
                                <label><spring:message code="customer"/></label>
                                <span class="value">${order.customerInfo.firstName}</span>
                                <span class="value">${order.customerInfo.lastName}</span>
                            </li>
                            <li>
                                <label><spring:message code="email"/></label>
                                <div class="value">${order.customerInfo.email}</div>
                            </li>
                            <li>
                                <label><spring:message code="phone_number"/></label>
                                <div class="value">${order.customerInfo.phoneNumber}</div>
                            </li>
                            <li>
                                <label><spring:message code="address"/></label>
                                <div class="value">
                                    <span>${order.customerInfo.town}</span>
                                    <span>${order.customerInfo.address}</span>
                                </div>
                            </li>
                            <li>
                                <label><spring:message code="postcode"/></label>
                                <div class="value">${order.customerInfo.postcode}</div>
                            </li>
                            <li>
                                <label><spring:message code="order.status"/></label>
                                <div class="value">${order.status}</div>
                            </li>
                        </ul>


                        <c:forEach var="tireItem" items="${order.tires}">
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

                        <ul id="total-field" class="tabled-data inverse-bold ">
                            <li>
                                <label><spring:message code="order.total"/></label>
                                <div class="value">${order.totalPrice}</div>
                            </li>
                        </ul>

                    </section>
                    <!-- /your-order -->

                </div>
            </div>
        </section>


        <%@ include file="../Footer.jsp" %>

    </div><!-- /.wrapper -->

    <%@ include file="../JavaScriptPostLoad.jsp" %>

</body>
</html>
