package com.example.demo.application.assertions.servicesAssertions;

import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.output.repository.ServicesRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public abstract class ServicesAssertions {
    protected ServicesRepository servicesRepository;

    public abstract void run(Integer serviceId) throws Throwable;
}