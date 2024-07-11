package com.usuarios.security.exceptions;

public class CustomException extends Exception{

    private Object errorObject;
    private String message;

    public CustomException(String message) {
        this.message = message;
    }

    public CustomException(Object errorObject) {
        this.errorObject = errorObject;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object getErrorObject() {
        return errorObject;
    }
}
