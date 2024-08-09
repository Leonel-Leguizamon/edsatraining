package com.edsatraining.consumerapp.domain;

import java.time.LocalDate;

import org.json.JSONObject;

public class Service {
    private int serviceId;
    private String carLicensePlate;
    private LocalDate realizationDate;
    private String title;
    private String observations;
    private double  cost;

    public Service(Integer serviceId, String carLicensePlate, LocalDate realizationDate, String title,
            String observations, Double cost) {
        this.serviceId = serviceId;
        this.carLicensePlate = carLicensePlate;
        this.realizationDate = realizationDate;
        this.title = title;
        this.observations = observations;
        this.cost = cost;
    }
    public Integer getServiceId() {
        return serviceId;
    }
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
    public String getCarLicensePlate() {
        return carLicensePlate;
    }
    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }
    public LocalDate getRealizationDate() {
        return realizationDate;
    }
    public void setRealizationDate(LocalDate realizationDate) {
        this.realizationDate = realizationDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }

    public JSONObject toJson(){
        JSONObject jsonService = new JSONObject()
            .put("serviceId", this.serviceId)
            .put("carLicensePlate", this.carLicensePlate)
            .put("realizationDate", this.realizationDate.toString())
            .put("title", this.title)
            .put("observations", this.observations)
            .put("cost", this.cost);
        return jsonService;
    }
    
}
