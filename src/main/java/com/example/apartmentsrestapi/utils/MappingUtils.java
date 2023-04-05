package com.example.apartmentsrestapi.utils;

import com.example.apartmentsrestapi.dto.*;
import com.example.apartmentsrestapi.entity.CitiesEntity;
import com.example.apartmentsrestapi.entity.HousesEntity;
import com.example.apartmentsrestapi.entity.StreetsEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.*;

@Service
public class MappingUtils {
    private final EntityManager entityManager;

    public MappingUtils(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public List<CitiesNumHouseDto> MapToCitiesNumHouseDto(String query){
        List<Object[]> queryResp = entityManager.createQuery(query).getResultList();
        List<CitiesNumHouseDto> dataList = new ArrayList<>();
        for(Object[] obj : queryResp) {
            CitiesNumHouseDto citiesNumHouseDto=new CitiesNumHouseDto();
            citiesNumHouseDto.setName(obj[0].toString());
            citiesNumHouseDto.setNumberOfHouse(Integer.valueOf(obj[1].toString()));
            dataList.add(citiesNumHouseDto);
        }
        return dataList;
    }

    public List<StreetsNumHouseDto> MapToStreetsNumHouseDto(String query){
        List<Object[]> queryResp = entityManager.createQuery(query).getResultList();
        List<StreetsNumHouseDto> dataList = new ArrayList<>();
        for(Object[] obj : queryResp) {
            StreetsNumHouseDto streetsNumHouseDto=new StreetsNumHouseDto();
            streetsNumHouseDto.setName(obj[0].toString());
            streetsNumHouseDto.setNumberOfHouse(Integer.valueOf(obj[1].toString()));
            dataList.add(streetsNumHouseDto);
        }
        return dataList;
    }

    public List<HouseNumApartmentDto> MapToHouseNumApartmentDto(String query){
        List<Object[]> queryResp = entityManager.createQuery(query).getResultList();
        List<HouseNumApartmentDto> dataList = new ArrayList<>();
        for(Object[] obj : queryResp) {
            HouseNumApartmentDto houseNumApartmentDto=new HouseNumApartmentDto();
            houseNumApartmentDto.setNameCity(obj[0].toString());
            houseNumApartmentDto.setNameStreet(obj[1].toString());
            houseNumApartmentDto.setNumber(obj[2].toString());
            houseNumApartmentDto.setNumberOfApartment(Integer.valueOf(obj[3].toString()));
            dataList.add(houseNumApartmentDto);
        }
        return dataList;
    }

}
