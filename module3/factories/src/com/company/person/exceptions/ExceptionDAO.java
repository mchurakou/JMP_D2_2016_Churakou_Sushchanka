package com.company.person.exceptions;

/**
 * Created by alt-hanny on 24.07.2016.
 */
public class ExceptionDAO extends Exception {
    public ExceptionDAO() {
        super();
    }

    public ExceptionDAO(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionDAO(String message) {
        super(message);
    }
}
