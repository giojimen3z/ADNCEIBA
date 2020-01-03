package com.an.parking.unit.databuilder;

import com.an.parking.domain.dto.Type;

public class TypeTestDataBuilder {

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

    public TypeTestDataBuilder(){

        this.typeId = TYPE_ID;
        this.typeDesc = TYPE_DESC;
        this.typePriceHour = TYPE_PRICE_HOUR;
        this.typePriceDay = TYPE_PRICE_DAY;
        this.typeExtraPay = TYPE_EXTRA_PAY;
    }


    public TypeTestDataBuilder  typeId(long typeId) {
        this.typeId = typeId;
        return this;
    }

    public TypeTestDataBuilder  typeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
        return this;
    }

    public TypeTestDataBuilder  typePriceHour(long typePriceHour) {
        this.typePriceHour = typePriceHour;
        return this;
    }

    public TypeTestDataBuilder  typePriceDay(long typePriceDay) {
        this.typePriceDay = typePriceDay;
        return this;
    }

    public TypeTestDataBuilder  typeExtraPay(long typeExtraPay) {
        this.typeExtraPay = typeExtraPay;
        return this;
    }

    public Type build() {
        Type type = new Type();
        type.setTypeId(this.typeId);
        type.setTypeDesc(this.typeDesc);
        type.setTypePriceDay(this.typePriceDay);
        type.setTypePriceHour(this.typePriceHour);
        type.setTypeExtraPay(this.typeExtraPay);

        return type;
    }

}
