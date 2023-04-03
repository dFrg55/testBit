package com.example.apartmentsrestapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class HouseNumberOfApartmentsDto {
    private Integer id;
    private String nameCite;
    private String nameStreet;
    private String number;
    private Integer street_id;
    private Long NumberOfApartments;
}
