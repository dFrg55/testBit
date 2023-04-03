package com.example.apartmentsrestapi.controller;

import com.example.apartmentsrestapi.dto.StreetsDto;
import com.example.apartmentsrestapi.entity.CitiesEntity;
import com.example.apartmentsrestapi.entity.StreetsEntity;
import com.example.apartmentsrestapi.service.StreetsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/streets")
public class StreetsController {
    private final StreetsService streetsService;

    public StreetsController(StreetsService streetsService) {
        this.streetsService = streetsService;
    }


    @GetMapping
    public List<StreetsDto> findAllHouse(@RequestParam(value="city_id", required=false) Integer city_id) {
        return (List<StreetsDto>) streetsService.findAllHouse(city_id);
    }

    @GetMapping("/all")
    public  List findAll(){
        return streetsService.findAll();
    }
}
