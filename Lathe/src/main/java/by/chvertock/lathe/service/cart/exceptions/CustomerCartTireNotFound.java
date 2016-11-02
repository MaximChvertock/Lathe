/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.cart.exceptions;

import by.chvertock.lathe.service.exceptions.ServiceException;


public class CustomerCartTireNotFound extends ServiceException {
    public CustomerCartTireNotFound() {
    }

    public CustomerCartTireNotFound(String message) {
        super(message);
    }

    public CustomerCartTireNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerCartTireNotFound(Throwable cause) {
        super(cause);
    }
}
