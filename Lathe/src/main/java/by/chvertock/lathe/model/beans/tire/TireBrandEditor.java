/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.tire;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.tire.TireBrand;
import by.chvertock.lathe.service.tire.TireBrandService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class TireBrandEditor extends PropertyEditorSupport {

    private static final Logger logger = Logger.getLogger(TireBrandEditor.class);

    @Autowired
    private TireBrandService brandService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        TireBrand brand = null;

        try {
            brand = brandService.getBrandByName(text);

//            System.out.println("Brand:" + brand);
        } catch (DaoException e) {
            logger.error("Can't convert '" + text + "' to tire brand", e);
        }

        this.setValue(brand);
    }
}
