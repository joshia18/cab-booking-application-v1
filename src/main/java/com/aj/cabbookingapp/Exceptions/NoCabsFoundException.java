package com.aj.cabbookingapp.Exceptions;

public class NoCabsFoundException extends Exception{
    public NoCabsFoundException() {
        super();
    }

    public NoCabsFoundException(String message) {
        super(message);
    }
}
