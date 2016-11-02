/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.order;

import by.chvertock.lathe.exceptions.ApplicationException;
import by.chvertock.lathe.model.entities.order.CustomerOrder;
import by.chvertock.lathe.service.order.CustomerOrderService;
import by.chvertock.lathe.util.StringUtils;
import by.chvertock.lathe.web.controllers.util.RegExpUtils;
import org.apache.commons.validator.routines.RegexValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerOrderController {

    private static final Logger logger = Logger.getLogger(CustomerOrderController.class);


    private RegexValidator emailValidator = new RegexValidator(RegExpUtils.PATTERN_EMAIL);

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping(value = "/shop/tires/check-order")
    public String showCheckPage() {
        return "shop/order/TireCheckOrderPage";
    }

    @RequestMapping(value = "/shop/tires/order")
    public ModelAndView showOrder(
            @ModelAttribute("identificator") String identificator,
            @ModelAttribute("email") String email,
            final RedirectAttributes redirectAttributes
    ) {

//        System.out.println(identificator);
//        System.out.println(email);

        if (!isValid(identificator, email, redirectAttributes)) {
            return new ModelAndView("redirect:/shop/tires/check-order");
        }

        try {
            CustomerOrder order = customerOrderService.getOrderByIdentificator(identificator);

            return new ModelAndView("shop/order/CustomerOrderPage", "order", order);
        } catch (ApplicationException e) {
            logger.error("Can't get order for identificator=" + identificator, e);
        }

        return new ModelAndView("404");
    }

    private boolean isValid(String identificator, String email, RedirectAttributes redirectAttributes) {
        boolean result = true;

        if (!emailValidator.isValid(email)) {
            redirectAttributes.addFlashAttribute("emailError", "Invalid email format");
            result = false;
        }

        if (StringUtils.isBlank(email)) {
            redirectAttributes.addFlashAttribute("emailError", "Email is required");
            result = false;
        }

        if (StringUtils.isBlank(identificator)) {
            redirectAttributes.addFlashAttribute("identificatorError", "Identificator is required");
            result = false;
        }

        CustomerOrder order = customerOrderService.getOrderByIdentificator(identificator);
        if (!order.getCustomerInfo().getEmail().equals(email)) {
            redirectAttributes.addAttribute("check-order", "check-order").addFlashAttribute("orderNotFoundError", "Order not found. Please, check your identificator adn email");
            result = false;
        }

        return result;
    }
}
