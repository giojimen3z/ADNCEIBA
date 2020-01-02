package com.an.parking.domain.exceptions;

public class VehicleNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3553285630845707373L;

    public VehicleNotFoundException (String message){

        super(message);
    }
}
