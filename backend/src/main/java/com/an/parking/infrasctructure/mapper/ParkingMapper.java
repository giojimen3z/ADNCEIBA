package com.an.parking.infrasctructure.mapper;

import com.an.parking.domain.dto.Parking;
import com.an.parking.infrasctructure.entity.ParkingEntity;
import com.an.parking.infrasctructure.entity.VehicleEntity;

public class ParkingMapper {

    private ParkingMapper(){

    }

    public static Parking entityToDomain(ParkingEntity entity) {
        Parking domain = new Parking();
        domain.setParkingId(entity.getParkingId());
        domain.setVehicleId(entity.getVehicleId().getVehicleId());
        domain.setParkingEnterDate(entity.getParkingEnterDate());
        domain.setParkingExitDate(entity.getParkingExitDate());
        domain.setParkingTotal(entity.getParkingTotal());
        return domain;
    }

    public static ParkingEntity domainToEntity(Parking domain) {
        ParkingEntity entity = new ParkingEntity();
        VehicleEntity vehicleEntity = new VehicleEntity();
        entity.setParkingId(domain.getParkingId());
        vehicleEntity.setVehicleId(domain.getVehicleId());
        entity.setVehicleId(vehicleEntity);
        entity.setParkingEnterDate(domain.getParkingEnterDate());
        entity.setParkingExitDate(domain.getParkingExitDate());
        entity.setParkingTotal(domain.getParkingTotal());
        return entity;
    }

}
