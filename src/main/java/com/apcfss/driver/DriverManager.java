package com.apcfss.driver;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager class helps to achieve thread safety for the
 * {@link org.openqa.selenium.WebDriver} instance.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see Driver
 */
public final class DriverManager {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverManager() {
	}

	public static ThreadLocal<WebDriver> drLocal = new ThreadLocal<WebDriver>();

	/**
	 * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance
	 * fetched from ThreadLocal variable.
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @return {@link org.openqa.selenium.WebDriver} instance
	 */
	public static WebDriver getDriver() {
		return drLocal.get();
	}

	/**
	 * Set the WebDriver instance to thread local variable
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to
	 *                  saved from Thread safety issues.
	 */
	public static void setDriver(WebDriver driverref) {
		drLocal.set(driverref);
	}

	/**
	 * Calling remove method on Threadlocal variable ensures to set the default
	 * value to Threadlocal variable. It is much safer than assigning null value to
	 * ThreadLocal variable.
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 */
	public static void unload() {
		drLocal.remove();
	}

}
