package com.an.parking.infrasctructure.repository.entity.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate")
    private String plate;

    @OneToOne
    private TypeVehicleEntity typeVehicle;

    @OneToOne
    private BrandEntity brand;

    @OneToOne
    private LocationEntity location;


}
