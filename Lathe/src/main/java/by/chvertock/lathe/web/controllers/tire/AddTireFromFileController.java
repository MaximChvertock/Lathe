/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire;

import by.chvertock.lathe.exceptions.ApplicationException;
import by.chvertock.lathe.model.entities.tire.Tire;
import by.chvertock.lathe.service.UploadFileService;
import by.chvertock.lathe.service.tire.TireFromFileService;
import by.chvertock.lathe.service.tire.TireService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

@Controller
public class AddTireFromFileController {

    private static final Logger logger = Logger.getLogger(AddTireFromFileController.class);

    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    private TireFromFileService tireFromFileService;

    @Autowired
    private TireService tireService;

    @RequestMapping(value = "/admin/tires/add-tire-from-file", method = RequestMethod.POST)
    public ModelAndView upload(
            @RequestParam("file") MultipartFile file
    ) {

        ModelAndView modelAndView = new ModelAndView("redirect:/admin/tires");

        try {
            File tireFile = uploadFileService.uploadExcelFileToTemp(file);

            Tire tire = tireFromFileService.getTire(tireFile);

            tireService.addTire(tire);
        } catch (ApplicationException e) {
            logger.error("Can't add tire from file", e);
        }

        return modelAndView;
    }
}
