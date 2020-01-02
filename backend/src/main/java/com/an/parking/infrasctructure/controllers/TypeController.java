package com.an.parking.infrasctructure.controllers;

import com.an.parking.application.service.TypeService;
import com.an.parking.domain.dto.Type;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/type")
public class TypeController {

    private final TypeService typeService;

    public TypeController(final TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public ResponseEntity<Type> guardarTipo(@RequestBody Type type) {
        typeService.saveType(type);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
