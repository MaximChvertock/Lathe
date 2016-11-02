/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;


import by.chvertock.lathe.dao.tire.TireDiameterDao;
import by.chvertock.lathe.model.entities.tire.TireDiameter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class TireDiameterService {

    @Autowired
    private TireDiameterDao tireDiameterDao;

    @Transactional
    public void addDiameter(TireDiameter diameter){
        tireDiameterDao.addDiameter(diameter);
    }

    @Transactional
    public void removeDiameter(TireDiameter diameter){
        tireDiameterDao.removeDiameter(diameter);
    }

    @Transactional
    public void updateDiameter(TireDiameter diameter){
        tireDiameterDao.updateDiameter(diameter);
    }

    @Transactional
    public TireDiameter getDiameterById(Long id){
        return tireDiameterDao.getDiameterById(id);
    }

    @Transactional
    public TireDiameter getDiameterByValue(String value){
        return tireDiameterDao.getDiameterByValue(value);
    }

    @Transactional
    public List<TireDiameter> getDiameters(){
        return tireDiameterDao.getDiameters();
    }

    @Transactional
    public int getDiametersCount(){
        return tireDiameterDao.getDiametersCount();
    }

    @Transactional
    public void removeAll(){
        tireDiameterDao.removeAll();
    }
}
