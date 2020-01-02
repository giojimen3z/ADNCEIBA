package com.an.parking.domain.repository;

import com.an.parking.domain.dto.Vehicle;

public interface IVehicleRepository {

    Vehicle saveVehicle(Vehicle vehicle);

    Vehicle queryVehicleByPlate(String plate);

    Vehicle queryById(Long id);

}
