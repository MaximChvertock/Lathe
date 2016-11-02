/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.interceptor;

import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.user.User;
import by.chvertock.lathe.service.cart.CustomerCartService;
import by.chvertock.lathe.web.controllers.util.AuthenticationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyCustomerCartInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AuthenticationUtils authenticationUtils;

    @Autowired
    private CustomerCartService cartService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        System.out.println(request.getPathInfo());

        HttpSession session = request.getSession();
        CustomerCart cart = null;

        if (authenticationUtils.isUserAuthenticated()) {
            User user = authenticationUtils.getAuthenticatedUser();
            cart = cartService.getCartByCustomer(user);

            if (cart == null) {
                cart = new CustomerCart();
                cart.setCustomer(user);

                // add cart to storage
                cartService.addCart(cart);
            }
        } else {
            cart = (CustomerCart) session.getAttribute("customerCart");
            if (cart == null) {
                cart = new CustomerCart();
            }
        }

        session.setAttribute("customerCart", cart);

        return super.preHandle(request, response, handler);
    }
}
