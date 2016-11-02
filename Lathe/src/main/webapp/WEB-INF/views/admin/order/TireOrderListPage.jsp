<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name='robots' content='all, follow'/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>Great admin</title>

    <link href=
          <c:url value="/resources/admin/css/default.css"/> rel="stylesheet" type="text/css" media="screen"/>
    <link href=
          <c:url value="/resources/admin/css/blue.css"/> rel="stylesheet" type="text/css" media="screen"/>
    <!-- color skin: blue / red / green / dark -->
    <link href=
          <c:url value="/resources/admin/css/datePicker.css"/> rel="stylesheet" type="text/css" media="screen"/>
    <link href=
          <c:url value="/resources/admin/css/wysiwyg.css"/> rel="stylesheet" type="text/css" media="screen"/>
    <link href=
          <c:url value="/resources/admin/css/fancybox-1.3.1.css"/> rel="stylesheet" type="text/css" media="screen"/>
    <link href=
          <c:url value="/resources/admin/css/visualize.css"/> rel="stylesheet" type="text/css" media="screen"/>

    <script type="text/javascript" src=<c:url value="/resources/admin/js/jquery-1.4.2.min.js"/>></script>
    <script type="text/javascript" src=<c:url value="/resources/admin/js/jquery.dimensions.min.js"/>></script>

    <!-- // Tabs // -->
    <script type="text/javascript" src=<c:url value="/resources/admin/js/ui.core.js"/>></script>
    <script type="text/javascript" src=<c:url value="/resources/admin/js/jquery.ui.tabs.min.js"/>></script>

    <!-- // Table drag and drop rows // -->
    <script type="text/javascript" src=<c:url value="/resources/admin/js/tablednd.js"/>></script>

    <!-- // Date Picker // -->
    <script type="text/javascript" src=<c:url value="/resources/admin/js/date.js"/>></script>
    <!--[if IE]>
    <script type="text/javascript" src=<c:url value="/resources/admin/js/jquery.bgiframe.js"/>></script>
    <![endif]-->
    <script type="text/javascript" src=<c:url value="/resources/admin/js/jquery.datePicker.js"/>></script>

    <!-- // Wysiwyg // -->
    <script type="text/javascript" src=<c:url value="/resources/admin/js/jquery.wysiwyg.js"/>></script>

    <!-- // Graphs // -->
    <script type="text/javascript" src=<c:url value="/resources/admin/js/excanvas.js"/>></script>
    <script type="text/javascript" src=<c:url value="/resources/admin/js/jquery.visualize.js"/>></script>

    <!-- // Fancybox // -->
    <script type="text/javascript" src=<c:url
            value="/resources/admin/js/jquery.fancybox-1.3.1.js"/>></script>

    <!-- // File upload // -->
    <script type="text/javascript" src=<c:url value="/resources/admin/js/jquery.filestyle.js"/>></script>

    <script type="text/javascript" src=<c:url value="/resources/admin/js/init.js"/>></script>
</head>

<body>
<div id="main">

    <%@ include file="../Header.jsp" %>

    <!-- #content -->
    <div id="content">

        <%@ include file="../BreadCrumbs.jsp" %>

        <%--<%@ include file="NewTireForm.jsp" %>--%>

        <%@ include file="TireOrderList.jsp" %>
    </div>
    <!-- /#content -->

    <%--<%@ include file="TiresSideBar.jsp" %>--%>

    <%@ include file="../Footer.jsp" %>
</div>
<!-- /#main -->
</body>
</html>