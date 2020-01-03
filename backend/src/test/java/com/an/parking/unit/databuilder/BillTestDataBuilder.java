package com.an.parking.unit.databuilder;

import com.an.parking.domain.dto.Bill;
import com.an.parking.domain.dto.Parking;

public class BillTestDataBuilder {

    private static final Parking PARKING_DEFAULT = new ParkingTestDataBuilder().build();
    private Parking parking;

    public BillTestDataBuilder(){

        this.parking = PARKING_DEFAULT;
    }
    public BillTestDataBuilder parking(Parking parking) {
        this.parking = parking;
        return this;
    }

    public Bill build() {
        Bill bill = new Bill();
        bill.setParking(this.parking);
        return bill;
    }


}
