/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.order;

import by.chvertock.lathe.model.entities.order.CustomerOrderTire;

public interface CustomerOrderTireDao {
    void addOrderTire(CustomerOrderTire tire);
    void removeOrderTire(CustomerOrderTire tire);
}
