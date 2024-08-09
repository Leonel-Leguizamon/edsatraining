package com.example.demo.infraestructure.input.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.assertions.carAssertions.AssertCarExists;
import com.example.demo.application.assertions.carAssertions.AssertLicensePlateFormat;
import com.example.demo.domain.DTOs.CarDto;
import com.example.demo.domain.DTOs.ServiceDto;
import com.example.demo.domain.mappers.ServicesMapper;
import com.example.demo.infraestructure.output.service.ServicesService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("/services")
public class ServicesController {
    
    @Autowired
    private ServicesService servicesService;

    @Autowired
    private AssertLicensePlateFormat assertLicensePlateFormat;

    @Autowired 
    private AssertCarExists assertCarExists;



    @GetMapping("/bydate")
    public ResponseEntity<List<CarDto>> getCarsServedByDate(
        @RequestParam("date") 
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate realizationDate) {
        return ResponseEntity.ok(servicesService.getCarsServedByDate(realizationDate));
    }
    
    @PostMapping("")
    public ResponseEntity createService(@RequestBody ServiceDto newService) {
        try {
            String licensePlate = newService.getCarLicensePlate();
            if (licensePlate != null){
                assertLicensePlateFormat.run(licensePlate);
            } else {
                return ResponseEntity.internalServerError().body("License plate can't be null");
            } 
            return ResponseEntity.ok(
                ServicesMapper.entityToDto(        
                    servicesService
                    .createService(ServicesMapper.dtoToEntity(newService))
                )
            );
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().body(t.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity getAllServices() {
        return ResponseEntity.ok(
            servicesService.getAllServices()
            .stream()
            .map(service -> ServicesMapper.entityToDto(service))
            .collect(Collectors.<ServiceDto> toList())
        );
    }
    
    @PutMapping("/{serviceId}")
    public ResponseEntity updateService(@PathVariable String serviceId, @RequestBody ServiceDto serviceDto) {
        String carLicensePlate = serviceDto.getCarLicensePlate();
        //If the client want to update the Car attended, we should check that the
        //license its correctly written and the car exists, before doing the mapping to entity
        //because then the field "Car" will be null, and that's not what the client want.
        if (carLicensePlate != null){
            try {
                assertLicensePlateFormat.run(carLicensePlate);
                assertCarExists.run(carLicensePlate);
                return ResponseEntity.ok(
                    ServicesMapper.entityToDto(
                        servicesService.updateService(
                            ServicesMapper.dtoToEntity(serviceDto)
                        )
                    )
                );
            } catch (Throwable t) {
                return ResponseEntity.internalServerError().body(t.getMessage());
            }
        } else {
            //in case that the client want update other fields, then we proceed as usual
            try {
                return ResponseEntity.ok(
                    ServicesMapper.entityToDto(
                        servicesService.updateService(
                            ServicesMapper.dtoToEntity(serviceDto)
                        )
                ));
            } catch (Throwable t) {
                return ResponseEntity.internalServerError().body(
                    t.getMessage()
                );
            }
        }
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity deleteService(@PathVariable Integer serviceId){
        try {
            servicesService.deleteService(serviceId);
            return ResponseEntity.ok("Succesfully deleted");
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().body(
                t.getMessage()
            );
        }
    }
}
