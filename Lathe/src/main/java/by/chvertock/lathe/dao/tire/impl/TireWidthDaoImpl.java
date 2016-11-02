/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.tire.TireWidthDao;
import by.chvertock.lathe.model.entities.tire.TireWidth;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TireWidthDaoImpl implements TireWidthDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addWidth(TireWidth width) {
        try{
            sessionFactory.getCurrentSession().save(width);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void removeWidth(TireWidth width) {
        try{
            sessionFactory.getCurrentSession().delete(width);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void updateWidth(TireWidth width) {
        try{
            sessionFactory.getCurrentSession().update(width);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public TireWidth getWidthById(Long id) {
        try{
            return (TireWidth) sessionFactory.getCurrentSession().get(TireWidth.class, id);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public TireWidth getWidthByValue(String value) {
        try{
            return (TireWidth)sessionFactory.getCurrentSession()
                    .createCriteria(TireWidth.class)
                    .add(Restrictions.eq("value", value))
                    .uniqueResult();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<TireWidth> getWidths() {
        try{
            return sessionFactory.getCurrentSession()
                    .createCriteria(TireWidth.class)
                    .list();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public int getWidthsCount() {
        return (Integer) sessionFactory.getCurrentSession()
                .createCriteria(TireWidth.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public void removeAll() {
        try{
            sessionFactory.getCurrentSession()
                    .createSQLQuery("DELETE FROM tire_width")
                    .executeUpdate();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
