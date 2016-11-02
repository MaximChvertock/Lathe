/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire;

import by.chvertock.lathe.model.entities.tire.TireWidth;

import java.util.List;

public interface TireWidthDao {
    void addWidth(TireWidth width);
    void removeWidth(TireWidth width);
    void updateWidth(TireWidth width);

    TireWidth getWidthById(Long id);
    TireWidth getWidthByValue(String value);

    List<TireWidth> getWidths();

    int getWidthsCount();

    void removeAll();
}
