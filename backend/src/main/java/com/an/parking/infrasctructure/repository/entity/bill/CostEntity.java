package com.an.parking.infrasctructure.repository.entity.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostEntity {

    @Id
    private Long id;
    private Integer hourCost;
    private Integer totalCost;

}
