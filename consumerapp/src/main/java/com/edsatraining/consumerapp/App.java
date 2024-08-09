package com.edsatraining.consumerapp;

import java.io.IOException;

import com.edsatraining.consumerapp.httphandler.Consumer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println(Consumer.getAllCars());

    }
}
