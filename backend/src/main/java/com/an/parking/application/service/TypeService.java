package com.an.parking.application.service;

import com.an.parking.domain.dto.Type;
import com.an.parking.domain.repository.ITypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeService {


    private final ITypeRepository iTypeRepository;



    public TypeService(final ITypeRepository iTypeRepository) {
        this.iTypeRepository = iTypeRepository;
    }

    public Type saveType(Type type) {
        return iTypeRepository.saveType(type);
    }


}
