<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name='robots' content='all, follow'/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>Great admin</title>
    <link href=
          <c:url value="/resources/admin/css/login.css"/> rel="stylesheet" type="text/css"/>
    <link href=
          <c:url value="/resources/admin/css/login-blue.css"/> rel="stylesheet" type="text/css"/>
    <!-- color skin: blue / red / green / dark -->
</head>
<body>
<div id="main">
    <div id="content">
        <div id="login">

            <div id="logo"><span>Great Admin</span></div>


            <%--<div>--%>
            <%--<c:if test="${error == true}">--%>
            <%--<p style="color:red">Invalid email or password</p>--%>
            <%--</c:if>--%>
            <%--</div>--%>

            <form method="post" id="form-login" class="formBox">
                <fieldset>
                    <div class="form-col">
                        <label for="username" class="lab">Username <c:if test="${error == true}">
                            <span class="warning"></span></c:if></label>
                        <input type="email" name="username" value="${username}" class="input" id="username"/>
                    </div>
                    <div class="form-col form-col-right">
                        <label for="password" class="lab">Password <c:if test="${error == true}">
                            <span class="warning"></span></c:if></label>
                        <input type="password" name="password" value="${password}" class="input" id="password"/>
                    </div>
                    <%--<div class="form-col form-col-check">--%>
                    <%--<label><input type="checkbox" name="remeber_me" class="checkbox"/>Remember me on this--%>
                    <%--computer</label>--%>
                    <%--</div>--%>
                    <div class="form-col form-col-right">
                        <input type="submit" name="" value="Login" class="submit"/>
                    </div>

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </fieldset>
            </form>

        </div>
    </div><!-- /content -->
</div><!-- /main -->
</body>
</html>

<%--&lt;%&ndash;<%@ include file="shop-header.jsp" &lt;%&ndash;--%>
<%--~ Author: Maksim Chvertock--%>
<%--~ Copyright (c) 2016.--%>
<%--&ndash;%&gt;--%>

<%--<main id="authentication" class="inner-bottom-md">--%>
<%--<div class="container">--%>
<%--<div class="row">--%>

<%--<div class="col-md-6">--%>
<%--<section class="section sign-in inner-right-xs">--%>
<%--<h2 class="bordered">Sign In</h2>--%>

<%--<c:choose>--%>
<%--<c:when test="${error == 'l_u_p_isInvalid'}">--%>
<%--<p style="color: red">Invalid email address or password</p>--%>
<%--</c:when>--%>
<%--</c:choose>--%>

<%--<form method="post" role="form" class="login-form cf-style-1">--%>
<%--<div class="field-row">--%>
<%--<label>Email</label>--%>
<%--<input type="email" name="username" value="${username}" class="le-input">--%>
<%--</div>--%>

<%--<div class="field-row">--%>
<%--<label>Password</label>--%>
<%--<input type="password" name="password" value="${password}" class="le-input">--%>
<%--</div>--%>

<%--<div class="buttons-holder">--%>
<%--<button type="submit" class="le-button huge">Sign In</button>--%>
<%--</div>--%>

<%--<input type="hidden"--%>
<%--name="${_csrf.parameterName}"--%>
<%--value="${_csrf.token}"/>--%>

<%--</form>--%>

<%--</section>--%>
<%--</div>--%>
<%--<div class="col-md-6">--%>
<%--<c:if test="${error == true}">--%>
<%--<p style="color:red">Invalid email or password</p>--%>
<%--</c:if>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</main>--%>

<%--<%@ include file="shop-footer.jsp" %>--%>