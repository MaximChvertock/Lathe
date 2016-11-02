/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.order;

import by.chvertock.lathe.exceptions.ApplicationException;
import by.chvertock.lathe.model.beans.CustomerInfoValidator;
import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.order.CustomerInfo;
import by.chvertock.lathe.service.MailSender;
import by.chvertock.lathe.service.order.CustomerOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes(
        value = {
                "customerCart",
                "customerInfo"
        },
        types = {
                CustomerCart.class,
                CustomerInfo.class
        }
)
public class CheckoutController {

    private static final Logger logger = Logger.getLogger(CheckoutController.class);

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CustomerInfoValidator customerInfoValidator;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MailSender mailSender;

    @InitBinder("customerInfo")
    protected void initCustomerInfoBinder(WebDataBinder binder) {
        binder.setValidator(customerInfoValidator);
    }

    @RequestMapping(value = "/shop/tires/checkout")
    public String test(
            @ModelAttribute("customerCart") CustomerCart customerCart
    ) {

        try {
            if (customerCart.getTires().isEmpty()) {
                return "redirect:/shop";
            }

            return "shop/tire/TireCheckoutPage";
        } catch (ApplicationException e) {
            logger.error("Can't show checkout page", e);
        }

        return "404";
    }

    @RequestMapping(value = "shop/tires/checkout/place-order")
    public ModelAndView placeOrder(
            @ModelAttribute("customerInfo") @Valid CustomerInfo info, BindingResult result,
            @ModelAttribute("customerCart") CustomerCart cart,
            final RedirectAttributes redirectAttributes
    ) {

        // check errors
        if (result.hasErrors()) {
            for (Object object : result.getAllErrors()) {
                if (object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;

                    String field = fieldError.getField();
                    String message = messageSource.getMessage(fieldError, null);

                    redirectAttributes.addFlashAttribute(field + "Error", message);
                }
            }

            return new ModelAndView("redirect:/shop/tires/checkout");
        }

        try {
            String identificator = customerOrderService.addCartAsOrder(cart, info);

            redirectAttributes.addFlashAttribute("identificator", identificator);
            redirectAttributes.addFlashAttribute("email", info.getEmail());

            // send email to customer
            String msg = "Your order is placed. Order ID: " + identificator;
            mailSender.send(info.getEmail(), "Tire shop order: " + identificator, msg);

            return new ModelAndView("redirect:/shop/tires/order");
        } catch (ApplicationException e) {
            logger.error("Can't place order", e);
        }

        return new ModelAndView("404");
    }

    @ModelAttribute("customerInfo")
    private CustomerInfo getCustomerInfo() {
        return new CustomerInfo();
    }
}
