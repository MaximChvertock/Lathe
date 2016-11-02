/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {

    @RequestMapping(value = {"/", "index", "welcome", "shop"})
    public String index() {
//        return "shop/ShopPage";
        return "redirect:/shop/tires";
    }
}
