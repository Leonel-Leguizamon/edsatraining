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
        boolean exit = false;
        int option;
 
        while (!exit) {
            System.out.println("1. CRUD Car");
            System.out.println("2. CRUD Services");
            System.out.println("3. Exit");
 
            try {
 
                System.out.println("Choose an option");
                option = sn.nextInt();
 
                switch (option) {
                    case 1:
                        CRUDCarMenu crudCarMenu = new CRUDCarMenu();
                        crudCarMenu.initMenu();
                        break;
                    case 2:
                        CRUDServicesMenu servicesMenu = new CRUDServicesMenu();
                        servicesMenu.initMenu();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Choose a number between 1 and 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Must insert a number");
                sn.next();
            }
        }
    }
}
