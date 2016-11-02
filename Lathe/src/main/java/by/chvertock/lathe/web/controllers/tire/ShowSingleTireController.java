/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire;

import by.chvertock.lathe.dao.exceptions.DaoException;
import by.chvertock.lathe.model.beans.tire.TireCompareList;
import by.chvertock.lathe.model.beans.tire.TireFilter;
import by.chvertock.lathe.model.entities.cart.CustomerCart;
import by.chvertock.lathe.model.entities.tire.Tire;
import by.chvertock.lathe.service.tire.TireService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes(
        value = {
                "newTire",
                "customerCart",
                "compareList"
        },
        types = {
                Tire.class,
                TireFilter.class,
                CustomerCart.class,
                TireCompareList.class
        }
)
public class ShowSingleTireController {

    private static final Logger logger = Logger.getLogger(ShowSingleTireController.class);

    @Autowired
    private TireService tireService;

    @RequestMapping(value = "/shop/tires/single")
    public ModelAndView show(
            @RequestParam(value = "tire-id") Long tireId
    ) {
        ModelAndView modelAndView = new ModelAndView("shop/tire/TireSinglePage");

        try {
            Tire tire = tireService.getTireById(tireId);

            modelAndView.addObject("tire", tire);
        } catch (DaoException e) {
            logger.error("Can't get tire list", e);
        }

        return modelAndView;
    }

    @ModelAttribute("compareList")
    private TireCompareList getCompareList() {
        return new TireCompareList();
    }
}
