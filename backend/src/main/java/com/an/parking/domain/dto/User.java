package com.an.parking.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long userId;
    private  String nameUser;
    private String lastNameUser;
    private String email;
    private String pass;
}
