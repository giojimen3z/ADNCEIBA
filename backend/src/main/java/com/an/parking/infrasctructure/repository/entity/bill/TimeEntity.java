package com.an.parking.infrasctructure.repository.entity.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;

@Table(name = "Time")
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class TimeEntity {

    @Id
    private Long id;
    private Calendar startTime;
    private Calendar endTime;


}
