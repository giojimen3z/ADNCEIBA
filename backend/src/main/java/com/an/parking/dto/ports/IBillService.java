package com.an.parking.dto.ports;

import com.an.parking.infrasctructure.repository.entity.bill.BillEntity;

import java.util.List;

public interface IBillService {
    
    BillEntity get(Long id);

    List<BillEntity> getAll();

    BillEntity save(BillEntity BillDto);

    BillEntity update(BillEntity BillDto);
    
}
