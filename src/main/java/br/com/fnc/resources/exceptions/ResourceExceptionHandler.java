package br.com.fnc.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fnc.services.exceptions.DataIntegrityViolationException;
import br.com.fnc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		//Menssagem de erro
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	//metodo para manipular esxessão delete
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		//Menssagem de erro
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}