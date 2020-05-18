package com.springboot.rest.webservices.restwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	//METHOD_1
	@GetMapping("/v1")
	public PersonV1 personV1() {
		return new PersonV1("Vatsal Bhatnagar");
	}
	
	@GetMapping("/v2")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Vatsal", "Bhatnagar"));
	}
	
	//METHOD_2(using request parameter)
	@GetMapping(value = "/person/params", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Vatsal Bhatnagar");
	}
	
	@GetMapping(value = "/person/params", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Vatsal", "Bhatnagar"));
	}
	
	//METHOD_3(using header)
	@GetMapping(value = "/person/header", headers  = "API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Vatsal Bhatnagar");
	}
	
	@GetMapping(value = "/person/header", headers  = "API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Vatsal", "Bhatnagar"));
	}

}
