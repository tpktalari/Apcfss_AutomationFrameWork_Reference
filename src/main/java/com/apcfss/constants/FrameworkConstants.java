package com.apcfss.constants;

import com.apcfss.enums.ConfigProperties;
import com.apcfss.utils.PropertyFileUtil;

/**
 * Framework Constants holds all the constant values used within the framework.
 * If some value needs to be changed or modified often, then it should be stored
 * in the property files
 * 
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see com.apcfss.utils.PropertyFileUtil
 */
public final class FrameworkConstants {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameworkConstants() {
	}

	private static final String PATHTORESOURCES = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = PATHTORESOURCES + "/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH = PATHTORESOURCES + "/config/configProperties.properties";
	private static final int EXPLICITWAIT = 20;
	private static final String EXCEL_RUNMANAGER_PATH = PATHTORESOURCES + "/excel/run_manager.xlsx";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportFilePath = "";
	private static final String EXTENT_XML_CONFIG_PATH = PATHTORESOURCES + "/config/ExtentConfig.xml";

	public static String getChromedriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}

	public static String getExcelRunmanagerPath() {
		return EXCEL_RUNMANAGER_PATH;
	}

	public static String getRunManagerSheet() {
		return RUNMANAGERSHEET;
	}

	public static String getExtentXmlConfigPath() {
		return EXTENT_XML_CONFIG_PATH;
	}

	/**
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @return Extent Report path where the index.html file will be generated.
	 */
	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReport();
		}
		return extentReportFilePath;
	}

	/**
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @return If Override reports value in the property file is no,then the time
	 *         stamp will be appended
	 */
	private static String createReport() {
		if (PropertyFileUtil.readDataFromPropertyFile(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "index.html";
		} else {
			return EXTENTREPORTFOLDERPATH + "/" + "index.html";
		}
	}
}
