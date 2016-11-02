/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.lathe;


import by.chvertock.lathe.dao.lathe.LatheDao;
import by.chvertock.lathe.model.beans.lathe.LatheFilter;
import by.chvertock.lathe.model.entities.lathe.Lathe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@Service
public class LatheService {

	@Autowired
	private LatheDao latheDao;

	@Transactional
	public void addLathe(Lathe lathe) {
		latheDao.addLathe(lathe);
	}

	@Transactional
	public void saveOrUpdateLathe(Lathe lathe) {
		latheDao.saveOrUpdate(lathe);
	}

	@Transactional
	public void removeLathe(Lathe lathe) {
		latheDao.removeLathe(lathe);
	}

	@Transactional
	public void updateLathe(Lathe lathe) {
		latheDao.updateLathe(lathe);
	}

	@Transactional
	public Lathe getLatheById(long id) {
		return latheDao.getLatheById(id);
	}

	@Transactional
	public List<Lathe> getLathes() {
		return latheDao.getLathes();
	}

	@Transactional
	public List<Lathe> getLathes(LatheFilter filter, Page page) {
		if (filter == null) {
			if (page == null) {
				return latheDao.getLathes();
			}
			return latheDao.getLathes(page.getFirstResult(), page.getMaxResults());
		}
		return latheDao.getLathes(filter, page.getFirstResult(), page.getMaxResults());
	}


	@Transactional
	public List<Lathe> getLathes(Page page) {
		return latheDao.getLathes(page.getFirstResult(), page.getMaxResults());
	}

	@Transactional
	public long getLatheCount() {
		return latheDao.getLatheCount();
	}

	@Transactional
	public long getLatheCount(LatheFilter filter) {
		return latheDao.getLatheCount(filter);
	}

	@Transactional
	public void removeAllLathes() {
		latheDao.removeAllLathes();
	}

	@Transactional
	public BigDecimal getMinPrice() {
		return latheDao.getMinPrice();
	}

	@Transactional
	public BigDecimal getMaxPrice() {
		return latheDao.getMaxPrice();
	}

	public static class Page {
		private int number;
		private int size;

		public Page(int number, int size) {
			this.number = number;
			this.size = size;
		}

		public int getFirstResult() {
			return (number - 1) * size;
		}

		public int getMaxResults() {
			return size;
		}
	}
}
