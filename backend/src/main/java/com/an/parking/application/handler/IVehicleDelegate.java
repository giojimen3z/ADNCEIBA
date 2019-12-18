package com.an.parking.application.handler;

import com.an.parking.dto.VehicleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleDelegate {

    ResponseEntity<VehicleDto> get(Long id);

    ResponseEntity<List<VehicleDto>> getAll();

    ResponseEntity save(VehicleDto vehicleDto);

    ResponseEntity update(Long id, VehicleDto vehicleDto);

}
