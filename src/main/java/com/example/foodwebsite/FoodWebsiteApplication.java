package com.example.foodwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FoodWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodWebsiteApplication.class, args);
    }

}
