package com.example.demo.domain.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.exception.carExceptions.CarNotExistsException;
import com.example.demo.domain.DTOs.ServiceDto;
import com.example.demo.infraestructure.output.entity.CarEntity;
import com.example.demo.infraestructure.output.entity.ServicesEntity;
import com.example.demo.infraestructure.output.service.CarService;



@Service
public class ServicesMapper {

    private static CarService carService;

    public static ServiceDto entityToDto(ServicesEntity service){
        ServiceDto output = new ServiceDto(
            service.getServiceId(), 
            service.getCar().getLicensePlate(),
            service.getRealizationDate(),
            service.getTitle(),
            service.getObservations(),
            service.getCost());
        return output;
    }
    
    public static ServicesEntity dtoToEntity(ServiceDto service) throws CarNotExistsException{
        Optional<CarEntity> car = carService.getCarById(service.getCarLicensePlate());

        ServicesEntity output = new ServicesEntity(
            service.getServiceId(), 
            car.get(),
            service.getRealizationDate(),
            service.getTitle(),
            service.getObservations(),
            service.getCost());
        return output;
    }

    @Autowired
    public void setCarService(CarService carService) {
        ServicesMapper.carService = carService;
    }
}
