package com.an.parking.infrasctructure.controllers;


import com.an.parking.application.handler.IVehicleDelegate;
import com.an.parking.dto.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
