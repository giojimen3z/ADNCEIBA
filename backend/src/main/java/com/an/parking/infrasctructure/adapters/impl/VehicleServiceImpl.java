package com.an.parking.infrasctructure.adapters.impl;

import com.an.parking.infrasctructure.adapters.IVehicleService;
import com.an.parking.infrasctructure.repository.entity.IVehicleRepository;
import com.an.parking.infrasctructure.repository.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BD")
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleRepository iVehicleRepository;

    @Override
    public VehicleEntity get(Long id) {
        return null;
    }

    @Override
    public List<VehicleEntity> getAll() {
        return iVehicleRepository.findAll();
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
