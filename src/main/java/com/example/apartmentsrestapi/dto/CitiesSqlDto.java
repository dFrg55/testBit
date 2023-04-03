package com.example.apartmentsrestapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CitiesSqlDto {
    private String name;
    private Long count;
}
