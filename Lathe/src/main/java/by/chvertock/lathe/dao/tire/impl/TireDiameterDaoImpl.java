/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.tire.TireDiameterDao;
import by.chvertock.lathe.model.entities.tire.TireDiameter;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TireDiameterDaoImpl implements TireDiameterDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addDiameter(TireDiameter diameter) {
        try{
            sessionFactory.getCurrentSession().save(diameter);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void removeDiameter(TireDiameter diameter) {
        try{
            sessionFactory.getCurrentSession().delete(diameter);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void updateDiameter(TireDiameter diameter) {
        try{
            sessionFactory.getCurrentSession().update(diameter);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public TireDiameter getDiameterById(Long id) {
        try{
            return (TireDiameter) sessionFactory.getCurrentSession().get(TireDiameter.class, id);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public TireDiameter getDiameterByValue(String value) {
        try{
            return (TireDiameter)sessionFactory.getCurrentSession()
                    .createCriteria(TireDiameter.class)
                    .add(Restrictions.eq("value", value))
                    .uniqueResult();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<TireDiameter> getDiameters() {
        try{
            return sessionFactory.getCurrentSession()
                    .createCriteria(TireDiameter.class)
                    .list();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public int getDiametersCount() {
        return (Integer) sessionFactory.getCurrentSession()
                .createCriteria(TireDiameter.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public void removeAll() {
        try{
            sessionFactory.getCurrentSession()
                    .createSQLQuery("DELETE FROM tire_diameter")
                    .executeUpdate();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
