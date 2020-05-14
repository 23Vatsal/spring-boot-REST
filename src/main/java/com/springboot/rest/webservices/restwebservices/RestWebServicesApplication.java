package com.springboot.rest.webservices.restwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebServicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		
		//change done to remove locale from argument in controller class
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
	}
	
	//to read the properties file
	@Bean
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		
		//because name of properties file is messsages*.properties
		messageSource.setBasename("message");
		
		return messageSource;
		
		
		
	}

}
