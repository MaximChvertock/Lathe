/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.order.impl;

import by.chvertock.lathe.dao.order.CustomerInfoDao;
import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.order.CustomerInfo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerInfoDaoImpl implements CustomerInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addInfo(CustomerInfo info) {
        try {
            sessionFactory.getCurrentSession().save(info);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void updateInfo(CustomerInfo info) {
        try {
            sessionFactory.getCurrentSession().update(info);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<CustomerInfo> getInfos() {
        try {
            return sessionFactory.getCurrentSession().createCriteria(CustomerInfo.class).list();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void removeInfo(CustomerInfo info) {
        try {
            sessionFactory.getCurrentSession().delete(info);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
