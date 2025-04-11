package com.example.MediTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediTimeApplication.class, args);
        System.out.println("MediTime is up and running!");
    }
}
