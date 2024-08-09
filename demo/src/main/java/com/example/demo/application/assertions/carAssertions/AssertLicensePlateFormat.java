package com.example.demo.application.assertions.carAssertions;

import org.springframework.stereotype.Service;

import com.example.demo.application.exception.carExceptions.LicensePlateNotMatchException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AssertLicensePlateFormat{

    private final String regex = "^([A-Z]{3}[0-9]{3}|[A-Z]{2}[0-9]{2}[A-Z]{2})$";

    public void run(String licensePlate) throws LicensePlateNotMatchException {
        if (!licensePlate.matches(regex))
            throw new LicensePlateNotMatchException(licensePlate);
    }
}