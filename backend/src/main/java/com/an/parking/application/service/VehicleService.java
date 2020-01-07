package com.an.parking.application.service;

import com.an.parking.domain.dto.Parking;
import com.an.parking.domain.dto.Vehicle;
import com.an.parking.domain.repository.IParkingRepository;
import com.an.parking.domain.repository.IVehicleRepository;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class VehicleService {

    private final IVehicleRepository iVehicleRepository;
    private final IParkingRepository iParkingRepository;

    public VehicleService(final IVehicleRepository iVehicleRepository, final IParkingRepository iParkingRepository) {
        this.iVehicleRepository = iVehicleRepository;
        this.iParkingRepository = iParkingRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        Vehicle vehicleCreated = iVehicleRepository.saveVehicle(vehicle);
        Parking parking = new Parking();
        parking.setVehicleId(vehicleCreated.getVehicleId());
        parking.setParkingEnterDate(Calendar.getInstance().getTime());
        parking = iParkingRepository.addmisionRegister(parking);
        return vehicleCreated;
    }
    public List<Vehicle> getAll(){

        return  iVehicleRepository.findAllVehicles();
    }


    public void deleteVehicle (String plate){

         iVehicleRepository.deleteVehicle(plate);
    }

    public Vehicle queryVehicleByPlate(String plate) {
        return iVehicleRepository.queryVehicleByPlate(plate);
    }

}
