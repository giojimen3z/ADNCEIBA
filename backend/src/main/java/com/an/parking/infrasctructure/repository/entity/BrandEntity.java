package com.an.parking.infrasctructure.repository.entity;

import javax.persistence.*;

@Table(name = "brand")
@Entity
public class BrandEntity {
    @Id
    private Long id;
    private String name;
    private String price;
}
