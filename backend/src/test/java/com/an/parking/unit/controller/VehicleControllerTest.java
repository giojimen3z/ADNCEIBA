package com.an.parking.unit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.an.parking.application.service.VehicleService;
import com.an.parking.domain.dto.Vehicle;
import com.an.parking.domain.exceptions.VehicleNotFoundException;
import com.an.parking.domain.repository.IVehicleRepository;
import com.an.parking.infrasctructure.controllers.VehicleController;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

    private static final long VEHICLE_ID = 1;
    private static final long TYPE_ID = 1;
    private static final long CC_VEHICLE = 0;
    private static final String PLATE_VEHICLE= "ASD154";

    private Vehicle vehicle;
    private ObjectWriter objectWriter;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IVehicleRepository vehicleRepository;

    @MockBean
    private VehicleService vehicleService;

    @Before
    public void setUp() {
        try {
            VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().vehicleId(VEHICLE_ID)
                    .typeId(TYPE_ID).plateVehicle(PLATE_VEHICLE)
                    .ccVehicle(CC_VEHICLE);
            vehicle = vehicleTestDataBuilder.build();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        } catch (Exception e) {
            throw new VehicleNotFoundException(e.getMessage());
        }
    }
    @Test
    public void saveVehicleTest() throws Exception {
        String vehiculoJson = objectWriter.writeValueAsString(vehicle);

        mockMvc.perform(post("/api/vehicle").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehiculoJson))
                .andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void queryVehiclesTest() throws Exception {
        mockMvc.perform(get("/api/vehicle/listvehicles").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void queryVehicleTest() throws Exception {
        mockMvc.perform(get("/api/vehicle/" + PLATE_VEHICLE).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful());
    }
}
