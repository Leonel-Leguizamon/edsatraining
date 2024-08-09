package com.edsatraining.consumerapp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ResponseFormatter {

    public static String formatResponseToJson(InputStream connectionResposne){
        BufferedReader reader = new BufferedReader(new InputStreamReader(connectionResposne));
        String responseToString = buildString(reader);
        return jsonPrettier(responseToString);
    }   

    private static String buildString(BufferedReader reader){
        StringBuilder results = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                results.append(line);
            }
            return results.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            return "";
        }
    }

    private static String jsonPrettier(String plainResponse){
        Gson gsonLib = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(plainResponse);
        return gsonLib.toJson(jsonElement);
    }
    
}
