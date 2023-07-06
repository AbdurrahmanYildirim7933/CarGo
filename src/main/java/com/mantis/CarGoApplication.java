package com.mantis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class CarGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarGoApplication.class, args);
	}

}
