package com.damiza.hello.spring.cloud.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServcieAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServcieAdminApplication.class,args);
    }
}
