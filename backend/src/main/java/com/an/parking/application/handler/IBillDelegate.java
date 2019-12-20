package com.an.parking.application.handler;


import com.an.parking.dto.bill.BillDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBillDelegate {
    ResponseEntity<BillDto> get(Long id);

    ResponseEntity<List<BillDto>> getAll();

    ResponseEntity<BillDto> save(BillDto BillDto);

    ResponseEntity update(BillDto BillDto);

}
