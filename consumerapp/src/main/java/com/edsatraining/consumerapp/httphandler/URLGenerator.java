package com.edsatraining.consumerapp.httphandler;

public class URLGenerator {
    private static final String BASE_URL = "http://localhost:8080";
    private static final String CAR_URI = "/car";
    private static final String SERVICES_URI = "/services";
    private static final String SERVICES_BYDATE_URI = "/services/bydate";

    public static String carsBaseUrl(){
        String output = BASE_URL + CAR_URI;
        return output;
    }
    
    public static String servicesBaseUrl(){
        String output = BASE_URL + SERVICES_URI;
        return output;
    }
    
    public static String servicesByDateUrl(){
        String output = BASE_URL + SERVICES_BYDATE_URI;
        return output;
    }
    
    public static String carsWParamsUrl(String param){
        return (URLGenerator.carsBaseUrl() + "/" + param);
    }
    
    public static String servicesWParamsUrl(String param){
        return (URLGenerator.servicesBaseUrl() + "/" + param);
    }




}
