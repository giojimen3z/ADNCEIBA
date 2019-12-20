package com.an.parking.infrasctructure.adapters.impl;

import com.an.parking.infrasctructure.adapters.IVehicleService;
import com.an.parking.infrasctructure.repository.entity.vehicle.IVehicleRepository;
import com.an.parking.infrasctructure.repository.entity.vehicle.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BD")
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleRepository iVehicleRepository;

    @Override
    public VehicleEntity get(Long id) {
        return iVehicleRepository.getOne(id);
    }

    @Override
    public List<VehicleEntity> getAll() {
        return iVehicleRepository.findAll();
    }

    @Override
    public VehicleEntity save(VehicleEntity vehicleEntity) {
        return iVehicleRepository.save(vehicleEntity);
    }

    @Override
    public VehicleEntity update(VehicleEntity vehicleEntity) {
        return iVehicleRepository.save(vehicleEntity);
    }
}
