package com.an.parking.unit.databuilder;

import com.an.parking.infrasctructure.entity.TypeEntity;

public class TypeEntityTestDataBuilder {

    private static final long TYPE_ID  = 1L;
    private static final String TYPE_DESC = "Moto";
    private static final long TYPE_PRICE_HOUR = 500;
    private static final long TYPE_PRICE_DAY = 4000;
    private static final long TYPE_EXTRA_PAY = 2000;

    private Long typeId;
    private String typeDesc;
    private Long typePriceHour;
    private Long typePriceDay;
    private Long typeExtraPay;

    public TypeEntityTestDataBuilder(){

        this.typeId = TYPE_ID;
        this.typeDesc = TYPE_DESC;
        this.typePriceHour = TYPE_PRICE_HOUR;
        this.typePriceDay = TYPE_PRICE_DAY;
        this.typeExtraPay = TYPE_EXTRA_PAY;

    }
    public TypeEntityTestDataBuilder typeId(long typeId) {
        this.typeId = typeId;
        return this;
    }

    public TypeEntityTestDataBuilder typeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
        return this;
    }

    public TypeEntityTestDataBuilder typePriceHour(long typePriceHour) {
        this.typePriceHour = typePriceHour;
        return this;
    }

    public TypeEntityTestDataBuilder typePriceDay(long typePriceDay) {
        this.typePriceDay = typePriceDay;
        return this;
    }

    public TypeEntityTestDataBuilder typeExtraPay(long typeExtraPay) {
        this.typeExtraPay = typeExtraPay;
        return this;
    }

    public TypeEntity build() {
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setTypeId(this.typeId);
        typeEntity.setTypeDesc(this.typeDesc);
        typeEntity.setTypePriceDay(this.typePriceDay);
        typeEntity.setTypePriceHour(this.typePriceHour);
        typeEntity.setTypeExtraPay(this.typeExtraPay);

        return typeEntity;
    }

}
