package com.apcfss.classIV.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;

public class NidhiLoginPage extends BasePage {

	
	@FindBy (id = "username")
	private WebElement usernameInputElement;
	
	@FindBy (id = "password")
	private WebElement passwordInputElement;
	
	@FindBy(id = "kc-login")
	private WebElement loginButtonElement;
	
	public NidhiLoginPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	private final By textboxUsername=By.id("username");
	private final By textboxPassword=By.id("password");
	private final By loginButton=By.id("kc-login");
	
	
	public void login() {
		sendKeys(textboxUsername, "14165719", WaitingStrategy.NONE, "Username Input Field");
		sendKeys(textboxPassword, "Civ@1234", WaitingStrategy.NONE, "Password Input Field");
		click(loginButton, WaitingStrategy.CLICKABLE, "Login Button");
	}
	
	public NidhiLoginPage enterUsername(String username) {
		sendKeys(textboxUsername, username, WaitingStrategy.PRESENCE, "Username Input Field");
		return this;
	}
	
	public NidhiLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password, WaitingStrategy.PRESENCE, "Password Input Field");
		return this;		
	}
	
	public NidhiHomePage clickLogin() {
		click(loginButton, WaitingStrategy.CLICKABLE, "Login Button");
		return new NidhiHomePage();
	}
}
