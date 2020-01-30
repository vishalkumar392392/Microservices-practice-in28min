package com.in28Minutes.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LimitsSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsSeviceApplication.class, args);
	}

}
