package com.apcfss.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.apcfss.constants.FrameworkConstants;
import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;

/**
 * Explicit wait factory produces different waits before operating on webelement
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 */
public final class ExplicitWaitFactory {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExplicitWaitFactory() {
	}
	
	/**
	 * 
	 * @author Pavan Kumar T 22-May-2023
	 * @param waitStrategy Strategy to be applied to find a web element
	 * {@link com.apcfss.enums.WaitingStrategy}
	 * @param by By locator of the webelement
	 * @return web element Locates and return the web element
	 */
	public static WebElement performExplicitWait(WaitingStrategy waitStrategy, By by) {
		WebElement element = null;
		if (waitStrategy == WaitingStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitStrategy == WaitingStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitStrategy == WaitingStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if (waitStrategy == WaitingStrategy.NONE) {
			element=DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
