package com.an.parking.dto.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Long id;
    private String section;
    private Integer site;
    private boolean availability;

}
