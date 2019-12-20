package com.an.parking.infrasctructure.mapper;

import com.an.parking.dto.bill.BillDto;
import com.an.parking.infrasctructure.repository.entity.bill.BillEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IMapperBill extends IMapperGeneric<BillEntity, BillDto> {
}
