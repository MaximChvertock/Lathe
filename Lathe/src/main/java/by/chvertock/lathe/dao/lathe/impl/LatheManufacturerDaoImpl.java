/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.lathe.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.lathe.LatheManufacturerDao;
import by.chvertock.lathe.model.entities.lathe.LatheManufacturer;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LatheManufacturerDaoImpl implements LatheManufacturerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addManufacturer(LatheManufacturer manufacturer) {
        try{
            sessionFactory.getCurrentSession().save(manufacturer);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void removeManufacturer(LatheManufacturer manufacturer) {
        try{
            sessionFactory.getCurrentSession().delete(manufacturer);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void updateManufacturer(LatheManufacturer manufacturer) {
        try{
            sessionFactory.getCurrentSession().update(manufacturer);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public LatheManufacturer getManufacturerById(Long id) {
        try{
            return (LatheManufacturer) sessionFactory.getCurrentSession().get(LatheManufacturer.class, id);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public LatheManufacturer getManufacturerByName(String name) {
        try{
            return (LatheManufacturer)sessionFactory.getCurrentSession()
                    .createCriteria(LatheManufacturer.class)
                    .add(Restrictions.eq("name", name))
                    .uniqueResult();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<LatheManufacturer> getManufacturers() {
        try{
            return sessionFactory.getCurrentSession()
                    .createCriteria(LatheManufacturer.class)
                    .list();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public int getManufacturersCount() {
        return (Integer) sessionFactory.getCurrentSession()
                .createCriteria(LatheManufacturer.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public void removeAll() {
        try{
            sessionFactory.getCurrentSession()
                    .createSQLQuery("DELETE FROM tire_manufacturer")
                    .executeUpdate();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
