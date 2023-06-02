package com.apcfss.utils;
/**
 * Constructs a dynamic xpath at run time.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 */
public final class DynamicXpathUtils {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DynamicXpathUtils() {}
	/**
	 * Receives a wildcard string, replace the wildcard with the value and return to the caller
	 * @author Pavan Kumar T
	 * 22-05-2023
	 * @param xpath Xpath with wildcard string
	 * @param value value to be replaced in place of wildcard
	 * @return dynamic xpath string
	 * 
	 */
	public static String getXpath(String xpath,String value) {
		//return xpath.replace("%replaceable%", value);
		return String.format(xpath, value);
	}
	
	/**
	 * Receives a wildcard string, replace the wildcard with the value and return to the caller
	 * @author Pavan Kumar T
	 * 22-05-2023
	 * @param xpath Xpath with wildcard string
	 * @param value1 value to be replaced in place of wildcard
	 * @param value2 value to be replaced in place of wildcard
	 * @return dynamic xpath string
	 */
	public static String getXpath(String xpath, String value1, String value2) {
		return String.format(xpath, value1,value2);
	}
}
