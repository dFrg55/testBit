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

    public List<Map<String,String>> QueryMapToList(String[] columns,String query){

        List<Object[]> queryResp = entityManager.createQuery(query).getResultList();
        List<Map<String,String>> dataList = new ArrayList<>();
        for(Object[] obj : queryResp) {
            Map<String,String> row = new LinkedHashMap<>(columns.length);
            for(int i=0; i<columns.length; i++) {
                if(obj[i]!=null)
                    row.put(columns[i], obj[i].toString());
                else
                    row.put(columns[i], "");
            }
            dataList.add(row);
        }
        return dataList;
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
//    public List<CitiesNumHouseDto> MapToCitiesNumHouseDto(String[] columns,String query){
//        List<CitiesNumHouseDto> queryResp = entityManager.createQuery(query).getResultList();
//        return queryResp;
//    }





//    public List<T> QueryMapToList(String[] columns,String query){
//
//        List<Object[]> queryResp = entityManager.createQuery(query).getResultList();
//        List<T> dataList = new ArrayList<>();
//        for(Object[] obj : queryResp) {
////            T row = new LinkedHashMap<>(columns.length);
//            T t =new Dto();
//            Class<? extends Object> clazz = citiesDto.getClass();
//            Field[] fields = clazz.getDeclaredFields();
//            for(Field field: fields){
//                String fieldName = field.getName();
//                System.out.println(field.getName());
//            }
//            for(int i=0; i<columns.length; i++) {
//                if(obj[i]!=null)
//                    row.put(columns[i], obj[i].toString());
//                else
//                    row.put(columns[i], "");
//            }
//            dataList.add(row);
//        }
//        return dataList;
//    }

}
