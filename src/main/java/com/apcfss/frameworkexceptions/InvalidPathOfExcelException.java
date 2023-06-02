package com.apcfss.frameworkexceptions;

/**
 * Runtime Exception occurs when the path given for any of the files is
 * incorrect.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see com.apcfms.exceptions.InvalidPathOfExcelException
 * @see com.apcfss.frameworkexceptions.InvalidPathOfPropertyFileException
 */
@SuppressWarnings("serial")
public class InvalidPathOfExcelException extends FrameworkException {
	/**
	 * Pass the message that needs to be appended to the stack trace
	 * 
	 * @param message Details about the exception or custom message
	 */
	public InvalidPathOfExcelException(String message) {
		super(message);
	}

	/**
	 * @param message Details about the exception or custom message
	 * @param cause   Pass the enriched stack trace or customized stack trace
	 */
	public InvalidPathOfExcelException(String message, Throwable cause) {
		super(message, cause);
	}
}
