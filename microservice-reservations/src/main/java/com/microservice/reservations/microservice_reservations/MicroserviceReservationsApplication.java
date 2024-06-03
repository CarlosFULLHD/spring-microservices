package com.microservice.reservations.microservice_reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceReservationsApplication.class, args);
	}

}
