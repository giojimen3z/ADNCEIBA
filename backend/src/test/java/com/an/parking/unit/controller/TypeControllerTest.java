package com.an.parking.unit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.an.parking.application.service.TypeService;
import com.an.parking.domain.dto.Type;
import com.an.parking.domain.exceptions.TypeNotFoundException;
import com.an.parking.domain.repository.ITypeRepository;
import com.an.parking.infrasctructure.controllers.TypeController;
import com.an.parking.unit.databuilder.TypeTestDataBuilder;
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
@WebMvcTest(TypeController.class)
public class TypeControllerTest {

    private static final long TYPE_ID = 2;
    private static final String TYPE_DESC = "Carro";
    private static final long TYPE_PRICE_HOUR = 1000;
    private static final long TYPE_PRICE_DAY = 8000;
    private static final long TYPE_EXTRA_PAY = 0;

    private Type type;
    private ObjectWriter objectWriter;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ITypeRepository typeRepository;

    @MockBean
    private TypeService typeService;

    @Before
    public void setUp() {
        try {
            TypeTestDataBuilder typeTestDataBuilder = new TypeTestDataBuilder().typeId(TYPE_ID)
                    .typeDesc(TYPE_DESC).typePriceHour(TYPE_PRICE_HOUR).typePriceDay(TYPE_PRICE_DAY)
                    .typeExtraPay(TYPE_EXTRA_PAY);
            type = typeTestDataBuilder.build();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        } catch (Exception e) {
            throw new TypeNotFoundException(e.getMessage());
        }
    }

    @Test
    public void saveType() throws Exception {
        String tipoJson = objectWriter.writeValueAsString(type);

        mockMvc.perform(post("/api/type").contentType(MediaType.APPLICATION_JSON_UTF8).content(tipoJson)).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
