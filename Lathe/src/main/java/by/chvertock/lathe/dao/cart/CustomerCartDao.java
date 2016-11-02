/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.cart;

import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.user.User;

import java.util.List;

public interface CustomerCartDao {
    void addCart(CustomerCart cart);
    void updateCart(CustomerCart cart);

    List<CustomerCart> getCarts();
    CustomerCart getCartByCustomer(User user);

    void removeCart(CustomerCart cart);
}
