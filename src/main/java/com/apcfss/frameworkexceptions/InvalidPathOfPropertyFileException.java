package com.apcfss.frameworkexceptions;

/**
 * Runtime Exception occurs when the path given for excel sheet is incorrect.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see com.apcfss.constants.FrameworkConstants
 */
@SuppressWarnings("serial")
public class InvalidPathOfPropertyFileException extends FrameworkException {
	/**
	 * Pass the message that needs to be appended to the stack trace
	 * 
	 * @param message Details about the exception or custom message
	 */
	public InvalidPathOfPropertyFileException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause   Pass the enriched stack trace or customized stack trace
	 */
	public InvalidPathOfPropertyFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
