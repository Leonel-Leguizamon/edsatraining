package com.edsatraining.consumerapp.menus;

import com.edsatraining.consumerapp.domain.Car;
import com.edsatraining.consumerapp.httphandler.Consumer;

public class CRUDCarMenu extends CRUDMenu {
    private Car testCar = new Car("AA22CC",20,10,"FORD","Red",2024);

    @Override
    public void create() {
        System.out.println("CREATE");
        System.out.println("The following car will be created: " + testCar.toJson().toString());
        System.out.println(Consumer.postCar(testCar.toJson()));
    }

    @Override
    public void delete() {
        System.out.println("The following car will be deleted: " + testCar.toJson().toString());
        System.out.println(Consumer.deleteCar(testCar.getLicensePlate()));
    }

    @Override
    public void requestOne() {
        System.out.println("The following car will be requested: " + testCar.getLicensePlate());
        System.out.println(Consumer.getCarByLicense(testCar.getLicensePlate()));
    }

    

    @Override
    public void requestAll() {
       // System.out.println("The following car will be requested: " + testCar.getLicensePlate());
       System.out.println(Consumer.getAllCars());
    }

    @Override
    public void update() {
        System.out.println("The following car will be updated: " + testCar.toJson().toString() + "\n");
        testCar.setChasisNumber(40);
        testCar.setColour("BLACK");
        System.out.println("New data: " + testCar.toJson().toString() + "\n");
        System.out.println(Consumer.updateCar(testCar.toJson(), testCar.getLicensePlate()));
    }

    @Override
    public void listOptions() {
        // TODO Auto-generated method stub
        System.out.println("1. Get one car");
        System.out.println("2. List all cars");
        System.out.println("3. Create a car");
        System.out.println("4. Update a car");
        System.out.println("5. Delete a car");
    }
    
}
