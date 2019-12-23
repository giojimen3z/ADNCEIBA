package com.an.parking.application.handler.impl;

import com.an.parking.application.handler.IUserDelegate;
import com.an.parking.dto.ports.IUserService;
import com.an.parking.dto.user.UserDto;
import com.an.parking.infrasctructure.mapper.IMapperUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserImpl implements IUserDelegate {

    private final IUserService iUserService;
    private final IMapperUser iMapperUser;

    public UserImpl (@Qualifier("user") IUserService iUserService, IMapperUser iMapperUser){

        this.iUserService = iUserService;
        this.iMapperUser = iMapperUser;

    }
    @Override
    public ResponseEntity<UserDto> get(Long id) {

        return ResponseEntity.ok(this.iMapperUser.entityToDto(this.iUserService.get(id)));
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(this.iMapperUser.entityToDto(this.iUserService.getAll()));
    }

    @Override
    public ResponseEntity<UserDto> save(UserDto UserDto) {
        return null;
    }

    @Override
    public ResponseEntity update(Long id, UserDto UserDto) {
        return null;
    }

    /*@Override
    public ResponseEntity post(String email, String pass) {
        return null;
    }*/
}
