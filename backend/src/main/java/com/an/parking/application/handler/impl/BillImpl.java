package com.an.parking.application.handler.impl;

import com.an.parking.application.handler.IBillDelegate;
import com.an.parking.dto.bill.BillDto;
import com.an.parking.infrasctructure.adapters.IBillService;
import com.an.parking.infrasctructure.mapper.IMapperBill;
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
        return null;
    }

    @Override
    public ResponseEntity<BillDto> save(BillDto BillDto) {
        return null;
    }

    @Override
    public ResponseEntity update( BillDto BillDto) {
        return null;
    }
}
