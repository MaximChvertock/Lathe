<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<div class="pagination-holder">
    <div class="row">

        <div class="col-xs-12 col-sm-6 text-left">
            <ul class="pagination ">
                <c:if test="${activePage > 1}">
                    <li>
                        <a href="${pageContext.servletContext.contextPath}/shop/tires?page=${activePage-1}"><spring:message
                                code="pagination.prev"/></a>
                    </li>
                </c:if>

                <c:forEach var="page" items="${pageList}">
                    <c:choose>
                        <c:when test="${page == activePage}">
                            <li class="current">
                                <a href="${pageContext.servletContext.contextPath}/shop/tires?page=${page}">${page}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="${pageContext.servletContext.contextPath}/shop/tires?page=${page}">${page}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${activePage < lastPage}">
                    <li>
                        <a href="${pageContext.servletContext.contextPath}/shop/tires?page=${activePage+1}"><spring:message
                                code="pagination.next"/></a>
                    </li>
                </c:if>
            </ul>
        </div>

        <div class="col-xs-12 col-sm-6">
            <div class="result-counter">
                Pages <span>1</span> of <span>${lastPage}</span>
            </div>
        </div>

    </div><!-- /.row -->
</div>
<!-- /.pagination-holder -->
