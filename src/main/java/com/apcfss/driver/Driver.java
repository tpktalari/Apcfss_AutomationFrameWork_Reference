package com.apcfss.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.apcfss.constants.FrameworkConstants;
import com.apcfss.enums.ConfigProperties;
import com.apcfss.factories.DriverFactory;
import com.apcfss.frameworkexceptions.BrowserInvocationFailedException;
import com.apcfss.utils.PropertyFileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Pavan Kumar T
 *
 */
public final class Driver {
	private Driver() {
	}

	// @Parameters("browser")
	public static void initDriver(/*String browser*/) {
		if (Objects.isNull(DriverManager.getDriver()))// driver == null
		{
			try {
				DriverManager.setDriver(DriverFactory.getDriver(/*browser)*/));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Please check capabilites of browser");
			}
			DriverManager.getDriver().get(PropertyFileUtil.readDataFromPropertyFile(ConfigProperties.URL));
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	/**
	 * Terminates the browser instance. Sets the threadlocal to default value, i.e
	 * null.
	 * 
	 * @author Pavan Kumar T, 22-May-2023
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver()))// driver!=null
		{
			DriverManager.getDriver().quit();
			DriverManager.unload(); // getDriver() = null;
		}
	}
}
