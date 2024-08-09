package com.edsatraining.consumerapp.httphandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class RequestGenerator {

    private static HttpURLConnection createConnection(String method, String url){
        try {
            URL myURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.connect();
            return connection;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static HttpURLConnection GET_CARS(){
        return RequestGenerator.createConnection("GET",URLGenerator.carsBaseUrl());
    }
    
    public static HttpURLConnection GET_CAR(String licensePlate){
        return RequestGenerator.createConnection("GET",URLGenerator.carsWParamsUrl(licensePlate));
    }
    
    public static HttpURLConnection DELETE_CAR(String licensePlate){
        return RequestGenerator.createConnection("DELETE",URLGenerator.carsWParamsUrl(licensePlate));
    }
    
    public static HttpURLConnection POST_CAR(){
        return RequestGenerator.createConnection("POST",URLGenerator.carsBaseUrl());
    }
    
    public static HttpURLConnection PUT_CAR(String licensePlate){
        return RequestGenerator.createConnection("PUT",URLGenerator.carsWParamsUrl(licensePlate));
    }
    
    public static HttpURLConnection GET_SERVICES(){
        return RequestGenerator.createConnection("GET",URLGenerator.servicesBaseUrl());
    }
    
    public static HttpURLConnection GET_SERVICES_BY_DATE(LocalDate date){
        return RequestGenerator.createConnection("GET",URLGenerator.servicesByDateUrl(date));
    }
    
    public static HttpURLConnection POST_SERVICE(){
        return RequestGenerator.createConnection("POST",URLGenerator.servicesBaseUrl());
    }

    public static HttpURLConnection PUT_SERVICE(String serviceId){
        return RequestGenerator.createConnection("PUT",URLGenerator.servicesWParamsUrl(serviceId));
    }
    public static HttpURLConnection DELETE_SERVICE(String serviceId){
        return RequestGenerator.createConnection("DELETE",URLGenerator.servicesWParamsUrl(serviceId));
    }

}
