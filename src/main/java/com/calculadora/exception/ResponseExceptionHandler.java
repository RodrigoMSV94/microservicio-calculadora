package com.calculadora.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.calculadora.log.Logger;

@RestControllerAdvice
public class ResponseExceptionHandler{
	
	@Autowired
	private Logger logger;
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception ex, WebRequest request){
		logger.log("Exception.class");
		ExceptionResponse er = new ExceptionResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				LocalDateTime.now(), 
				ex.getMessage() != null?ex.getMessage():"Error en servidor", 
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public final ResponseEntity<ExceptionResponse> manejarMessageNotReadableExceptio(HttpMessageNotReadableException ex, WebRequest request) {
		logger.log("HttpMessageNotReadableException.class");
		ExceptionResponse er = new ExceptionResponse(
				HttpStatus.BAD_REQUEST.value(), 
				LocalDateTime.now(), 
				"Solicitud JSON con formato incorrecto", 
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_REQUEST);
	}
	

	
	
}
