package com.example.demo.application.exception.carExceptions;

import lombok.Getter;

@Getter
public class CarNotExistsException extends Throwable {
    String carLicensePlate;

    public CarNotExistsException(String carLicensePlate){
        super(String.format("Car with %s license plate not exists", carLicensePlate));
        this.carLicensePlate = carLicensePlate;
    }
}
