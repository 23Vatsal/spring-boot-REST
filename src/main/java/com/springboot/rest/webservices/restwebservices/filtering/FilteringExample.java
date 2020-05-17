package com.springboot.rest.webservices.restwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringExample {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		
		return new SomeBean("value1","value2","value3");
	}

}
