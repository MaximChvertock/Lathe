/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.cart;

import by.chvertock.lathe.model.entities.cart.CustomerCart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class ShowCustomerCartController {

//    @Autowired
//    private CustomerCartService cartService;

    @RequestMapping(value = "shop/cart")
    public String cart(
            @ModelAttribute("customerCart") CustomerCart customerCart
    ) {
        if (customerCart.getTires().isEmpty()) {
            return "redirect:/shop";
        }

        return "shop/cart/CustomerCartPage";
    }

//    @ModelAttribute("customerCart")
//    private CustomerCart getCustomerCart(){
////        CustomerCart cart = new CustomerCart();
////        return cart;
//        return cartService.newCart();
//    }
}
