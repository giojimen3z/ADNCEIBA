package com.an.parking.dto.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataAccess {
    private Long id;
    private String emailUser;
    private String passwordUser;
}
