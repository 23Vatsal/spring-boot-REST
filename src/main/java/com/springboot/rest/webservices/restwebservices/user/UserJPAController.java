package com.springboot.rest.webservices.restwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserJPAController {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getOneUser(@PathVariable int id) {
		User user= userDaoService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id=> "+id);
		}
	    
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user= userDaoService.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id=> "+id);
		}

	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=userDaoService.save(user);
		
		//show that user is created.
		//return http response code also
		URI location=ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
