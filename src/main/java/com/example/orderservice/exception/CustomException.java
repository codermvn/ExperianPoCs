package com.example.orderservice.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -470180507998010368L;

	public CustomException() {
		super();
	}

	public CustomException(final String message) {
		super(message);
	}

}
