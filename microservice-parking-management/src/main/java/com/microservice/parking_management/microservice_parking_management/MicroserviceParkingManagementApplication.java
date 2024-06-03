package com.microservice.parking_management.microservice_parking_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceParkingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceParkingManagementApplication.class, args);
	}

}
