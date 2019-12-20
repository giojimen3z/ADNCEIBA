package com.an.parking.application.handler;



import com.an.parking.dto.user.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserDelegate {
    
    ResponseEntity<UserDto> get(Long id);

    ResponseEntity<List<UserDto>> getAll();

    ResponseEntity<UserDto> save(UserDto UserDto);

    ResponseEntity update(Long id, UserDto UserDto);
}
