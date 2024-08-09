package com.example.demo.infraestructure.input.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.assertions.carAssertions.AssertLicensePlateFormat;
import com.example.demo.application.exception.carExceptions.CarExistsException;
import com.example.demo.application.exception.carExceptions.CarNotExistsException;
import com.example.demo.application.exception.carExceptions.LicensePlateNotMatchException;
import com.example.demo.domain.DTOs.CarDto;
import com.example.demo.domain.mappers.CarMapper;
import com.example.demo.infraestructure.output.entity.CarEntity;
import com.example.demo.infraestructure.output.service.CarService;

import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController {
    
    @Autowired
    private CarService carService;

    @Autowired
    private AssertLicensePlateFormat assertLicensePlateFormat;

    @GetMapping("/{licensePlate}")
    public ResponseEntity getCarInformation(@PathVariable String licensePlate) throws CarNotExistsException {
        try {
            Optional<CarEntity> car = carService.getCarById(licensePlate);
            CarEntity savedCar = car.get();
            CarDto returnCar = CarMapper.mapToDto(savedCar);
            return ResponseEntity.ok(returnCar);
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().body(t.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity getAllCars() {
        List<CarDto> cars = carService.listAllCars()
                                        .stream()
                                        .map(car -> CarMapper.mapToDto(car))
                                        .collect(Collectors.<CarDto> toList());
        return ResponseEntity.ok(cars);
    }
    
    
    @PostMapping("")
    public ResponseEntity postCar(@RequestBody CarDto newCar) throws LicensePlateNotMatchException, CarExistsException {
        try {
            assertLicensePlateFormat.run(newCar.getLicensePlate());
            CarEntity savedCar =  carService.saveCar(CarMapper.mapToEntity(newCar));
            return ResponseEntity.ok(CarMapper.mapToDto(savedCar));    
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().body(t.getMessage());
        }
    }

    @PutMapping("/{licensePlate}")
    public ResponseEntity updateCar(@PathVariable String licensePlate, @RequestBody CarDto carDto) throws CarNotExistsException {
        //TODO: process PUT request
        try {
            CarEntity updatedCar = carService.updateCar(licensePlate, CarMapper.mapToEntity(carDto));
            return ResponseEntity.ok(CarMapper.mapToDto(updatedCar));
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().body(t.getMessage());
        }
    }

    @DeleteMapping("/{licensePlate}")
    public ResponseEntity deleteCar(@PathVariable String licensePlate) throws CarNotExistsException{
        try {
            carService.deleteCar(licensePlate);
            return ResponseEntity.ok().body("Succesfully deleted");
        } catch (Throwable t){
            return ResponseEntity.internalServerError().body(t.getMessage());
        }
    }
    
}
