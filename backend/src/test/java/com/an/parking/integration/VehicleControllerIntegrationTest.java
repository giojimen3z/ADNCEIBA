package com.an.parking.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.an.parking.Application;
import com.an.parking.domain.dto.Vehicle;
import com.an.parking.unit.databuilder.VehicleTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class VehicleControllerIntegrationTest {

    public static final long VEHICLE_ID = 3;
    public static final String PLATE_VEHICLE = "RQG72E";
    public static final String PLATE_VEHICLE_OPTIONAL = "RQR45A";
    public static final long TYPE_ID = 1;
    public static final long CC_VEHICLE = 100;
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    private Vehicle vehicle;
    private ObjectWriter objectWriter;
    @Before
    public void setUp() throws ParseException {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().ccVehicle(CC_VEHICLE)
                .plateVehicle(PLATE_VEHICLE).typeId(TYPE_ID);
        vehicle = vehicleTestDataBuilder.build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
    }
    @Test
    public void saveVehicle() throws Exception {
        String vehiculoJson = objectWriter.writeValueAsString(vehicle);
        mockMvc.perform(post("/api/vehicle").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehiculoJson))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void findAllVehicles() throws Exception {
        mockMvc.perform(get("/api/vehicle/listvehicles").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void queryByPlate() throws Exception {
        mockMvc.perform(get("/api/vehicle/" + PLATE_VEHICLE_OPTIONAL).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print()).andExpect(status().isOk());
    }

}
