/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.lathe;

import by.chvertock.lathe.model.entities.lathe.LatheManufacturer;
import by.chvertock.lathe.model.entities.tire.TireBrand;

import java.util.List;

public interface LatheManufacturerDao {
    void addManufacturer(LatheManufacturer manufacturer);
    void removeManufacturer(LatheManufacturer manufacturer);
    void updateManufacturer(LatheManufacturer manufacturer);

    LatheManufacturer getManufacturerById(Long id);
    LatheManufacturer getManufacturerByName(String name);

    List<LatheManufacturer> getManufacturers();

    int getManufacturersCount();

    void removeAll();
}
