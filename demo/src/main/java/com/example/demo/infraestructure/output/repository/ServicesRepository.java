package com.example.demo.infraestructure.output.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infraestructure.output.entity.ServicesEntity;


public interface ServicesRepository extends JpaRepository<ServicesEntity, Integer>{
    List<ServicesEntity> findByRealizationDate(LocalDate realizationDate);
}
