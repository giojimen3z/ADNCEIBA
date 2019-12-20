package com.an.parking.dto.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeVehicleDto {

    private Long id;
    private String cc;
    private boolean meanTransportation;


}
