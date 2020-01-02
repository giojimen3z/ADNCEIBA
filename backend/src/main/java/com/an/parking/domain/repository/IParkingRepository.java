package com.an.parking.domain.repository;

import com.an.parking.domain.dto.Parking;

public interface IParkingRepository {

    Parking addmisionRegister(Parking parking);

    Parking exitRegister(Parking parking);

    long parkingSites(long typeId, long parkingTotal);

    void parkedVehicle (String vehiclePlate);

    Parking parkedVehicleTotalParking(String vehiclePlate);
}
