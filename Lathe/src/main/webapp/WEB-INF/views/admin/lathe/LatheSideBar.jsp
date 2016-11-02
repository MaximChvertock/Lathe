<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- #sidebar -->
<div id="sidebar">

    <!-- mainmenu -->
    <ul id="floatMenu" class="mainmenu">
        <li class="first">
            <a href="#"></a>
        </li>

        <%--<li>--%>
        <%--<a href="#"><spring:message code="brands"/></a>--%>
        <%--<ul class="submenu">--%>

        <%--<!-- new brand -->--%>
        <%--<li>--%>
        <%--<form:form--%>
        <%--class="formBox"--%>
        <%--action="${pageContext.servletContext.contextPath}/admin/tires/add-new-brand"--%>
        <%--method="post"--%>
        <%--modelAttribute="newBrand">--%>
        <%--<div class="clearfix">--%>
        <%--<label for="brand-new-name-id">--%>
        <%--<spring:message code="sidebar.tire.new.brand.enter_brand_name"/>--%>
        <%--</label>--%>
        <%--<div class="con">--%>
        <%--<input type="text" class="input"--%>
        <%--name="name"--%>
        <%--id="brand-new-name-id"/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class="formBox btn-submit"><!-- Submit form -->--%>
        <%--<input type="submit" value="<spring:message code="add"/>" class="button"/>--%>
        <%--</div>--%>
        <%--</form:form>--%>
        <%--</li>--%>
        <%--<!-- /new brand -->--%>

        <%--<!-- action brand -->--%>
        <%--<li>--%>
        <%--<form class="formBox"--%>
        <%--action="${pageContext.servletContext.contextPath}/admin/tires/action-brand?${_csrf.parameterName}=${_csrf.token}"--%>
        <%--method="post">--%>
        <%--<div class="clearfix">--%>
        <%--<label for="brand-list-id">--%>
        <%--<spring:message code="sidebar.tire.action.brand.select_brand"/>--%>
        <%--</label>--%>
        <%--</div>--%>
        <%--<div class="clearfix">--%>
        <%--<div class="con">--%>
        <%--<select class="select" name="id" id="brand-list-id">--%>
        <%--<c:forEach var="brand" items="${brandList}">--%>
        <%--<option value="${brand.id}">${brand}</option>--%>
        <%--</c:forEach>--%>
        <%--</select>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<div class="clearfix">--%>
        <%--<div class="con">--%>
        <%--<input type="text" class="input" name="name"/>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<input type="hidden" id="action-brand-id" name="action"/>--%>

        <%--<div class="formBox btn-submit"><!-- Submit form -->--%>
        <%--<input type="submit" value="Edit" class="button"--%>
        <%--onclick="document.getElementById('action-brand-id').value = 1;"/>--%>
        <%--<input type="submit" value="Remove" class="button"--%>
        <%--onclick="document.getElementById('action-brand-id').value = 2;"/>--%>
        <%--</div>--%>
        <%--</form>--%>
        <%--</li>--%>
        <%--<!-- /action brand -->--%>
        <%--</ul>--%>
        <%--</li>--%>

        <%--<li>--%>
        <%--<a href="#"><spring:message code="types"/></a>--%>
        <%--<ul class="submenu">--%>

        <%--<!-- new type -->--%>
        <%--<li>--%>
        <%--<form:form--%>
        <%--class="formBox"--%>
        <%--action="${pageContext.servletContext.contextPath}/admin/tires/add-new-type"--%>
        <%--method="post"--%>
        <%--modelAttribute="newType">--%>
        <%--<div class="clearfix">--%>
        <%--<label for="type-new-id">--%>
        <%--<spring:message code="sidebar.tire.new.type.enter_type"/>--%>
        <%--</label>--%>
        <%--<div class="con">--%>
        <%--<input type="text" class="input"--%>
        <%--name="name"--%>
        <%--id="type-new-id"/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class="formBox btn-submit"><!-- Submit form -->--%>
        <%--<input type="submit" value="<spring:message code="add"/>" class="button"/>--%>
        <%--</div>--%>
        <%--</form:form>--%>
        <%--</li>--%>
        <%--<!-- /new type -->--%>

        <%--<!-- action type -->--%>
        <%--<li>--%>
        <%--<form class="formBox"--%>
        <%--action="${pageContext.servletContext.contextPath}/admin/tires/action-type?${_csrf.parameterName}=${_csrf.token}"--%>
        <%--method="post">--%>
        <%--<div class="clearfix">--%>
        <%--<label for="type-list-id">--%>
        <%--<spring:message code="sidebar.tire.action.type.select_type"/>--%>
        <%--</label>--%>
        <%--</div>--%>
        <%--<div class="clearfix">--%>
        <%--<div class="con">--%>
        <%--<select class="select" name="id" id="type-list-id">--%>
        <%--<c:forEach var="type" items="${typeList}">--%>
        <%--<option value="${type.id}">${type}</option>--%>
        <%--</c:forEach>--%>
        <%--</select>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<div class="clearfix">--%>
        <%--<div class="con">--%>
        <%--<input type="text" class="input" name="name"/>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<input type="hidden" id="action-type-id" name="action"/>--%>

        <%--<div class="formBox btn-submit"><!-- Submit form -->--%>
        <%--<input type="submit" value="Edit" class="button"--%>
        <%--onclick="document.getElementById('action-type-id').value = 1;"/>--%>
        <%--<input type="submit" value="Remove" class="button"--%>
        <%--onclick="document.getElementById('action-type-id').value = 2;"/>--%>
        <%--</div>--%>
        <%--</form>--%>
        <%--</li>--%>
        <%--<!-- /action type -->--%>
        <%--</ul>--%>
        <%--</li>--%>

        <%--<!-- image -->--%>
        <%--<li>--%>
        <%--<a href="#"><spring:message code="images"/></a>--%>
        <%--<ul class="submenu">--%>

        <%--<!-- new image -->--%>
        <%--<li>--%>

        <%--<form action="${pageContext.servletContext.contextPath}/admin/tires/upload-image?${_csrf.parameterName}=${_csrf.token}"--%>
        <%--method="post"--%>
        <%--enctype="multipart/form-data">--%>
        <%--<spring:message code="sidebar.tire.action.image.select_image_file"/><br/>--%>
        <%--<input type="file" name="file"/><br/>--%>
        <%--<input type="text" name="name"/>--%>

        <%--<div class="formBox btn-submit"><!-- Submit form -->--%>
        <%--<input type="submit" value="<spring:message code="upload"/>" class="button"/>--%>
        <%--</div>--%>
        <%--</form>--%>
        <%--</li>--%>
        <%--<!-- /new image -->--%>

        <%--<!-- action image -->--%>
        <%--<li>--%>
        <%--<form class="formBox"--%>
        <%--action="${pageContext.servletContext.contextPath}/admin/tires/action-image?${_csrf.parameterName}=${_csrf.token}"--%>
        <%--method="post">--%>
        <%--<div class="clearfix">--%>
        <%--<label for="image-list-id">--%>
        <%--<spring:message code="sidebar.tire.action.image.select_image"/>--%>
        <%--</label>--%>
        <%--</div>--%>
        <%--<div class="clearfix">--%>
        <%--<div class="con">--%>
        <%--<select class="select" name="id" id="image-list-id">--%>
        <%--<c:forEach var="image" items="${imageList}">--%>
        <%--<option value="${image.id}">${image}</option>--%>
        <%--</c:forEach>--%>
        <%--</select>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--&lt;%&ndash;<div class="clearfix">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="con">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="text" class="input" name="name"/>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

        <%--<input type="hidden" id="action-image-id" name="action"/>--%>

        <%--<div class="formBox btn-submit"><!-- Submit form -->--%>
        <%--&lt;%&ndash;<input type="submit" value="Edit" class="button"&ndash;%&gt;--%>
        <%--&lt;%&ndash;onclick="document.getElementById('action-image-id').value = 1;"/>&ndash;%&gt;--%>
        <%--<input type="submit" value="Remove" class="button"--%>
        <%--onclick="document.getElementById('action-image-id').value = 2;"/>--%>
        <%--</div>--%>
        <%--</form>--%>
        <%--</li>--%>
        <%--<!-- /action image -->--%>
        <%--</ul>--%>
        <%--</li>--%>
        <%--<!-- /image -->--%>

        <!-- excel -->
        <li>
            <a href="#"><spring:message code="upload"/></a>
            <ul class="submenu">
                <li>

                    <form action="${pageContext.servletContext.contextPath}/admin/lathe/add-lathe-from-file?${_csrf.parameterName}=${_csrf.token}"
                          method="post"
                          enctype="multipart/form-data">
                        <spring:message code="sidebar.tire.action.tire.select_file"/><br/>
                        <input type="file" name="file"/><br/>
                        <%--<input type="text" name="name"/>--%>

                        <div class="formBox btn-submit"><!-- Submit form -->
                            <input type="submit" value="<spring:message code="upload"/>" class="button"/>
                        </div>
                    </form>
                </li>
            </ul>
        </li>
        <!-- /excel -->


        <li class="last">
            <a href="#"
               class="link"></a>
        </li>
    </ul>
    <!-- /.mainmenu -->

</div>
<!-- /#sidebar -->