/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans;

import by.chvertock.lathe.model.entities.order.CustomerInfo;
import by.chvertock.lathe.web.controllers.util.RegExpUtils;
import org.apache.commons.validator.routines.RegexValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class CustomerInfoValidator implements Validator {

//    private EmailValidator emailValidator = EmailValidator.getInstance();


    private RegexValidator phoneNumberValidator = new RegexValidator(RegExpUtils.PATTERN_PHONE_NUMBER);
    private RegexValidator emailValidator = new RegexValidator(RegExpUtils.PATTERN_EMAIL);


    public boolean supports(Class<?> aClass) {
        return CustomerInfo.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        CustomerInfo info = (CustomerInfo) o;


        if (!emailValidator.isValid(info.getEmail())) {
            errors.rejectValue("email", "customer_info.email.invalid");
        }

        if (!phoneNumberValidator.isValid(info.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", "customer_info.phone_number.invalid");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "customer_info.first_name.is_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "customer_info.last_name.is_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "customer_info.address.is_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "customer_info.email.is_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postcode", "customer_info.postcode.is_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "customer_info.phone_number.is_empty");

    }
}
