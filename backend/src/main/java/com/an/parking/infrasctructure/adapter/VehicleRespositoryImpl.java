package com.an.parking.infrasctructure.adapter;

import com.an.parking.domain.dto.Vehicle;
import com.an.parking.domain.exceptions.VehicleNotFoundException;
import com.an.parking.domain.repository.IParkingRepository;
import com.an.parking.domain.repository.IVehicleRepository;
import com.an.parking.infrasctructure.adapter.jpa.IParkingRepositoryJpa;
import com.an.parking.infrasctructure.adapter.jpa.IVehicleRepositoryJpa;
import com.an.parking.infrasctructure.entity.ParkingEntity;
import com.an.parking.infrasctructure.entity.VehicleEntity;
import com.an.parking.infrasctructure.mapper.VehicleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class VehicleRespositoryImpl implements IVehicleRepository {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleRespositoryImpl.class);

    public static final String VEHICLE_NOT_FOUND = "El vehiculo no se encuentra registrado";


    private final IVehicleRepositoryJpa repository;
    private final IParkingRepositoryJpa parkingRepository;

    public VehicleRespositoryImpl(IVehicleRepositoryJpa repository, IParkingRepositoryJpa parkingRepository) {
        this.repository = repository;
        this.parkingRepository = parkingRepository;
    }


    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return VehicleMapper.entityToDomain(repository.save(VehicleMapper.domainToEntity(vehicle)));
    }

    @Override
    public Vehicle queryVehicleByPlate(String plate) {
        return VehicleMapper.entityToDomain(this.repository.findByPlateVehicle(plate)
                .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND)));

    }

    @Override
    public List<Vehicle> findAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        List<ParkingEntity> entityList = parkingRepository.findByVehicleIdIsNotNullAndParkingEnterDateIsNotNullAndParkingExitDateIsNull();
        entityList.forEach(value -> vehicles.add(VehicleMapper.entityToDomain(value.getVehicleId())));
        return vehicles;
    }

    @Override
    public Vehicle queryById(Long id) {
        try {
            return VehicleMapper.entityToDomain(repository.getOne(id));
        } catch (EntityNotFoundException e) {
            LOG.error(VEHICLE_NOT_FOUND, e);
            throw new VehicleNotFoundException(VEHICLE_NOT_FOUND);
        }
    }

    @Override
    public void deleteVehicle(String plate) {
        this.parkingRepository.delete(this.parkingRepository.findByVehicleIdPlateVehicle(plate).get());
        this.repository.delete(this.repository.findByPlateVehicle(plate).get());
    }
}
