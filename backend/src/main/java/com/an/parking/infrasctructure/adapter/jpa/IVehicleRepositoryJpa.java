package com.an.parking.infrasctructure.adapter.jpa;

import com.an.parking.infrasctructure.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IVehicleRepositoryJpa extends JpaRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findByPlateVehicle (String plate);


}
