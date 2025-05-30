package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminProjectApplication.class, args);
	}

}
