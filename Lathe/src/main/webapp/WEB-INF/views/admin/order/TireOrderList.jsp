<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Author: Maksim Chvertock
  ~ Copyright (c) 2016.
  --%>

<!-- box -->
<div class="box">
    <div class="headlines">
        <h2><span><spring:message code="orders"/></span></h2>
    </div>

    <div class="clearfix">
        <form action="${pageContext.servletContext.contextPath}/admin/tires/not-processed-orders">
            <input type="submit" value="show not processed" class="button"/>
        </form>
    </div>
    <div class="clearfix">
        <form action="${pageContext.servletContext.contextPath}/admin/tires/processed-orders">
            <input type="submit" value="show processed" class="button"/>
        </form>
    </div>

    <form class="formBox">

        <!-- table -->
        <table class="tab tab-drag">
            <c:forEach var="order" items="${orderList}" varStatus="status">
                <tr>
                    <td>
                        <div class="form-cols">

                            <div class="col1">

                                <!-- identificator -->
                                <div class="clearfix">
                                    <div class="lab">
                                        <label for="order-identificator-${order.id}-id"><spring:message
                                                code="identificator"/></label>
                                    </div>
                                    <div>
                                        <span id="order-identificator-${order.id}-id">${order.identificator}</span>
                                            <%--<form:input class="input"--%>
                                            <%--id="tire-name-id"--%>
                                            <%--path="tireList[${status.index}].name"/>--%>
                                    </div>
                                </div>
                                <!-- /identificator -->

                                <!-- status -->
                                <div class="clearfix">
                                    <div class="lab">
                                        <label for="order-status-${order.id}-id"><spring:message
                                                code="status"/></label>
                                    </div>
                                    <div>
                                        <span id="order-status-${order.id}-id">${order.status}</span>

                                        <c:if test="${order.status == 'ORDER_IS_NOT_PROCESSED'}">
                                            <a class="button"
                                               href="${pageContext.servletContext.contextPath}/admin/tires/orders/set-processed?order-id=${order.id}"><spring:message
                                                    code="change_to_processed"/> </a>
                                        </c:if>

                                            <%--<form action="${pageContext.servletContext.contextPath}/admin/tires/orders/set-processed?order-id=${order.id}">--%>
                                            <%--<input type="submit" value="Processed" class="button"/>--%>
                                            <%--</form>--%>
                                            <%--<form:input class="input"--%>
                                            <%--id="tire-name-id"--%>
                                            <%--path="tireList[${status.index}].name"/>--%>
                                    </div>
                                </div>
                                <!-- /status -->

                                <!-- date -->
                                <div class="clearfix">
                                    <div class="lab">
                                        <label for="order-date-${order.id}-id"><spring:message
                                                code="order_date"/></label>
                                    </div>
                                    <div>
                                        <span id="order-date-${order.id}-id">${order.date}</span>
                                            <%--<form:input class="input"--%>
                                            <%--type="number"--%>
                                            <%--id="tire-price-id"--%>
                                            <%--path="tireList[${status.index}].price"--%>
                                            <%--min="${defProperties['tire.price.min.default']}"--%>
                                            <%--max="${defProperties['tire.price.max.default']}"--%>
                                            <%--step="${defProperties['tire.price.step.default']}"/>--%>
                                    </div>
                                </div>
                                <!-- /date -->

                                <!-- customer -->
                                <div class="clearfix">
                                    <div class="lab">
                                        <label for="order-customer-${order.id}-id"><spring:message
                                                code="customer"/></label>
                                    </div>
                                    <div>
                                        <span id="order-customer-${order.id}-id">${order.customerInfo.firstName} ${order.customerInfo.lastName}</span>
                                            <%--<form:input class="input"--%>
                                            <%--type="number"--%>
                                            <%--id="tire-instock-id"--%>
                                            <%--path="tireList[${status.index}].inStock"--%>
                                            <%--min="${defProperties['tire.in_stock.min.default']}"--%>
                                            <%--max="${defProperties['tire.in_stock.max.default']}"--%>
                                            <%--step="${defProperties['tire.in_stock.step.default']}"/>--%>
                                    </div>
                                </div>
                                <!-- /customer -->


                                <!-- email -->
                                <div class="clearfix">
                                    <div class="lab">
                                        <label for="order-email-${order.id}-id">
                                            <spring:message code="email"/>
                                        </label>
                                    </div>
                                    <div>
                                        <span id="order-email-${order.id}-id">${order.customerInfo.email}</span>
                                            <%--<form:select class="select"--%>
                                            <%--path="tireList[${status.index}].type"--%>
                                            <%--id="tire-type-${status.index}-id"--%>
                                            <%--items="${typeList}"/>--%>
                                    </div>
                                </div>
                                <!-- /email -->


                                <!-- phone number -->
                                <div class="clearfix">
                                    <div class="lab">
                                        <label for="order-phone-${order.id}-id">
                                            <spring:message code="phone_number"/>
                                        </label>
                                    </div>
                                    <div>
                                        <span id="order-phone-${order.id}-id-${order.id}-id">${order.customerInfo.phoneNumber}</span>
                                            <%--<form:select class="select"--%>
                                            <%--path="tireList[${status.index}].type"--%>
                                            <%--id="tire-type-${status.index}-id"--%>
                                            <%--items="${typeList}"/>--%>
                                    </div>
                                </div>
                                <!-- /phone number -->

                                <!-- company -->
                                <div class="clearfix">
                                    <div class="lab">
                                        <label for="order-company-${order.id}-id">
                                            <spring:message code="company_name"/>
                                        </label>
                                    </div>
                                    <div>
                                        <span id="order-company-${order.id}-id">${order.customerInfo.companyName}</span>
                                            <%--<form:select class="select"--%>
                                            <%--path="tireList[${status.index}].image"--%>
                                            <%--id="tire-image-${status.index}-id"--%>
                                            <%--items="${imageList}"/>--%>
                                    </div>
                                </div>
                                <!-- /company -->

                                <!-- address -->
                                <div class="clearfix">
                                    <div class="lab">
                                        <label for="order-address-${order.id}-id">
                                            <spring:message code="address"/>
                                        </label>
                                    </div>
                                    <div>
                                        <span id="order-address-${order.id}-id">${order.customerInfo.town} ${order.customerInfo.address}</span>
                                            <%--<form:select class="select"--%>
                                            <%--path="tireList[${status.index}].brand"--%>
                                            <%--id="tire-brand-${status.index}-id"--%>
                                            <%--items="${brandList}"/>--%>
                                    </div>
                                </div>
                                <!-- /address -->

                                <!-- postcode -->
                                <div class="clearfix">
                                    <div class="lab">
                                        <label for="order-postcode-${order.id}-id">
                                            <spring:message code="postcode"/>
                                        </label>
                                    </div>
                                    <div>
                                        <span id="order-postcode-${order.id}-id">${order.customerInfo.postcode}</span>
                                            <%--<form:select class="select"--%>
                                            <%--path="tireList[${status.index}].type"--%>
                                            <%--id="tire-type-${status.index}-id"--%>
                                            <%--items="${typeList}"/>--%>
                                    </div>
                                </div>
                                <!-- /postcode -->

                            </div>

                            <div class="col2">


                                <table class="tab tab-drag">
                                    <c:forEach var="orderItem" items="${order.tires}">
                                        <tr>
                                            <td>
                                                <img src="${appProperties['content.images.url']}/${orderItem.tire.image.fileName}"
                                                     width="73" height="73">
                                            </td>

                                            <td>
                                                X ${orderItem.quantity}
                                            </td>

                                            <td>
                                                    ${orderItem.tire.name}
                                            </td>

                                            <td>
                                                    ${orderItem.tire.brand}
                                            </td>

                                            <td>
                                                    ${orderItem.tire.price}
                                            </td>
                                        </tr>


                                    </c:forEach>
                                    <tr>
                                        <!-- total price -->
                                        <div class="clearfix">
                                            <div class="lab">
                                                <label for="order-total-${order.id}-id">
                                                    <spring:message code="order.total"/>
                                                </label>
                                            </div>
                                            <div>
                                                <span id="order-total-${order.id}-id">${order.totalPrice}</span>
                                            </div>
                                        </div>
                                        <!-- /total price -->

                                    </tr>
                                </table>

                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- /table -->

    </form>
    <%--<!-- box-action -->--%>
    <%--<div class="tab-action">--%>
    <%--<select class="select">--%>
    <%--<option>Choose an action</option>--%>
    <%--</select>--%>
    <%--<input type="submit" value="Apply action" class="submit"/>--%>
    <%--</div>--%>
    <!-- /box-action -->

    <!-- pagination -->
    <%@ include file="TireOrderPagination.jsp" %>
    <!-- /pagination -->
</div>
<!-- /box -->