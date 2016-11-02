/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.tire.TireTypeDao;
import by.chvertock.lathe.model.entities.tire.TireType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TireTypeDaoImpl implements TireTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addType(TireType type) {
        try{
            sessionFactory.getCurrentSession().save(type);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void removeType(TireType type) {
        try{
            sessionFactory.getCurrentSession().delete(type);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void updateType(TireType type) {
        try{
            sessionFactory.getCurrentSession().update(type);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public TireType getTypeById(Long id) {
        try{
            return (TireType) sessionFactory.getCurrentSession().get(TireType.class, id);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public TireType getTypeByName(String name) {
        try{
            return (TireType)sessionFactory.getCurrentSession()
                    .createCriteria(TireType.class)
                    .add(Restrictions.eq("name", name))
                    .uniqueResult();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<TireType> getTypes() {
        try{
            return sessionFactory.getCurrentSession()
                    .createCriteria(TireType.class)
                    .list();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public int getTypesCount() {
        return (Integer) sessionFactory.getCurrentSession()
                .createCriteria(TireType.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public void removeAll() {
        try{
            sessionFactory.getCurrentSession()
                    .createSQLQuery("DELETE FROM tire_type")
                    .executeUpdate();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
