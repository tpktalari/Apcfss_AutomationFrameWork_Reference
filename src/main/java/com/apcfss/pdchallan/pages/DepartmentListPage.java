package com.apcfss.pdchallan.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;
import com.apcfss.pages.BasePage;

public class DepartmentListPage extends BasePage {
	@FindBy(xpath = "//div[starts-with(text(),'Department List')]")
	private WebElement pageHeaderElement;
	@FindBy(xpath = "//div[contains(@class,'search')]/input")
	private WebElement textboxSearch;
	@FindBy(xpath = "//button[@data-service-type='department']")
	private List<WebElement> buttonsDepartment;
	@FindBy(xpath = "//button[contains(@class,'Close ')]")
	private WebElement buttonClose;

	public DepartmentListPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public boolean checkPreseneceOfPageHeader() {
		Reporter.log(pageHeaderElement.getText(), true);
		return pageHeaderElement.isDisplayed();
	}

	private final By dept = By.xpath("//button[contains(@data-service-value,'AGAP1')]");

	public TreasuryInfoPage clickOnDepartment() {
		click(dept, WaitingStrategy.CLICKABLE, "AGAP1 Dept.");
		return new TreasuryInfoPage();
	}

	public TreasuryInfoPage clickOnDepartmentByMatchingText(String listItem) {
		clickOnElementMatchingText(buttonsDepartment, listItem);
		return new TreasuryInfoPage();
	}

	public List<WebElement> getButtonsDepartment() {
		return buttonsDepartment;
	}
	
	
	
}
