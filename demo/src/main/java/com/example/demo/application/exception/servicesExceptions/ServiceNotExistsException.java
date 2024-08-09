package com.example.demo.application.exception.servicesExceptions;

import lombok.Getter;

@Getter
public class ServiceNotExistsException extends Throwable {
    Integer serviceId;

    public ServiceNotExistsException(Integer serviceId){
        super(String.format("Service with id %s not exists", serviceId));
        this.serviceId = serviceId;
    }
}
