package com.an.parking.unit.databuilder;


import com.an.parking.domain.dto.Parking;
import com.an.parking.infrasctructure.entity.VehicleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ParkingTestDataBuilder {
    private static final long PARKING_ID = 1;
    private static final long VEHICLE_ID = 1;
    private static final String PARKING_ENTER_DATE = "10/12/2019 07:00:00";
    private static final String PARKING_EXIT_DATE = "10/12/2019 20:00:00";
    private static final long PARKING_TOTAL = 600;

    private static final Logger LOG = LoggerFactory.getLogger(ParkingTestDataBuilder.class);
    private Long parkingId;
    private Long vehicleId;
    private Date parkingEnterDate;
    private Date parkingExitDate;
    private Long parkingTotal;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");

    public ParkingTestDataBuilder(){
        try {
            this.parkingId = PARKING_ID;
            this.vehicleId = VEHICLE_ID;
            this.parkingEnterDate = dateFormat.parse(PARKING_ENTER_DATE);
            this.parkingExitDate = dateFormat.parse(PARKING_EXIT_DATE);
            this.parkingTotal = PARKING_TOTAL;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
    public ParkingTestDataBuilder parkingId(Long parkingId) {
        this.parkingId = parkingId;
        return this;
    }

    public ParkingTestDataBuilder vehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public ParkingTestDataBuilder ParkingDateEnter(Date parkingDateEnter) {
        this.parkingEnterDate = parkingDateEnter;
        return this;
    }

    public ParkingTestDataBuilder ParkingDateExit(Date parkingDateExit) {
        this.parkingExitDate = parkingDateExit;
        return this;
    }

    public ParkingTestDataBuilder parkingTotal(Long parkingTotal) {
        this.parkingTotal = parkingTotal;
        return this;
    }

    public Parking build() {
        Parking parking = new Parking();
        parking.setParkingId(this.parkingId);
        parking.setVehicleId(this.vehicleId);
        parking.setParkingEnterDate(this.parkingEnterDate);
        parking.setParkingExitDate(this.parkingExitDate);
        parking.setParkingTotal(this.parkingTotal);
        return parking;
    }

}
