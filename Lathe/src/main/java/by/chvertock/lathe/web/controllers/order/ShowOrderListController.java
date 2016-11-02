/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.order;

import by.chvertock.lathe.exceptions.ApplicationException;
import by.chvertock.lathe.model.beans.order.CustomerOrderFilter;
import by.chvertock.lathe.model.entities.order.CustomerOrder;
import by.chvertock.lathe.model.entities.order.CustomerOrderStatus;
import by.chvertock.lathe.model.entities.order.StatusType;
import by.chvertock.lathe.service.order.CustomerOrderService;
import by.chvertock.lathe.service.order.CustomerOrderStatusService;
import by.chvertock.lathe.service.tire.TireService;
import by.chvertock.lathe.web.controllers.util.PaginationUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@SessionAttributes(
        value = {
                "orderFilter"
        },
        types = {
                CustomerOrderFilter.class,
        }
)
public class ShowOrderListController {

    private static final Logger logger = Logger.getLogger(ShowOrderListController.class);

    private static final int PAGE_SIZE = 10;
    private static final int PAGE_RADIUS = 2;

    @Autowired
    private CustomerOrderService customerOrderService;


    @Autowired
    private CustomerOrderStatusService customerOrderStatusService;

    @RequestMapping(value = "admin/tires/orders")
    public ModelAndView show(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @Valid @ModelAttribute("orderFilter") CustomerOrderFilter orderFilter, BindingResult result
    ) {
        ModelAndView modelAndView = new ModelAndView("/admin/order/TireOrderListPage");

        try {

            System.out.println(orderFilter);

            prepareOrderList(modelAndView, page, orderFilter);

        } catch (ApplicationException e) {
            logger.error("Can't show tire list", e);
        }

        return modelAndView;
    }


    @RequestMapping(value = "admin/tires/not-processed-orders")
    public ModelAndView showNotProcessed(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @Valid @ModelAttribute("orderFilter") CustomerOrderFilter orderFilter, BindingResult result
    ) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/tires/orders");

        try {

            CustomerOrderStatus status = customerOrderStatusService.getStatusByType(StatusType.ORDER_IS_NOT_PROCESSED);
            orderFilter.setStatus(status);

        } catch (ApplicationException e) {
            logger.error("Can't show tire list", e);
        }

        return modelAndView;
    }

    @RequestMapping(value = "admin/tires/processed-orders")
    public ModelAndView showProcessed(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @Valid @ModelAttribute("orderFilter") CustomerOrderFilter orderFilter, BindingResult result
    ) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/tires/orders");

        try {

            CustomerOrderStatus status = customerOrderStatusService.getStatusByType(StatusType.ORDER_IS_PROCESSED);
            orderFilter.setStatus(status);

        } catch (ApplicationException e) {
            logger.error("Can't show tire list", e);
        }

        return modelAndView;
    }

    private void prepareOrderList(ModelAndView modelAndView, int page, CustomerOrderFilter orderFilter) {
        List<CustomerOrder> orderList = customerOrderService.getOrders(orderFilter, new TireService.Page(page, PAGE_SIZE));

        int count = (int) customerOrderService.getOrderCount(orderFilter);

        List<Integer> pageList = PaginationUtils.getPageList(page, PAGE_RADIUS, PAGE_SIZE, count);

        int lastPage = PaginationUtils.getLastPage(count, PAGE_SIZE);

        modelAndView.addObject("orderList", orderList);
        modelAndView.addObject("pageList", pageList);
        modelAndView.addObject("activePage", page);
        modelAndView.addObject("lastPage", lastPage);

    }

    @ModelAttribute("orderFilter")
    private CustomerOrderFilter getFilter() {
        CustomerOrderFilter filter = new CustomerOrderFilter();
        filter.setStatus(customerOrderStatusService.getStatusByType(StatusType.ORDER_IS_NOT_PROCESSED));
        return filter;
    }
}
