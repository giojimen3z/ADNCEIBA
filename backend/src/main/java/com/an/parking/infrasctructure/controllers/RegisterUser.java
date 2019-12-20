package com.an.parking.infrasctructure.controllers;

import com.an.parking.application.handler.IUserDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class RegisterUser {

    @Autowired
    private IUserDelegate iUserDelegate;

}
