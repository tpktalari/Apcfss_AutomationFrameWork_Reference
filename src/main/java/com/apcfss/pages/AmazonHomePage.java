package com.apcfss.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apcfss.driver.DriverManager;

public final class AmazonHomePage {

	@FindBy(id = "nav-hamburger-menu")
	private WebElement linkHamBurger;

	public AmazonHomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public AmazonHamburgerMenuPage clickHamburgerBtn() {
		linkHamBurger.click();
		return new AmazonHamburgerMenuPage();
	}

}
