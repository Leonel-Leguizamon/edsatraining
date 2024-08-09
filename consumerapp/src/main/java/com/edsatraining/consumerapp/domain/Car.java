package com.edsatraining.consumerapp.domain;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Car {
    private String licensePlate;
    private int chasisNumber;
    private int engineNumber;
    private String make;
    private String colour;
    private int manufactureYear;  
    private List<Service> servicesDone;

    public Car(String licensePlate, Integer chasisNumber, Integer engineNumber, String make, String colour,
            Integer manufactureYear) {
        this.licensePlate = licensePlate;
        this.chasisNumber = chasisNumber;
        this.engineNumber = engineNumber;
        this.make = make;
        this.colour = colour;
        this.manufactureYear = manufactureYear;
        this.servicesDone = new ArrayList<Service>();
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public Integer getChasisNumber() {
        return chasisNumber;
    }
    public void setChasisNumber(Integer chasisNumber) {
        this.chasisNumber = chasisNumber;
    }
    public Integer getEngineNumber() {
        return engineNumber;
    }
    public void setEngineNumber(Integer engineNumber) {
        this.engineNumber = engineNumber;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public Integer getManufactureYear() {
        return manufactureYear;
    }
    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
    public List<Service> getServicesDone() {
        return servicesDone;
    }
    public void addService(Service newService){
        this.servicesDone.add(newService);
    }

    public JSONObject toJson(){
        JSONObject jsonCar = new JSONObject()
            .put("licensePlate", this.licensePlate)
            .put("chasisNumber", this.chasisNumber)
            .put("engineNumber", this.engineNumber)
            .put("make", this.make)
            .put("colour", this.colour)
            .put("manufactureYear", this.manufactureYear)
            .put("servicesDone", this.servicesDone.toArray());
        return jsonCar;
    }
}
