package com.an.parking.unit.domain;

import com.an.parking.domain.dto.Bill;
import com.an.parking.domain.dto.Parking;
import com.an.parking.unit.databuilder.BillTestDataBuilder;
import com.an.parking.unit.databuilder.ParkingTestDataBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class BillTest {

    private static final Parking PARKING = new ParkingTestDataBuilder().build();

    @Test
    public void parkingBuild() {
        BillTestDataBuilder billTestDataBuilder = new BillTestDataBuilder();

        Bill bill = billTestDataBuilder.parking(PARKING).build();

        assertNotNull(bill);

    }
}
