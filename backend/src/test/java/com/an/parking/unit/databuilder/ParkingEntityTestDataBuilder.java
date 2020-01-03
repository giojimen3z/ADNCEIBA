package com.an.parking.unit.databuilder;

import com.an.parking.infrasctructure.entity.ParkingEntity;
import com.an.parking.infrasctructure.entity.VehicleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ParkingEntityTestDataBuilder {

    private static final long PARKING_ID = 1;
    private static final VehicleEntity VEHICLE_ID = new VehicleEntityTestDataBuilder().build();
    private static final String PARKING_ENTER_DATE = "10/12/2019 07:00:00";
    private static final String PARKING_EXIT_DATE = "10/12/2019 20:00:00";
    private static final long PARKING_TOTAL = 600;

    private static final Logger LOG = LoggerFactory.getLogger(ParkingEntityTestDataBuilder.class);

    private Long parkingId;
    private VehicleEntity vehicleId;
    private Date parkingEnterDate;
    private Date parkingExitDate;
    private Long parkingTotal;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");

    public ParkingEntityTestDataBuilder(){
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
    public ParkingEntityTestDataBuilder ParkingId(Long parkingId) {
        this.parkingId = parkingId;
        return this;
    }

    public ParkingEntityTestDataBuilder vehicleId(VehicleEntity vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public ParkingEntityTestDataBuilder ParkingDateEnter(Date parkingDateEnter) {
        this.parkingEnterDate = parkingDateEnter;
        return this;
    }

    public ParkingEntityTestDataBuilder ParkingDateExit(Date parkingDateExit) {
        this.parkingExitDate = parkingDateExit;
        return this;
    }

    public ParkingEntityTestDataBuilder ParkingTotal(Long parkingTotal) {
        this.parkingTotal = parkingTotal;
        return this;
    }

    public ParkingEntity build() {
        ParkingEntity parking = new ParkingEntity();
        parking.setParkingId(this.parkingId);
        parking.setVehicleId(this.vehicleId);
        parking.setParkingEnterDate(this.parkingEnterDate);
        parking.setParkingExitDate(this.parkingExitDate);
        parking.setParkingTotal(this.parkingTotal);
        return parking;
    }


}
