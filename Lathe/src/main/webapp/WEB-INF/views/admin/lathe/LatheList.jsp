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

    <%--<%@ include file="LatheFilter.jsp" %>--%>


    <form:form
            class="formBox"
            action="${pageContext.servletContext.contextPath}/admin/lathe/update-lathe-list?${_csrf.parameterName}=${_csrf.token}"
            method="post"
            modelAttribute="latheListForm">
        <fieldset>

            <div class="btn-submit"><!-- Submit form -->
                <input type="submit" value="Update" class="button"/>
            </div>

            <!-- table -->
            <table class="tab tab-drag">
                <c:forEach var="tire" items="${latheListForm.latheList}" varStatus="status">
                    <tr>

                        <input type="hidden" name="latheList[${status.index}].id" value="${lathe.id}"/>

                        <td class="action">
                            <a href="${pageContext.servletContext.contextPath}/admin/lathes/remove-lathe?id=${lathe.id}"
                               class="ico ico-delete">Delete</a>
                        </td>
                        <td>
                            <%--<img src="${appProperties['content.images.url']}/${lathe.image.fileName}"--%>
                                 <%--width="128" height="128">--%>
                                <img src="${appProperties['content.images.url']}/MillTap_700_1.jpg"
                                     width="128" height="128">
                        </td>

                        <td>
                            <div class="form-cols">

                                <div class="col1">

                                    <!-- name -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="lathe-name-id"><spring:message
                                                    code="model.name"/></label>
                                        </div>
                                        <div class="con">
                                            <form:input class="input"
                                                        id="lathe-name-id"
                                                        path="latheList[${status.index}].model"/>
                                        </div>
                                    </div>
                                    <!-- /name -->

                                    <!-- price -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="lathe-price-id"><spring:message
                                                    code="price"/></label>
                                        </div>
                                        <div class="con">
                                            <form:input class="input"
                                                        type="number"
                                                        id="lathe-price-id"
                                                        path="latheList[${status.index}].price"
                                                        min="${defProperties['lathe.price.min.default']}"
                                                        max="${defProperties['lathe.price.max.default']}"
                                                        step="${defProperties['lathe.price.step.default']}"/>
                                        </div>
                                    </div>
                                    <!-- /price -->

                                    <%--<!-- in stock -->--%>
                                    <%--<div class="clearfix">--%>
                                        <%--<div class="lab">--%>
                                            <%--<label for="lathe-instock-id"><spring:message--%>
                                                    <%--code="in_stock"/></label>--%>
                                        <%--</div>--%>
                                        <%--<div class="con">--%>
                                            <%--<form:input class="input"--%>
                                                        <%--type="number"--%>
                                                        <%--id="lathe-instock-id"--%>
                                                        <%--path="latheList[${status.index}].inStock"--%>
                                                        <%--min="${defProperties['lathe.in_stock.min.default']}"--%>
                                                        <%--max="${defProperties['lathe.in_stock.max.default']}"--%>
                                                        <%--step="${defProperties['lathe.in_stock.step.default']}"/>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<!-- /in stock -->--%>

                                    <%--<!-- image -->--%>
                                    <%--<div class="clearfix">--%>
                                        <%--<div class="lab">--%>
                                            <%--<label for="lathe-image-${status.index}-id">--%>
                                                <%--<spring:message code="img"/>--%>
                                            <%--</label>--%>
                                        <%--</div>--%>
                                        <%--<div class="con">--%>

                                            <%--<form:select class="select"--%>
                                                         <%--path="latheList[${status.index}].image"--%>
                                                         <%--id="lathe-image-${status.index}-id"--%>
                                                         <%--items="${imageList}"/>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<!-- /image -->--%>

                                    <%--<!-- brand -->--%>
                                    <%--<div class="clearfix">--%>
                                        <%--<div class="lab">--%>
                                            <%--<label for="lathe-brand-${status.index}-id">--%>
                                                <%--<spring:message code="brand"/>--%>
                                            <%--</label>--%>
                                        <%--</div>--%>
                                        <%--<div class="con">--%>
                                            <%--<form:select class="select"--%>
                                                         <%--path="latheList[${status.index}].brand"--%>
                                                         <%--id="lathe-brand-${status.index}-id"--%>
                                                         <%--items="${brandList}"/>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<!-- /brand -->--%>

                                    <!-- type -->
                                    <div class="clearfix">
                                        <div class="lab">
                                            <label for="lathe-type-${status.index}-id">
                                                <spring:message code="type"/>
                                            </label>
                                        </div>
                                        <div class="con">
                                            <form:select class="select"
                                                         path="latheList[${status.index}].type"
                                                         id="lathe-type-${status.index}-id"
                                                         items="${typeList}"/>
                                        </div>
                                    </div>
                                    <!-- /type -->

                                </div>

                                <div class="col2">

                                    <%--<!-- width -->--%>
                                    <%--<div class="clearfix">--%>
                                        <%--<div class="lab">--%>
                                            <%--<label for="lathe-width-${status.index}-id">--%>
                                                <%--<spring:message code="width"/>--%>
                                            <%--</label>--%>
                                        <%--</div>--%>
                                        <%--<div class="con">--%>
                                            <%--<form:input class="input"--%>
                                                        <%--path="latheList[${status.index}].width"--%>
                                                        <%--id="lathe-width-${status.index}-id"--%>
                                                        <%--min="${defProperties['lathe.width.min.default']}"--%>
                                                        <%--max="${defProperties['lathe.width.max.default']}"--%>
                                                        <%--step="${defProperties['lathe.width.step.default']}"--%>
                                                        <%--autocomplete="off"--%>
                                                        <%--list="width-list-id"/>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<!-- /width -->--%>

                                    <%--<!-- /profile -->--%>
                                    <%--<div class="clearfix">--%>
                                        <%--<div class="lab">--%>
                                            <%--<label for="lathe-profile-${status.index}-id">--%>
                                                <%--<spring:message code="profile"/>--%>
                                            <%--</label>--%>
                                        <%--</div>--%>
                                        <%--<div class="con">--%>
                                            <%--<form:input class="input"--%>
                                                        <%--path="latheList[${status.index}].profile"--%>
                                                        <%--id="lathe-profile-${status.index}-id"--%>
                                                        <%--min="${defProperties['lathe.profile.min.default']}"--%>
                                                        <%--max="${defProperties['lathe.profile.max.default']}"--%>
                                                        <%--step="${defProperties['lathe.profile.step.default']}"--%>
                                                        <%--autocomplete="off"--%>
                                                        <%--list="profile-list-id"/>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<!-- /profile -->--%>

                                    <%--<!-- diameter -->--%>
                                    <%--<div class="clearfix">--%>
                                        <%--<div class="lab">--%>
                                            <%--<label for="lathe-diameter-${status.index}-id">--%>
                                                <%--<spring:message code="diameter"/>--%>
                                            <%--</label>--%>
                                        <%--</div>--%>
                                        <%--<div class="con">--%>
                                            <%--<form:input class="input"--%>
                                                        <%--path="latheList[${status.index}].diameter"--%>
                                                        <%--id="lathe-diameter-${status.index}-id"--%>
                                                        <%--min="${defProperties['lathe.diameter.min.default']}"--%>
                                                        <%--max="${defProperties['lathe.diameter.max.default']}"--%>
                                                        <%--step="${defProperties['lathe.diameter.step.default']}"--%>
                                                        <%--autocomplete="off"--%>
                                                        <%--list="diameter-list-id"/>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<!-- /diameter -->--%>

                                    <%--<!-- description -->--%>
                                    <%--<div class="clearfix">--%>
                                        <%--<div class="lab">--%>
                                            <%--<label for="lathe-description-id"><spring:message--%>
                                                    <%--code="description"/></label>--%>
                                        <%--</div>--%>
                                        <%--<div class="con">--%>
                                            <%--<form:textarea class="textarea"--%>
                                                           <%--id="lathe-description-id"--%>
                                                           <%--path="latheList[${status.index}].description"--%>
                                                           <%--cols="" rows="10"--%>
                                                           <%--maxlength="1024"/>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<!-- /description -->--%>

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
    <%@ include file="LathePagination.jsp" %>
    <!-- /pagination -->
</div>
<!-- /box -->