package com.an.parking.infrasctructure.adapters;

import com.an.parking.infrasctructure.repository.entity.vehicle.VehicleEntity;

import java.util.List;

public interface IVehicleService {

    VehicleEntity get(Long id);

    List<VehicleEntity> getAll();

    VehicleEntity save(VehicleEntity vehicleDto);

    VehicleEntity update(VehicleEntity vehicleDto);

}