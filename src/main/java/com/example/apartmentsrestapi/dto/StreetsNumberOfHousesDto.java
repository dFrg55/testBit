package com.example.apartmentsrestapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class StreetsNumberOfHousesDto {
    private Integer id;
    private String name;
    private Integer city_id;
    private Long NumberOfHouses;

}

