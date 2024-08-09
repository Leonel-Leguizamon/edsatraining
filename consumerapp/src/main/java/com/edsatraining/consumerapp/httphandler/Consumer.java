package com.edsatraining.consumerapp.httphandler;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDate;

import org.json.JSONObject;

import com.edsatraining.consumerapp.utils.ResponseFormatter;

public class Consumer {

    private static String getResponse(HttpURLConnection activeConnection){

        String formattedOutput = "";
        try {
            formattedOutput = ResponseFormatter.formatResponseToJson(activeConnection.getInputStream());
        } catch (IOException e) {
            System.err.println(ResponseFormatter.formatResponseToJson(activeConnection.getErrorStream()));
        }
        activeConnection.disconnect();
        return formattedOutput;
    }
    
    private static String getPostOrPutResponse(HttpURLConnection activeConnection, String jsonObject){

        String formattedOutput = "";
        try {
            DataOutputStream writeOutputStream = new DataOutputStream(activeConnection.getOutputStream());
            writeOutputStream.write(jsonObject.getBytes());
            writeOutputStream.flush();
            writeOutputStream.close();
            formattedOutput = ResponseFormatter.formatResponseToJson(activeConnection.getInputStream());
        } catch (IOException e) {
            System.err.println(ResponseFormatter.formatResponseToJson(activeConnection.getErrorStream()));
        }
        activeConnection.disconnect();
        return formattedOutput;
    }

    public static String getAllCars(){
        return Consumer.getResponse(RequestGenerator.GET_CARS());
    }

    public static String getCarByLicense(String license){
        return Consumer.getResponse(RequestGenerator.GET_CAR(license));
    }
    
    public static String postCar(JSONObject carJsonObject){
        return Consumer.getPostOrPutResponse(RequestGenerator.POST_CAR(), carJsonObject.toString());
    }

    public static String deleteCar(String license){
        return Consumer.getResponse(RequestGenerator.DELETE_CAR(license));
    }

    public static String updateCar(JSONObject carJSONObject, String licensePlate){
        return Consumer.getPostOrPutResponse(RequestGenerator.PUT_CAR(licensePlate), carJSONObject.toString());
    }
    
    public static String postService(JSONObject serviceJSONObject){
        return Consumer.getPostOrPutResponse(RequestGenerator.POST_SERVICE(), serviceJSONObject.toString());
    }
    
    public static String updateService(JSONObject serviceJSONObject, String serviceId){
        return Consumer.getPostOrPutResponse(RequestGenerator.PUT_SERVICE(serviceId), serviceJSONObject.toString());
    }
    
    public static String deleteService(String serviceId){
        return Consumer.getResponse(RequestGenerator.DELETE_SERVICE(serviceId));
    }

    public static String getServicesByDate(LocalDate date){
        return Consumer.getResponse(RequestGenerator.GET_SERVICES_BY_DATE(date));
    }

    public static String getAllServices(){
        return Consumer.getResponse(RequestGenerator.GET_SERVICES());
    }



}
