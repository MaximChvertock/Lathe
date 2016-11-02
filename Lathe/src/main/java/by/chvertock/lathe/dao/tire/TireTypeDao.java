/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire;

import by.chvertock.lathe.model.entities.tire.TireType;

import java.util.List;

public interface TireTypeDao {
    void addType(TireType type);
    void removeType(TireType type);
    void updateType(TireType type);

    TireType getTypeById(Long id);
    TireType getTypeByName(String name);

    List<TireType> getTypes();

    int getTypesCount();

    void removeAll();
}
