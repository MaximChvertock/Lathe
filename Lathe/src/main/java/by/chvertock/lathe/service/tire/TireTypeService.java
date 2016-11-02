/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;


import by.chvertock.lathe.dao.tire.TireTypeDao;
import by.chvertock.lathe.model.entities.tire.TireType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class TireTypeService {

    @Autowired
    private TireTypeDao tireTypeDao;

    @Transactional
    public void addType(TireType type){
        tireTypeDao.addType(type);
    }

    @Transactional
    public void removeType(TireType type){
        tireTypeDao.removeType(type);
    }

    @Transactional
    public void updateType(TireType type){
        tireTypeDao.updateType(type);
    }

    @Transactional
    public TireType getTypeById(Long id){
        return tireTypeDao.getTypeById(id);
    }

    @Transactional
    public TireType getTypeByName(String name){
        return tireTypeDao.getTypeByName(name);
    }

    @Transactional
    public List<TireType> getTypes(){
        return tireTypeDao.getTypes();
    }

    @Transactional
    public int getTypesCount(){
        return tireTypeDao.getTypesCount();
    }

    @Transactional
    public void removeAll(){
        tireTypeDao.removeAll();
    }
}
