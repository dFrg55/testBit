package com.example.apartmentsrestapi.service;

import com.example.apartmentsrestapi.dto.CitiesDto;
import com.example.apartmentsrestapi.dto.CitiesNumberOfHousesDto;
import com.example.apartmentsrestapi.repository.CitiesRepo;
import com.example.apartmentsrestapi.utils.MappingUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CitiesService {

    private final CitiesRepo citiesRepo;
    private final MappingUtils mappingUtils;
    private final EntityManager entityManager;

    public CitiesService(CitiesRepo citiesRepo, MappingUtils mappingUtils, EntityManager entityManager) {
        this.citiesRepo = citiesRepo;

        this.mappingUtils = mappingUtils;
        this.entityManager = entityManager;
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

//    public List<Object> findAllHouseSql(){
//        String Query=" SELECT ce.name , count (ce.name)  FROM CitiesEntity ce " +
//                "JOIN StreetsEntity se ON ce.id=se.city_id " +
//                "JOIN HousesEntity he ON se.id=he.street_id " +
//                "GROUP BY ce.name";
//        List<Object> list = entityManager.createQuery(Query).getResultList();
//
//        return list;
//    }
    public List<CitiesNumberOfHousesDto> findAllHouseSql() {
        String Query=" SELECT ce.name , count (ce.name)  FROM CitiesEntity ce " +
                "JOIN StreetsEntity se ON ce.id=se.city_id " +
                "JOIN HousesEntity he ON se.id=he.street_id " +
                "GROUP BY ce.name";


        List<Object[]> queryResp = entityManager.createQuery(
                Query).getResultList();
        String[] columns = {"name", "count"};
        List<CitiesNumberOfHousesDto> dataList = new ArrayList<>();
        for(Object[] obj : queryResp) {
            CitiesNumberOfHousesDto row = new CitiesNumberOfHousesDto();
            row.setName(obj[0].toString());
            row.setNumberOfHouses(Long.valueOf(obj[1].toString()));
            dataList.add(row);
        }

        return dataList;
    }




}
