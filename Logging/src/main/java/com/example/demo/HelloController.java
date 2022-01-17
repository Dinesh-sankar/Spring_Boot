package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class HelloController {

	Logger logger = (Logger) LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/hello")
	public String sayHello( ) {
					
		logger.debug("Hello at Debug level");
		return "Hello World";
		
	}
	
}
