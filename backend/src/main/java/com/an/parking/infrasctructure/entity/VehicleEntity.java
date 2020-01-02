package com.an.parking.infrasctructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "vehicle")

public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicleId;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private TypeEntity  typeId;

    @Column(name = "cc_vehicle", nullable = true)

    private long ccVehicle;
    @Column(name = "plate_vehicle", nullable = true)
    private String plateVehicle;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicleId")
    private Set<ParkingEntity> parkingEntity;


}
