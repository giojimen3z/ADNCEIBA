package com.an.parking.domain.exceptions;

public class ParkingNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -4585577827821776799L;

    public ParkingNotFoundException(String message){

        super(message);
    }
}
