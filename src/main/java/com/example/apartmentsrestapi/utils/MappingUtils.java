package com.example.apartmentsrestapi.utils;

import com.example.apartmentsrestapi.dto.CitiesDto;
import com.example.apartmentsrestapi.dto.CitiesNumberOfHousesDto;
import com.example.apartmentsrestapi.dto.StreetsDto;
import com.example.apartmentsrestapi.dto.StreetsNumberOfHousesDto;
import com.example.apartmentsrestapi.entity.CitiesEntity;
import com.example.apartmentsrestapi.entity.StreetsEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    //из entity в dto
    public  CitiesDto mapToCitiesDto(CitiesEntity entity){
        CitiesDto dto = new CitiesDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    //из dto в entity
    public  CitiesEntity mapToCitiesEntity(CitiesDto dto){
        CitiesEntity entity = new CitiesEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
    public CitiesNumberOfHousesDto mapToCitiesNumberOfHousesDto(CitiesEntity entity,Long NumberOfHouses){
        CitiesNumberOfHousesDto dto = new CitiesNumberOfHousesDto();
        dto.setNumberOfHouses(NumberOfHouses);
        dto.setName(entity.getName());
        return dto;
    }
    public StreetsNumberOfHousesDto mapToStreetsNumberOfHousesDto(StreetsEntity entity,Long NumberOfHouses){
        StreetsNumberOfHousesDto dto = new StreetsNumberOfHousesDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCity_id(entity.getCity_id());
        dto.setNumberOfHouses(NumberOfHouses);
        return dto;
    }




}
