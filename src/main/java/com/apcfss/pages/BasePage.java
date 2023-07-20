package com.apcfss.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.LogType;
import com.apcfss.enums.WaitingStrategy;
import com.apcfss.factories.ExplicitWaitFactory;
import com.apcfss.reports.ExtentLogger;
import com.apcfss.reports.FrameworkLogger;

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
	
	
	protected void clickOnElementMatchingText(List<WebElement> elements,String listItem) {
		for(int i=0;i<elements.size();i++) {
			if(elements.get(i).getAttribute("data-service-value").contains(listItem)) {
				elements.get(i).click();
				break;
			}
		}
		try {
			ExtentLogger.pass(listItem + " is clicked", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch from parent window to any child window or from any
	 * child window to parent window based on the partial URL.
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindowBasedOnTitle(String partialWindowTitle) {
		Set<String> windowIds = DriverManager.getDriver().getWindowHandles();
		Iterator<String> iterator = windowIds.iterator();
		while (iterator.hasNext()) {
			String windowId = iterator.next();
			String currentwindowTitle = DriverManager.getDriver().switchTo().window(windowId).getTitle();
			if (currentwindowTitle.contains(partialWindowTitle))
				break;
		}
	}

	protected void scrollTillElement(WebElement element) {
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollTillLast() {
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollActionByValue() {
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0, arguments[0])", 2000);
	}
	
	
	
	

	/*
	 * private void explicitlyWaitForElementToBeClickable(By by) { new
	 * WebDriverWait(DriverManager.getDriver(),
	 * FrameworkConstants.getExplicitWait())
	 * .until(ExpectedConditions.elementToBeClickable(by)); }
	 * 
	 * private void explicitlyWaitForElementToBePresent(By by) { new
	 * WebDriverWait(DriverManager.getDriver(),
	 * FrameworkConstants.getExplicitWait())
	 * .until(ExpectedConditions.presenceOfElementLocated(by)); }
	 */
}
