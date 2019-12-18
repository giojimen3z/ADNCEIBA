package com.an.parking.infrasctructure.adapters.impl;

import com.an.parking.application.handler.IVehicleDelegate;
import com.an.parking.infrasctructure.adapters.IVehicleService;
import com.an.parking.infrasctructure.repository.entity.VehicleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("API")
public class VehicleAPi implements IVehicleService {

    @Override
    public VehicleEntity get(Long id) {
        return null;
    }

    @Override
    public List<VehicleEntity> getAll() {
        return null;
    }

    @Override
    public boolean save(VehicleEntity vehicleDto) {
        return false;
    }

    @Override
    public boolean update(Long id, VehicleEntity vehicleDto) {
        return false;
    }
}
