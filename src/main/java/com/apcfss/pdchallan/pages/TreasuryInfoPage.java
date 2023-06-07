package com.apcfss.pdchallan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;
import com.apcfss.pages.BasePage;

public final class TreasuryInfoPage extends BasePage {
	
	@FindBy(xpath = "//span[text()='1. Treasury Info.']")
	private WebElement elementTreasuryInfo;
	
	@FindBy(xpath = "//div[@class='fp-container']")
	private WebElement fpContainer;

	public TreasuryInfoPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	private final By logoGoap = By.xpath("//img[contains(@src,'herb')]");
	private final By textBoxDepartment = By.xpath("//input[@id='department']");
	private final By textBoxService = By.id("service");
	private final By buttonProceed = By.xpath("//button[text()='Proceed']");

	public DepartmentListPage clickOnDepartmentTextBox() {
		click(textBoxDepartment, WaitingStrategy.CLICKABLE, "Department TextBox");
		return new DepartmentListPage();
	}

	public ServiceListPage clickOnServiceTextBox() {
		click(textBoxService, WaitingStrategy.CLICKABLE, "Service TextBox");
		return new ServiceListPage();
	}

	public RemitterDetailsPage clickOnProceedButton() {
		click(buttonProceed, WaitingStrategy.CLICKABLE, "Proceed Button");
		return new RemitterDetailsPage();
	}

	public WebElement getLogoGoap() {
		return DriverManager.getDriver().findElement(logoGoap);
	}

	public String getTitle() {
		return getPageTitle();
	}
	
	public String getColorOfTreasuryInfo()
	{
		return elementTreasuryInfo.getCssValue("color");
	}

	public WebElement getFpContainer()
	{
		return fpContainer;
	}

}
