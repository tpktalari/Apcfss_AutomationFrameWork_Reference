package com.apcfss.frameworkexceptions;

@SuppressWarnings("serial")
public class UnableToReadDataException extends FrameworkException {
	public UnableToReadDataException(String message) {
		super(message);
	}

	/**
	 * To customize the stack trace
	 * 
	 * @param message
	 * @param cause
	 */
	public UnableToReadDataException(String message, Throwable cause) {
		super(message, cause);
	}
}
