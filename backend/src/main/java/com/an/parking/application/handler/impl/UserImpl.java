package com.an.parking.application.handler.impl;

import com.an.parking.application.handler.IUserDelegate;
import com.an.parking.dto.user.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserImpl implements IUserDelegate {
    @Override
    public ResponseEntity<UserDto> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> save(UserDto UserDto) {
        return null;
    }

    @Override
    public ResponseEntity update(Long id, UserDto UserDto) {
        return null;
    }
}
