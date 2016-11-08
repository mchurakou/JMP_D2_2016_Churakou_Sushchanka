package org.training.issueTracker.service.exceptions;

public class InputException extends Exception {
	

	private static final long serialVersionUID = 1L;

	public InputException() {
		
	}
	
	public InputException(String message) {
		super(message);
	}
	
	public InputException(Throwable cause) {
		super(cause);
	}
	
	public InputException(String message, Throwable cause) {
		super(message, cause);
	}

}
