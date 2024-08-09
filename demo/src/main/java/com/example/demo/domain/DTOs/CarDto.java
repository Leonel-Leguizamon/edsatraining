package com.example.demo.domain.DTOs;

import java.util.List;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CarDto {
    String licensePlate;
    @NonNull
    Integer chasisNumber;
    Integer engineNumber;
    String make;
    String colour;
    Integer manufactureYear;  
    List<ServiceDto> servicesDone;
}
