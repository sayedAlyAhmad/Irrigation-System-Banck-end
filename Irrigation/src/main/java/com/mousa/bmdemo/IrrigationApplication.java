package com.mousa.bmdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IrrigationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrrigationApplication.class, args);
	}

}
