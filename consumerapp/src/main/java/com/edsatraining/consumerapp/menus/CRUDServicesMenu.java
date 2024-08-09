package com.edsatraining.consumerapp.menus;

import java.time.LocalDate;
import java.time.Month;

import com.edsatraining.consumerapp.domain.Service;
import com.edsatraining.consumerapp.httphandler.Consumer;

public class CRUDServicesMenu extends CRUDMenu {
    private Service testService = new Service(4, "AA22CC", LocalDate.of(2024, Month.AUGUST, 17), "Test service", "Without observations", 4000.0);
    @Override
    public void create() {
        System.out.println("CREATE");
        System.out.println("The following service will be created: " + testService.toJson().toString());
        System.out.println(Consumer.postService(testService.toJson()));
    }

    @Override
    public void delete() {
        System.out.println("The following service will be deleted: " + testService.toJson().toString());
        System.out.println(Consumer.deleteService(testService.getServiceId().toString()));
    }

    @Override
    public void requestOne() {
        LocalDate ld = LocalDate.of(2024, Month.AUGUST, 17);
        System.out.println(String.format("The following cars served at date %s will be requested", ld));
        System.out.println(Consumer.getServicesByDate(ld));
    }

    

    @Override
    public void requestAll() {
       System.out.println(Consumer.getAllServices());
    }

    @Override
    public void update() {
        System.out.println("The following service will be updated: " + testService.toJson().toString() + "\n");
        testService.setCost(20000.0);
        testService.setObservations("With observations");
        System.out.println("New data: " + testService.toJson().toString() + "\n");
        System.out.println(Consumer.updateService(testService.toJson(), testService.getServiceId().toString()));
    }

    @Override
    public void listOptions() {
        // TODO Auto-generated method stub
        System.out.println("1. Get cars served by date");
        System.out.println("2. List all services");
        System.out.println("3. Create a service");
        System.out.println("4. Update a service");
        System.out.println("5. Delete a service");
    }
    
}