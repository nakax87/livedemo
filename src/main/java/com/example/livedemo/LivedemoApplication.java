package com.example.livedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.livedemo"})
public class LivedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivedemoApplication.class, args);
    }
}