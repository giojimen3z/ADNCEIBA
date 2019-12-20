package com.an.parking.dto.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long id;
    private TypeVehicleDto typeVehicle;
    private String plate;
    private Brand brand;
    private  Location location;

}
