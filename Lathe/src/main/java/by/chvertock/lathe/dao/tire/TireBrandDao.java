/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.tire;

import by.chvertock.lathe.model.entities.tire.TireBrand;

import java.util.List;

public interface TireBrandDao {
    void addBrand(TireBrand brand);
    void removeBrand(TireBrand brand);
    void updateBrand(TireBrand brand);

    TireBrand getBrandById(Long id);
    TireBrand getBrandByName(String name);

    List<TireBrand> getBrands();

    int getBrandsCount();

    void removeAll();
}
