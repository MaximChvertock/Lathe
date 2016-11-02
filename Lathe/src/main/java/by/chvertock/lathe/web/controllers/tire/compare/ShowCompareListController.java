/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.compare;

import by.chvertock.lathe.model.beans.tire.TireCompareList;
import by.chvertock.lathe.model.entities.cart.CustomerCart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(
        value = {
                "customerCart",
                "compareList"
        },
        types = {
                CustomerCart.class,
                TireCompareList.class
        }
)
public class ShowCompareListController {

    @RequestMapping(value = "shop/tires/compare")
    public String show(
            @ModelAttribute("compareList") TireCompareList compareList
    ) {
        if (compareList.getTires().isEmpty()) {
            return "redirect:/shop/tires";
        }

        return "shop/tire/TireComparePage";
    }

    @ModelAttribute("compareList")
    private TireCompareList getCompareList() {
        return new TireCompareList();
    }
}
