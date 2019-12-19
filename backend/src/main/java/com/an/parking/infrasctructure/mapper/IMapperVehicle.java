package com.an.parking.infrasctructure.mapper;

import com.an.parking.dto.VehicleDto;
import com.an.parking.infrasctructure.repository.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IMapperVehicle extends IMapperGeneric< VehicleEntity,VehicleDto> {
}
