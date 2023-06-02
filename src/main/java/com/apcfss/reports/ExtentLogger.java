package com.apcfss.reports;

import com.apcfss.enums.ConfigProperties;
import com.apcfss.utils.PropertyFileUtil;
import com.apcfss.utils.ScreensotUtil;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {
	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) {
		if (PropertyFileUtil.readDataFromPropertyFile(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreensotUtil.getBase64()).build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) {
		if (PropertyFileUtil.readDataFromPropertyFile(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreensotUtil.getBase64()).build());
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) {
		if (PropertyFileUtil.readDataFromPropertyFile(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreensotUtil.getBase64()).build());
		} else {
			skip(message);
		}
	}
}
