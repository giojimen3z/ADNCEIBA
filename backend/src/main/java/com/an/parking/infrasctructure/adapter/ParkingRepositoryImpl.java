package com.an.parking.infrasctructure.adapter;

import com.an.parking.domain.dto.Parking;
import com.an.parking.domain.exceptions.ParkingNotFoundException;
import com.an.parking.domain.repository.IParkingRepository;
import com.an.parking.infrasctructure.adapter.jpa.IParkingRepositoryJpa;
import com.an.parking.infrasctructure.mapper.ParkingMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ParkingRepositoryImpl implements IParkingRepository {

    private final IParkingRepositoryJpa repository;

    public ParkingRepositoryImpl(final IParkingRepositoryJpa repository) {
        this.repository = repository;
    }


    @Override
    public Parking addmisionRegister(Parking parking) {
        return ParkingMapper.entityToDomain(repository.save(ParkingMapper.domainToEntity(parking)));
    }

    @Override
    public Parking exitRegister(Parking parking) {
        return ParkingMapper.entityToDomain(repository.save(ParkingMapper.domainToEntity(parking)));
    }

    @Override
    public long parkingSites(Long typeId, Long parkingTotal) {
        return repository.countByVehicleIdTypeIdAndParkingTotal(typeId,parkingTotal);
    }

    @Override
    public void parkedVehicle(String vehiclePlate) {
        if (repository.findByVehicleIdPlateVehicle(vehiclePlate).isPresent())
            throw new ParkingNotFoundException("El Vehiculo ya se encuentra estacionado");

    }

    @Override
    public Parking parkedVehicleTotalParking(String vehiclePlate) {
        return ParkingMapper.entityToDomain(repository.findByVehicleIdPlateVehicle(vehiclePlate)
                .orElseThrow(() -> new ParkingNotFoundException("El vehiculo no se entruentra estacionado")));
    }

}
