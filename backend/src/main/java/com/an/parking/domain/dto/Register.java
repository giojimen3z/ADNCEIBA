package com.an.parking.domain.dto;

import com.an.parking.domain.exceptions.ParkingNotFoundException;
import com.an.parking.domain.exceptions.TypeNotFoundException;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class Register {

    private static final long VEHICLE_TYPE_CAR = 2;
    private static final long VEHICLE_TYPE_MOTO = 1;
    private static final String VEHICLE_NOT_FOUND = "Tipo de Vehiculo Incompatible";
    private static final String ERROR_DENIED_ACCES = "Acceso denegado: Los Vehiculos con placas que inicial con "
            + "'A' Solo pueden ingresar los Domingos y Lunes";
    private static final String ERROR_PARKING_FULL = "Acceso denegado: El estacionamiento esta en su maxima capacidad";

    private static final String FIRST_LETTER_PLATE = "A";
    private static final int MAX_CAPACITY_CARS = 50;
    private static final int MAX_CAPACITY_MOTO = 30;
    private static final int MAX_CC_RATE = 200;


    public Parking registerValidation (Vehicle vehicle, Calendar admissionDate) {
        Parking parking;

        if (Objects.equals(vehicle.getTypeId(), VEHICLE_TYPE_CAR) || Objects.equals(vehicle.getTypeId(), VEHICLE_TYPE_MOTO)) {
            if (vehicleEntry(vehicle, admissionDate) || !plateValue(vehicle.getPlateVehicle())) {
                parking = new Parking();
                parking.setVehicleId(vehicle.getVehicleId());
                parking.setParkingEnterDate(admissionDate.getTime());
                parking.setParkingTotal(0);
                return parking;
            }else{
                throw new ParkingNotFoundException(ERROR_DENIED_ACCES);
            }
        }else{
            throw new TypeNotFoundException(VEHICLE_NOT_FOUND);
        }


    }
        //se  evalua la entrada del   vehiculo
    public boolean vehicleEntry(Vehicle vehicle, Calendar admissionDate) {
        return (plateValue(vehicle.getPlateVehicle()) && vehicleEntryDay(admissionDate));
    }
    //Se valida la primera letra de la placa del vehiculo
    public boolean plateValue(String plate) {
        return plate.toUpperCase().startsWith(FIRST_LETTER_PLATE);
    }

    //se valida  el dia en el que ingresa el vehiculo
    public boolean vehicleEntryDay(Calendar admissionDate) {
        return (Objects.equals(admissionDate.get(Calendar.DAY_OF_WEEK), Calendar.SUNDAY)
                || Objects.equals(admissionDate.get(Calendar.DAY_OF_WEEK), Calendar.MONDAY) ? Boolean.TRUE
                : Boolean.FALSE);
    }
    //Se valida la capacidad del estacionamiento
    public boolean parkingCapacity(long parkingCapacity, long typeId) {
        boolean isFull = ((typeId == VEHICLE_TYPE_CAR ? MAX_CAPACITY_CARS
                : MAX_CAPACITY_MOTO) <= parkingCapacity);
        if (isFull)
            throw new ParkingNotFoundException(ERROR_PARKING_FULL);
        return isFull;
    }
    // se  valida  la salida  y se genera la  factura
    public Bill billGeneration(Vehicle vehicle, Type type, Parking parking) {
        Bill bill = new Bill();
        Calendar admissionDate;
        Calendar exitDate;
        admissionDate = exitDate = Calendar.getInstance();
        admissionDate.setTime(parking.getParkingEnterDate());
        parking.setParkingTotal(totalParking(admissionDate, exitDate, type, vehicle));
        parking.setParkingExitDate(exitDate.getTime());
        bill.setParking(parking);
        bill.setVehicle(vehicle);
        return bill;
    }

    //Calcula  el  tiempo total y el costo  del mismo
    public long totalParking(Calendar admissionDate, Calendar exitDate, Type type, Vehicle vehicle) {
        long price = 0;
        long serviceTime = TimeUnit.MILLISECONDS
                .toHours(exitDate.getTimeInMillis() - admissionDate.getTimeInMillis());
        while (serviceTime >= 24) {
            price += type.getTypePriceDay();
            serviceTime -= 24;
        }
        price += (serviceTime >= 9 ? type.getTypePriceDay() : type.getTypePriceHour() * serviceTime)
                + ((type.getTypeId() == VEHICLE_TYPE_MOTO && vehicle.getCcVehicle() >= MAX_CC_RATE)
                ? type.getTypeExtraPay()
                : 0);
        return price;
    }

}
