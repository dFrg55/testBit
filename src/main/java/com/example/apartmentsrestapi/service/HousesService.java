package com.example.apartmentsrestapi.service;

import com.example.apartmentsrestapi.repository.CitiesRepo;
import com.example.apartmentsrestapi.repository.StreetsRepo;
import com.example.apartmentsrestapi.utils.MappingUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HousesService {
    private final CitiesRepo citiesRepo;
    private final MappingUtils mappingUtils;


    public HousesService( CitiesRepo citiesRepo, MappingUtils mappingUtils) {
        this.citiesRepo = citiesRepo;
        this.mappingUtils = mappingUtils;
    }

    public List findAll(){
        return citiesRepo.findAll();
    }
    public List findAllHousesInCities(Integer city_id){
        List countHouseInCities = citiesRepo.findAll().stream()
                .map(citiesEntity ->
                        mappingUtils.mapToCitiesNumberOfHousesDto(citiesEntity,
                                citiesEntity.getStreetsEntity().stream()
                                        .map(houses -> houses.getHousesEntity().stream().count())
                                        .reduce(0l, Long::sum))
                )
                .collect(Collectors.toList());

        return countHouseInCities;
    }
}
