/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.order;


import by.chvertock.lathe.dao.order.CustomerOrderDao;
import by.chvertock.lathe.model.beans.order.CustomerOrderFilter;
import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.cart.CustomerCartTire;
import by.chvertock.lathe.model.entities.order.CustomerInfo;
import by.chvertock.lathe.model.entities.order.CustomerOrder;
import by.chvertock.lathe.model.entities.order.CustomerOrderStatus;
import by.chvertock.lathe.model.entities.order.CustomerOrderTire;
import by.chvertock.lathe.model.entities.tire.Tire;
import by.chvertock.lathe.model.entities.user.User;
import by.chvertock.lathe.service.tire.TireService;
import by.chvertock.lathe.util.GeneratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Transactional
    public void addOrder(CustomerOrder order) {
        customerOrderDao.addOrder(order);
    }

    @Transactional
    public void updateOrder(CustomerOrder order) {
        customerOrderDao.updateOrder(order);
    }

    @Transactional
    public List<CustomerOrder> getOrders() {
        return customerOrderDao.getOrders();
    }

    @Transactional
    public CustomerOrder getOrderById(long id) {
        return customerOrderDao.getOrderById(id);
    }

    @Transactional
    public CustomerOrder getOrderByCustomer(User user) {
        return customerOrderDao.getOrderByCustomer(user);
    }

    @Transactional
    public CustomerOrder getOrderByIdentificator(String identificator) {
        return customerOrderDao.getOrderByIdentificator(identificator);
    }

    @Transactional
    public List<CustomerOrder> getOrders(CustomerOrderFilter filter, TireService.Page page) {
        if (filter == null) {
            if (page == null) {
                return customerOrderDao.getOrders();
            }
            return customerOrderDao.getOrders(page.getFirstResult(), page.getMaxResults());
        }
        return customerOrderDao.getOrders(filter, page.getFirstResult(), page.getMaxResults());
    }

    @Transactional
    public List<CustomerOrder> getOrers(TireService.Page page) {
        return customerOrderDao.getOrders(page.getFirstResult(), page.getMaxResults());
    }

    @Transactional
    public long getOrderCount() {
        return customerOrderDao.getOrderCount();
    }

    @Transactional
    public long getOrderCount(CustomerOrderFilter filter) {
        return customerOrderDao.getOrderCount(filter);
    }
    @Transactional
    public void removeOrder(CustomerOrder order) {
        customerOrderDao.removeOrder(order);
    }

    @Transactional
    public String addCartAsOrder(CustomerCart cart, CustomerInfo info) {

//        System.out.println("cart:" + cart);
//        System.out.println("info:" + info);

        // prepare unique identificator
        String identificator = GeneratorUtils.getUniqueId();

        CustomerOrder order = new CustomerOrder();

        // apply order status
        order.setStatus(new CustomerOrderStatus());

        // CustomerCartTire set to CustomerOrderTire set
        Set<CustomerCartTire> cartTires = cart.getTires();
        Set<CustomerOrderTire> orderTires = new HashSet<CustomerOrderTire>();
        for (CustomerCartTire cartTire : cartTires) {
            Tire tire = cartTire.getTire();
            int quantity = cartTire.getQuantity();

            CustomerOrderTire orderTire = new CustomerOrderTire(tire, quantity);

            orderTires.add(orderTire);
        }
        // and apply it
        order.setTires(orderTires);

        order.setIdentificator(identificator);

        order.setCustomerInfo(info);

        // add current date
        order.setDate(new Date());

        // save to persistent storage
        addOrder(order);
//        System.out.println(order);

        return identificator;
    }
}
