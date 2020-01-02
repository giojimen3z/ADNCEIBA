package com.an.parking.infrasctructure.controllers;

import com.an.parking.application.service.VehicleService;
import com.an.parking.domain.dto.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {


    private final VehicleService vehicleService;

    public VehicleController(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<Vehicle> guardarVehiculo(@RequestBody Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{plate}")
    public ResponseEntity<Vehicle> get(@PathVariable("plate") String plate) {
        return new ResponseEntity<>(vehicleService.queryVehicleByPlate(plate), HttpStatus.OK);
    }

}
