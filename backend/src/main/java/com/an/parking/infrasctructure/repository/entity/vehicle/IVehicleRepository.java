package com.an.parking.infrasctructure.repository.entity.vehicle;

import com.an.parking.infrasctructure.repository.entity.vehicle.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends JpaRepository<VehicleEntity, Long> {
}
