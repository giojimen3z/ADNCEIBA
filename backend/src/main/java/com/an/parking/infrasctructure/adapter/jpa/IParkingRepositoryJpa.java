package com.an.parking.infrasctructure.adapter.jpa;

import com.an.parking.infrasctructure.entity.ParkingEntity;
import com.an.parking.infrasctructure.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IParkingRepositoryJpa extends JpaRepository<ParkingEntity,Long> {

    int countByVehicleIdTypeIdAndParkingTotal(long typeId, long parkingTotal);
    Optional<ParkingEntity> findByVehicleIdPlateVehicle(String plate);

    List<ParkingEntity> findByVehicleIdIsNotNullAndParkingEnterDateIsNotNullAndParkingExitDateIsNull();

}
