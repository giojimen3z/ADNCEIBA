package com.an.parking.infrasctructure.adapter.jpa;

import com.an.parking.infrasctructure.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepositoryJpa extends JpaRepository<TypeEntity,Long> {


}
