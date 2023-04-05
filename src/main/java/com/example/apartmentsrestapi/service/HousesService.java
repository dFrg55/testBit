package com.example.apartmentsrestapi.service;

import com.example.apartmentsrestapi.dto.HouseNumApartmentDto;
import com.example.apartmentsrestapi.entity.CitiesEntity;
import com.example.apartmentsrestapi.entity.HousesEntity;
import com.example.apartmentsrestapi.entity.StreetsEntity;
import com.example.apartmentsrestapi.repository.CitiesRepo;
import com.example.apartmentsrestapi.utils.MappingUtils;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class HousesService {
    private final CitiesRepo citiesRepo;
    private final MappingUtils mappingUtils;

    public HousesService(CitiesRepo citiesRepo, MappingUtils mappingUtils) {
        this.citiesRepo = citiesRepo;
        this.mappingUtils = mappingUtils;

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

    //Разбор адресной строки строки
    public String findHouse(String address) {
        if(address==null)
            return "Дом отсутсвует в базе данных";
        //Regex для разбора адреса
        //Можно доработать так как тут например не учитываются площади или проспекты вместо названиие улицы
        Pattern pCity = Pattern.compile("\\S*г\\S+\\s+[а-яА-Я0-9 ]+(?=д|у|$)");
        Pattern pStreet = Pattern.compile("\\S*у\\S+\\s+[а-яА-Я0-9 ]+(?=д|г|$)");
        Pattern pHome = Pattern.compile("\\S*д\\S+\\s+[а-яА-Я0-9 ]+(?=у|г|$)");
        Matcher mCity = pCity.matcher(address);
        Matcher mStreet = pStreet.matcher(address);
        Matcher mHome = pHome.matcher(address);

        //Запрос в бд
        List<CitiesEntity> citiesEntities = citiesRepo.findAll();
        if (mCity.find() & mStreet.find() & mHome.find()) {
            String sCity = address.substring(mCity.start(), mCity.end());
            String sStreet = address.substring(mStreet.start(), mStreet.end());
            String sHome = address.substring(mHome.start(), mHome.end());
            for (CitiesEntity city :
                    citiesEntities) {
                if (sCity.contains(city.getName())) {
                    for (StreetsEntity streets :
                            city.getStreetsEntity()) {
                        if (sStreet.contains(streets.getName())) {
                            for (HousesEntity houses :
                                    streets.getHousesEntity()) {
                                if (sHome.contains(houses.getNumber())) {
                                    return Integer.toString(houses.getId());
                                }
                            }
                        }
                    }
                }
            }
        }
        return "Дом отсутсвует в базе данных";
    }
}
