package com.springboot.rest.webservices.restwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.rest.webservices.restwebservices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		
	}
	
	//if invalid user is entered.
	//above method is for every other error other than this.
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(),"User not found!");
		
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
		
		
		
	}
	
	

}
