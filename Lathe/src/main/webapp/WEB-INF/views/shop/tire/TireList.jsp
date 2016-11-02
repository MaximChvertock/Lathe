<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>


<!-- tires -->
<section id="tires">

    <div class="grid-list-products">

        <h2 class="section-title"><spring:message code="tires"/></h2>

        <%--<div class="control-bar">--%>

            <%--<div id="popularity-sort" class="le-select">--%>
                <%--<select data-placeholder="sort by popularity">--%>
                    <%--<option value="1">1-100 players</option>--%>
                    <%--<option value="2">101-200 players</option>--%>
                    <%--<option value="3">200+ players</option>--%>
                <%--</select>--%>
            <%--</div>--%>

            <%--<div id="item-count" class="le-select">--%>
                <%--<select>--%>
                    <%--<option value="1">24 per page</option>--%>
                    <%--<option value="2">48 per page</option>--%>
                    <%--<option value="3">32 per page</option>--%>
                <%--</select>--%>
            <%--</div>--%>

        <%--<div class="grid-list-buttons">--%>
            <%--<ul>--%>
                <%--<li class="grid-list-button-item active"><a data-toggle="tab" href="#grid-view"><i--%>
                        <%--class="fa fa-th-large"></i> Grid</a></li>--%>
                <%--<li class="grid-list-button-item "><a data-toggle="tab" href="#list-view"><i--%>
                        <%--class="fa fa-th-list"></i> List</a></li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    </div><!-- /.control-bar -->

    <div class="tab-content">


        <%@ include file="TireListGridView.jsp" %>


        <%--<%@ include file="TireListListView.jsp" %>--%>


    </div><!-- /.tab-content -->

    </div><!-- /.grid-list-products -->

</section>
<!-- /tires -->
