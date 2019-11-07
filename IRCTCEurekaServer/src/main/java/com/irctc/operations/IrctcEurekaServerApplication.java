package com.irctc.operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class IrctcEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrctcEurekaServerApplication.class, args);
	}

}
