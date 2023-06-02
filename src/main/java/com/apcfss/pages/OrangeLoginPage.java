package com.apcfss.pages;

import org.openqa.selenium.By;

import com.apcfss.enums.WaitingStrategy;

public final class OrangeLoginPage extends BasePage{
	private final By textboxUserName=By.xpath("//input[@name='username']");
	private final By textboxPassword=By.xpath("//input[@type='password' and @name='password']");
	private final By buttonLogin=By.xpath("//button[contains(@class,'login-button')]");
	
	
	public OrangeLoginPage enterUsername(String userName){
		sendKeys(textboxUserName,userName, WaitingStrategy.PRESENCE,"Username TextBox");
		return this;
	}
	public OrangeLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password,WaitingStrategy.PRESENCE,"Password TextBox");
		return this;
	}
	public OrangeHomePage clickLogin()
	{
		click(buttonLogin,WaitingStrategy.CLICKABLE,"Login button");
		return new OrangeHomePage();
	}

	public String getTitle()
	{
		return getPageTitle();
	}
	
}
