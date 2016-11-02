/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.tire;


import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.tire.TireProfile;
import by.chvertock.lathe.service.tire.TireProfileService;
import by.chvertock.lathe.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class TireProfileEditor extends PropertyEditorSupport {

    private static final Logger logger = Logger.getLogger(TireProfileEditor.class);

    @Autowired
    private TireProfileService profileService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        TireProfile profile = null;

        try {
            if(StringUtils.isBlank(text)){
                throw new IllegalArgumentException("text is blank or null");
            }

            profile = new TireProfile();
            profile.setValue(text);
            profileService.addProfile(profile);

            profile = profileService.getProfileByValue(text);

//            System.out.println("Profile:" + profile);
        } catch (DaoException e) {
            logger.error("Can't convert '" + text + "' to tire profile", e);
        }

        this.setValue(profile);
    }
}