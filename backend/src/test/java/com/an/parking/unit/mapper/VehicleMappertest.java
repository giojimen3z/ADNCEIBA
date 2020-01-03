package com.an.parking.unit.mapper;

import com.an.parking.domain.dto.Vehicle;
import com.an.parking.infrasctructure.entity.VehicleEntity;
import com.an.parking.infrasctructure.mapper.VehicleMapper;
import com.an.parking.unit.databuilder.VehicleEntityTestDataBuilder;
import com.an.parking.unit.databuilder.VehicleTestDataBuilder;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VehicleMappertest {
    Vehicle vehicle;
    VehicleEntity vehicleEntity;

    VehicleTestDataBuilder vehicleTestDataBuilder;
    VehicleEntityTestDataBuilder vehicleEntityTestDataBuilder;

    @Before
    public void setUp() {
        vehicleTestDataBuilder = new VehicleTestDataBuilder();
        vehicleEntityTestDataBuilder = new VehicleEntityTestDataBuilder();
    }

    @Test
    public void domainToEntity() {
        vehicle = vehicleTestDataBuilder.build();
        vehicleEntity = VehicleMapper.domainToEntity(vehicle);
        assertEquals(vehicle.getVehicleId(), vehicleEntity.getVehicleId());
        assertEquals(vehicle.getTypeId(), vehicleEntity.getTypeId().getTypeId());
        assertEquals(vehicle.getCcVehicle(), vehicleEntity.getCcVehicle());
        assertEquals(vehicle.getPlateVehicle(), vehicleEntity.getPlateVehicle());
    }

    @Test
    public void entityToDomain() {
        vehicleEntity = vehicleEntityTestDataBuilder.build();
        vehicle = VehicleMapper.entityToDomain(vehicleEntity);
        assertEquals(vehicleEntity.getVehicleId(), vehicle.getVehicleId());
        assertEquals(vehicleEntity.getTypeId().getTypeId(), vehicle.getTypeId());
        assertEquals(vehicleEntity.getCcVehicle(), vehicle.getCcVehicle());
        assertEquals(vehicleEntity.getPlateVehicle(), vehicle.getPlateVehicle());
    }

}
