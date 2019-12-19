package com.an.parking.infrasctructure.repository.entity;

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

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "")
    private BrandEntity brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public TypeVehicleEntity getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicleEntity typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
