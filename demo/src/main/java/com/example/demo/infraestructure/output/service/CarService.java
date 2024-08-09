package com.example.demo.infraestructure.output.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.assertions.carAssertions.AssertCarExists;
import com.example.demo.application.assertions.carAssertions.AssertCarNotExists;
import com.example.demo.application.exception.carExceptions.CarExistsException;
import com.example.demo.application.exception.carExceptions.CarNotExistsException;
import com.example.demo.infraestructure.output.entity.CarEntity;
import com.example.demo.infraestructure.output.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CarService {
    
    @Autowired
    private final CarRepository carRepository;
    
    @Autowired
    private final AssertCarExists assertCarExists;
    
    @Autowired
    private final AssertCarNotExists assertCarNotExists;

    public CarEntity saveCar(CarEntity newCar) throws CarExistsException{
        //check existence
        assertCarNotExists.run(newCar.getLicensePlate());
        return carRepository.save(newCar);
    }

    public CarEntity updateCar(String licensePlate, CarEntity newCar) throws CarNotExistsException {
        //check existence
        assertCarExists.run(licensePlate);
        CarEntity car = carRepository.findById(licensePlate).get();
        if (newCar.getChasisNumber() != null) {
            car.setChasisNumber(newCar.getChasisNumber());
        }
        if (newCar.getEngineNumber() != null) {
            car.setEngineNumber(newCar.getEngineNumber());
        }
        if (newCar.getColour() != null) {
            car.setColour(newCar.getColour());
        }
        if (newCar.getMake() != null) {
            car.setMake(newCar.getMake());
        }
        if (newCar.getManufactureYear() != null) {
            car.setManufactureYear(newCar.getManufactureYear());
        }
        
        if (newCar.getServices() != null) {
            car.setServices(newCar.getServices());
        }

        return carRepository.save(car);
}

    
    public void deleteCar(String licensePlate) throws CarNotExistsException{
        assertCarExists.run(licensePlate);
        carRepository.deleteById(licensePlate);
    }

    public Optional<CarEntity> getCarById(String licensePlate) throws CarNotExistsException{
        //check existence, throw exception
        assertCarExists.run(licensePlate);
        return carRepository.findById(licensePlate);
    }

    public List<CarEntity> listAllCars(){
        return carRepository.findAll();
    }

}
