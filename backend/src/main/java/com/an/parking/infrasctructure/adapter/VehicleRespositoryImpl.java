package com.an.parking.infrasctructure.adapter;

import com.an.parking.domain.dto.Vehicle;
import com.an.parking.domain.exceptions.VehicleNotFoundException;
import com.an.parking.domain.repository.IVehicleRepository;
import com.an.parking.infrasctructure.adapter.jpa.IVehicleRepositoryJpa;
import com.an.parking.infrasctructure.mapper.VehicleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityNotFoundException;

public class VehicleRespositoryImpl implements IVehicleRepository {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleRespositoryImpl.class);

    public static final String VEHICLE_NOT_FOUND = "El vehiculo no se encuentra registrado";

    private final IVehicleRepositoryJpa repository;


    public VehicleRespositoryImpl (IVehicleRepositoryJpa repository ){
        this.repository =repository;
    }
    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return VehicleMapper.entityToDomain(repository.save(VehicleMapper.domainToEntity(vehicle)));
    }

    @Override
    public Vehicle queryVehicleByPlate(String plate) {
        return VehicleMapper.entityToDomain(this.repository.findByVehiclePlate(plate)
                .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND)));

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
}
