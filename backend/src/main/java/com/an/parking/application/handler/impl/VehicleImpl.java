package com.an.parking.application.handler.impl;

import com.an.parking.application.handler.IVehicleDelegate;
import com.an.parking.dto.VehicleDto;
import com.an.parking.infrasctructure.adapters.IVehicleService;
import com.an.parking.infrasctructure.mapper.IMapperVehicle;
import com.an.parking.infrasctructure.repository.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleImpl implements IVehicleDelegate {

    private final IVehicleService iVehicleService;
    private final IMapperVehicle iMapperVehicle;

    public VehicleImpl(@Qualifier("BD") IVehicleService iVehicleService, IMapperVehicle iMapperVehicle) {
        this.iVehicleService = iVehicleService;
        this.iMapperVehicle = iMapperVehicle;
    }

    @Override
    public ResponseEntity<VehicleDto> get(Long id) {
        // VehicleEntity vehicleEntity = this.iVehicleService.get(id);
        //VehicleDto vehicleDto = iMapperVehicle.entityToDto(vehicleEntity);
        return ResponseEntity.ok(this.iMapperVehicle.entityToDto(this.iVehicleService.get(id)));
    }

    @Override
    public ResponseEntity<List<VehicleDto>> getAll() {
        //HERE YOU SHOULD VALIDATE THE BUSINESS LOGIC
//        List<VehicleEntity> vehicleEntities = this.iVehicleService.getAll();
//        List<VehicleDto> vehicleDtos = this.iMapperVehicle.dtoToEntity(vehicleEntities);
//        return ResponseEntity.ok(vehicleDtos);
        return ResponseEntity.ok(this.iMapperVehicle.entityToDto(this.iVehicleService.getAll()));
    }

    @Override
    public ResponseEntity<VehicleDto> save(VehicleDto vehicleDto) {

        VehicleEntity vehicleEntity = this.iMapperVehicle.dtoToEntity(vehicleDto);
        VehicleEntity _vehicleEntity = this.iVehicleService.save(vehicleEntity);
        VehicleDto _vehicleDto = this.iMapperVehicle.entityToDto(_vehicleEntity);
        return ResponseEntity.ok(_vehicleDto);


        //   return ResponseEntity.ok(this.iMapperVehicle.entityToDto(vehicleEntity));
    }

    @Override
    public ResponseEntity update(Long id, VehicleDto vehicleDto) {
        return null;
    }
}
