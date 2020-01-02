package com.an.parking.application.service;

import com.an.parking.domain.dto.Vehicle;
import com.an.parking.domain.repository.IVehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final IVehicleRepository iVehicleRepository;

    public VehicleService(final IVehicleRepository iVehicleRepository) {
        this.iVehicleRepository = iVehicleRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return iVehicleRepository.saveVehicle(vehicle);
    }
    public List<Vehicle> getAll(){

        return  iVehicleRepository.findAllVehicles();
    }
    public Vehicle queryVehicleByPlate(String plate) {
        return iVehicleRepository.queryVehicleByPlate(plate);
    }

}
