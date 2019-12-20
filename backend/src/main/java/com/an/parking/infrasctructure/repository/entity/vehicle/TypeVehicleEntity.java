package com.an.parking.infrasctructure.repository.entity.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VehicleType")
public class TypeVehicleEntity {
    @Id
    private Long id;
    private String cc;
    private boolean meanTransportation;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public boolean isMeanTransportation() {
        return meanTransportation;
    }

    public void setMeanTransportation(boolean meanTransportation) {
        this.meanTransportation = meanTransportation;
    }
}
