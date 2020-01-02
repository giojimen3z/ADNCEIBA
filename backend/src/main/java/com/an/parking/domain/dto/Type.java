package com.an.parking.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Type {

    private long typeId;
    private String typeDesc;
    private long typePriceHour;
    private long typePriceDay;
    private long typeExtraPay;
}
