<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<div class="col-xs-12 col-sm-4 col-md-3 sidemenu-holder">
    <!-- ================================== TOP NAVIGATION ================================== -->
    <div class="side-menu animate-dropdown">
        <div class="head"><i class="fa fa-list"></i><spring:message code="shop.side_menu.category.title"/></div>
        <nav class="yamm megamenu-horizontal" role="navigation">
            <ul class="nav">
                <li><a href="${pageContext.servletContext.contextPath}/shop/products"><spring:message
                        code="shop.side_menu.category.wheeldrives"/></a></li>
                <li><a href="${pageContext.servletContext.contextPath}/shop/tires"><spring:message
                        code="shop.side_menu.category.tires"/></a></li>
            </ul><!-- /.nav -->
        </nav><!-- /.megamenu-horizontal -->
    </div><!-- /.side-menu -->
    <!-- ================================== TOP NAVIGATION : END ================================== -->
</div><!-- /.sidemenu-holder -->
