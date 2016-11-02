/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.model.beans;

import by.chvertock.lathe.model.entities.cart.CustomerCart;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerCartValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerCart.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
