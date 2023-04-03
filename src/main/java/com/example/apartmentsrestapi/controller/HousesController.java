package com.example.apartmentsrestapi.controller;


import com.example.apartmentsrestapi.service.HousesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HousesController {
    private final HousesService housesService;

    public HousesController(HousesService housesService) {
        this.housesService = housesService;
    }

    @GetMapping
    public List findAllHouse(@RequestParam(value="city_id", required=false) Integer city_id){
        if(city_id==null){
            return housesService.findAll();
        }
        else {
            return housesService.findAllHousesInCities(city_id);
        }
    }
}
