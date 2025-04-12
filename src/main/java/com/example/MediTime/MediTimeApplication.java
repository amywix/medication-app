package com.example.MediTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.MediTime.repository")
@EntityScan("com.example.MediTime.model")
@ComponentScan("com.example.MediTime")


public class MediTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediTimeApplication.class, args);
        System.out.println("MediTime is up and running!");
    }
}
