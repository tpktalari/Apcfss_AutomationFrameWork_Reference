package com.apcfss.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;
import com.apcfss.utils.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {

	@FindBy(xpath = "//div[text()='Mobiles, Computers']/parent::a")
	private WebElement linkMobileAndComputers;
	
	@FindBy(xpath = "//a[text()='Laptops']")
	private WebElement linkLaptops;
	@FindBy(xpath = "//a[text()='Drivers & Storage']")
	private WebElement linkDriversAndStorage;
	@FindBy(xpath = "//a[text()='Printers & Ink']")
	private WebElement linkPrintersAndInk;
	
	//private String linkSubMenu="//a[text()='%replaceable%']";
	private String linkSubMenu="//a[text()='%s']";
	
	public AmazonLaptopPage clickOnSubMenuItem(String menutext) {
		String newpath=DynamicXpathUtils.getXpath(linkSubMenu, menutext);
		click(By.xpath(newpath),WaitingStrategy.CLICKABLE, menutext);
		if(menutext.contains("Laptops"))
		{
			return new AmazonLaptopPage();
		}
		return null;
	}

	public AmazonHamburgerMenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	
	
	
	
	
	
	
	
	
	

	public AmazonHamburgerMenuPage clickMobileAndComputers() {
		linkMobileAndComputers.click();
		return this;
	}

	public AmazonLaptopPage clickLaptops() {
		linkLaptops.click();
		return new AmazonLaptopPage();
	}

	public AmazonPrinterAndInkPage clickPrintersAndInk() {
		linkPrintersAndInk.click();
		return new AmazonPrinterAndInkPage();
	}

}
