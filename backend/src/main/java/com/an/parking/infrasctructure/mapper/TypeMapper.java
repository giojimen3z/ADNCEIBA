package com.an.parking.infrasctructure.mapper;

import com.an.parking.domain.dto.Type;
import com.an.parking.infrasctructure.entity.TypeEntity;

public class TypeMapper {

    private TypeMapper(){


    }


    public static Type entityToDomain(TypeEntity entity) {
        Type domain = new Type();
        domain.setTypeId(entity.getTypeId());
        domain.setTypeDesc(entity.getTypeDesc());
        domain.setTypePriceHour(entity.getTypePriceHour());
        domain.setTypePriceDay(entity.getTypePriceDay());
        domain.setTypeExtraPay(entity.getTypeExtraPay());
        return domain;
    }

    public static TypeEntity domainToEntity(Type domain) {
        TypeEntity entity = new TypeEntity();
        entity.setTypeId(domain.getTypeId());
        entity.setTypeDesc(domain.getTypeDesc());
        entity.setTypePriceHour(domain.getTypePriceHour());
        entity.setTypePriceDay(domain.getTypePriceDay());
        entity.setTypeExtraPay(domain.getTypeExtraPay());
        return entity;
    }


}
