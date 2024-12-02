package com.apcfss.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.apcfss.enums.ConfigProperties;
import com.apcfss.utils.PropertyFileUtil;



public final class DriverFactory {
	private DriverFactory() {
	}
	public static WebDriver getDriver(/*String browser*/) throws MalformedURLException {
		WebDriver driver = null;
		String runmode = PropertyFileUtil.readDataFromPropertyFile(ConfigProperties.RUNMODE);
		String browser=PropertyFileUtil.readDataFromPropertyFile(ConfigProperties.BROWSER);
		if (browser.equalsIgnoreCase("chrome")) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("chrome");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			} else {
				driver = new ChromeDriver();
			}

		} else if (browser.equalsIgnoreCase("edge")) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("edge");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			} else {
				driver = new EdgeDriver();
			}
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("edge");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			} else {
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}
