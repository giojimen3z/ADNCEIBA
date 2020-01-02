package com.an.parking.domain.repository;

import com.an.parking.domain.dto.Type;

public interface ITypeRepository {

    Type saveType(Type type);

    Type queryById(long id);

}
