package com.an.parking.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.an.parking.Application;
import com.an.parking.domain.dto.Type;
import com.an.parking.unit.databuilder.TypeTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
public class TypeControllerIntegrationTest {

    public static final long TYPE_ID = 3;
    public static final long TYPE_ID_MOTO = 1;
    public static final String TYPE_DESC = "Bicicleta";
    public static final long TYPE_PRICE_DAY = 2000;
    public static final long TYPE_PRICE_HOUR = 200;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    private Type type;
    private ObjectWriter objectWriter;

    @Before
    public void setUp() throws ParseException {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        TypeTestDataBuilder typeTestDataBuilder = new TypeTestDataBuilder().typeId(TYPE_ID).typeDesc(TYPE_DESC)
                .typePriceHour(TYPE_PRICE_HOUR).typePriceDay(TYPE_PRICE_DAY).typeExtraPay(0);
        type = typeTestDataBuilder.build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
    }

    @Test
    @Ignore
    public void saveType() throws Exception {
        String tipoJson = objectWriter.writeValueAsString(type);
        mockMvc.perform(post("/api/type").contentType(MediaType.APPLICATION_JSON_UTF8).content(tipoJson)).andDo(print())
                .andExpect(status().isCreated());
    }
}
