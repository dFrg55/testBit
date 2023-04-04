package com.example.apartmentsrestapi.service;

import com.example.apartmentsrestapi.dto.HouseNumApartmentDto;
import com.example.apartmentsrestapi.entity.CitiesEntity;
import com.example.apartmentsrestapi.entity.HousesEntity;
import com.example.apartmentsrestapi.entity.StreetsEntity;
import com.example.apartmentsrestapi.repository.CitiesRepo;
import com.example.apartmentsrestapi.utils.MappingUtils;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class HousesService {
    private final CitiesRepo citiesRepo;
    private final MappingUtils mappingUtils;


    public HousesService(CitiesRepo citiesRepo, MappingUtils mappingUtils) {
        this.citiesRepo = citiesRepo;
        this.mappingUtils = mappingUtils;

    }

    public List findAll() {
        return citiesRepo.findAll();
    }

    public List<HouseNumApartmentDto> findAllApartmentSql(Integer city_id, Integer street_id) {
        String query = " SELECT ce.name,se.name,he.number,count(*) FROM CitiesEntity ce " +
                " JOIN StreetsEntity se ON ce.id=se.city_id " +
                " JOIN HousesEntity he ON se.id=he.street_id " +
                " JOIN ApartmentsEntity ae ON he.id=ae.house_id ";
        if (city_id != null) {
            query += " WHERE se.city_id=:city_id ";
            query = query.replace(":city_id", city_id.toString());
        } else if (street_id != null) {
            query += " WHERE he.street_id=:street_id ";
            query = query.replace(":street_id", street_id.toString());
        }
        query += " GROUP BY ce.name,se.name,he.number";
        return mappingUtils.MapToHouseNumApartmentDto(query);
    }

    public String findHouse(String address) {
        List<CitiesEntity> citiesEntities = citiesRepo.findAll();
        for (CitiesEntity city :
                citiesEntities) {
            if (address.contains(city.getName())) {
                for (StreetsEntity streets :
                        city.getStreetsEntity()) {
                    if (address.contains(streets.getName())) {
                        for (HousesEntity houses :
                                streets.getHousesEntity()) {
                            if (address.contains(houses.getNumber())){
                                return Integer.toString(houses.getId());
                            }
                        }
                    }
                }
            }
        }
        return "Дом отсутсвует в базе данных";
    }

}
