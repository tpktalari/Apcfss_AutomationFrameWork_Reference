package com.apcfss.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.apcfss.annotations.FrameworkAnnotations;
import com.apcfss.reports.ExtentLogger;
import com.apcfss.reports.ExtentReport;

/**
 * Implements {@link org.testng.ITestListener} and
 * {@link org.testng.ISuiteListener} to leverage the abstract methods Mostly
 * used to help in extent report generation
 * 
 * <pre>
 * Please make sure to add the listener details in the testng.xml file
 * </pre>
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 */
public class ListenerImplementation implements ITestListener, ISuiteListener {
	/**
	 * Initialize the reports with the file name
	 * 
	 * @see com.apcfss.reports.ExtentReport
	 */
	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	/**
	 * Terminate the reports
	 * 
	 * @see com.apcfss.reports.ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
	}

	/**
	 * Starts a test node for each testng test
	 * 
	 * @see com.apcfss.reports.ExtentReport
	 * @see com.apcfss.annotations.FrameworkAnnotations
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthor(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotations.class).author());
		ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotations.class).category());
		/**
		 * result.getMethod().getConstructorOrMethod().getMethod()
		 * .getAnnotation(FrameworkAnnotations.class)---> same like Method
		 * m(lang.reflection)
		 */
	}

	/**
	 * Marks the test as pass and logs it in the report need to do
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed");
	}

	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report
	 * 
	 * @see need to do
	 * @see com.apcfms.utils.ScreenshotUtil
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Marks the test as skip and logs it in the report
	 * 
	 * @see need to do
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/**
		 * NA
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/**
		 * NA
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/**
		 * NA
		 */
	}

}
