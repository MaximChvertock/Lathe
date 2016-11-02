/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans.tire;


import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.tire.TireWidth;
import by.chvertock.lathe.service.tire.TireWidthService;
import by.chvertock.lathe.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class TireWidthEditor extends PropertyEditorSupport {

    private static final Logger logger = Logger.getLogger(TireWidthEditor.class);

    @Autowired
    private TireWidthService widthService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        TireWidth width = null;

        try {
            if(StringUtils.isBlank(text)){
                throw new IllegalArgumentException("text is blank or null");
            }

            width = new TireWidth();
            width.setValue(text);
            widthService.addWidth(width);

            width = widthService.getWidthByValue(text);

//            System.out.println("Width:" + width);
        } catch (DaoException e) {
            logger.error("Can't convert '" + text + "' to tire width", e);
        }

        this.setValue(width);
    }
}