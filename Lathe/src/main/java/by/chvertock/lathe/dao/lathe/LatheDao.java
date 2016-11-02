/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.lathe;

import by.chvertock.lathe.model.beans.lathe.LatheFilter;
import by.chvertock.lathe.model.entities.lathe.Lathe;

import java.math.BigDecimal;
import java.util.List;

public interface LatheDao {
	void addLathe(Lathe lathe);

	void saveOrUpdate(Lathe lathe);

	void removeLathe(Lathe lathe);

	void updateLathe(Lathe lathe);

	Lathe getLatheById(long id);

	List<Lathe> getLathes();

	List<Lathe> getLathes(int first, int count);

	List<Lathe> getLathes(LatheFilter filter, int first, int count);

	long getLatheCount();

	long getLatheCount(LatheFilter filter);

	BigDecimal getMinPrice();

	BigDecimal getMaxPrice();

	void removeAllLathes();

}
