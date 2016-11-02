/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.cart.impl;

import by.chvertock.lathe.dao.cart.CustomerCartTireDao;
import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.cart.CustomerCartTire;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerCartTireDaoImpl implements CustomerCartTireDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartTire(CustomerCartTire tire) {
        try{
            sessionFactory.getCurrentSession().save(tire);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void removeCartTire(CustomerCartTire tire) {
        try{
            sessionFactory.getCurrentSession().delete(tire);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
