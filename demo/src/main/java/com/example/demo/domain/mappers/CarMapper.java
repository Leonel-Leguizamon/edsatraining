package com.example.demo.domain.mappers;

import java.util.stream.Collectors;

import com.example.demo.domain.DTOs.CarDto;
import com.example.demo.domain.DTOs.ServiceDto;
import com.example.demo.infraestructure.output.entity.CarEntity;

public class CarMapper {
    
    public static CarDto mapToDto(CarEntity car){
        CarDto output = new CarDto(
            car.getLicensePlate(),
            car.getChasisNumber(),
            car.getEngineNumber(), 
            car.getMake(),
            car.getColour(),
            car.getManufactureYear(),
            car.getServices()
                .stream()
                .map(service -> ServicesMapper.entityToDto(service))
                .collect(Collectors.<ServiceDto> toList())
        );
        return output;                                            
    }
    public static CarEntity mapToEntity(CarDto car){
        CarEntity output = new CarEntity(
            car.getLicensePlate(),
            car.getChasisNumber(),
            car.getEngineNumber(), 
            car.getMake(),
            car.getColour(),
            car.getManufactureYear(),
            null
        );

        if (car.getServicesDone() != null){
            output.setServices(
                car.getServicesDone()
                .stream()
                .map(service -> {
                    try {
                        return ServicesMapper.dtoToEntity(service);
                    } catch (Throwable e) {
                        return null;
                    }
                })
                .collect(Collectors.toList())
            );
        }
        return output;                                            
    }
}
