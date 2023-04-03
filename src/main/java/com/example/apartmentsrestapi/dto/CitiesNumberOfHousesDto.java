package com.example.apartmentsrestapi.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component

public class CitiesNumberOfHousesDto {
    String name;
    Long numberOfHouses;

}
