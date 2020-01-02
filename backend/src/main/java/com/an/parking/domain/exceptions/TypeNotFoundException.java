package com.an.parking.domain.exceptions;

public class TypeNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 7248444567218073221L;

    public TypeNotFoundException(String message){

        super(message);
    }
}
