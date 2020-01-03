package com.an.parking.unit.domain;

import com.an.parking.domain.dto.Register;
import com.an.parking.domain.dto.Type;
import com.an.parking.domain.dto.Vehicle;
import com.an.parking.domain.exceptions.ParkingNotFoundException;
import com.an.parking.unit.databuilder.RegisterTestDataBuilder;
import com.an.parking.unit.databuilder.TypeTestDataBuilder;
import com.an.parking.unit.databuilder.VehicleTestDataBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterTest {

    private static final String TYPE_NOT_FOUND = "Tipo de Vehiculo Incompatible";
    private static final String ERROR_DENIED_ACCES = "Acceso denegado: Los Vehiculos con placas que inicial con "
            + "'A' Solo pueden ingresar los Domingos y Lunes";
    private static final String ERROR_PARKING_FULL = "Acceso denegado: El estacionamiento esta en su maxima capacidad";
    private static final String FIRST_LETTER_PLATE = "AJE74A";
    private static final String PLATE_VEHICLE = "VJE746";
    private static final int MAX_CAPACITY_CARS = 50;
    private static final int MAX_CAPACITY_MOTO = 30;
    private static final Long VEHICLE_TYPE_CAR = 2L;
    private static final long VEHICLE_TYPE_MOTO = 1;
    private static final String PARKING_ENTER_DATE = "14/12/2019 07:00:00";
    private static final String PARKING_EXIT_DATE = "15/12/2019 11:00:00";

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");

    private Register register;

    @Before
    public void setUp() {
        // arrage
        RegisterTestDataBuilder registerTestDataBuilder = new RegisterTestDataBuilder();

        // act
        register = registerTestDataBuilder.build();
    }

    @Test
    public void registerBuild() {
        // act
        assertNotNull(register);
    }

    @Test
    public void accessGrantedSundayPlateA() {
        Calendar admissionDate = Calendar.getInstance();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder()
                .plateVehicle(FIRST_LETTER_PLATE);
        admissionDate.set(2019, 5, 9, 7, 0);
        assertTrue(register.vehicleEntry(vehicleTestDataBuilder.build(), admissionDate));
    }

    @Test
    public void accessGrantedSundayNormalPlate() {
        Calendar admissionDate = Calendar.getInstance();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().plateVehicle(PLATE_VEHICLE);
        admissionDate.set(2019, 5, 9, 7, 0);
        assertFalse(register.vehicleEntry(vehicleTestDataBuilder.build(), admissionDate));
    }

    @Test
    public void accessGrantedMondaylPlateA() {
        Calendar admissionDate = Calendar.getInstance();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder()
                .plateVehicle(FIRST_LETTER_PLATE);
        admissionDate.set(2019, 5, 10, 7, 0);
        assertTrue(register.vehicleEntry(vehicleTestDataBuilder.build(), admissionDate));
    }

    @Test
    public void accesGrantedMondayNormalPlate() {
        Calendar admissionDate = Calendar.getInstance();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().plateVehicle(PLATE_VEHICLE);
        admissionDate.set(2019, 5, 10, 7, 0);
        assertFalse(register.vehicleEntry(vehicleTestDataBuilder.build(), admissionDate));
    }

    @Test
    public void accesGrantedNormalPlateNormalDay() {
        Calendar admissionDate = Calendar.getInstance();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder()
                .plateVehicle(FIRST_LETTER_PLATE);
        admissionDate.set(2019, 5, 11, 7, 0);
        assertFalse(register.vehicleEntry(vehicleTestDataBuilder.build(), admissionDate));
    }

    @Test
    public void accessGrantedNormalPlateNormalDay() {
        Calendar admissionDate = Calendar.getInstance();
        VehicleTestDataBuilder  vehicleTestDataBuilder = new VehicleTestDataBuilder().plateVehicle(PLATE_VEHICLE);
        admissionDate.set(2019, 5, 11, 7, 0);
        assertFalse(register.vehicleEntry(vehicleTestDataBuilder.build(), admissionDate));
    }

    @Test
    @Ignore
    public void registerValidationMoto() {
        Calendar admissionDate = Calendar.getInstance();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().typeId(VEHICLE_TYPE_MOTO);
        Vehicle vehicle = vehicleTestDataBuilder.build();
        assertNotNull(register.registerValidation(vehicle, admissionDate));
    }

    @Test
    @Ignore
    public void registerValidationCar() {
        Calendar admissionDate = Calendar.getInstance();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().typeId(VEHICLE_TYPE_CAR);
        Vehicle vehicle = vehicleTestDataBuilder.build();
        assertNotNull(register.registerValidation(vehicle, admissionDate));
    }

    @Test
    public void errorValidationTypeNotFound() {
        Calendar admissionDate = Calendar.getInstance();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().typeId(3);
        Vehicle vehicle = vehicleTestDataBuilder.build();
        try {
            register.registerValidation(vehicle, admissionDate);
            fail();
        } catch (Exception e) {
            assertEquals(TYPE_NOT_FOUND, e.getMessage());
        }
    }

    @Test
    public void parkingNotFound() throws ParseException {
        Calendar admissionDate = Calendar.getInstance();
        admissionDate.setTime(dateFormat.parse("04/06/2019 16:00:00"));
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder()
                .plateVehicle(FIRST_LETTER_PLATE);
        Vehicle vehicle = vehicleTestDataBuilder.build();
        try {
            register.registerValidation(vehicle, admissionDate);
            fail();
        } catch (Exception e) {
            assertEquals(ERROR_DENIED_ACCES, e.getMessage());
        }
    }

    @Test
    public void parkingStorageValidationCar() {
        try {
            register.parkingCapacity(MAX_CAPACITY_CARS, VEHICLE_TYPE_CAR);
            fail();
        } catch (ParkingNotFoundException e) {
            assertEquals(e.getMessage(), ERROR_PARKING_FULL);
        }
    }

    @Test
    public void parkingStorageValidationMoto() {
        try {
            register.parkingCapacity(MAX_CAPACITY_MOTO, VEHICLE_TYPE_MOTO);
            fail();
        } catch (ParkingNotFoundException e) {
            assertEquals(e.getMessage(), ERROR_PARKING_FULL);
        }
    }

    @Test
    public void parkingOkMoto() {
        assertFalse(register.parkingCapacity(1, VEHICLE_TYPE_MOTO));
    }

    @Test
    public void carExitCalculate() throws ParseException {
        Type type = new TypeTestDataBuilder().typeId(VEHICLE_TYPE_CAR).typeDesc("Carro").typePriceDay(8000)
                .typePriceHour(1000).typeExtraPay(0).build();
        Vehicle vehicle = new VehicleTestDataBuilder().ccVehicle(0).plateVehicle(PLATE_VEHICLE)
                .typeId(VEHICLE_TYPE_CAR).build();
        Calendar admissionDate = Calendar.getInstance();
        Calendar exitDate = Calendar.getInstance();
        admissionDate.setTime(dateFormat.parse(PARKING_ENTER_DATE));
        exitDate.setTime(dateFormat.parse(PARKING_EXIT_DATE));

        long precioTotal = register.totalParking(admissionDate, exitDate, type, vehicle);

        assertEquals(precioTotal, 12000);

    }

    @Test
    public void calculateExitMotoCcDown200() throws ParseException {
        Type type = new TypeTestDataBuilder().build();
        Vehicle vehicle = new VehicleTestDataBuilder().ccVehicle(100).build();
        Calendar admissionDate = Calendar.getInstance();
        Calendar exitDate = Calendar.getInstance();
        admissionDate.setTime(dateFormat.parse(PARKING_ENTER_DATE));
        exitDate.setTime(dateFormat.parse(PARKING_EXIT_DATE));

        long precioTotal = register.totalParking(admissionDate, exitDate, type, vehicle);

        assertEquals(precioTotal, 6000);

    }

    @Test
    public void calculateexitCar() throws ParseException {
        Type type = new TypeTestDataBuilder().typeId(VEHICLE_TYPE_CAR).typeDesc("Carro").typePriceDay(8000)
                .typePriceHour(1000).typeExtraPay(0).build();
        Vehicle vehicle = new VehicleTestDataBuilder().ccVehicle(0).plateVehicle(PLATE_VEHICLE)
                .typeId(VEHICLE_TYPE_CAR).build();
        Calendar admissionDate = Calendar.getInstance();
        Calendar exitDate = Calendar.getInstance();
        admissionDate.setTime(dateFormat.parse(PARKING_ENTER_DATE));
        exitDate.setTime(dateFormat.parse(PARKING_EXIT_DATE));

        long precioTotal = register.totalParking(admissionDate, exitDate, type, vehicle);

        assertEquals(precioTotal, 12000);

    }

    @Test
    public void calculateExitMotoCcUp200() throws ParseException {
        Type type = new TypeTestDataBuilder().build();
        Vehicle vehicle = new VehicleTestDataBuilder().ccVehicle(500).build();
        Calendar admissionDate = Calendar.getInstance();
        Calendar exitDate = Calendar.getInstance();
        admissionDate.setTime(dateFormat.parse(PARKING_ENTER_DATE));
        exitDate.setTime(dateFormat.parse(PARKING_EXIT_DATE));

        long precioTotal = register.totalParking(admissionDate, exitDate, type, vehicle);


        assertEquals(precioTotal, 8000);

    }
}
