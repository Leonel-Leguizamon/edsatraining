package com.edsatraining.consumerapp;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.edsatraining.consumerapp.menus.CRUDCarMenu;
import com.edsatraining.consumerapp.menus.CRUDServicesMenu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
            System.out.println("1. CRUD Car");
            System.out.println("2. CRUD Services");
            System.out.println("3. Exit");
 
            try {
 
                System.out.println("Choose an option");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        CRUDCarMenu crudCarMenu = new CRUDCarMenu();
                        crudCarMenu.initMenu();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        CRUDServicesMenu servicesMenu = new CRUDServicesMenu();
                        servicesMenu.initMenu();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
