package com.apcfss.frameworkexceptions;

/**
 * Runtime Exception occurs when the key or value fetched from the property file
 * is null
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see com.apcfss.constants.FrameworkConstants
 * @see com.apcfss.utils.PropertyFileUtil
 */
@SuppressWarnings("serial")
public class PropertyFileUsageException extends FrameworkException {
	/**
	 * Pass the message that needs to be appended to the stack trace
	 * 
	 * @param message Details about the exception or custom message
	 */
	public PropertyFileUsageException(String message) {
		super(message);
	}

	/**
	 * @param message Details about the exception or custom message
	 * @param cause   Pass the enriched stack trace or customized stack trace
	 */
	public PropertyFileUsageException(String message, Throwable cause) {
		super(message, cause);
	}
}
