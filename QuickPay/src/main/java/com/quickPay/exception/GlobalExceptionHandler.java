package com.quickPay.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorHandle> globalException( Exception exception , WebRequest  wr ){
		
		ErrorHandle eh = new ErrorHandle(LocalDateTime.now() , exception.getMessage() , wr.getDescription(false));
		
		return new ResponseEntity<ErrorHandle>( eh , HttpStatus.BAD_REQUEST ) ;
		
	}
	
	
	
	// Customer exception 
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorHandle> customerException( CustomerException exception , WebRequest  wr ){
		
		ErrorHandle eh = new ErrorHandle(LocalDateTime.now() , exception.getMessage() , wr.getDescription(false));
		
		return new ResponseEntity<ErrorHandle>( eh , HttpStatus.BAD_REQUEST ) ;
		
	}
	
	// Customer exception 
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorHandle> loginException( LoginException exception , WebRequest  wr ){
		
		ErrorHandle eh = new ErrorHandle(LocalDateTime.now() , exception.getMessage() , wr.getDescription(false));
		
		return new ResponseEntity<ErrorHandle>( eh , HttpStatus.BAD_REQUEST ) ;
		
	}
	
	
	
}
