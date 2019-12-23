package com.an.parking.infrasctructure.adapters.impl;

import com.an.parking.dto.ports.IBillService;
import com.an.parking.infrasctructure.repository.entity.bill.BillEntity;
import com.an.parking.infrasctructure.repository.entity.bill.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("Bill")
public class BillServiceImpl implements IBillService {

    @Autowired
    private IBillRepository iBillRepository;

    @Override
    public BillEntity get(Long id) {
        return iBillRepository.getOne(id);
    }

    @Override
    public List<BillEntity> getAll() {
        return iBillRepository.findAll();
    }

    @Override
    public BillEntity save(BillEntity BillDto) {
        return iBillRepository.save(BillDto);
    }

    @Override
    public BillEntity update(BillEntity BillDto) {
        return iBillRepository.save(BillDto);
    }
}
