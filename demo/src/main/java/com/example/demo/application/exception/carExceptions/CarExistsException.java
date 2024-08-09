/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.application.exception.carExceptions;

import lombok.Getter;

@Getter
public class CarExistsException extends Throwable {

    String carLicensePlate;
    
    public CarExistsException(String carLicensePlate) {
        super(String.format("Car with %s license plate already exists", carLicensePlate));
        this.carLicensePlate = carLicensePlate;
    }
}
