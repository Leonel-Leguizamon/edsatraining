package com.example.demo.domain.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CarDto {
    String licensePlate;
    Integer chasisNumber;
    Integer engineNumber;
    String make;
    String colour;
    Integer manufactureYear;  
    List<ServiceDto> servicesDone;
}
