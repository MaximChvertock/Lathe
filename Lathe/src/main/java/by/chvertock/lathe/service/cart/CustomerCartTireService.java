/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.cart;

import by.chvertock.lathe.dao.cart.CustomerCartTireDao;
import by.chvertock.lathe.model.entities.cart.CustomerCartTire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerCartTireService {

    @Autowired
    private CustomerCartTireDao customerCartTireDao;

    @Transactional
    public void addCartTire(CustomerCartTire cartTire){
        customerCartTireDao.addCartTire(cartTire);
    }

    @Transactional
    public void removeCartTire(CustomerCartTire cartTire){
        customerCartTireDao.removeCartTire(cartTire);
    }
}
