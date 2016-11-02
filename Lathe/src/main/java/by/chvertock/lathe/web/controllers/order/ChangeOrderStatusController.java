/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.order;

import by.chvertock.lathe.exceptions.ApplicationException;
import by.chvertock.lathe.model.entities.order.CustomerOrder;
import by.chvertock.lathe.model.entities.order.CustomerOrderStatus;
import by.chvertock.lathe.model.entities.order.StatusType;
import by.chvertock.lathe.service.order.CustomerOrderService;
import by.chvertock.lathe.service.order.CustomerOrderStatusService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeOrderStatusController {

    private static final Logger logger = Logger.getLogger(ChangeOrderStatusController.class);

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CustomerOrderStatusService customerOrderStatusService;


    @RequestMapping(value = "admin/tires/orders/set-processed")
    public String setProcessed(
            @RequestParam("order-id") Long orderId
    ) {
        try {

            System.out.println(orderId);

            CustomerOrder order = customerOrderService.getOrderById(orderId);

            CustomerOrderStatus status = customerOrderStatusService.getStatusByType(StatusType.ORDER_IS_PROCESSED);

            order.setStatus(status);

            customerOrderService.updateOrder(order);

            System.out.println(order);
        } catch (ApplicationException e) {
            logger.error("Can't change customer order status", e);
        }

        return "redirect:/admin/tires/orders";
    }
}
