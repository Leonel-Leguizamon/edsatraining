package com.example.demo.infraestructure.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infraestructure.output.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, String>{
    
}
