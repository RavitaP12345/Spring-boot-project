package com.example.microservicemaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceMasterApplication.class, args);
	}

}
