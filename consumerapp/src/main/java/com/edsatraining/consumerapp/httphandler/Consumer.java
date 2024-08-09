package com.edsatraining.consumerapp.httphandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDate;

import com.edsatraining.consumerapp.utils.ResponseFormatter;

public class Consumer {

    private static String getResponse(HttpURLConnection activeConnection){

        String formattedOutput = "";
        try {
            formattedOutput = ResponseFormatter.formatResponseToJson(activeConnection.getInputStream());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        activeConnection.disconnect();
        return formattedOutput;
    }
    
    public static String getAllCars(){
        return Consumer.getResponse(RequestGenerator.GET_CARS());
    }

    public static String postCar(Object car){
        //TODO
        return null;
    }

    public static String deleteCar(String license){
        //TODO
        return null;
    }

    public static String getCarByLicense(String license){
        //TODO
        return null;
    }

    public static String updateCar(String fields){
        //TODO
        return null;
    }

    public static String postService(Object service){
        //TODO
        return null;
    }

    public static String updateService(String fields){
        //TODO
        return null;
    }

    public static String getServicesByDate(LocalDate date){
        //TODO
        return null;
    }

    public static String getAllServices(){
        return Consumer.getResponse(RequestGenerator.GET_SERVICES());
    }



}
