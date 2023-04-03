package com.example.apartmentsrestapi.controller;


import com.example.apartmentsrestapi.repository.HousesRepo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HousesController {
    private final HousesRepo housesRepo;

    public HousesController(HousesRepo housesRepo) {
        this.housesRepo = housesRepo;
    }
}
