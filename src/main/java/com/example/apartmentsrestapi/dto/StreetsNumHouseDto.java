package com.example.apartmentsrestapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class StreetsNumHouseDto {

    private String name;
    private Integer numberOfHouse;

}
