/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.order.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.order.CustomerOrderDao;
import by.chvertock.lathe.model.beans.order.CustomerOrderFilter;
import by.chvertock.lathe.model.entities.order.CustomerOrder;
import by.chvertock.lathe.model.entities.user.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addOrder(CustomerOrder order) {
        try {
//            System.out.println(order);

            sessionFactory.getCurrentSession().save(order);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void updateOrder(CustomerOrder order) {
        try {
            sessionFactory.getCurrentSession().update(order);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<CustomerOrder> getOrders() {
        try {
            return sessionFactory.getCurrentSession().createCriteria(CustomerOrder.class).list();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public CustomerOrder getOrderByCustomer(User user) {
        try {
            return (CustomerOrder) sessionFactory.getCurrentSession()
                    .createCriteria(CustomerOrder.class)
                    .addOrder(Order.desc("date"))
                    .add(Restrictions.eq("customer", user))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<CustomerOrder> getOrders(int first, int count) {
        try {
            return sessionFactory.getCurrentSession()
                    .createCriteria(CustomerOrder.class)
                    .addOrder(Order.desc("date"))
                    .setFirstResult(first)
                    .setMaxResults(count)
                    .list();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<CustomerOrder> getOrders(CustomerOrderFilter filter, int first, int count) {
        return sessionFactory.getCurrentSession()
                .createCriteria(CustomerOrder.class)
                .addOrder(Order.desc("date"))
                .add(Restrictions.eq("status", filter.getStatus()))
                .setFirstResult(first)
                .setMaxResults(count)
                .list();
    }

    @Override
    public long getOrderCount(CustomerOrderFilter filter) {
        return (Long) getCriteria(filter)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    @Override
    public long getOrderCount() {
        return (Long) sessionFactory.getCurrentSession().createCriteria(CustomerOrder.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public CustomerOrder getOrderByIdentificator(String identificator) {
        try {
            return (CustomerOrder) sessionFactory.getCurrentSession()
                    .createCriteria(CustomerOrder.class)
                    .add(Restrictions.eq("identificator", identificator))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void removeOrder(CustomerOrder order) {
        try {
            sessionFactory.getCurrentSession().delete(order);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public CustomerOrder getOrderById(long id) {
        try {
            return (CustomerOrder) sessionFactory.getCurrentSession().get(CustomerOrder.class, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    private Criteria getCriteria(CustomerOrderFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CustomerOrder.class);

//        // apply not processed
        criteria
                .add(Restrictions.eq("status", filter.getStatus()));

        return criteria;
    }
}