package by.chvertock.lathe.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @RequestMapping("/404")
    public ModelAndView error404(){
        ModelAndView modelAndView = new ModelAndView("error");

        modelAndView.addObject("error", "404");

        return modelAndView;
    }

    @RequestMapping("/403")
    public ModelAndView error403(){
        ModelAndView modelAndView = new ModelAndView("error");

        modelAndView.addObject("error", "403");

        return modelAndView;
    }
}
