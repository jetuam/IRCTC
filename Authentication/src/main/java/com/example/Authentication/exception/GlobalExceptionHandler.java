package com.example.Authentication.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = UserIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleException(UserIdNotFoundException exception, WebRequest request) {
		ErrorMessage errormsg = new ErrorMessage(LocalDate.now(), request.getDescription(false),
				exception.getMessage());
		return new ResponseEntity<ErrorMessage>(errormsg, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = InSufficientBalanceException.class)
	public ResponseEntity<ErrorMessage> balanceException(InSufficientBalanceException exception, WebRequest request) {

		ErrorMessage msg = new ErrorMessage(LocalDate.now(), request.getDescription(false), exception.getMessage());
		return new ResponseEntity<ErrorMessage>(msg, HttpStatus.NOT_FOUND);

	}
}
