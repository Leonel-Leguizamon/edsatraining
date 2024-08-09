package com.example.demo.application.assertions.carAssertions;

import org.springframework.stereotype.Service;

import com.example.demo.application.exception.carExceptions.CarExistsException;
import com.example.demo.infraestructure.output.repository.CarRepository;

@Service
public class AssertCarNotExists extends CarAssertions{

    public AssertCarNotExists(CarRepository carRepository) {
        super(carRepository);
    }
    
    @Override
    public void run(String licensePlate) throws CarExistsException {
        if (carRepository.existsById(licensePlate)){
            throw new CarExistsException(licensePlate);
        }
    }
}