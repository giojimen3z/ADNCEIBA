package com.an.parking.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.an.parking.Application;
import com.an.parking.domain.dto.Vehicle;
import com.an.parking.unit.databuilder.VehicleTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ParkingControllerIntegrationTest {

    private static final String PLATE_VEHICLE = "ASD15A";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private Vehicle vehicle;
    private ObjectWriter objectWriter;

    @Before
    public void setUp() throws ParseException {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().vehicleId(2);
        vehicle = vehicleTestDataBuilder.build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
    }

    @Test
    @Ignore
    public void guardarVehiculoSalida() throws Exception {
        mockMvc.perform(patch("/api/parking/exit/" + PLATE_VEHICLE)
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isCreated());
    }

    @Test
    @Ignore
    public void guardarVehiculoEntrada() throws Exception {
        String vehiculoJson = objectWriter.writeValueAsString(vehicle);
        mockMvc.perform(
                post("/api/parking/addvehicle").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehiculoJson))
                .andDo(print()).andExpect(status().isCreated());
    }
}
