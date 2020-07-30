package com.example.springboot.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<Object> handleAny(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSOn message";

		buildResponseError(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
		
		return super.handleHttpMessageNotReadable(ex, headers, status, request);
	}

	private ResponseEntity<ApiError> buildResponseError(ApiError apiError) {
		return new ResponseEntity<> (apiError, apiError.getStatus());
	}

}
