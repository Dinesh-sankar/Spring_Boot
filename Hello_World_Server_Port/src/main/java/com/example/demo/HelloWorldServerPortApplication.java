package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldServerPortApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldServerPortApplication.class, args);
		System.out.println("The server is running in port 8081");
	}

}
