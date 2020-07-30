package com.example.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class ApiError {

	private String object;
	private String field;
	private Object rejectedValue;
	private String message;
	private HttpStatus status;
	private Throwable exception;
	public ApiError(String object, String message) {
		super();
		this.object = object;
		this.message = message;
	}
	
	
	public ApiError(HttpStatus badRequest, String error, HttpMessageNotReadableException ex) {
		this.status = badRequest;
		this.message = error;
		this.exception = ex;
	}


	public String getObject() {
		return object;
	}


	public void setObject(String object) {
		this.object = object;
	}


	public String getField() {
		return field;
	}


	public void setField(String field) {
		this.field = field;
	}


	public Object getRejectedValue() {
		return rejectedValue;
	}


	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public Throwable getException() {
		return exception;
	}


	public void setException(Throwable exception) {
		this.exception = exception;
	}

	
	
}
