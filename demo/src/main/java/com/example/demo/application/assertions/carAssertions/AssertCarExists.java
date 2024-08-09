package com.example.demo.application.assertions.carAssertions;

import org.springframework.stereotype.Service;

import com.example.demo.application.exception.carExceptions.CarNotExistsException;
import com.example.demo.infraestructure.output.repository.CarRepository;

@Service
public class AssertCarExists extends CarAssertions{

    public AssertCarExists(CarRepository carRepository) {
        super(carRepository);
    }
    
    @Override
    public void run(String licensePlate) throws CarNotExistsException {
        if (! carRepository.existsById(licensePlate)){
            throw new CarNotExistsException(licensePlate);
        }
    }
}
