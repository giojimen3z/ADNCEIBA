package com.an.parking.infrasctructure.adapters;

import com.an.parking.infrasctructure.repository.entity.VehicleEntity;

import java.util.List;

public interface IVehicleService {

    VehicleEntity get(Long id);

    List<VehicleEntity> getAll();

    VehicleEntity save(VehicleEntity vehicleDto);

    VehicleEntity update(Long id, VehicleEntity vehicleDto);

}
