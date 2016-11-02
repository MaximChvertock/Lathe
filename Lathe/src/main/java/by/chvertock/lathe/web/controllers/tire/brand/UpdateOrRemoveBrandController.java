/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.brand;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.tire.TireBrand;
import by.chvertock.lathe.service.tire.TireBrandService;
import by.chvertock.lathe.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateOrRemoveBrandController {

    private static final Logger logger = Logger.getLogger(UpdateOrRemoveBrandController.class);

    private static final int ACTION_UPDATE = 1;
    private static final int ACTION_REMOVE = 2;

    @Autowired
    private TireBrandService brandService;

    @RequestMapping(value = "/admin/tires/action-brand")
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

            TireBrand brand = brandService.getBrandById(id);
            brand.setName(name);
            brandService.updateBrand(brand);
        } catch (Exception e) {
            logger.error("Can't update name='" + name + "' for tire brand with id=" + id, e);
        }
    }

    private void remove(Long id) {
        try {
            TireBrand brand = brandService.getBrandById(id);
            brandService.removeBrand(brand);
        } catch (DaoException e) {
            logger.error("Can't remove tire brand with id=" + id, e);
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
