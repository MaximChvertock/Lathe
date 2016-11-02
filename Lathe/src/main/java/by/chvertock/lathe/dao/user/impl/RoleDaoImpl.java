/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.user.impl;


import by.chvertock.lathe.dao.user.RoleDao;
import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.user.Role;
import by.chvertock.lathe.model.entities.user.RoleType;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addRole(Role role) {
        try {
            sessionFactory.getCurrentSession().save(role);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void removeRole(Role role) {
        try {
            sessionFactory.getCurrentSession().delete(role);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Role getRole(long id) {
        try {
            return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Role> getRoles() {
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createCriteria(Role.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Role getRoleByName(RoleType role) {
        try {
            return (Role) sessionFactory
                    .getCurrentSession()
                    .createCriteria(Role.class)
                    .add(Restrictions.eq("role", role))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
