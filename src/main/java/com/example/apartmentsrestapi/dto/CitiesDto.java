package com.example.apartmentsrestapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component

public class CitiesDto {
    private Integer id;
    private String name;
}
