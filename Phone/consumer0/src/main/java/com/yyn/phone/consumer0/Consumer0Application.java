package com.yyn.phone.consumer0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Consumer0Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer0Application.class, args);
	}

}
