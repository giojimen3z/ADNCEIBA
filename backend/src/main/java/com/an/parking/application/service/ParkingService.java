package com.an.parking.application.service;

import com.an.parking.domain.dto.Bill;
import com.an.parking.domain.dto.Parking;
import com.an.parking.domain.dto.Type;
import com.an.parking.domain.dto.Vehicle;
import com.an.parking.domain.repository.IParkingRepository;
import com.an.parking.domain.repository.ITypeRepository;
import com.an.parking.domain.repository.IVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class ParkingService {

    private static final long TOTAL_PARKING_CERO = 0;

    private final IParkingRepository iParkingRepository;
    private final IVehicleRepository iVehicleRepository;
    private final RegisterService registerService;
    private final ITypeRepository iTypeRepository;


    public ParkingService(IParkingRepository iParkingRepository, IVehicleRepository iVehicleRepository, RegisterService registerService,
                          ITypeRepository iTypeRepository ) {
        this.iParkingRepository = iParkingRepository;
        this.iVehicleRepository = iVehicleRepository;
        this.registerService = registerService;
        this.iTypeRepository = iTypeRepository;

    }

    public Parking addmisionRegister(Vehicle vehicle) {
        Calendar addmisionDate = Calendar.getInstance();
        vehicle = iVehicleRepository.queryById(vehicle.getVehicleId());
        iParkingRepository.parkedVehicle(vehicle.getPlateVehicle());
        long spacesCounterParking = iParkingRepository.parkingSites(vehicle.getTypeId(),
                TOTAL_PARKING_CERO);
        registerService.parkingCapacity(spacesCounterParking, vehicle.getTypeId());
        return this.iParkingRepository.addmisionRegister(this.registerService.registerValidation(vehicle, addmisionDate));
    }

    public Bill exitRegister(String plate) {
        Vehicle vehicle = iVehicleRepository.queryVehicleByPlate(plate);
        Type type = iTypeRepository.queryById(vehicle.getTypeId());
        Parking parking = iParkingRepository.parkedVehicleTotalParking(plate);
        return registerService.billGeneration(vehicle, type, parking);
    }
}
