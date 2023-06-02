package com.apcfss.reference;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {
//	@Test(dataProvider="getData")
//	public void test1(String username,String password,String firstname,String lastname) {
//		System.out.println(firstname);
//	}
//	@DataProvider
//	public Object[][] getData1() throws IOException
//	{
//		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/excel/testDataTmb.xlsx");
//		XSSFWorkbook workbook=new XSSFWorkbook(fis);
//		XSSFSheet sheet=workbook.getSheet("testing");
//		
//		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		for(int i=1;i<=sheet.getLastRowNum();i++)
//		{
//			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
//			{
//				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
//			}
//		}
//		return data;
//	}
	
	
	
	//To get Rid of using more number of parameters in test2(?) we can use this way 
	@Test(dataProvider="getData2")
	public void test2(Map<String, String> map,Map<String, String> map1,Map<String, String> map2,Map<String, String> map3) {
		System.out.println(map.get("firstname"));
		System.out.println(map.get("lastname"));
//		System.out.println(map.get("username"));
//		System.out.println(map.get("password"));
		
	}
	
	@DataProvider
	public Object[][] getData2() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/excel/testDataTmb.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("testing");
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		Map<String, String> map;
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			map=new HashMap<String, String>();
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				String key=sheet.getRow(0).getCell(j).getStringCellValue();
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i-1][j]=map;
			}
		}
		return data;
	}
}
	
