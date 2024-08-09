package com.example.demo.application.assertions.carAssertions;

import org.springframework.stereotype.Service;

import com.example.demo.infraestructure.output.repository.CarRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public abstract class CarAssertions {
    protected CarRepository carRepository;

    public abstract void run(String licensePlate) throws Throwable;
}
