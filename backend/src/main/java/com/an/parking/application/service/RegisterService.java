package com.an.parking.application.service;

import com.an.parking.domain.dto.*;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class RegisterService {

    private final Register register;

    public RegisterService(final Register register) {
        this.register = register;
    }

    public Parking registerValidation(Vehicle vehicle, Calendar addmissionDate) {
        return register.registerValidation(vehicle, addmissionDate);
    }

    public void parkingCapacity(long parkingCapacity, long typeId) {
        register.parkingCapacity(parkingCapacity, typeId);
    }

    public Bill billGeneration(Vehicle vehicle, Type type, Parking parking ) {
        return register.billGeneration(vehicle, type, parking);
    }

}
