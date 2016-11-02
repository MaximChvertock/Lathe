/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.lathe.impl;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.dao.lathe.LatheDao;
import by.chvertock.lathe.model.beans.lathe.LatheFilter;
import by.chvertock.lathe.model.entities.lathe.Lathe;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class LatheDaoImpl implements LatheDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addLathe(Lathe lathe) {
		try {
			sessionFactory.getCurrentSession().save(lathe);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void saveOrUpdate(Lathe lathe) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(lathe);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void removeLathe(Lathe lathe) {
		try {
			// set null to foreign keys

			sessionFactory.getCurrentSession().delete(lathe);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void updateLathe(Lathe lathe) {
		try {
			sessionFactory.getCurrentSession().update(lathe);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public Lathe getLatheById(long id) {
		try {
			return (Lathe) sessionFactory.getCurrentSession().get(Lathe.class, id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Lathe> getLathes() {
		try {
			return sessionFactory.getCurrentSession().createCriteria(Lathe.class).list();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Lathe> getLathes(int first, int count) {
		try {
			return sessionFactory.getCurrentSession()
					.createCriteria(Lathe.class)
					.setFirstResult(first)
					.setMaxResults(count)
					.list();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Lathe> getLathes(LatheFilter filter, int first, int count) {
		return getCriteria(filter)
				.setFirstResult(first)
				.setMaxResults(count)
				.list();

	}

	public long getLatheCount() {
		return (Long) sessionFactory.getCurrentSession()
				.createCriteria(Lathe.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
	}

	public long getLatheCount(LatheFilter filter) {
		return (Long) getCriteria(filter)
				.setProjection(Projections.rowCount())
				.uniqueResult();
	}

	public BigDecimal getMinPrice() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Lathe.class);

		try {
			return (BigDecimal) criteria.setProjection(Projections.min("price")).uniqueResult();
		} catch (Exception e) {
			return BigDecimal.ZERO;
		}
	}

	public BigDecimal getMaxPrice() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Lathe.class);

		try {
			return (BigDecimal) criteria.setProjection(Projections.max("price")).uniqueResult();
		} catch (Exception e) {
			return BigDecimal.ZERO;
		}
	}


	public void removeAllLathes() {
		try {
			sessionFactory.getCurrentSession()
					.createSQLQuery("DELETE FROM lathe")
					.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	private Criteria getCriteria(LatheFilter filter) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Lathe.class);


		return criteria;
	}
}
