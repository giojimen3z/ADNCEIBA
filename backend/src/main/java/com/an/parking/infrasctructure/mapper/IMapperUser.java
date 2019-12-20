package com.an.parking.infrasctructure.mapper;

import com.an.parking.dto.user.UserDto;
import com.an.parking.infrasctructure.repository.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IMapperUser extends IMapperGeneric<UserEntity, UserDto> {
}
