package com.an.parking.dto;

import lombok.Data;

@Data
public class VehicleDto {

    private TypeVehicleDto typeVehicleDto;
    private String plate;
    private Brand brand;

}
