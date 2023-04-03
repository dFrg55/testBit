package com.example.apartmentsrestapi.service;

import com.example.apartmentsrestapi.dto.CitiesDto;
import com.example.apartmentsrestapi.dto.CitiesNumberOfHousesDto;
import com.example.apartmentsrestapi.repository.CitiesRepo;
import com.example.apartmentsrestapi.utils.MappingUtils;
import org.springframework.stereotype.Service;
import com.example.apartmentsrestapi.entity.CitiesEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitiesService {

    private final CitiesRepo citiesRepo;
    private final MappingUtils mappingUtils;

    public CitiesService(CitiesRepo citiesRepo, MappingUtils mappingUtils) {
        this.citiesRepo = citiesRepo;

        this.mappingUtils = mappingUtils;
    }

    //    public List<CitiesEntity> findAllHouse(){
//        List countHouseInCities =citiesRepo.findAll().stream()
//                .map(streets->"Город: "+streets.getName()+" Количество домов: "+ streets.getStreetsEntity().stream()
//                        .map(houses-> houses.getHousesEntity().stream().count())
//                        .reduce(0l,Long::sum))
//                .collect(Collectors.toList());
//        countHouseInCities.stream().forEach(System.out::println);
//        return countHouseInCities;
//    }
    public List<CitiesNumberOfHousesDto> findAllHouse() {
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

    public List<CitiesDto> findAll() {
        MappingUtils mappingUtils = new MappingUtils();
        return citiesRepo.findAll().stream()
                .map(citiesEntity -> mappingUtils.mapToCitiesDto(citiesEntity))
                .collect(Collectors.toList());
    }

    public CitiesDto mapToCitiesDto(CitiesEntity entity) {
        CitiesDto dto = new CitiesDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

}
