package com.an.parking.infrasctructure.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface IMapperGeneric<T, D> {

    T dtoToEntity(D dto);

    D entityToDto(T entity);

    List<D> entityToDto(List<T> entity);

    List<T> dtoToEntity(List<D> dto);

    void mergeToEntity(Object entityOld, @MappingTarget T entityNew);

    void mergeToDtos(Object dtoOld, @MappingTarget D dtoNew);

}
