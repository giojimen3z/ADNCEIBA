package com.an.parking.infrasctructure.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate")
    private String plate;

    @OneToOne
    private TypeVehicleEntity typeVehicleDto;
    @OneToOne
    private BrandEntity brandEntity;

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

    public TypeVehicleEntity getTypeVehicleDto() {
        return typeVehicleDto;
    }

    public void setTypeVehicleDto(TypeVehicleEntity typeVehicleDto) {
        this.typeVehicleDto = typeVehicleDto;
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }
}
