package com.example.apartmentsrestapi.controller;

import com.example.apartmentsrestapi.dto.CitiesNumHouseDto;
import com.example.apartmentsrestapi.service.CitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CitiesController
{
    private  final CitiesService citiesService;

    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }
    @GetMapping
    public List<CitiesNumHouseDto> findAllHouse() {
        return  citiesService.findAllHouseSql();
    }

}
