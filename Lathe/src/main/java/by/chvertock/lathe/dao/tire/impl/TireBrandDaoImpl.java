/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.tire.TireBrandDao;
import by.chvertock.lathe.model.entities.tire.TireBrand;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TireBrandDaoImpl implements TireBrandDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addBrand(TireBrand brand) {
        try{
            sessionFactory.getCurrentSession().save(brand);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void removeBrand(TireBrand brand) {
        try{
            sessionFactory.getCurrentSession().delete(brand);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void updateBrand(TireBrand brand) {
        try{
            sessionFactory.getCurrentSession().update(brand);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public TireBrand getBrandById(Long id) {
        try{
            return (TireBrand) sessionFactory.getCurrentSession().get(TireBrand.class, id);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public TireBrand getBrandByName(String name) {
        try{
            return (TireBrand)sessionFactory.getCurrentSession()
                    .createCriteria(TireBrand.class)
                    .add(Restrictions.eq("name", name))
                    .uniqueResult();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<TireBrand> getBrands() {
        try{
            return sessionFactory.getCurrentSession()
                    .createCriteria(TireBrand.class)
                    .list();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public int getBrandsCount() {
        return (Integer) sessionFactory.getCurrentSession()
                .createCriteria(TireBrand.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public void removeAll() {
        try{
            sessionFactory.getCurrentSession()
                    .createSQLQuery("DELETE FROM tire_brand")
                    .executeUpdate();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
