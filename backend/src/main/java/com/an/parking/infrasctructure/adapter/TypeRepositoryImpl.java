package com.an.parking.infrasctructure.adapter;

import com.an.parking.domain.dto.Type;
import com.an.parking.domain.exceptions.TypeNotFoundException;
import com.an.parking.domain.repository.ITypeRepository;
import com.an.parking.infrasctructure.adapter.jpa.ITypeRepositoryJpa;
import com.an.parking.infrasctructure.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class TypeRepositoryImpl implements ITypeRepository {

    public static final String TYPE_NOT_FOUND = "El vehiculo no se encuentra registrado";

    @Autowired
    private ITypeRepositoryJpa repository;

    public TypeRepositoryImpl(ITypeRepositoryJpa repository) {

        this.repository = repository;
    }

    @Override
    public Type saveType(Type type) {
        return TypeMapper.entityToDomain(repository.save(TypeMapper.domainToEntity(type)));
    }

    @Override
    public Type queryById(long id) {
        return TypeMapper.entityToDomain(repository.findById(id).orElseThrow(() -> new TypeNotFoundException(TYPE_NOT_FOUND)));
    }
}
