package com.example.demo.domain.DTOs;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ServiceDto {
    Integer serviceId;
    String carLicensePlate;
    LocalDate realizationDate;
    String title;
    String observations;
    Double cost;
}
