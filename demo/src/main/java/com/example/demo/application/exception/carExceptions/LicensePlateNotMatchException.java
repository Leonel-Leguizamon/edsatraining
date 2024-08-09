package com.example.demo.application.exception.carExceptions;

import lombok.Getter;

@Getter
public class LicensePlateNotMatchException extends Throwable {
    String carLicensePlate;

    public LicensePlateNotMatchException(String carLicensePlate){
        super(String.format("The License Plate %s does not match with valid License Format. Try XXX000 or XX00XX formats", carLicensePlate));
        this.carLicensePlate = carLicensePlate;
    }
}