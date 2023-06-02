package com.apcfss.pdchallan.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.remote.strprotocol.AbstractRemoteTestRunnerClient;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;
import com.apcfss.pages.BasePage;

public class ServiceListPage extends BasePage {
	@FindBy(xpath = "//div[starts-with(text(),'Services List')]")
	private WebElement pageHeaderElement;
	@FindBy(xpath = "//div[contains(@class,'search')]/input")
	private WebElement textboxSearch;
	@FindBy(xpath = "//button[@data-service-type='service']")
	private List<WebElement> buttonsServices;
	@FindBy(xpath = "//button[contains(@class,'Close ')]")
	private WebElement buttonClose;

	public ServiceListPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public boolean checkPresenceOfServiceListPage() {
		Reporter.log(pageHeaderElement.getText(),true);
		return pageHeaderElement.isDisplayed();
		
	}

	private final By ser = By.xpath("//button[contains(@data-service-value,'5125')]");

	public TreasuryInfoPage clickOnService() {
		click(ser, WaitingStrategy.CLICKABLE, "5125 Service");
		return new TreasuryInfoPage();
	}
	
	public TreasuryInfoPage clickOnServiceByMatchingText(String listItem) {
		clickOnElementMatchingText(buttonsServices, listItem);
		return new TreasuryInfoPage();
	}


}
