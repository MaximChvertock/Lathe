/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.type;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.tire.TireType;
import by.chvertock.lathe.service.tire.TireTypeService;
import by.chvertock.lathe.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateOrRemoveTypeController {

    private static final Logger logger = Logger.getLogger(UpdateOrRemoveTypeController.class);

    private static final int ACTION_UPDATE = 1;
    private static final int ACTION_REMOVE = 2;

    @Autowired
    private TireTypeService typeService;

    @RequestMapping(value = "/admin/tires/action-type")
    public String actionType(
            @RequestParam(value = "action", required = true) Integer action,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            validate(id);

            switch (action) {
                case ACTION_UPDATE:
                    update(id, name);
                    break;
                case ACTION_REMOVE:
                    remove(id);
                    break;
            }
        } catch (Exception e) {
            logger.error("", e);
        }

        return "redirect:/admin/tires";
    }

    private void update(Long id, String name) {
        try {
            validate(name);

            TireType type = typeService.getTypeById(id);
            type.setName(name);
            typeService.updateType(type);
        } catch (Exception e) {
            logger.error("Can't update name='" + name + "' for tire type with id=" + id, e);
        }
    }

    private void remove(Long id) {
        try {
            TireType type = typeService.getTypeById(id);
            typeService.removeType(type);
        } catch (DaoException e) {
            logger.error("Can't remove tire type with id=" + id, e);
        }
    }

    private void validate(String name){

        // TODO: validate name format

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name is '" + name + "'");
        }
    }

    private void validate(Long id){
        if (id == null) {
            throw new NullPointerException("Id=" + id);
        }
    }
}
