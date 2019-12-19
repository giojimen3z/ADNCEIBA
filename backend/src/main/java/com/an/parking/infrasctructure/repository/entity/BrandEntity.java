package com.an.parking.infrasctructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "brand")
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class BrandEntity {
    @Id
    private Long id;
    private String name;
    private String price;


}
