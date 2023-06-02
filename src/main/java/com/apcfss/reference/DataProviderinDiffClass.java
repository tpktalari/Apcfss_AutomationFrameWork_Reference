package com.apcfss.reference;

import org.testng.annotations.DataProvider;

public class DataProviderinDiffClass {
	
	@DataProvider
	public static String[][] getData()
	{
		String[][] a= {{"pavan"},{"kumar"},{"abc"}};
		return a;
	}

}
