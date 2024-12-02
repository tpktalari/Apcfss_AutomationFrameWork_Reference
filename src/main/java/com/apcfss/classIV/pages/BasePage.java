package com.apcfss.classIV.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;
import com.apcfss.factories.ExplicitWaitFactory;
import com.apcfss.reports.ExtentLogger;

public class BasePage {
	
	protected void click(By by, WaitingStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();
		try {
			ExtentLogger.pass(elementName + " is clicked", true);
			
			//FrameworkLogger.log(LogType.EXTENTANDCONSOLE, elementName + " is clicked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void sendKeys(By by, String value, WaitingStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value + " is entered successfully in " + elementName, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected boolean isDisplayed(By by, WaitingStrategy waitingStrategy, String elelemtName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitingStrategy, by);
		boolean result = element.isDisplayed();
		try {
			if (result) {
				ExtentLogger.pass(elelemtName + " Displayed ", true);
			} else {
				ExtentLogger.fail(elelemtName + " Not Displayed ", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	protected String getElementText(By by, WaitingStrategy waitStrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		return element.getText();
		}

	protected void clearDataInField(By by, WaitingStrategy waitStrategy, String elementName ) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.clear();
		try {
			ExtentLogger.pass(element.getText() + " is cleared successfully in " + elementName, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
