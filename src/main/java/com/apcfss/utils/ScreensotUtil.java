package com.apcfss.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.apcfss.driver.DriverManager;

/**
 * Utility to take base64 screenshot.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * 
 */
public final class ScreensotUtil {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ScreensotUtil() {
	}

	/**
	 * Captures screenshot of the current page, constructs a base64 string from the
	 * image and return to the caller. There is no temporary screenshot image
	 * generated here. If user needs separate screenshot image, they can construct a
	 * new method. It is advisable to use this method for many reasons.
	 * 
	 * @author Pavan Kumar T 22-05-2023
	 * @return Image in the form of Base64 String which can be appended directly to
	 *         report
	 */
	public static String getBase64() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
