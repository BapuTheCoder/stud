package com.example.demo.StudentException;

import org.springframework.http.HttpStatus;

public class StudentException extends RuntimeException {

	private String errorMessage;
	private HttpStatus errorCode;
	
	public StudentException(String errorMessage, HttpStatus errorCode) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	
}
