package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppRegistrationApplication.class, args);
	}
}