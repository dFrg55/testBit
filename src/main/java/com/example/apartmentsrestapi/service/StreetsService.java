package com.example.apartmentsrestapi.service;

import com.example.apartmentsrestapi.dto.CitiesNumberOfHousesDto;
import com.example.apartmentsrestapi.dto.StreetsDto;
import com.example.apartmentsrestapi.dto.StreetsNumberOfHousesDto;
import com.example.apartmentsrestapi.repository.CitiesRepo;
import com.example.apartmentsrestapi.repository.StreetsRepo;
import com.example.apartmentsrestapi.utils.MappingUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreetsService {
    private final StreetsRepo streetsRepo;
    private final MappingUtils mappingUtils;

    public StreetsService(StreetsRepo streetsRepo,MappingUtils mappingUtils) {
        this.streetsRepo = streetsRepo;
        this.mappingUtils=mappingUtils;

    }

    public List findAllHouse(Integer city_id) {
        List countHouseInStreets;
        if (city_id == null) {
            countHouseInStreets = streetsRepo.findAll().stream()
                    .map(streets -> {
                        return mappingUtils
                                .mapToStreetsNumberOfHousesDto(streets,
                                        streets.getHousesEntity().stream().count());
                    })
                    .collect(Collectors.toList());
        } 
        else {
            countHouseInStreets = streetsRepo.findAll().stream()
                    .filter(streetsEntity -> city_id.equals(streetsEntity.getCity_id()))
                    .map(streets -> {
                        return mappingUtils
                                .mapToStreetsNumberOfHousesDto(streets,
                                        streets.getHousesEntity().stream().count());
                    })
                    .collect(Collectors.toList());
        }
        return countHouseInStreets;
    }
    public List findAll(){
        return streetsRepo.findAll();
    }

}
