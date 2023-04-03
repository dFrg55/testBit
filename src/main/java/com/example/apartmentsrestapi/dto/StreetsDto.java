package com.example.apartmentsrestapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class StreetsDto {
    private Integer id;
    private String name;
    private Integer city_id;
    
}
