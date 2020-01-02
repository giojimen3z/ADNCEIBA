package com.an.parking.infrasctructure.mapper;

import com.an.parking.domain.dto.Vehicle;
import com.an.parking.infrasctructure.entity.TypeEntity;
import com.an.parking.infrasctructure.entity.VehicleEntity;

public class VehicleMapper {

    private VehicleMapper(){

    }

    public static Vehicle entityToDomain(VehicleEntity entity) {
        Vehicle domain = new Vehicle();
        domain.setVehicleId(entity.getVehicleId());
        domain.setTypeId(entity.getTypeId().getTypeId());
        domain.setCcVehicle(entity.getCcVehicle());
        domain.setPlateVehicle(entity.getPlateVehicle());
        return domain;
    }

    public static VehicleEntity domainToEntity(Vehicle domain) {
        VehicleEntity entity = new VehicleEntity();
        TypeEntity type = new TypeEntity();
        entity.setVehicleId(domain.getVehicleId());
        type.setTypeId(domain.getTypeId());
        entity.setTypeId(type);
        entity.setPlateVehicle(domain.getPlateVehicle());
        entity.setCcVehicle(domain.getCcVehicle());

        return entity;
    }


}
