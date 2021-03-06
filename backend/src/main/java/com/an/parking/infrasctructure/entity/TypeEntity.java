package com.an.parking.infrasctructure.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "type")
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @Column(name = "type_Desc")
    private String typeDesc;

    @Column(name = "type_price_hour")
    private Long typePriceHour;

    @Column(name = "type_price_day")
    private Long typePriceDay;

    @Column(name = "type_extra_pay")
    private Long typeExtraPay;

}
