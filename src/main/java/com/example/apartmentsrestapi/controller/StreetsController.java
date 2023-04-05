package com.example.apartmentsrestapi.controller;

import com.example.apartmentsrestapi.dto.CitiesDto;
import com.example.apartmentsrestapi.repository.StreetsRepo;
import com.example.apartmentsrestapi.service.StreetsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.List;

@RestController
@RequestMapping("/streets")
public class StreetsController {
    private final StreetsService streetsService;
    private final StreetsRepo streetsRepo;

    public StreetsController(StreetsService streetsService, StreetsRepo streetsRepo) {
        this.streetsService = streetsService;
        this.streetsRepo = streetsRepo;
    }

    @GetMapping
    public List findAllHouse(@RequestParam(value = "city_id", required = false) Integer city_id) {
        return streetsService.findAllHouseSql(city_id);
    }

}

