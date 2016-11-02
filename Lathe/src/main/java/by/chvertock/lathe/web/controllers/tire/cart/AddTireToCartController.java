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
public class AddTireToCartController {

    private static final Logger logger = Logger.getLogger(RemoveTireController.class);

    @Autowired
    private TireService tireService;

    @Autowired
    private CustomerCartService cartService;

    @RequestMapping("shop/tires/add-to-cart")
    public String add(
            @RequestParam(value = "tire-id") Long tireId,
            @RequestParam(value = "redirect", required = false, defaultValue = "shop/tires") String redirect,
            @ModelAttribute("customerCart") CustomerCart customerCart
    ) {
        try {
            Tire tire = tireService.getTireById(tireId);

            // increase or add new tire to cart
            cartService.incCartTire(customerCart, tire, 1);


//            customerCart.addTire(tire);

//            System.out.println(customerCart);

//            cartService.addCart(customerCart);
        } catch (Exception e) {
            logger.error("Can't add tire to customer cart", e);
        }

        return "redirect:/" + redirect;
    }
}
