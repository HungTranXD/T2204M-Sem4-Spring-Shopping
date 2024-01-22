package com.example.t2204msem4springshopping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class T2204MSem4SpringShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(T2204MSem4SpringShoppingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
            System.out.println("Start project");
        };
    }
}
