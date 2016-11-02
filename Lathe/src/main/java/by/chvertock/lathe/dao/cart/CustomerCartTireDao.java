/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.cart;

import by.chvertock.lathe.model.entities.cart.CustomerCartTire;

public interface CustomerCartTireDao {
    void addCartTire(CustomerCartTire tire);
    void removeCartTire(CustomerCartTire tire);
}
