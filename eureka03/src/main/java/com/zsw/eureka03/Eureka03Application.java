package com.zsw.eureka03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka03Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka03Application.class, args);
    }

}
