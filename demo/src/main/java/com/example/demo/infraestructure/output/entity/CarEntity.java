package com.example.demo.infraestructure.output.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="cars")
public class CarEntity {
    
    @Id
    @Column(name="license_plate")
    //check for pattern
    private String licensePlate;

    @Column(name="chasis_number")
    private Integer chasisNumber;
    
    @Column(name="engine_number")
    private Integer engineNumber;
    
    @Column(name="make")
    private String make;
    
    @Column(name="colour")
    private String colour;
    
    @Column(name="manufacture_year")
    private Integer manufactureYear; 

    @JsonManagedReference
    @OneToMany(
        mappedBy = "car", 
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    private List<ServicesEntity> services;
}
