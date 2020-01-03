package com.an.parking.unit.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.an.parking.domain.dto.Type;
import com.an.parking.unit.databuilder.TypeTestDataBuilder;
import org.junit.Test;

public class TypeTest {

    public static final Long TYPE_ID = 2L;
    public static final String TYPE_DESC = "Carro";
    public static final Long TYPE_PRICE_DAY = 8000L;
    public static final Long TYPE_PRICE_HOUR = 1000L;
    public static final Long TYPE_EXTRA_PRICE = 0L;

    @Test
    public void setUp() {
        // arrage
        TypeTestDataBuilder typeTestDataBuilder = new TypeTestDataBuilder();

        // act
        Type type = typeTestDataBuilder.typeId(TYPE_ID).typeDesc(TYPE_DESC).typePriceDay(TYPE_PRICE_DAY)
                .typePriceHour(TYPE_PRICE_HOUR).typeExtraPay(TYPE_EXTRA_PRICE).build();

        assertNotNull(type);
        assertEquals(type.getTypeId(), TYPE_ID);
        assertEquals(type.getTypeDesc(), TYPE_DESC);
        assertEquals(type.getTypePriceDay(), TYPE_PRICE_DAY);
        assertEquals(type.getTypePriceHour(), TYPE_PRICE_HOUR);
        assertEquals(type.getTypeExtraPay(),TYPE_EXTRA_PRICE);
    }
}
