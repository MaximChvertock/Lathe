/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.entities.tire.Tire;
import by.chvertock.lathe.service.tire.TireService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveTireController {

    private static final Logger logger = Logger.getLogger(RemoveTireController.class);

    @Autowired
    private TireService tireService;

    @RequestMapping("admin/tires/remove-tire")
    public String remove(@RequestParam(value = "id", required = true) Long id) {
        try {
            Tire tire = tireService.getTireById(id);
            tireService.removeTire(tire);
        } catch (DaoException e) {
            logger.error("Can't get tire by id=" + id, e);
        }

        return "redirect:/admin/tires";
    }
}
