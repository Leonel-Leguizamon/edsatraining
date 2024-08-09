package com.example.demo.application.assertions.servicesAssertions;

import org.springframework.stereotype.Service;

import com.example.demo.application.exception.servicesExceptions.ServiceNotExistsException;
import com.example.demo.infraestructure.output.repository.ServicesRepository;


@Service
public class AssertServiceExists extends ServicesAssertions{

    public AssertServiceExists(ServicesRepository servicesRepository) {
        super(servicesRepository);
    }

    @Override
    public void run(Integer serviceId) throws ServiceNotExistsException {
        if (! servicesRepository.existsById(serviceId))
            throw new ServiceNotExistsException(serviceId);
    }
    
}
