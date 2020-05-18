package com.springboot.rest.webservices.restwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringExample {
	
	//Example of dynamic filtering
	//send only field1 and field2
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		
	 SomeBean someBean = new SomeBean("value1","value2","value3");
	 
	 MappingJacksonValue mapping=new MappingJacksonValue(someBean);
	 
	 SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
	 
	FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	mapping.setFilters(filters);
	 
	 return mapping;
	}
	
	//send only field2 and field3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListSomeBean() {
		
		List<SomeBean> list= Arrays.asList(new SomeBean("value1","value2","value3"), new SomeBean("value11", "value22", "value33"));
		
		
		 
		 MappingJacksonValue mapping=new MappingJacksonValue(list);
		 
		 SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field3","field2");
		 
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);
		
		return mapping;
	}

	

}
