package com.apcfss.pages;

import org.openqa.selenium.By;

import com.apcfss.enums.WaitingStrategy;
import com.apcfss.reports.ExtentLogger;
import com.apcfss.reports.ExtentManager;
import com.apcfss.reports.ExtentReport;
import com.aventstack.extentreports.Status;

//Assertion should not be called in PageLayers
public final class OrangeHomePage extends BasePage{
	private final By dropdownUser = By.xpath("//i[contains(@class,'userdropdown-icon')]");
	private final By linkLogout = By.xpath("//a[contains(@href,'logout')]");

	public OrangeHomePage clickUserDD() {
		click(dropdownUser,WaitingStrategy.CLICKABLE,"User Dropdown");
		return this;
	}

	public OrangeLoginPage clickLogout()  {
		click(linkLogout, WaitingStrategy.CLICKABLE,"Logout Button");
		return new OrangeLoginPage();
	}

}
