package by.chvertock.lathe.service.exceptions;


import by.chvertock.lathe.exceptions.ApplicationException;

public class ServiceException extends ApplicationException{

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
