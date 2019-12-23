package com.an.parking.dto.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cost {

    private Long id;
    private Integer hourCost;
    private Integer totalCost;

}
