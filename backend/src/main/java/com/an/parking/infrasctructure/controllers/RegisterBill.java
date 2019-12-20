package com.an.parking.infrasctructure.controllers;

import com.an.parking.application.handler.IBillDelegate;
import com.an.parking.dto.bill.BillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class RegisterBill {
    
    @Autowired
    private IBillDelegate iBillDelegate;

    @GetMapping("/bill")
    public ResponseEntity<List<BillDto>> getBill() {
        return iBillDelegate.getAll();
    }
    @GetMapping("/{id}")
    public  ResponseEntity<BillDto> get(@PathVariable Long id ){ return iBillDelegate.get(id);}

    @PostMapping()

    public ResponseEntity save(@RequestBody BillDto BillDto){

        return iBillDelegate.save(BillDto);
    }

}
