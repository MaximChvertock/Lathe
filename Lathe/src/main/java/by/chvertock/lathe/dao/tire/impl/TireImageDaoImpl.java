/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.tire.TireImageDao;
import by.chvertock.lathe.model.entities.tire.TireImage;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TireImageDaoImpl implements TireImageDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addImage(TireImage image) {
        try{
            sessionFactory.getCurrentSession().save(image);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void removeImage(TireImage image) {
        try{
            sessionFactory.getCurrentSession().delete(image);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void updateImage(TireImage image) {
        try{
            sessionFactory.getCurrentSession().update(image);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public TireImage getImageById(Long id) {
        try{
            return (TireImage) sessionFactory.getCurrentSession().get(TireImage.class, id);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    public TireImage getImageByFileName(String fileName) {
        try{
            return (TireImage)sessionFactory.getCurrentSession()
                    .createCriteria(TireImage.class)
                    .add(Restrictions.eq("fileName", fileName))
                    .uniqueResult();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<TireImage> getImages() {
        try{
            return sessionFactory.getCurrentSession()
                    .createCriteria(TireImage.class)
                    .list();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public int getImagesCount() {
        return (Integer) sessionFactory.getCurrentSession()
                .createCriteria(TireImage.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public void removeAll() {
        try{
            sessionFactory.getCurrentSession()
                    .createSQLQuery("DELETE FROM tire_image")
                    .executeUpdate();
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
