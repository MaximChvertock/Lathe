/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.tire;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.tire.TireImage;
import by.chvertock.lathe.service.tire.TireImageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class TireImageEditor extends PropertyEditorSupport {

    private static final Logger logger = Logger.getLogger(TireImageEditor.class);

    @Autowired
    private TireImageService imageService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        TireImage image = null;

        try {
            image = imageService.getImageByFileName(text);
//            System.out.println("Image:" + image);
        } catch (DaoException e) {
            logger.error("Can't convert '" + text + "' to tire image", e);
        }

        this.setValue(image);
    }
}