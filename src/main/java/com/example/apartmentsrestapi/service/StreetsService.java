package com.example.apartmentsrestapi.service;

import com.example.apartmentsrestapi.dto.StreetsNumHouseDto;
import com.example.apartmentsrestapi.repository.StreetsRepo;
import com.example.apartmentsrestapi.utils.MappingUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StreetsService {
    private final StreetsRepo streetsRepo;
    private final MappingUtils mappingUtils;

    public StreetsService(StreetsRepo streetsRepo, MappingUtils mappingUtils) {
        this.streetsRepo = streetsRepo;
        this.mappingUtils = mappingUtils;
    }

    public List findAll() {
        return streetsRepo.findAll();
    }

//    public List<Map<String,String>> findAllHouseSql() {
//        String[] columns = {"name","numberOfHouses"};
//        String query = "SELECT se.name , count (se.name)  FROM  StreetsEntity se " +
//                " JOIN HousesEntity he ON se.id=he.street_id " +
//                " GROUP BY se.name ";
//        return mappingUtils.QueryMapToList(columns,query);
//    }

    public List<StreetsNumHouseDto> findAllHouseSql(Integer city_id) {


        String query = "SELECT se.name , count (se.name)  FROM  StreetsEntity se " +
                "JOIN HousesEntity he ON se.id=he.street_id ";
        if (city_id != null) {
            query = query +
                    " WHERE se.city_id=:city_id ";
            query = query.replace(":city_id", city_id.toString());
        }
        query = query + " GROUP BY se.name ";
        System.out.println(query);
        return mappingUtils.MapToStreetsNumHouseDto( query);
    }

}
