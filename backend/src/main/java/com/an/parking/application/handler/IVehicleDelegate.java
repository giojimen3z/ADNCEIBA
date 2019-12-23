package com.an.parking.application.handler;

import com.an.parking.dto.vehicle.VehicleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleDelegate {

    ResponseEntity<VehicleDto> get(Long id);

    ResponseEntity<List<VehicleDto>> getAll();

    ResponseEntity<VehicleDto> save(VehicleDto vehicleDto);

    ResponseEntity update(VehicleDto vehicleDto);

}
