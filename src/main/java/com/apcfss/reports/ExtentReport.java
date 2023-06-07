package com.apcfss.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.apcfss.constants.FrameworkConstants;
import com.apcfss.enums.CategoryType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Perform initialization and termination of
 * {@link com.aventstack.extentreports.ExtentReports} After creating an instance
 * for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to
 * ThreadLocal variable for providing thread safety.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see com.apcfss.listeners.ListenerImplementation
 * @see com.apcfss.annotations.FrameworkAnnotations
 */
public final class ExtentReport {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentReport() {
	}

	private static ExtentReports reports;

	/**
	 * Set the initial configuration for the Extent Reports and decides the report
	 * generation path.
	 * 
	 * @author Pavan Kumar t 22-May-2023
	 */
	public static void initReports() {
		if (Objects.isNull(reports)) {
			reports = new ExtentReports();
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			reports.attachReporter(htmlReporter);
			try {
				htmlReporter.loadXMLConfig(FrameworkConstants.getExtentXmlConfigPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			reports.setSystemInfo("Base Browser", "Chrome");
			reports.setSystemInfo("Base Environment", "Testing");
			reports.setSystemInfo("Base URL", "https://receipts.test.nidhi.apcfss.in/pdchallan");
			reports.setSystemInfo("Base Platform", "Windows-11");
			reports.setSystemInfo("Reporter Name", "Pavan Kumar T");
		}
	}

	/**
	 * Creates a test node in the extent report. Delegates to {@link ExtentManager}
	 * for providing thread safety
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @param testcaseName Test Name that needs to be reflected in the report
	 */
	public static void createTest(String testcaseName,String description) {
		ExtentTest test = reports.createTest(testcaseName,description);
		ExtentManager.setExtentTest(test);
	}

	/**
	 * Flushing the reports ensures extent logs are reflected properly. Opens the
	 * report in the default desktop browser. Sets the ThreadLocal variable to
	 * default value
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 */
	public static void flushReports() {
		if (Objects.nonNull(reports)) {
			reports.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Logs the authors details in the authors view in the extent report. Gives an
	 * clear idea of Authors Vs Percentage success metrics
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @param authors Authors who created a particular test case
	 */
	public static void addAuthor(String[] authors) {
		for (String author : authors) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}
	}

	/**
	 * Adds the category a particular test case belongs to. Gives an clear idea of
	 * Group Vs Percentage success metrics.
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @param categories category a particular test case belongs to.
	 */
	public static void addCategory(CategoryType[] categories) {
		for (CategoryType category : categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}
	}
}
