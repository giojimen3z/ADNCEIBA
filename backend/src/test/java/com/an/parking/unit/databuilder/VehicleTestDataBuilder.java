package com.an.parking.unit.databuilder;

import com.an.parking.domain.dto.Vehicle;
import com.an.parking.infrasctructure.entity.TypeEntity;

public class VehicleTestDataBuilder {

    private static final long VEHICLE_ID = 1;
    private static final long TYPE_ID = 1;
    private static final long CC_VEHICLE = 650;
    private static final String PLATE_VEHICLE= "ASD15A";

    private Long vehicleId;
    private Long typeId;
    private Long ccVehicle;
    private String plateVehicle;

    public VehicleTestDataBuilder(){
        this.vehicleId = VEHICLE_ID;
        this.typeId = TYPE_ID;
        this.ccVehicle = CC_VEHICLE;
        this.plateVehicle = PLATE_VEHICLE;

    }
    public VehicleTestDataBuilder vehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public VehicleTestDataBuilder typeId(long typeId) {
        this.typeId = typeId;
        return this;
    }

    public VehicleTestDataBuilder ccVehicle(long ccVehicle) {
        this.ccVehicle = ccVehicle;
        return this;
    }


    public VehicleTestDataBuilder plateVehicle(String plateVehicle) {
        this.plateVehicle = plateVehicle;
        return this;
    }

    public Vehicle build() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(this.vehicleId);
        vehicle.setTypeId(this.typeId);
        vehicle.setCcVehicle(this.ccVehicle);
        vehicle.setPlateVehicle(this.plateVehicle);
        return vehicle;
    }

}
