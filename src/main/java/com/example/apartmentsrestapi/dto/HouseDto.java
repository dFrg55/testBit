package com.example.apartmentsrestapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class HouseDto {
    private Integer id;
    private String number;
    private Integer street_id;
}
