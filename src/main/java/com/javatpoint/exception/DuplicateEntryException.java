package com.javatpoint.exception;

public class DuplicateEntryException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public DuplicateEntryException() {
		super();
	}

	public DuplicateEntryException(final String message) {
		super(message);
	}

}