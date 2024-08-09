package com.edsatraining.consumerapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.edsatraining.consumerapp.utils.ResponseFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {

        String uri = "/car";
        String baseUrl = "http://localhost:8080";

        URL myURL = new URL(baseUrl.concat(uri));
        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
        
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        
        connection.connect();
        System.out.println(ResponseFormatter.formatResponseToJson(connection.getInputStream()));
        connection.disconnect();


    }
}
