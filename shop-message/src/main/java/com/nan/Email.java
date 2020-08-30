package com.nan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Email {
    public static void main(String[] args) {
        SpringApplication.run(Email.class,args);
    }
}
