package com.an.parking.infrasctructure.adapters;



import com.an.parking.infrasctructure.repository.entity.user.UserEntity;

import java.util.List;

public interface IUserService {
    UserEntity get(String email, String pass);

    List<UserEntity> getAll();

    UserEntity save(UserEntity userDto);

    UserEntity update(UserEntity userDto);

}
