package com.springboot.rest.webservices.restwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping("/v1")
	public PersonV1 personV1() {
		return new PersonV1("Vatsal Bhatnagar");
	}
	
	@GetMapping("/v2")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Vatsal", "Bhatnagar"));
	}
	

}
