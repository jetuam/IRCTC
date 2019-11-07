package com.irctc.SearchEngine.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = TrainNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleException(TrainNotFoundException exception, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), LocalDate.now(),
				request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = FoodNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleException(FoodNotFoundException exception, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), LocalDate.now(),
				request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
