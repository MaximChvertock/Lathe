/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire;

import by.chvertock.lathe.model.beans.tire.TireFilter;
import by.chvertock.lathe.model.entities.tire.*;

import java.math.BigDecimal;
import java.util.List;

public interface TireDao {
    void addTire(Tire tire);
    void removeTire(Tire tire);
    void updateTire(Tire tire);

    Tire getTireById(long id);

    List<Tire> getTires();

    List<Tire> getTires(int first, int count);

    List<Tire> getTires( TireFilter filter, int first, int count);

    long getTireCount();

    long getTireCount(TireFilter filter);

    BigDecimal getMinPrice();

    BigDecimal getMaxPrice();

    void removeAllTires();

}
