/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.tire.TireProfileDao;
import by.chvertock.lathe.model.entities.tire.TireProfile;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TireProfileDaoImpl implements TireProfileDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProfile(TireProfile profile) {
        try{
            sessionFactory.getCurrentSession().save(profile);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void removeProfile(TireProfile profile) {
        try{
            sessionFactory.getCurrentSession().delete(profile);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void updateProfile(TireProfile profile) {
        try{
            sessionFactory.getCurrentSession().update(profile);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public TireProfile getProfileById(Long id) {
        try{
            return (TireProfile) sessionFactory.getCurrentSession().get(TireProfile.class, id);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public TireProfile getProfileByValue(String value) {
        try{
            return (TireProfile)sessionFactory.getCurrentSession()
                    .createCriteria(TireProfile.class)
                    .add(Restrictions.eq("value", value))
                    .uniqueResult();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<TireProfile> getProfiles() {
        try{
            return sessionFactory.getCurrentSession()
                    .createCriteria(TireProfile.class)
                    .list();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public int getProfilesCount() {
        return (Integer) sessionFactory.getCurrentSession()
                .createCriteria(TireProfile.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public void removeAll() {
        try{
            sessionFactory.getCurrentSession()
                    .createSQLQuery("DELETE FROM tire_profile")
                    .executeUpdate();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
