package com.springboot.rest.webservices.restwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class UserDaoService {
	
	private static List<User> list=new ArrayList<>();
	
	private static int userCount=3;
	
	static {
		list.add(new User(1,"Vatsal",new Date()));
		list.add(new User(2,"Vasu",new Date()));
		list.add(new User(3,"Tarun",new Date()));
	}
	//methods on the list
	public List<User> findAll(){
		return list;
	}
	
	//for creating a new user
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		
		list.add(user);
		return user;
		
	}
	
	public User findOne(int id) {
		for (User user : list) {
			if(user.getId()==id) {
				return user;
			}
			
		}
		return null;
	}

}
