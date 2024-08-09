package com.edsatraining.consumerapp.httphandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestGenerator {

    private static HttpURLConnection createConnection(String method, String url){
        try {
            URL myURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
            connection.setRequestMethod(method);
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
    
    public static HttpURLConnection GET_SERVICES(){
        return RequestGenerator.createConnection("GET",URLGenerator.servicesBaseUrl());
    }
    
    public static HttpURLConnection GET_SERVICES_BY_DATE(){
        return RequestGenerator.createConnection("GET",URLGenerator.servicesByDateUrl());
    }
    
}
