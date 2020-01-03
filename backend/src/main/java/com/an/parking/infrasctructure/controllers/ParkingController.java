package com.an.parking.infrasctructure.controllers;

import com.an.parking.application.service.ParkingService;
import com.an.parking.domain.dto.Bill;
import com.an.parking.domain.dto.Parking;
import com.an.parking.domain.dto.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(final ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/addvehicle")
    public ResponseEntity<Parking> addVehicleParking(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(parkingService.addmisionRegister(vehicle), HttpStatus.CREATED);
    }

    @PatchMapping("/exit/{plate}")
    public ResponseEntity<Bill> removeVehicleParking(@PathVariable("plate") String plate) {
        return new ResponseEntity<>(parkingService.exitRegister(plate), HttpStatus.CREATED);
    }

}
