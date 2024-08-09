package com.example.demo.application.assertions.servicesAssertions;

import org.springframework.stereotype.Service;

import com.example.demo.application.exception.servicesExceptions.ServiceExistsException;
import com.example.demo.infraestructure.output.repository.ServicesRepository;

@Service
public class AssertServiceNotExists extends ServicesAssertions{

    public AssertServiceNotExists(ServicesRepository servicesRepository) {
        super(servicesRepository);
    }

    @Override
    public void run(Integer serviceId) throws ServiceExistsException {
        if (servicesRepository.existsById(serviceId))
            throw new ServiceExistsException(serviceId);
    }
    
}
