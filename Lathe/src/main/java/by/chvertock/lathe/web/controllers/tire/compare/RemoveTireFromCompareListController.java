/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.compare;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.beans.tire.TireCompareList;
import by.chvertock.lathe.model.entities.tire.Tire;
import by.chvertock.lathe.service.tire.TireService;
import by.chvertock.lathe.web.controllers.tire.RemoveTireController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(
        value = {
                "compareList"
        },
        types = {
                TireCompareList.class
        }
)
public class RemoveTireFromCompareListController {

    private static final Logger logger = Logger.getLogger(RemoveTireController.class);

    @Autowired
    private TireService tireService;

    @RequestMapping("shop/tires/remove-from-compare")
    public String add(
            @RequestParam(value = "tire-id") Long tireId,
            @RequestParam(value = "redirect", required = false, defaultValue = "shop/tires") String redirect,
            @ModelAttribute("compareList") TireCompareList compareList
    ) {
        try {
            Tire tire = tireService.getTireById(tireId);

            compareList.removeTire(tire);
        } catch (DaoException e) {
            logger.error("Can't remove tire from compare list", e);
        }

        return "redirect:/" + redirect;
    }
}
