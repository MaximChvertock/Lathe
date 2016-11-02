/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire;

import by.chvertock.lathe.model.entities.tire.TireDiameter;

import java.util.List;

public interface TireDiameterDao {
    void addDiameter(TireDiameter diameter);
    void removeDiameter(TireDiameter diameter);
    void updateDiameter(TireDiameter diameter);

    TireDiameter getDiameterById(Long id);
    TireDiameter getDiameterByValue(String value);

    List<TireDiameter> getDiameters();

    int getDiametersCount();

    void removeAll();
}
