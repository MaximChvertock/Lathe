/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.cart;


import by.chvertock.lathe.dao.cart.CustomerCartDao;
import by.chvertock.lathe.dao.cart.CustomerCartTireDao;
import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.cart.CustomerCartTire;
import by.chvertock.lathe.model.entities.tire.Tire;
import by.chvertock.lathe.model.entities.user.User;
import by.chvertock.lathe.service.cart.exceptions.CustomerCartTireNotFound;
import by.chvertock.lathe.web.controllers.util.AuthenticationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CustomerCartService {

    @Autowired
    private CustomerCartDao customerCartDao;

    @Autowired
    private CustomerCartTireDao customerCartTireDao;

    @Autowired
    private AuthenticationUtils authenticationUtils;

    @Transactional
    public void addCart(CustomerCart cart) {
        customerCartDao.addCart(cart);
    }

    @Transactional
    public void updateCart(CustomerCart cart) {
        customerCartDao.updateCart(cart);
    }

    @Transactional
    public List<CustomerCart> getCarts() {
        return customerCartDao.getCarts();
    }

    @Transactional
    public CustomerCart getCartByCustomer(User user) {
        return customerCartDao.getCartByCustomer(user);
    }

    @Transactional
    public void removeCart(CustomerCart cart) {
        customerCartDao.removeCart(cart);
    }

    @Transactional
    public void incCartTire(CustomerCart cart, Tire tire) {
        incCartTire(cart, tire, 1);
    }

    @Transactional
    public void incCartTire(CustomerCart cart, Tire tire, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity=" + quantity + " is not positive");
        }

        CustomerCartTire cartTire;
        try {
            cartTire = getCartTire(cart, tire);
        } catch (CustomerCartTireNotFound e) {
            // cart tire not found in cart
            // create new
            cartTire = new CustomerCartTire(tire, 0);
        }

        int cartTireQuantity = cartTire.getQuantity();

        cartTireQuantity += quantity;

        cartTire.setQuantity(cartTireQuantity);

        // update cart tire in cart
        cart.addCartTire(cartTire);

        // update cart in persistent storage
        if (cart.getCustomer() != null) {
            updateCart(cart);
        }
    }

    @Transactional
    public void decCartTire(CustomerCart cart, Tire tire) {
        CustomerCartTire cartTire = getCartTire(cart, tire);

        int quantity = cartTire.getQuantity();

        --quantity;

        cartTire.setQuantity(quantity);

        System.out.println("quantity: " + quantity);
        if (quantity <= 0) {

            // remove cart tire from persistent storage
            if (cart.getCustomer() != null) {
                customerCartTireDao.removeCartTire(cartTire);
            }

            // remove cart tire from cart
            cart.removeCartTire(cartTire);

            return;
        }

        // update cart tire in cart
        cart.addCartTire(cartTire);

        // update cart in persistent storage
        if (cart.getCustomer() != null) {
            updateCart(cart);
        }
    }

    public CustomerCartTire getCartTire(CustomerCart cart, Tire tire) {

        // get tire list from cart to local variable
        // cart.getTires() must be thread safe
        Set<CustomerCartTire> tires = cart.getTires();


        Iterator<CustomerCartTire> iterator = tires.iterator();
        while (iterator.hasNext()) {
            CustomerCartTire cartTire = iterator.next();
            if (cartTire.getTire().equals(tire)) {
                return cartTire;
            }
        }

        throw new CustomerCartTireNotFound("Not found " + tire + " in " + cart);
    }

//    @Transactional
//    public CustomerCart newCart() {
//        if (authenticationUtils.isUserAuthenticated()) {
//            User user = authenticationUtils.getAuthenticatedUser();
//            if (user != null) {
//                CustomerCart cart = getCartByCustomer(user);
//                if (cart != null) {
//                    return cart;
//                }
//            }
//        }
//
//        return new CustomerCart();
//    }

//    @Transactional
//    public void saveCart(CustomerCart cart) {
//
//        if (cart.getCustomer() == null && authenticationUtils.isUserAuthenticated()) {
//            User user = authenticationUtils.getAuthenticatedUser();
//
//            if (user != null) {
//                cart.setCustomer(user);
//
//                customerCartDao.addCart(cart);
//            }
//        }
//
//        System.out.println(cart);
//    }
}
