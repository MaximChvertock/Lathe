/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.tire;


import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.tire.TireDiameter;
import by.chvertock.lathe.service.tire.TireDiameterService;
import by.chvertock.lathe.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class TireDiameterEditor extends PropertyEditorSupport {

    private static final Logger logger = Logger.getLogger(TireDiameterEditor.class);

    @Autowired
    private TireDiameterService diameterService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        TireDiameter diameter = null;

        try {
            if(StringUtils.isBlank(text)){
                throw new IllegalArgumentException("text is blank or null");
            }

            diameter = new TireDiameter();
            diameter.setValue(text);
            diameterService.addDiameter(diameter);

            diameter = diameterService.getDiameterByValue(text);

//            System.out.println("Diameter:" + diameter);
        } catch (DaoException e) {
            logger.error("Can't convert '" + text + "' to tire diameter", e);
        }

        this.setValue(diameter);
    }
}