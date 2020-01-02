package com.an.parking.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Type {

    private Long typeId;
    private String typeDesc;
    private Long typePriceHour;
    private Long typePriceDay;
    private Long typeExtraPay;
}
