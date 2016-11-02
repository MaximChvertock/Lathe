/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.order.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.order.CustomerOrderTireDao;
import by.chvertock.lathe.model.entities.order.CustomerOrderTire;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerOrderTireDaoImpl implements CustomerOrderTireDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addOrderTire(CustomerOrderTire tire) {
        try {
            sessionFactory.getCurrentSession().save(tire);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void removeOrderTire(CustomerOrderTire tire) {
        try {
            sessionFactory.getCurrentSession().delete(tire);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
