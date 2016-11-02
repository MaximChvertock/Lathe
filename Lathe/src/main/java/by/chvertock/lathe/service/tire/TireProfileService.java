/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.tire;


import by.chvertock.lathe.dao.tire.TireProfileDao;
import by.chvertock.lathe.model.entities.tire.TireProfile;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class TireProfileService {

    @Autowired
    private TireProfileDao tireProfileDao;

    @Transactional
    public void addProfile(TireProfile profile){
        tireProfileDao.addProfile(profile);
    }

    @Transactional
    public void removeProfile(TireProfile profile){
        tireProfileDao.removeProfile(profile);
    }

    @Transactional
    public void updateProfile(TireProfile profile){
        tireProfileDao.updateProfile(profile);
    }

    @Transactional
    public TireProfile getProfileById(Long id){
        return tireProfileDao.getProfileById(id);
    }

    @Transactional
    public TireProfile getProfileByValue(String value){
        return tireProfileDao.getProfileByValue(value);
    }

    @Transactional
    public List<TireProfile> getProfiles(){
        return tireProfileDao.getProfiles();
    }

    @Transactional
    public int getProfilesCount(){
        return tireProfileDao.getProfilesCount();
    }

    @Transactional
    public void removeAll(){
        tireProfileDao.removeAll();
    }
}
