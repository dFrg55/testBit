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
    public List findAllHouse(@RequestParam(value = "city_id", required = false) Integer city_id,
                             @RequestParam(value = "street_id", required = false) Integer street_id) {
            return housesService.findAllApartmentSql(city_id,street_id);

    }
    //Разбор адресной строки
    @GetMapping("/address")
    public String findHouse(@RequestParam(value = "address", required = false)String address){
        return housesService.findHouse(address);
    }

}
