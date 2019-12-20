package com.an.parking.infrasctructure.adapters.impl;

import com.an.parking.infrasctructure.adapters.IUserService;
import com.an.parking.infrasctructure.repository.entity.user.IUserRepository;
import com.an.parking.infrasctructure.repository.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("user")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public UserEntity get(String email, String pass) {
        return null;
    }

    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public UserEntity save(UserEntity userDto) {
        return null;
    }

    @Override
    public UserEntity update(UserEntity userDto) {
        return null;
    }
}
