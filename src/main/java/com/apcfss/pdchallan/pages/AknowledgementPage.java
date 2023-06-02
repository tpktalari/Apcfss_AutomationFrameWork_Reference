package com.apcfss.pdchallan.pages;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.apcfss.enums.WaitingStrategy;
import com.apcfss.pages.BasePage;

public class AknowledgementPage extends BasePage {
	private final By pageHeader = By.xpath("//h1[normalize-space()='Acknowledgement']");
	private final By listGroupItems = By.xpath("//div[@class='list-group-item' and text()='Pending']");

	public boolean isAknowledgementPageDisplayed() {
		boolean result;
		try {
			result=isDisplayed(pageHeader, WaitingStrategy.VISIBLE, "Aknowledgement Page");
		} catch (Exception e) {
			throw new RuntimeException("Fail-Aknowledgement Page is not dispalyed");
		}
		return result;
	}

	public AknowledgementPage isTranctionDetailsVisible() {
		try {
			isDisplayed(listGroupItems, WaitingStrategy.VISIBLE, "Transaction Details");
		} catch (Exception e) {
			throw new RuntimeException("Transaction Details Are not Displayed");
		}
		return this;
	}

}
