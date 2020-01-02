package com.an.parking.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bill {


    private Parking parking;
    private Vehicle vehicle;

}
