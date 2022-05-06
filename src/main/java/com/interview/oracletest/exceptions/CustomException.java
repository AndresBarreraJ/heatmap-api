package com.interview.oracletest.exceptions;

public class CustomException {
	String message;

	public CustomException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
