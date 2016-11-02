<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<!-- box -->
<div class="box">
    <div class="headlines">
        <h2><span>Table list</span></h2>
        <a href="#" class="show-filter">show filter</a>
    </div>

    <%@ include file="TireFilter.jsp" %>


    <form:form
            class="formBox"
            action="${pageContext.servletContext.contextPath}/admin/tires/update-tire-list?${_csrf.parameterName}=${_csrf.token}"
            method="post"
            modelAttribute="tireListForm">
        <fieldset>

            <div class="btn-submit"><!-- Submit form -->
                <input type="submit" value="Update" class="button"/>
            </div>

            <!-- table -->
            <table class="tab tab-drag">
                <c:forEach var="tire" items="${tireListForm.tireList}" varStatus="status">
                    <tr>

                        <input type="hidden" name="tireList[${status.index}].id" value="${tire.id}"/>

                        <td class="action">
                            <a href="${pageContext.servletContext.contextPath}/admin/tires/remove-tire?id=${tire.id}"
                               class="ico ico-delete">Delete</a>
                        </td>
                        <td>
                            <img src="${appProperties['content.images.url']}/${tire.image.fileName}"
                                 width="128" height="128">
                        </td>

                        <td>
                            <div class="form-cols">

                                <div class="col1">

                                    <!-- name -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-name-id"><spring:message
                                                    code="model.name"/></label>
                                        </div>
                                        <div class="con">
                                            <form:input class="input"
                                                        id="tire-name-id"
                                                        path="tireList[${status.index}].name"/>
                                        </div>
                                    </div>
                                    <!-- /name -->

                                    <!-- price -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-price-id"><spring:message
                                                    code="price"/></label>
                                        </div>
                                        <div class="con">
                                            <form:input class="input"
                                                        type="number"
                                                        id="tire-price-id"
                                                        path="tireList[${status.index}].price"
                                                        min="${defProperties['tire.price.min.default']}"
                                                        max="${defProperties['tire.price.max.default']}"
                                                        step="${defProperties['tire.price.step.default']}"/>
                                        </div>
                                    </div>
                                    <!-- /price -->

                                    <!-- in stock -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-instock-id"><spring:message
                                                    code="in_stock"/></label>
                                        </div>
                                        <div class="con">
                                            <form:input class="input"
                                                        type="number"
                                                        id="tire-instock-id"
                                                        path="tireList[${status.index}].inStock"
                                                        min="${defProperties['tire.in_stock.min.default']}"
                                                        max="${defProperties['tire.in_stock.max.default']}"
                                                        step="${defProperties['tire.in_stock.step.default']}"/>
                                        </div>
                                    </div>
                                    <!-- /in stock -->

                                    <!-- image -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-image-${status.index}-id">
                                                <spring:message code="img"/>
                                            </label>
                                        </div>
                                        <div class="con">

                                            <form:select class="select"
                                                         path="tireList[${status.index}].image"
                                                         id="tire-image-${status.index}-id"
                                                         items="${imageList}"/>
                                        </div>
                                    </div>
                                    <!-- /image -->

                                    <!-- brand -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-brand-${status.index}-id">
                                                <spring:message code="brand"/>
                                            </label>
                                        </div>
                                        <div class="con">
                                            <form:select class="select"
                                                         path="tireList[${status.index}].brand"
                                                         id="tire-brand-${status.index}-id"
                                                         items="${brandList}"/>
                                        </div>
                                    </div>
                                    <!-- /brand -->

                                    <!-- type -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-type-${status.index}-id">
                                                <spring:message code="type"/>
                                            </label>
                                        </div>
                                        <div class="con">
                                            <form:select class="select"
                                                         path="tireList[${status.index}].type"
                                                         id="tire-type-${status.index}-id"
                                                         items="${typeList}"/>
                                        </div>
                                    </div>
                                    <!-- /type -->

                                </div>

                                <div class="col2">

                                    <!-- width -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-width-${status.index}-id">
                                                <spring:message code="width"/>
                                            </label>
                                        </div>
                                        <div class="con">
                                            <form:input class="input"
                                                        path="tireList[${status.index}].width"
                                                        id="tire-width-${status.index}-id"
                                                        min="${defProperties['tire.width.min.default']}"
                                                        max="${defProperties['tire.width.max.default']}"
                                                        step="${defProperties['tire.width.step.default']}"
                                                        autocomplete="off"
                                                        list="width-list-id"/>
                                        </div>
                                    </div>
                                    <!-- /width -->

                                    <!-- /profile -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-profile-${status.index}-id">
                                                <spring:message code="profile"/>
                                            </label>
                                        </div>
                                        <div class="con">
                                            <form:input class="input"
                                                        path="tireList[${status.index}].profile"
                                                        id="tire-profile-${status.index}-id"
                                                        min="${defProperties['tire.profile.min.default']}"
                                                        max="${defProperties['tire.profile.max.default']}"
                                                        step="${defProperties['tire.profile.step.default']}"
                                                        autocomplete="off"
                                                        list="profile-list-id"/>
                                        </div>
                                    </div>
                                    <!-- /profile -->

                                    <!-- diameter -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-diameter-${status.index}-id">
                                                <spring:message code="diameter"/>
                                            </label>
                                        </div>
                                        <div class="con">
                                            <form:input class="input"
                                                        path="tireList[${status.index}].diameter"
                                                        id="tire-diameter-${status.index}-id"
                                                        min="${defProperties['tire.diameter.min.default']}"
                                                        max="${defProperties['tire.diameter.max.default']}"
                                                        step="${defProperties['tire.diameter.step.default']}"
                                                        autocomplete="off"
                                                        list="diameter-list-id"/>
                                        </div>
                                    </div>
                                    <!-- /diameter -->

                                    <!-- description -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="tire-description-id"><spring:message
                                                    code="description"/></label>
                                        </div>
                                        <div class="con">
                                            <form:textarea class="textarea"
                                                           id="tire-description-id"
                                                           path="tireList[${status.index}].description"
                                                           cols="" rows="10"
                                                           maxlength="1024"/>
                                        </div>
                                    </div>
                                    <!-- /description -->

                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <!-- /table -->

        </fieldset>
    </form:form>
    <%--<!-- box-action -->--%>
    <%--<div class="tab-action">--%>
    <%--<select class="select">--%>
    <%--<option>Choose an action</option>--%>
    <%--</select>--%>
    <%--<input type="submit" value="Apply action" class="submit"/>--%>
    <%--</div>--%>
    <!-- /box-action -->

    <!-- pagination -->
    <%@ include file="../Pagination.jsp" %>
    <!-- /pagination -->
</div>
<!-- /box -->