/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.filter;

import by.chvertock.lathe.model.beans.tire.TireFilter;
import by.chvertock.lathe.service.tire.TireFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"filter"}, types = {TireFilter.class})
public class TireFilterController {

    @Autowired
    private TireFilterService tireFilterService;

    @RequestMapping("/admin/tires/filter-clear")
    public String adminFilterClear(@ModelAttribute("filter") TireFilter filter) {
        tireFilterService.clearFilter(filter);
        return "redirect:/admin/tires";
    }

    @RequestMapping("/shop/tires/filter-clear")
    public String shopFilterClear(@ModelAttribute("filter") TireFilter filter) {
        tireFilterService.clearFilter(filter);
        return "redirect:/shop/tires";
    }
}
