package com.apcfss.utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

	@DataProvider(parallel=true)
	public static Object[][] getDataKeyValue() {
		return ExcelUtil.getTestDetailsForDataProvider("DATA");
	}
}
