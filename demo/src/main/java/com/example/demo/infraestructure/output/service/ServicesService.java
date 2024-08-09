package com.example.demo.infraestructure.output.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.assertions.carAssertions.AssertCarExists;
import com.example.demo.application.assertions.servicesAssertions.AssertServiceExists;
import com.example.demo.application.assertions.servicesAssertions.AssertServiceNotExists;
import com.example.demo.application.exception.carExceptions.CarNotExistsException;
import com.example.demo.application.exception.servicesExceptions.ServiceExistsException;
import com.example.demo.application.exception.servicesExceptions.ServiceNotExistsException;
import com.example.demo.domain.DTOs.CarDto;
import com.example.demo.domain.mappers.CarMapper;
import com.example.demo.infraestructure.output.entity.CarEntity;
import com.example.demo.infraestructure.output.entity.ServicesEntity;
import com.example.demo.infraestructure.output.repository.ServicesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private AssertCarExists assertCarExists;

    @Autowired
    private AssertServiceExists assertServiceExists;

    @Autowired
    private AssertServiceNotExists assertServiceNotExists;
    
    public List<CarDto> getCarsServedByDate(LocalDate realizationDate){

        return servicesRepository
                .findByRealizationDate(realizationDate)
                .stream()
                .map(service -> CarMapper.mapToDto(service.getCar()))
                .collect(Collectors.<CarDto> toList());
    }

    public ServicesEntity createService(ServicesEntity newService) throws CarNotExistsException, ServiceExistsException{
        CarEntity carServed = newService.getCar();
        if (carServed != null){
            assertCarExists.run(carServed.getLicensePlate());
            assertServiceNotExists.run(newService.getServiceId());
            return servicesRepository.save(newService);
        } else {
            throw new CarNotExistsException("");
        }
    }

    public ServicesEntity updateService(ServicesEntity newService) throws ServiceNotExistsException {
        assertServiceExists.run(newService.getServiceId());
        ServicesEntity savedService = servicesRepository.findById(newService.getServiceId()).get();
        if (newService.getCar() != null){
            savedService.setCar(newService.getCar());
        }
        if (newService.getRealizationDate() != null){
            savedService.setRealizationDate(newService.getRealizationDate());
        }
        if (newService.getTitle() != null){
            savedService.setTitle(newService.getTitle());
        }
        if (newService.getCost() != null){
            savedService.setCost(newService.getCost());
        }
        if (newService.getObservations() != null){
            savedService.setObservations(newService.getObservations());
        }
        return servicesRepository.save(savedService);
    }

    public void deleteService(Integer serviceId) throws ServiceNotExistsException{
        assertServiceExists.run(serviceId);
        servicesRepository.deleteById(serviceId);
    }

    public List<ServicesEntity> getAllServices(){
        return servicesRepository.findAll();
    }
}
