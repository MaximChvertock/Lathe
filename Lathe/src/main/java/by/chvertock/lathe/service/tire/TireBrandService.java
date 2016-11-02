/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;


import by.chvertock.lathe.dao.tire.TireBrandDao;
import by.chvertock.lathe.model.entities.tire.TireBrand;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class TireBrandService {

    @Autowired
    private TireBrandDao tireBrandDao;

    @Transactional
    public void addBrand(TireBrand brand){
        tireBrandDao.addBrand(brand);
    }

    @Transactional
    public void removeBrand(TireBrand brand){
        tireBrandDao.removeBrand(brand);
    }

    @Transactional
    public void updateBrand(TireBrand brand){
        tireBrandDao.updateBrand(brand);
    }

    @Transactional
    public TireBrand getBrandById(Long id){
        return tireBrandDao.getBrandById(id);
    }

    @Transactional
    public TireBrand getBrandByName(String name){
        return tireBrandDao.getBrandByName(name);
    }

    @Transactional
    public List<TireBrand> getBrands(){
        return tireBrandDao.getBrands();
    }

    @Transactional
    public int getBrandsCount(){
        return tireBrandDao.getBrandsCount();
    }

    @Transactional
    public void removeAll(){
        tireBrandDao.removeAll();
    }
}
