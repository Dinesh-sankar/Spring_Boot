package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private ApiConfig apiconfig;
	
	@GetMapping("/hello")
	public String sayHello() {
		return apiconfig.getHost() + " "
				+ apiconfig.getPort() + " "
				+ apiconfig.getTimeout();
	}
	
}
