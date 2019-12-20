package com.an.parking.infrasctructure.repository.entity.bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<BillEntity, Long> {
}
