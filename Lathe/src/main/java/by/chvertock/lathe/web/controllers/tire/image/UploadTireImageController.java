/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.tire.image;


import by.chvertock.lathe.model.entities.tire.TireImage;
import by.chvertock.lathe.service.tire.TireImageService;
import by.chvertock.lathe.util.IOUtils;
import by.chvertock.lathe.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.UUID;


@Controller
public class UploadTireImageController {

    private static final Logger logger = Logger.getLogger(UploadTireImageController.class);

    @Autowired
    private TireImageService imageService;

    @Value("${content.images.directory}")
    private String imagesDir;

    @RequestMapping(value = "/admin/tires/upload-image", method = RequestMethod.POST)
    public ModelAndView upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "name", required = false) String name
    ) {

        ModelAndView modelAndView = new ModelAndView("redirect:/admin/tires");

        try {
            validate(file);

            String fileExtension = getFileExtensionFromContentType(file.getContentType());
            if (!IOUtils.isImageExtension(fileExtension)) {
                throw new IllegalArgumentException("Wrong file extension '" + fileExtension + "'");
            }

            // make file name
            String imageFileName;
            if (StringUtils.isBlank(name)) {
                imageFileName = UUID.randomUUID().toString() + "." + fileExtension;
            } else {
                imageFileName = name + "." + fileExtension;
            }

            // save uploaded file to image directory
            byte[] bytes = file.getBytes();

            String fileName = imagesDir + File.separator + imageFileName;

            File imageFile = new File(fileName);

            OutputStream out = new BufferedOutputStream(new FileOutputStream(imageFile));
            out.write(bytes);
            out.close();

            // add record to database
            TireImage image = new TireImage();
            image.setFileName(imageFileName);
            imageService.addImage(image);

        } catch (Exception e) {
            logger.error("Can't upload image", e);
        }

        return modelAndView;
    }

    private String getFileExtensionFromContentType(String contentType) {
        if (contentType == null) {
            return "";
        }

        String[] strings = contentType.split("/");

        if (strings == null || strings.length == 0) {
            return "";
        }

        return strings[strings.length - 1];
    }

    private void validate(MultipartFile file) {
        if (file == null) {
            throw new NullPointerException("File is null");
        }

        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }
    }
}