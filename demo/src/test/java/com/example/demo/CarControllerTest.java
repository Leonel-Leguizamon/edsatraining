package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.application.assertions.carAssertions.AssertLicensePlateFormat;
import com.example.demo.infraestructure.input.controller.CarController;
import com.example.demo.infraestructure.output.service.CarService;


@WebMvcTest(CarController.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;    

    @MockBean
    private CarService carService;

    @MockBean
    private AssertLicensePlateFormat assertLicensePlateFormat;

    // @Test
    // public void shouldReturnCarInfo() throws Exception{
    //     String uriEndpoint = "/car/ABC123";
    //     String expectedResult = "{\"licensePlate\":\"ABC123\",\"chasisNumber\":1,\"engineNumber\":1,\"make\":\"Toyota\",\"colour\":\"Red\",\"manufactureYear\":2022,\"servicesDone\":[{\"serviceId\":3,\"carLicensePlate\":\"ABC123\",\"realizationDate\":\"2024-08-18\",\"title\":\"Cambio de liquido refrigerante\",\"observations\":\"Sin obs\",\"cost\":2000.0}]}";
    //     mockMvc.perform(MockMvcRequestBuilders.get(uriEndpoint))
    //     .andExpect(MockMvcResultMatchers.status().isOk())
    //     .andExpect(MockMvcResultMatchers.content().json(expectedResult));
    // }
}
