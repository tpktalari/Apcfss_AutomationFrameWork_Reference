package com.apcfss.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.apcfss.driver.Driver;

public class BaseTest {

	
	protected BaseTest() {
	}
	/*@Parameters("browser")*/
	@BeforeMethod
	protected void setUp(/*Object[] data/*String browser*/){
//		@SuppressWarnings("unchecked")
//		Map<String, String> map=(Map<String, String>)data[0];
		Driver.initDriver(/*map.get("browser")*/);
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}
