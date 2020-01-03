package com.an.parking.unit.domain;

import com.an.parking.domain.dto.Vehicle;
import com.an.parking.unit.databuilder.VehicleTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

public class VehicleTest {

    private static final Long VEHICLE_ID = 1L;
    private static final String PLATE_VEHICLE = "AGS12A";
    private static final Long CC_VEHICLE = 200L;
    private static final Long TYPE_ID = 1L;


    private Vehicle vehicle;

    @Before
    public void setUp() {
        // arrage
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder()
                .ccVehicle(CC_VEHICLE).typeId(TYPE_ID).vehicleId(VEHICLE_ID)
                .plateVehicle(PLATE_VEHICLE);
        // act
        vehicle = vehicleTestDataBuilder.build();
    }

    @Test
    public void buildvehiculo() throws ParseException {
        // assert
        assertNotNull(vehicle);
        assertEquals(vehicle.getVehicleId(), VEHICLE_ID);
        assertEquals(vehicle.getCcVehicle(), CC_VEHICLE);
        assertEquals(vehicle.getTypeId(), TYPE_ID);
        assertEquals(vehicle.getPlateVehicle(), PLATE_VEHICLE);
    }
}
