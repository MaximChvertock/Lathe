/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.web.controllers.util;

import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public abstract class ValidatorUtils {
    private ValidatorUtils() {
    }

    public static List<String> getErrorDefaultMessages(Errors errors) {
        List<String> result = new ArrayList<String>();
        for (ObjectError error : errors.getFieldErrors()) {
            result.add(error.getDefaultMessage());
        }
        return result;
    }

    public static List<String> getErrorCodeMessages(Errors errors) {
        List<String> result = new ArrayList<String>();
        for (ObjectError error : errors.getFieldErrors()) {
            result.add(error.getCode());
        }
        return result;
    }

    public static List<String> getErrorMessages(Errors errors, MessageSource messageSource) {
        List<String> result = new ArrayList<String>();
        for (Object object : errors.getAllErrors()) {
            if (object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;

                String message = messageSource.getMessage(fieldError, null);

                result.add(message);
            }
        }

        return result;
    }
}
