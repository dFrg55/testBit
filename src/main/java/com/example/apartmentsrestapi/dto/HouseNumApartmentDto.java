package com.example.apartmentsrestapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class HouseNumApartmentDto {
    private String nameCity;
    private String nameStreet;
    private String number;

    private Integer numberOfApartment;
}
