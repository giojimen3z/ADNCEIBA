package com.an.parking.infrasctructure.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "parking")
public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parkingId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity vehicleId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "parking_enter_date", nullable = false)
    private Date parkingEnterDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "parking_exit_date", nullable = true)
    private Date parkingExitDate;

    @Column(name = "parking_total", nullable = true)
    private long parkingTotal;
}
