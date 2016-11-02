/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.type;

import by.chvertock.lathe.model.entities.tire.TireType;
import by.chvertock.lathe.service.tire.TireTypeService;
import by.chvertock.lathe.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddNewTypeController {

    private static final Logger logger = Logger.getLogger(AddNewTypeController.class);

    @Autowired
    private TireTypeService typeService;

    @RequestMapping("/admin/tires/add-new-type")
    public String add(@RequestParam(value = "name", required = true) String name){

        try{
            validate(name);

            TireType type = new TireType();
            type.setName(name);

            typeService.addType(type);
        } catch (Exception e){
            logger.error("Can't add new tire type", e);
        }

        return "redirect:/admin/tires";
    }

    private void validate(String name){

        // TODO: validate name format

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name is '" + name + "'");
        }
    }
}
