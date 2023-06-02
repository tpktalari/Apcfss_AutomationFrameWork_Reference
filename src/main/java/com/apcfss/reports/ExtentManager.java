package com.apcfss.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class helps to achieve thread safety for the
 * {@link com.aventstack.extentreports.ExtentTest} instance.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see {@link com.apcfss.driver.Driver}
 */
public class ExtentManager {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest}
	 * instance fetched from ThreadLocal variable.
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread
	 * local variable
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.
	 *           
	 */
	static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	/**
	 * Calling remove method on Threadlocal variable ensures to set the default
	 * value to Threadlocal variable. It is much safer than assigning null value to
	 * ThreadLocal variable.
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 */
	static void unload() {
		extentTest.remove();
	}
}
