/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.order;


import by.chvertock.lathe.model.beans.order.CustomerOrderFilter;
import by.chvertock.lathe.model.entities.order.CustomerOrder;
import by.chvertock.lathe.model.entities.user.User;

import java.util.List;

public interface CustomerOrderDao {
    void addOrder(CustomerOrder order);
    void updateOrder(CustomerOrder order);

    List<CustomerOrder> getOrders();
    CustomerOrder getOrderByCustomer(User user);


    List<CustomerOrder> getOrders(int first, int count);

    List<CustomerOrder> getOrders(CustomerOrderFilter filter, int first, int count);

    long getOrderCount(CustomerOrderFilter filter);
    long getOrderCount();

    CustomerOrder getOrderByIdentificator(String identificator);

    void removeOrder(CustomerOrder order);

    CustomerOrder getOrderById(long id);
}
