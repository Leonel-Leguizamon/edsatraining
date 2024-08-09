package com.example.demo.application.exception.servicesExceptions;

import lombok.Getter;

@Getter
public class ServiceExistsException extends Throwable {
    Integer serviceId;

    public ServiceExistsException(Integer serviceId){
        super(String.format("Service with id %s already exists", serviceId));
        this.serviceId = serviceId;
    }
}