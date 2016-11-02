/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire;

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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateTireListController {

    private static final Logger logger = Logger.getLogger(UpdateTireListController.class);

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

    @RequestMapping("admin/tires/update-tire-list")
    public ModelAndView update(
            @ModelAttribute("tireListForm") TireListForm form,
            BindingResult result,


            @ModelAttribute("filter") TireFilter filter
    ) {

        ModelAndView modelAndView = new ModelAndView("redirect:/admin/tires");

        // TODO: need some testing of validation

        if (result.hasErrors()) {
            logger.error(result); // TODO: it's sheet code

            modelAndView.addObject("errorList", ValidatorUtils.getErrorDefaultMessages(result));
        } else {
            try {

                if (form.getTireList() == null) {
                    throw new NullPointerException("form.getTireList() returned null");
                }

//                System.out.println(form);

                for (Tire tire : form.getTireList()) {
                    tireService.updateTire(tire);
                }

                filterService.clearFilter(filter);
            } catch (Exception e) {
                logger.error("Can't update tires", e);
            }
        }

        return modelAndView;
    }
}
