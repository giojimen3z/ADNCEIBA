package com.an.parking.infrasctructure.controllers;

import com.an.parking.application.handler.IUserDelegate;
import com.an.parking.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class RegisterUser {

    @Autowired
    private IUserDelegate iUserDelegate;

    @GetMapping("/{id}")
    public  ResponseEntity<UserDto> get(@PathVariable Long id ){ return iUserDelegate.get(id);}

   /* @PostMapping()

    public ResponseEntity post(@PathVariable String email, @PathVariable String pass){

        return iUserDelegate.post(email, pass);
    }
*/
    @PostMapping()

    public ResponseEntity save(@PathVariable UserDto UserDto){

        return iUserDelegate.save(UserDto);
    }


}
