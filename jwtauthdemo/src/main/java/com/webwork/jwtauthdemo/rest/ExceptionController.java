package com.webwork.jwtauthdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.webwork.jwtauthdemo.entity.ResponseError;
import com.webwork.jwtauthdemo.exception.BusinessException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public ResponseEntity<ResponseError> handleException(BusinessException exc) {

		ResponseError error = new ResponseError();

		error.setStatus(HttpStatus.NOT_FOUND.value());

		error.setMessage(exc.getMessage());

		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<ResponseError> handleException(Exception exc) {

		ResponseError error = new ResponseError();

		error.setStatus(HttpStatus.NOT_FOUND.value());

		error.setMessage(exc.getMessage());

		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

}
