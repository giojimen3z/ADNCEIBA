package com.an.parking.infrasctructure.adapters.impl;

import com.an.parking.dto.ports.IUserService;
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
    public UserEntity get(Long id) {
        return iUserRepository.getOne(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return iUserRepository.findAll();
    }

    @Override
    public UserEntity save(UserEntity UserEntity) {
        return iUserRepository.save(UserEntity);
    }

    @Override
    public UserEntity update(UserEntity UserEntity) {
        return iUserRepository.save(UserEntity);
    }



}
