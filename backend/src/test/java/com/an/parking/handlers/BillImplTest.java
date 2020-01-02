package com.an.parking.handlers;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.an.parking.application.handler.impl.BillImpl;
import com.an.parking.domain.bill.BillDto;
import com.an.parking.infrasctructure.adapters.impl.BillServiceImpl;
import com.an.parking.infrasctructure.mapper.IMapperBill;
import com.an.parking.infrasctructure.adapter.entity.bill.BillEntity;

@RunWith(SpringJUnit4ClassRunner.class)

public class BillImplTest {


    private BillImpl bill;

    private BillServiceImpl billService;

    private IMapperBill iMapperBill;

    @BeforeEach
    public void setUp(){
        BillDto billDto = new BillDto();
        billDto.setId(1L);
        billService = Mockito.mock(BillServiceImpl.class);
        iMapperBill = Mockito.mock(IMapperBill.class);
        when(iMapperBill.dtoToEntity(any(BillDto.class))).thenReturn(new BillEntity());
        when(billService.save(any(BillEntity.class))).thenReturn(new BillEntity());
        when(iMapperBill.entityToDto(any(BillEntity.class))).thenReturn(billDto);
        bill = new BillImpl(this.billService,this.iMapperBill);
    }

    @Test
    public void testSaveOk(){
        ResponseEntity response =  bill.save(new BillDto());

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(((BillDto)response.getBody()).getId(), 1L);
    }


}
