package com.an.parking.dto.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Time{

    private Long id;
    private Date startTime;
    private Date endTime;


}
