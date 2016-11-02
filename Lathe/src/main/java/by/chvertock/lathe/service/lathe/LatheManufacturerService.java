/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.lathe;


import by.chvertock.lathe.dao.lathe.LatheManufacturerDao;
import by.chvertock.lathe.model.entities.lathe.LatheManufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LatheManufacturerService {

    @Autowired
    private LatheManufacturerDao tireManufacturerDao;

    @Transactional
    public void addManufacturer(LatheManufacturer manufacturer){
        tireManufacturerDao.addManufacturer(manufacturer);
    }

    @Transactional
    public void removeManufacturer(LatheManufacturer manufacturer){
        tireManufacturerDao.removeManufacturer(manufacturer);
    }

    @Transactional
    public void updateManufacturer(LatheManufacturer manufacturer){
        tireManufacturerDao.updateManufacturer(manufacturer);
    }

    @Transactional
    public LatheManufacturer getManufacturerById(Long id){
        return tireManufacturerDao.getManufacturerById(id);
    }

    @Transactional
    public LatheManufacturer getManufacturerByName(String name){
        return tireManufacturerDao.getManufacturerByName(name);
    }

    @Transactional
    public List<LatheManufacturer> getManufacturers(){
        return tireManufacturerDao.getManufacturers();
    }

    @Transactional
    public int getManufacturersCount(){
        return tireManufacturerDao.getManufacturersCount();
    }

    @Transactional
    public void removeAll(){
        tireManufacturerDao.removeAll();
    }
}
