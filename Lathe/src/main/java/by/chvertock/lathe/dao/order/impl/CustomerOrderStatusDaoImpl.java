/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.order.impl;

import by.chvertock.lathe.dao.order.CustomerOrderStatusDao;
import by.chvertock.lathe.model.entities.order.CustomerOrderStatus;
import by.chvertock.lathe.model.entities.order.StatusType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderStatusDaoImpl implements CustomerOrderStatusDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CustomerOrderStatus getStatusByType(StatusType type) {
        return (CustomerOrderStatus) sessionFactory.getCurrentSession()
                .createCriteria(CustomerOrderStatus.class)
                .add(Restrictions.eq("status", type))
                .uniqueResult();
    }
}
