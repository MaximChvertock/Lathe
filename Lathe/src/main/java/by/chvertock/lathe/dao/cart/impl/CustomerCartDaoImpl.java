/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.cart.impl;

import by.chvertock.lathe.dao.cart.CustomerCartDao;
import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.user.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerCartDaoImpl implements CustomerCartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCart(CustomerCart cart) {
        try {
//            System.out.println(cart);

            sessionFactory.getCurrentSession().save(cart);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void updateCart(CustomerCart cart) {
        try {
            sessionFactory.getCurrentSession().update(cart);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<CustomerCart> getCarts() {
        try {
            return sessionFactory.getCurrentSession().createCriteria(CustomerCart.class).list();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public CustomerCart getCartByCustomer(User user) {
        try {
            return (CustomerCart) sessionFactory.getCurrentSession()
                    .createCriteria(CustomerCart.class)
                    .add(Restrictions.eq("customer", user))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void removeCart(CustomerCart cart) {
        try {
            cart.setCustomer(null); //

            sessionFactory.getCurrentSession().delete(cart);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
