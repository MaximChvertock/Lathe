/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.user.impl;

import by.chvertock.lathe.dao.user.UserDao;
import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.user.Role;
import by.chvertock.lathe.model.entities.user.RoleType;
import by.chvertock.lathe.model.entities.user.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void updateUser(User user){
        try {
            sessionFactory.getCurrentSession().update(user);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void removeUser(User user) {
        try {
            Set<Role> nullRole = new HashSet<Role>();
            Role role = new Role();
            role.setRole(RoleType.ROLE_NULL);
            nullRole.add(role);

            user.setRoles(nullRole);

            sessionFactory.getCurrentSession().delete(user);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public User getUser(long id) {
        try {
            return (User) sessionFactory.getCurrentSession().get(User.class, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createCriteria(User.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public User getUserByEMail(String email) {
        try {
            return (User) sessionFactory
                    .getCurrentSession()
                    .createCriteria(User.class)
                    .add(Restrictions.eq("email", email))
                    .uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


}
