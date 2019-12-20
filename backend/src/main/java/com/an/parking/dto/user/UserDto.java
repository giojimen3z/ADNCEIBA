package com.an.parking.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

     private Long id;
     private DataAccess  dataAccess;
     private  String nameUser;
     private String lastNameUser;


}
