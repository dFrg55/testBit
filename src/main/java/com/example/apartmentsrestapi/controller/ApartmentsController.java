package com.example.apartmentsrestapi.controller;

import com.example.apartmentsrestapi.repository.ApartmentsRepo;
import com.example.apartmentsrestapi.repository.CitiesRepo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApartmentsController {
    private final ApartmentsRepo apartmentsRepo;

    public ApartmentsController(ApartmentsRepo apartmentsRepo) {
        this.apartmentsRepo = apartmentsRepo;
    }
}
