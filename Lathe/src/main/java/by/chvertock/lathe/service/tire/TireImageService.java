/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;


import by.chvertock.lathe.dao.tire.TireImageDao;
import by.chvertock.lathe.model.entities.tire.TireImage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class TireImageService {

    @Autowired
    private TireImageDao tireImageDao;

    @Transactional
    public void addImage(TireImage image){
        tireImageDao.addImage(image);
    }

    @Transactional
    public void removeImage(TireImage image){
        tireImageDao.removeImage(image);
    }

    @Transactional
    public void updateImage(TireImage image){
        tireImageDao.updateImage(image);
    }

    @Transactional
    public TireImage getImageById(Long id){
        return tireImageDao.getImageById(id);
    }

    @Transactional
    public TireImage getImageByFileName(String fileName){
        return tireImageDao.getImageByFileName(fileName);
    }

    @Transactional
    public List<TireImage> getImages(){
        return tireImageDao.getImages();
    }

    @Transactional
    public int getImagesCount(){
        return tireImageDao.getImagesCount();
    }

    @Transactional
    public void removeAll(){
        tireImageDao.removeAll();
    }
}
