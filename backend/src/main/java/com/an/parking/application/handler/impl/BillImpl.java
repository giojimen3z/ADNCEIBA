package com.an.parking.application.handler.impl;

import com.an.parking.application.handler.IBillDelegate;
import com.an.parking.dto.bill.BillDto;
import com.an.parking.dto.ports.IBillService;
import com.an.parking.infrasctructure.mapper.IMapperBill;
import com.an.parking.infrasctructure.repository.entity.bill.BillEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillImpl implements IBillDelegate {
    private final IBillService iBillService;
    private final IMapperBill iMapperBill;

    public  BillImpl(@Qualifier("Bill") IBillService iBillService, IMapperBill iMapperBill){
        this.iBillService = iBillService;
        this.iMapperBill = iMapperBill;
    }
    @Override
    public ResponseEntity<BillDto> get(Long id) {
        return ResponseEntity.ok(this.iMapperBill.entityToDto(this.iBillService.get(id)));
    }

    @Override
    public ResponseEntity<List<BillDto>> getAll() {
        return ResponseEntity.ok(this.iMapperBill.entityToDto(this.iBillService.getAll()));
    }


    @Override
    public ResponseEntity<BillDto> save(BillDto billDto) {

        BillEntity billEntity = this.iMapperBill.dtoToEntity(billDto);

        //TODO you should controller this exception
        BillEntity billEntityAux = this.iBillService.save(billEntity);

        BillDto billDtoAux = this.iMapperBill.entityToDto(billEntityAux);

        return  ResponseEntity.ok(billDtoAux);


    }

    @Override
    public ResponseEntity update( BillDto billDto) {
        return null;
    }


}
