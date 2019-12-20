package com.an.parking.infrasctructure.controllers;


import com.an.parking.application.handler.IVehicleDelegate;
import com.an.parking.dto.vehicle.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class RegisterVehicle {

    @Autowired
    private IVehicleDelegate iVehicleDelegate;

    @GetMapping("/list")
    public ResponseEntity<List<VehicleDto>> getVehicle() {
        return iVehicleDelegate.getAll();
    }
    @GetMapping("/{id}")
    public  ResponseEntity<VehicleDto> get(@PathVariable Long id ){ return iVehicleDelegate.get(id);}

    @PostMapping()

    public ResponseEntity save(@RequestBody VehicleDto vehicleDto){

            return iVehicleDelegate.save(vehicleDto);
    }




}
