package com.an.parking.domain.repository;

import com.an.parking.domain.dto.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    Vehicle saveVehicle(Vehicle vehicle);

    Vehicle queryVehicleByPlate(String plate);

    Vehicle queryById(Long id);

    //Vehicle deleteVehicle(String plate);

    List<Vehicle> findAllVehicles();


}
