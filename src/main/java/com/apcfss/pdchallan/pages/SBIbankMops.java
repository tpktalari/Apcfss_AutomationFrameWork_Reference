package com.apcfss.pdchallan.pages;

import org.openqa.selenium.By;

import com.apcfss.enums.WaitingStrategy;
import com.apcfss.pages.BasePage;

public class SBIbankMops extends BasePage {
	private final By sbiLogo=By.xpath("//a[contains(@href,'sbi')]");
	
	public void presenceOfSbiLogo() {
		isDisplayed(sbiLogo, WaitingStrategy.VISIBLE,"Sbi Logo");
	}
	
	
	
	public String getTitle() {
		return getPageTitle();
	}
	
	
}
