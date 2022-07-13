package com.aj.cabbookingapp.Exceptions;

public class CabNotFoundException extends Exception{
    public CabNotFoundException() {
        super();
    }

    public CabNotFoundException(String message) {
        super(message);
    }
}
