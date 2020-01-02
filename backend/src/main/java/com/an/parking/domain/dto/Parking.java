package com.an.parking.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Parking {
    private long parkingId;
    private long vehicleId;
    private Date parkingEnterDate;
    private Date parkingExitDate;
    private long parkingTotal;
}
