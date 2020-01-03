package com.an.parking.unit.databuilder;

import com.an.parking.infrasctructure.entity.TypeEntity;
import com.an.parking.infrasctructure.entity.VehicleEntity;

public class VehicleEntityTestDataBuilder {

    private static final long VEHICLE_ID = 1;
    private static final TypeEntity TYPE_ID = new TypeEntityTestDataBuilder().build();
    private static final long CC_VEHICLE = 650;
    private static final String PLATE_VEHICLE= "ASD15A";

    private Long vehicleId;
    private TypeEntity typeId;
    private Long ccVehicle;
    private String plateVehicle;

    public VehicleEntityTestDataBuilder(){
        this.vehicleId = VEHICLE_ID;
        this.typeId = TYPE_ID;
        this.ccVehicle = CC_VEHICLE;
        this.plateVehicle = PLATE_VEHICLE;
    }

    public VehicleEntityTestDataBuilder vehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public VehicleEntityTestDataBuilder typeId(TypeEntity typeId) {
        this.typeId = typeId;
        return this;
    }

    public VehicleEntityTestDataBuilder ccVehicle(long ccVehicle) {
        this.ccVehicle = ccVehicle;
        return this;
    }



    public VehicleEntityTestDataBuilder plateVehicle(String plateVehicle) {
        this.plateVehicle = plateVehicle;
        return this;
    }

    public VehicleEntity build() {
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setVehicleId(this.vehicleId);
        vehicleEntity.setTypeId(this.typeId);
        vehicleEntity.setCcVehicle(this.ccVehicle);
        vehicleEntity.setPlateVehicle(this.plateVehicle);
        return vehicleEntity;
    }

}
