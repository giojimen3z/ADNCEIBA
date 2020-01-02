package com.an.parking.application.service;

import com.an.parking.domain.dto.Vehicle;
import com.an.parking.domain.repository.IVehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final IVehicleRepository iVehicleRepository;

    public VehicleService(final IVehicleRepository iVehicleRepository) {
        this.iVehicleRepository = iVehicleRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return iVehicleRepository.saveVehicle(vehicle);
    }

    public Vehicle queryVehicleByPlate(String plate) {
        return iVehicleRepository.queryVehicleByPlate(plate);
    }

}
