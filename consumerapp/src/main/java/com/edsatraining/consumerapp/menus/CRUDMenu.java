package com.edsatraining.consumerapp.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class CRUDMenu {
 
    
    public void initMenu(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            listOptions();
            System.out.println("6. Exit");
 
            try {
 
                System.out.println("Choose an option");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        requestOne();
                        break;
                    case 2:
                        requestAll();
                        break;
                    case 3:
                        create();
                        break;
                    case 4:
                        update();
                        break;
                    case 5:
                        delete();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    public abstract void create();
    public abstract void requestOne();
    public abstract void requestAll();
    public abstract void update();
    public abstract void delete();
    public abstract void listOptions();
}
