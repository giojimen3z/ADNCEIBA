package com.an.parking.unit.domain;

import com.an.parking.domain.dto.Parking;
import com.an.parking.unit.databuilder.ParkingTestDataBuilder;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingTest {
    private static final Long PARKING_ID = 1L;
    private static final Long VEHICLE_ID = 1L;
    private static final String PARKING_ENTER_DATE = "14/12/2019 07:00:00";
    private static final String PARKING_EXIT_DATE = "15/12/2019 11:00:00";
    private static final long PARKING_TOTAL = 600;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
    @Test
    public void parkingBuild() throws ParseException {
        ParkingTestDataBuilder parkingTestDataBuilder = new ParkingTestDataBuilder();

        Parking parking = parkingTestDataBuilder.parkingId(PARKING_ID)
                .ParkingDateEnter(dateFormat.parse(PARKING_ENTER_DATE))
                .ParkingDateExit(dateFormat.parse(PARKING_EXIT_DATE)).parkingTotal(PARKING_TOTAL)
                .vehicleId(VEHICLE_ID).build();

        assertNotNull(parking);
        assertEquals(parking.getParkingEnterDate(), dateFormat.parse(PARKING_ENTER_DATE));
        assertEquals(parking.getParkingExitDate(), dateFormat.parse(PARKING_EXIT_DATE));
        assertEquals(parking.getParkingId(), PARKING_ID);
        assertEquals(parking.getParkingTotal(), PARKING_TOTAL);
        assertEquals(parking.getVehicleId(), VEHICLE_ID);

    }
}
