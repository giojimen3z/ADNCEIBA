package com.an.parking.unit.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import com.an.parking.application.service.ParkingService;
import com.an.parking.domain.dto.Vehicle;
import com.an.parking.domain.repository.IVehicleRepository;
import com.an.parking.infrasctructure.controllers.ParkingController;
import com.an.parking.unit.databuilder.VehicleTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ParkingController.class)
public class ParkingControllerTest {

    private static final long VEHICLE_ID = 1;
    private static final String PLATE_VEHICLE= "ASD15A";

    private Vehicle vehicle;
    private ObjectWriter objectWriter;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IVehicleRepository vehicleRepository;

    @MockBean
    private ParkingService parkingService;
    @Before
    public void setUp() throws Exception {
        VehicleTestDataBuilder vehiculoTestDataBuilder = new VehicleTestDataBuilder().vehicleId(VEHICLE_ID)
                .ccVehicle(0).plateVehicle(null).typeId(0);
        vehicle = vehiculoTestDataBuilder.build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
    }

    @Test
    public void addVehicleParkingTest() throws Exception {
        String vehiculoJson = objectWriter.writeValueAsString(vehicle);

        mockMvc.perform(
                post("/api/parking/addvehicle").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehiculoJson))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void removeVehicleParkingTest() throws Exception {
        mockMvc.perform(patch("/api/parking/exit/" + PLATE_VEHICLE)
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isCreated());
    }

}
