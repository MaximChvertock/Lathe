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
        <form
                action="${pageContext.servletContext.contextPath}/shop/tires/order?${_csrf.parameterName}=${_csrf.token}"
                method="post">
            <section id="checkout-page">

                <div class="container">
                    <div class="col-xs-12 no-margin">

                        <div class="billing-address">
                            <h2 class="border h1"><spring:message code="check-order.title"/></h2>
                            <form>
                                <span class="error" style="color:red;">${orderNotFoundError}</span>
                                <div class="row field-row">
                                    <div class="col-xs-12 col-sm-4">
                                        <label><spring:message code="check-order.identificator"/>*</label>
                                        <input class="le-input"
                                               name="identificator" required="true"/>
                                        <span class="error" style="color:red;">${identificatorError}</span>
                                    </div>
                                    <div class="col-xs-12 col-sm-4">
                                        <label><spring:message code="check-order.email"/>*</label>
                                        <input class="le-input"
                                               name="email"
                                               type="email" required="true"/>
                                        <span class="error" style="color:red;">${emailError}</span>
                                    </div>
                                </div><!-- /.field-row -->
                            </form>
                        </div>


                        <div class="place-order-button">
                            <button class="le-button big"><spring:message code="check_order.submit"/></button>
                        </div><!-- /.place-order-button -->

                    </div><!-- /.col -->
                </div><!-- /.container -->

            </section>
        </form>
        <!-- /checkout-page -->

        <%@ include file="../Footer.jsp" %>

    </div><!-- /.wrapper -->

    <%@ include file="../JavaScriptPostLoad.jsp" %>

</body>
</html>
