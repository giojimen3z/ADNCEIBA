package com.an.parking.unit.mapper;

import com.an.parking.domain.dto.Type;
import com.an.parking.infrasctructure.entity.TypeEntity;
import com.an.parking.infrasctructure.mapper.TypeMapper;
import com.an.parking.unit.databuilder.TypeEntityTestDataBuilder;
import com.an.parking.unit.databuilder.TypeTestDataBuilder;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TypeMapperTest {

    Type type;
    TypeEntity typeEntity;

    TypeTestDataBuilder typeTestDataBuilder;
    TypeEntityTestDataBuilder typeEntityTestDataBuilder;

    @Before
    public void setUp() {
        typeTestDataBuilder = new TypeTestDataBuilder();
        typeEntityTestDataBuilder = new TypeEntityTestDataBuilder();
    }
    @Test
    public void domainToEntityTest() {
        type = typeTestDataBuilder.build();
        typeEntity = TypeMapper.domainToEntity(type);
        assertEquals(type.getTypeId(), typeEntity.getTypeId());
        assertEquals(type.getTypeDesc(), typeEntity.getTypeDesc());
        assertEquals(type.getTypePriceHour(), typeEntity.getTypePriceHour());
        assertEquals(type.getTypePriceDay(), typeEntity.getTypePriceDay());
        assertEquals(type.getTypeExtraPay(), typeEntity.getTypeExtraPay());
    }

    @Test
    public void entityToDOmainTest() {
        typeEntity = typeEntityTestDataBuilder.build();
        type = TypeMapper.entityToDomain(typeEntity);
        assertEquals(typeEntity.getTypeId(), type.getTypeId());
        assertEquals(typeEntity.getTypeDesc(), type.getTypeDesc());
        assertEquals(typeEntity.getTypePriceHour(), type.getTypePriceHour());
        assertEquals(typeEntity.getTypePriceDay(), type.getTypePriceDay());
        assertEquals(typeEntity.getTypeExtraPay(), type.getTypeExtraPay());
    }


}
