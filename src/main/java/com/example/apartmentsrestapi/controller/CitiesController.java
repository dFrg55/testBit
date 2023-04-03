package com.example.apartmentsrestapi.controller;

import com.example.apartmentsrestapi.dto.CitiesDto;
import com.example.apartmentsrestapi.dto.CitiesNumberOfHousesDto;
import com.example.apartmentsrestapi.entity.CitiesEntity;
import com.example.apartmentsrestapi.repository.CitiesRepo;
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
    public List<CitiesNumberOfHousesDto> findAllHouse() {
        return  citiesService.findAllHouse();
    }
    @GetMapping("/all")
    public List<CitiesDto> findAll() {
        return citiesService.findAll();
    }


}
