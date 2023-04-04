package com.example.apartmentsrestapi.service;

import com.example.apartmentsrestapi.dto.CitiesNumHouseDto;
import com.example.apartmentsrestapi.repository.CitiesRepo;
import com.example.apartmentsrestapi.utils.MappingUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CitiesService {

    private final CitiesRepo citiesRepo;
    private final MappingUtils mappingUtils;

    public CitiesService(CitiesRepo citiesRepo, MappingUtils mappingUtils) {
        this.citiesRepo = citiesRepo;

        this.mappingUtils = mappingUtils;
    }


    public List<CitiesNumHouseDto> findAllHouseSql() {

        String query = "SELECT ce.name as name, count (ce.name)  FROM CitiesEntity ce " +
                "JOIN StreetsEntity se ON ce.id=se.city_id " +
                "JOIN HousesEntity he ON se.id=he.street_id " +
                "GROUP BY ce.name";

        return mappingUtils.MapToCitiesNumHouseDto(query);
    }


}
