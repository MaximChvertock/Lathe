/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire;

import by.chvertock.lathe.model.beans.ErrorHolder;
import by.chvertock.lathe.model.beans.tire.*;
import by.chvertock.lathe.model.entities.tire.*;
import by.chvertock.lathe.service.tire.TireFilterService;
import by.chvertock.lathe.service.tire.TireService;
import by.chvertock.lathe.web.controllers.util.ValidatorUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@SessionAttributes(
        value = {
                "addNewTireErrorHolder",
                "newTire",
                "filter"
        },
        types = {
                ErrorHolder.class,
                Tire.class,
                TireFilter.class
        }
)
public class AddNewTireController {

    private static final Logger logger = Logger.getLogger(AddNewTireController.class);

    @Autowired
    private TireService tireService;

    @Autowired
    private TireFilterService filterService;

    @Autowired
    private TireBrandEditor brandEditor;
    @Autowired
    private TireTypeEditor typeEditor;
    @Autowired
    private TireImageEditor imageEditor;
    @Autowired
    private TireWidthEditor widthEditor;
    @Autowired
    private TireProfileEditor profileEditor;
    @Autowired
    private TireDiameterEditor diameterEditor;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(TireBrand.class, brandEditor);
        binder.registerCustomEditor(TireType.class, typeEditor);
        binder.registerCustomEditor(TireImage.class, imageEditor);
        binder.registerCustomEditor(TireWidth.class, widthEditor);
        binder.registerCustomEditor(TireProfile.class, profileEditor);
        binder.registerCustomEditor(TireDiameter.class, diameterEditor);
    }

    @RequestMapping("admin/tires/add-new-tire")
    public ModelAndView add(
            @Valid @ModelAttribute("newTire") Tire newTire,
            BindingResult result,

            @ModelAttribute("filter") TireFilter filter,

            @ModelAttribute("addNewTireErrorHolder") ErrorHolder errorHolder
    ) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/tires");

//        System.out.println(newTire); // DEBUG
//        System.out.println(result);

        // remove all errors from holder
        errorHolder.clear();

        try {
            // validate tire bean from client side
            validate(result, errorHolder);

            tireService.addTire(newTire);

            // always clear filter to view added tire with new parameters
            filterService.clearFilter(filter);
        } catch (Exception e) {
            logger.error("Can't add tire=" + newTire, e);
        }

        return modelAndView;
    }

    private void validate(BindingResult result, ErrorHolder errorHolder) {
        if (result.hasErrors()) {
            errorHolder.setErrors(ValidatorUtils.getErrorDefaultMessages(result));

            throw new IllegalArgumentException("New tire bean has some errors");
        }
    }

    @ModelAttribute("addNewTireErrorHolder")
    private ErrorHolder getErrorHolder() {
        return new ErrorHolder();
    }
}
