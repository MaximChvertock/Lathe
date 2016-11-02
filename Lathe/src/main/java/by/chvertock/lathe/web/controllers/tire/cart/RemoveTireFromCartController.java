/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.cart;

import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.tire.Tire;
import by.chvertock.lathe.service.cart.CustomerCartService;
import by.chvertock.lathe.service.tire.TireService;
import by.chvertock.lathe.web.controllers.tire.RemoveTireController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(
        value = {
                "customerCart"
        },
        types = {
                CustomerCart.class
        }
)
public class RemoveTireFromCartController {

    private static final Logger logger = Logger.getLogger(RemoveTireController.class);

    @Autowired
    private TireService tireService;

    @Autowired
    private CustomerCartService cartService;

    @RequestMapping("shop/tires/remove-from-cart")
    public String add(
            @RequestParam(value = "tire-id") Long tireId,
            @RequestParam(value = "redirect", required = false, defaultValue = "shop/tires") String redirect,
            @ModelAttribute("customerCart") CustomerCart customerCart
    ) {
        try {
            Tire tire = tireService.getTireById(tireId);


            // decrease or remove tire from cart
            cartService.decCartTire(customerCart, tire);

//            customerCart.removeTire(tire);
//
//            cartService.addCart(customerCart);
        } catch (Exception e) {
            logger.error("Can't remove tire from customer cart", e);
        }

        return "redirect:/" + redirect;
    }
}
