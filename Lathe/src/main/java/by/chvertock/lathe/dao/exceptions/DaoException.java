package by.chvertock.lathe.dao.exceptions;


import by.chvertock.lathe.exceptions.ApplicationException;

public class DaoException extends ApplicationException{
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
