/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.tire;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.tire.TireType;
import by.chvertock.lathe.service.tire.TireTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class TireTypeEditor extends PropertyEditorSupport {

    private static final Logger logger = Logger.getLogger(TireTypeEditor.class);

    @Autowired
    private TireTypeService typeService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        TireType type = null;

        try {
            type = typeService.getTypeByName(text);
//            System.out.println("Type:" + type);
        } catch (DaoException e) {
            logger.error("Can't convert '" + text + "' to tire type", e);
        }

        this.setValue(type);
    }
}