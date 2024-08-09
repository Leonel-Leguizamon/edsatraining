package com.edsatraining.consumerapp.httphandler;

import java.time.LocalDate;

public class URLGenerator {
    private static final String BASE_URL = "http://localhost:8080";
    private static final String CAR_URI = "/car";
    private static final String SERVICES_URI = "/services";
    private static final String SERVICES_BYDATE_URI = "/services/bydate?date=";

    public static String carsBaseUrl(){
        String output = BASE_URL + CAR_URI;
        return output;
    }
    
    public static String servicesBaseUrl(){
        String output = BASE_URL + SERVICES_URI;
        return output;
    }
    
    public static String servicesByDateUrl(LocalDate date){
        String dateFormatted = date.toString();
        String output = BASE_URL + SERVICES_BYDATE_URI + dateFormatted;
        System.out.println(output);
        return output;
    }
    
    public static String carsWParamsUrl(String param){
        return (URLGenerator.carsBaseUrl() + "/" + param);
    }
    
    public static String servicesWParamsUrl(String param){
        return (URLGenerator.servicesBaseUrl() + "/" + param);
    }




}
