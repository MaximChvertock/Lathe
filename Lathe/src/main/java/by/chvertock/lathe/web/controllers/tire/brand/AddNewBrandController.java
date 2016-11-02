/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.brand;

import by.chvertock.lathe.model.entities.tire.TireBrand;
import by.chvertock.lathe.service.tire.TireBrandService;
import by.chvertock.lathe.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddNewBrandController {

    private static final Logger logger = Logger.getLogger(AddNewBrandController.class);

    @Autowired
    private TireBrandService brandService;

    @RequestMapping("/admin/tires/add-new-brand")
    public String add(@RequestParam(value = "name", required = true) String name){

        try{
            validate(name);

            TireBrand brand = new TireBrand();
            brand.setName(name);

            brandService.addBrand(brand);
        } catch (Exception e){
            logger.error("Can't add new tire brand", e);
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
