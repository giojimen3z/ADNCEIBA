package com.an.parking.dto.ports;



import com.an.parking.infrasctructure.repository.entity.user.UserEntity;

import java.util.List;

public interface IUserService {
    UserEntity get(Long id);

    List<UserEntity> getAll();

    UserEntity save(UserEntity userDto);

    UserEntity update(UserEntity userDto);

}
