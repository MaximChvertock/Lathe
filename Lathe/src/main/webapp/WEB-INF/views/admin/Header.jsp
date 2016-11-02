<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<!-- #header -->
<div id="header">

    <!-- #logo -->
    <div id="logo">
        <a href="index.html" title="Go to Homepage"><span>Great Admin</span></a>
    </div>
    <!-- /#logo -->

    <div id="user">
        <h2><span>${pageContext.request.userPrincipal.name}</span></h2>
        <a href="${pageContext.servletContext.contextPath}/logout">Logout</a>
    </div>
</div>
<!-- /#header -->
