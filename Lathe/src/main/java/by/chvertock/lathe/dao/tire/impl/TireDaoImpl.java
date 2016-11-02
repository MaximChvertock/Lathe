/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.tire.TireDao;
import by.chvertock.lathe.model.beans.tire.TireFilter;
import by.chvertock.lathe.model.entities.tire.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class TireDaoImpl implements TireDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addTire(Tire tire) {
        try {
            sessionFactory.getCurrentSession().save(tire);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void removeTire(Tire tire) {
        try {
            tire.setBrand(null);
            tire.setType(null);
            tire.setImage(null);
            tire.setWidth(null);
            tire.setProfile(null);
            tire.setDiameter(null);

            sessionFactory.getCurrentSession().delete(tire);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void updateTire(Tire tire) {
        try {
            sessionFactory.getCurrentSession().update(tire);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Tire getTireById(long id) {
        try {
            return (Tire) sessionFactory.getCurrentSession().get(Tire.class, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Tire> getTires() {
        try {
            return sessionFactory.getCurrentSession().createCriteria(Tire.class).list();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Tire> getTires(int first, int count) {
        try {
            return sessionFactory.getCurrentSession()
                    .createCriteria(Tire.class)
                    .setFirstResult(first)
                    .setMaxResults(count)
                    .list();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Tire> getTires(TireFilter filter, int first, int count) {
        return getCriteria(filter)
                .setFirstResult(first)
                .setMaxResults(count)
                .list();

    }

    public long getTireCount() {
        return (Long) sessionFactory.getCurrentSession()
                .createCriteria(Tire.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public long getTireCount(TireFilter filter) {
        return (Long) getCriteria(filter)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public BigDecimal getMinPrice() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tire.class);

        try {
            return (BigDecimal) criteria.setProjection(Projections.min("price")).uniqueResult();
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public BigDecimal getMaxPrice() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tire.class);

        try {
            return (BigDecimal) criteria.setProjection(Projections.max("price")).uniqueResult();
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }


    public void removeAllTires() {
        try {
            sessionFactory.getCurrentSession()
                    .createSQLQuery("DELETE FROM tire")
                    .executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    private Criteria getCriteria(TireFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tire.class);

        // apply brands
        if (filter.getTireBrands() != null) {
            Junction brandPredicate = Restrictions.disjunction();
            for (TireBrand brand : filter.getTireBrands()) {
                brandPredicate.add(Restrictions.eq("brand", brand));
            }
            criteria.add(brandPredicate);
        }

        // apply types
        if (filter.getTireTypes() != null) {
            Junction typePredicate = Restrictions.disjunction();
            for (TireType type : filter.getTireTypes()) {
                typePredicate.add(Restrictions.eq("type", type));
            }
            criteria.add(typePredicate);
        }

        // apply widths
        if (filter.getTireWidths() != null) {
            Junction widthPredicate = Restrictions.disjunction();
            for (TireWidth width : filter.getTireWidths()) {
                widthPredicate.add(Restrictions.eq("width", width));
            }
            criteria.add(widthPredicate);
        }

        // apply profiles
        if (filter.getTireProfiles() != null) {
            Junction profilePredicate = Restrictions.disjunction();
            for (TireProfile profile : filter.getTireProfiles()) {
                profilePredicate.add(Restrictions.eq("profile", profile));
            }
            criteria.add(profilePredicate);
        }

        // apply diameters
        if (filter.getTireDiameters() != null) {
            Junction diameterPredicate = Restrictions.disjunction();
            for (TireDiameter diameter : filter.getTireDiameters()) {
                diameterPredicate.add(Restrictions.eq("diameter", diameter));
            }
            criteria.add(diameterPredicate);
        }

        // apply price
        criteria
                .add(Restrictions.ge("price", filter.getMinPrice()))
                .add(Restrictions.le("price", filter.getMaxPrice()));


        // TODO: uncomment it
        // DISABLED FOR DEBUG
//        // apply in stock
//        criteria
//                .add(Restrictions.eq("inStock", inStock));

        return criteria;
    }
}
