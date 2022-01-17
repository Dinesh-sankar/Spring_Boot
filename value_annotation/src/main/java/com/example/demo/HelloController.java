package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${message}")			//Value provided in the application.properties file
	private String msg;
	
	@Value("${text : This is the default message}")		//Default value 
	private String defaultMessage;
	
	@Value("${name.list}")								//List values
	private String[] list;
	
	@Value("#{${mapvalues}}")							//#is the Spring Expression Language 
	private Map<String, Integer> testMap;
	
	@GetMapping("/hello")
	public String sayHello() {
		return msg;
	}
	
	@GetMapping("/default")
	public String sayDefault() {
		return defaultMessage;
	}
	
	@GetMapping("/list")
	public String[] sayList() {
		return list;
	}
	
	@GetMapping("/map")
	public Map<String, Integer> sayMap() {
		return testMap;
	}
	
}
