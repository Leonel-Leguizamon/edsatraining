package com.edsatraining.consumerapp.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class CRUDMenu {
 
    
    public void initMenu(){
        Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int option;
        while (!exit) {
            listOptions();
            System.out.println("6. Exit");
 
            try {
 
                System.out.println("Choose an option");
                option = sn.nextInt();
 
                switch (option) {
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
                        exit = true;
                        break;
                    default:
                        System.out.println("Only numbers between 1 and 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must insert a number");
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
