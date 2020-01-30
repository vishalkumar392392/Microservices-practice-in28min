package com.restApi.course.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.restApi.course.exception.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	@ExceptionHandler(value= UserNotFoundException.class)
	 public ResponseEntity<Object> exception(UserNotFoundException exception) {
	      return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value=DeletionException.class)
	public ResponseEntity<?> deleteException(DeletionException ex, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(
				new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	**/
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= UserNotFoundException.class)
	 public ResponseEntity<Object> exception(UserNotFoundException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
	      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	   }

}
