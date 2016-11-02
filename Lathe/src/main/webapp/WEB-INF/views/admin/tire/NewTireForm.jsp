<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>


<!-- HELP WINDOW -->
<div id="help" class="modal-window">

    <h2>Example help window</h2>

    <p>Suspendisse et ante vitae turpis vestibulum fermentum nec nec elit. Suspendisse ullamcorper lacus in arcu mollis
        fringilla porta mi placerat. Ut at elit non diam tristique scelerisque. </p>

    <ul class="list list-square">
        <li><strong>Lorem ipsum</strong> dolor sit amet</li>
        <li><strong>consectetur adipiscing</strong> elit phasellus et risus</li>
        <li><strong>Maecenas non</strong> nunc proin eleifend viverra sapien</li>
    </ul>

</div>

<!-- box -->
<div class="box">
    <div class="headlines">
        <h2><span><spring:message code="form.tire.new.title"/></span></h2>
        <a href="#help" class="help"></a>
    </div>

    <!-- box-content -->
    <div class="box-content">

        <!-- formbox -->
        <form:form class="formBox"
                   action="${pageContext.servletContext.contextPath}/admin/tires/add-new-tire?${_csrf.parameterName}=${_csrf.token}"
                   method="post"
                   modelAttribute="newTire">
            <fieldset>

                <!-- form-cols -->
                <div class="form-cols">

                    <!-- Error form message -->
                    <c:if test="${not empty addNewTireErrorHolder and addNewTireErrorHolder.hasErrors()}">
                        <div class="form-message error">
                            <p><spring:message
                                    code="form.tire.new.error.caption"/></p>
                            <ul>
                                <c:forEach var="error" items="${addNewTireErrorHolder.errors}">
                                    <li>
                                        <c:out value="${error}"/>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>

                    <div class="col1">

                        <!-- name -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-name-id"><spring:message
                                        code="form.tire.new.name"/></label>
                            </div>
                            <div class="con">
                                <input type="text" class="input"
                                       value="${newTire.name}"
                                       name="name"
                                       id="tire-new-name-id"/>
                            </div>
                        </div>
                        <!-- /name -->

                        <!-- price -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-price-id"><spring:message
                                        code="form.tire.new.price"/></label>
                            </div>
                            <div class="con">
                                <form:input type="number"
                                            class="input"
                                            path="price"
                                            id="tire-new-price-id"
                                            min="${defProperties['tire.price.min.default']}"
                                            max="${defProperties['tire.price.max.default']}"
                                            step="${defProperties['tire.price.step.default']}"/>
                            </div>
                        </div>
                        <!-- /price -->

                        <!-- in stock -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-instock-id"><spring:message
                                        code="form.tire.new.in_stock"/></label>
                            </div>
                            <div class="con">
                                <form:input type="number"
                                            class="input"
                                            path="inStock"
                                            id="tire-new-instock-id"
                                            min="${defProperties['tire.in_stock.min.default']}"
                                            max="${defProperties['tire.in_stock.max.default']}"
                                            step="${defProperties['tire.in_stock.step.default']}"/>
                            </div>
                        </div>
                        <!-- /in stock -->

                        <!-- image -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-image-id">
                                    <spring:message code="form.tire.new.image"/>
                                </label>
                            </div>
                            <div class="con">
                                <form:select class="select"
                                             path="image"
                                             id="tire-new-image-id"
                                             items="${imageList}"/>
                            </div>
                        </div>
                        <!-- /image -->

                        <!-- brand -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-brand-id">
                                    <spring:message code="form.tire.new.brand"/>
                                </label>
                            </div>
                            <div class="con">
                                <form:select class="select"
                                             path="brand"
                                             id="tire-new-brand-id"
                                             items="${brandList}"/>
                            </div>
                        </div>
                        <!-- /brand -->

                        <!-- type -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-type-id">
                                    <spring:message code="form.tire.new.type"/>
                                </label>
                            </div>
                            <div class="con">
                                <form:select class="select"
                                             path="type"
                                             id="tire-new-type-id"
                                             items="${typeList}"/>
                            </div>
                        </div>
                        <!-- /type -->

                    </div>

                    <div class="col2">

                        <!-- width -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-width-id">
                                    <spring:message code="form.tire.new.width"/>
                                </label>
                            </div>
                            <div class="con">
                                <form:input class="input"
                                            path="width"
                                            id="tire-new-width-id"
                                            min="${defProperties['tire.width.min.default']}"
                                            max="${defProperties['tire.width.max.default']}"
                                            step="${defProperties['tire.width.step.default']}"
                                            autocomplete="off"
                                            list="width-list-id"/>

                                <datalist id="width-list-id">
                                    <c:forEach var="width" items="${widthList}">
                                        <option value="${width.value}">${width.value}</option>
                                    </c:forEach>
                                </datalist>
                            </div>
                        </div>
                        <!-- /width -->

                        <!-- /profile -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-profile-id">
                                    <spring:message code="form.tire.new.profile"/>
                                </label>
                            </div>
                            <div class="con">
                                <form:input class="input"
                                            path="profile"
                                            id="tire-new-profile-id"
                                            min="${defProperties['tire.profile.min.default']}"
                                            max="${defProperties['tire.profile.max.default']}"
                                            step="${defProperties['tire.profile.step.default']}"
                                            autocomplete="off"
                                            list="profile-list-id"/>

                                <datalist id="profile-list-id">
                                    <c:forEach var="profile" items="${profileList}">
                                        <option value="${profile.value}">${profile.value}</option>
                                    </c:forEach>
                                </datalist>
                            </div>
                        </div>
                        <!-- /profile -->

                        <!-- diameter -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-diameter-id">
                                    <spring:message code="form.tire.new.diameter"/>
                                </label>
                            </div>
                            <div class="con">
                                <form:input class="input"
                                            path="diameter"
                                            id="tire-new-diameter-id"
                                            min="${defProperties['tire.diameter.min.default']}"
                                            max="${defProperties['tire.diameter.max.default']}"
                                            step="${defProperties['tire.diameter.step.default']}"
                                            autocomplete="off"
                                            list="diameter-list-id"/>

                                <datalist id="diameter-list-id">
                                    <c:forEach var="diameter" items="${diameterList}">
                                        <option value="${diameter.value}">${diameter.value}</option>
                                    </c:forEach>
                                </datalist>
                            </div>
                        </div>
                        <!-- /diameter -->

                        <!-- description -->
                        <div class="clearfix">
                            <div class="lab">
                                <label for="tire-new-description-id"><spring:message
                                        code="form.tire.new.description"/></label>
                            </div>
                            <div class="con">
                                <form:textarea class="textarea"
                                               id="tire-new-description-id"
                                               path="description"
                                               cols="" rows="10"
                                               maxlength="1024"/>
                                    <%--<textarea cols="" rows="10" class="textarea"--%>
                                    <%--id="tire-new-description-id"--%>
                                    <%--name="description"--%>
                                    <%--maxlength="1024">${newTire.description}</textarea>--%>
                            </div>
                        </div>
                        <!-- /description -->

                    </div>
                </div>
                <!-- /form-cols -->

                <div class="btn-submit"><!-- Submit form -->
                    <input type="submit" value="Submit form" class="button"/>
                </div>
            </fieldset>
        </form:form>
        <!-- /formbox -->
    </div>
    <!-- /box-content -->
</div>
<!-- /box -->