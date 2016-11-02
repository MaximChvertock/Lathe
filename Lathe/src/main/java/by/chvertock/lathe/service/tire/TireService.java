/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;


import by.chvertock.lathe.dao.tire.TireDao;
import by.chvertock.lathe.model.beans.tire.TireFilter;
import by.chvertock.lathe.model.entities.tire.Tire;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

public class TireService {

    @Autowired
    private TireDao tireDao;

    @Transactional
    public void addTire(Tire tire) {
        tireDao.addTire(tire);
    }

    @Transactional
    public void removeTire(Tire tire) {
        tireDao.removeTire(tire);
    }

    @Transactional
    public void updateTire(Tire tire) {
        tireDao.updateTire(tire);
    }

    @Transactional
    public Tire getTireById(long id) {
        return tireDao.getTireById(id);
    }

    @Transactional
    public List<Tire> getTires() {
        return tireDao.getTires();
    }

    @Transactional
    public List<Tire> getTires(TireFilter filter, Page page) {
        if (filter == null) {
            if (page == null) {
                return tireDao.getTires();
            }
            return tireDao.getTires(page.getFirstResult(), page.getMaxResults());
        }
        return tireDao.getTires(filter, page.getFirstResult(), page.getMaxResults());
    }


    @Transactional
    public List<Tire> getTires(Page page) {
        return tireDao.getTires(page.getFirstResult(), page.getMaxResults());
    }

    @Transactional
    public long getTireCount() {
        return tireDao.getTireCount();
    }

    @Transactional
    public long getTireCount(TireFilter filter) {
        return tireDao.getTireCount(filter);
    }

    @Transactional
    public void removeAllTires() {
        tireDao.removeAllTires();
    }

    @Transactional
    public BigDecimal getMinPrice() {
        return tireDao.getMinPrice();
    }

    @Transactional
    public BigDecimal getMaxPrice() {
        return tireDao.getMaxPrice();
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
