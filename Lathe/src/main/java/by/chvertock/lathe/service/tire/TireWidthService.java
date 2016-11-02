/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;


import by.chvertock.lathe.dao.tire.TireWidthDao;
import by.chvertock.lathe.model.entities.tire.TireWidth;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class TireWidthService {

    @Autowired
    private TireWidthDao tireWidthDao;

    @Transactional
    public void addWidth(TireWidth width){
        tireWidthDao.addWidth(width);
    }

    @Transactional
    public void removeWidth(TireWidth width){
        tireWidthDao.removeWidth(width);
    }

    @Transactional
    public void updateWidth(TireWidth width){
        tireWidthDao.updateWidth(width);
    }

    @Transactional
    public TireWidth getWidthById(Long id){
        return tireWidthDao.getWidthById(id);
    }

    @Transactional
    public TireWidth getWidthByValue(String value){
        return tireWidthDao.getWidthByValue(value);
    }

    @Transactional
    public List<TireWidth> getWidths(){
        return tireWidthDao.getWidths();
    }

    @Transactional
    public int getWidthsCount(){
        return tireWidthDao.getWidthsCount();
    }

    @Transactional
    public void removeAll(){
        tireWidthDao.removeAll();
    }
}
