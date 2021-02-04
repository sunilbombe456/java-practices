package com.webwork.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.webwork.springrestdemo.entity.StudentErrorResponse;

@ControllerAdvice
public class StudentRestExceptionhandler {
	
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundExeception exc){
		// create student error response
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return response entity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	// Catch any type of exception
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}


}
