package com.an.parking.unit.mapper;

import com.an.parking.domain.dto.Parking;
import com.an.parking.infrasctructure.entity.ParkingEntity;
import com.an.parking.infrasctructure.mapper.ParkingMapper;
import com.an.parking.unit.databuilder.ParkingEntityTestDataBuilder;
import com.an.parking.unit.databuilder.ParkingTestDataBuilder;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ParkingMapperTest {

    Parking parking;
    ParkingEntity parkingEntity;

    ParkingTestDataBuilder parkingTestDataBuilder;
    ParkingEntityTestDataBuilder parkingEntityTestDataBuilder;
    @Before
    public void setUp() {
        parkingTestDataBuilder = new ParkingTestDataBuilder();
        parkingEntityTestDataBuilder = new ParkingEntityTestDataBuilder();
    }

    @Test
    public void domainToEntityTest() {
        parking = parkingTestDataBuilder.build();
        parkingEntity = ParkingMapper.domainToEntity(parking);
        assertEquals(parking.getParkingId(), parkingEntity.getParkingId());
        assertEquals(parking.getVehicleId(), parkingEntity.getVehicleId().getVehicleId());
        assertEquals(parking.getParkingEnterDate(), parkingEntity.getParkingEnterDate());
        assertEquals(parking.getParkingExitDate(), parkingEntity.getParkingExitDate());
        assertEquals(parking.getParkingTotal(), parkingEntity.getParkingTotal());
    }

    @Test
    public void entityToDOmainTest() {
        parkingEntity = parkingEntityTestDataBuilder.build();
        parking = ParkingMapper.entityToDomain(parkingEntity);
        assertEquals(parkingEntity.getParkingId(), parking.getParkingId());
        assertEquals(parkingEntity.getVehicleId().getVehicleId(), parking.getVehicleId());
        assertEquals(parkingEntity.getParkingEnterDate(), parking.getParkingEnterDate());
        assertEquals(parkingEntity.getParkingExitDate(), parking.getParkingExitDate());
        assertEquals(parkingEntity.getParkingTotal(), parking.getParkingTotal());
    }

}
