package com.an.parking.controllers;

import com.an.parking.application.handler.IBillDelegate;
import com.an.parking.dto.bill.BillDto;
import com.an.parking.infrasctructure.controllers.RegisterBill;
import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterBill.class)
public class RegisterBillControllerTest {
    @Autowired
    private  MockMvc mockMvc;

    @Mock
    private RegisterBill registerBill;

    @MockBean
    private IBillDelegate iBillDelegate;

    @Before
    private void  setup(){
        List<BillDto> billDtos = new ArrayList<>();
        billDtos.add(new BillDto());
        ResponseEntity<List<BillDto>> listResponseEntity =  ResponseEntity.ok(billDtos);

        when(iBillDelegate.getAll()).thenReturn(listResponseEntity);

    }

    @Test
    public void TestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/bill/list").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
        //MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/bill/list").contentType(MediaType.APPLICATION_JSON)).andReturn();
        //Assertions.assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
    }
}
