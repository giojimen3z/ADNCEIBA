package com.an.parking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Brand {
    private Long id;
    private String name;
    private String price;
}
