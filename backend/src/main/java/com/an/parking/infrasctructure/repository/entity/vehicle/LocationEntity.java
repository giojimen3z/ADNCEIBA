package com.an.parking.infrasctructure.repository.entity.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationEntity {
    @Id
    private Long id;
    private String section;
    private Integer site;
    private boolean availability;

}
