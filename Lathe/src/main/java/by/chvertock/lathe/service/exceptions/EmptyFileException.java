/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.service.exceptions;

/**
 * Created by mad on 24.03.16.
 */
public class EmptyFileException extends UploadFileException {
    public EmptyFileException() {
    }

    public EmptyFileException(String message) {
        super(message);
    }

    public EmptyFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFileException(Throwable cause) {
        super(cause);
    }
}
