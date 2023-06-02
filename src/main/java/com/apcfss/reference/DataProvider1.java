package com.apcfss.reference;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	@Test(dataProvider = "getData"/*,dataProviderClass = DataProviderinDiffClass.class*/)
	public void test1(String userName)
	{
		System.out.println("enter un");
		System.out.println("enter pwd");
		System.out.println("click login");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] a= {{"pavan"},{"kumar"},{"abc"}};
		return a;
	}
	
	@DataProvider
	public String[] getData1d()
	{
		String[] s= {"pavan","kumar","abc"};
		return s;
	}
	
	//1st[]-> indicates how many times you want to run(no.of iterations)
	//2nd[]->indicates how many parameters we want to feed to test method.

}
