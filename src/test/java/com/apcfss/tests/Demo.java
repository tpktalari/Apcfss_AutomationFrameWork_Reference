package com.apcfss.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.apcfss.constants.FrameworkConstants;
import com.apcfss.utils.ExcelUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo {
	@Test
	public void attachLogoTest() throws IOException
	{
		ExtentReports extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
		try {
			spark.loadXMLConfig(FrameworkConstants.getExtentXmlConfigPath());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		extent.attachReporter(spark);
		
		ExtentTest test=extent.createTest("First Test");
		test.pass("started");
		test.pass("passed");
		extent.flush();
		
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ExcelUtil.getTestDetailsForDataProvider("RUNMANAGER")[0]));
		System.out.println(Arrays.toString(ExcelUtil.getTestDetailsForDataProvider("RUNMANAGER")[1]));
	}
}
