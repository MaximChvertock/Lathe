<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<div class="pagination">
    <ul>
        <c:if test="${activePage != 1}">
            <li class="graphic first">
                <a href="${pageContext.servletContext.contextPath}/admin/tires/orders?page=1"></a>
            </li>
        </c:if>
        <c:if test="${activePage > 1}">
            <li class="graphic prev">
                <a href="${pageContext.servletContext.contextPath}/admin/tires/orders?page=${activePage-1}"></a>
            </li>
        </c:if>
        <c:forEach var="page" items="${pageList}">
            <c:choose>
                <c:when test="${page == activePage}">
                    <li class="active">
                        <a href="${pageContext.servletContext.contextPath}/admin/tires/orders?page=${page}">${page}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.servletContext.contextPath}/admin/tires/orders?page=${page}">${page}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${activePage < lastPage}">
            <li class="graphic next">
                <a href="${pageContext.servletContext.contextPath}/admin/tires/orders?page=${activePage+1}"></a>
            </li>
        </c:if>
        <c:if test="${activePage != lastPage}">
            <li class="graphic last">
                <a href="${pageContext.servletContext.contextPath}/admin/tires/orders?page=${lastPage}"></a>
            </li>
        </c:if>
    </ul>
    <p>Pages 1 of ${lastPage}</p>
</div>