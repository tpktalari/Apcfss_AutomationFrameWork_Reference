package com.apcfss.pdchallan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;
import com.apcfss.pages.BasePage;

public class PaymentModePage extends BasePage {

	private final By paymentModeElement = By.xpath("//div[text()='Payment Mode']");
	private final By cancelButton = By.xpath("//button[.='Cancel ']");
	private final By sbiLogo = By.xpath("//img[@alt='SBI']");
	private final By payuLogo = By.xpath("//img[@alt='PAYU']");
	private final By errorMessageElement = By.xpath("//div[@id='swal2-html-container']");
	
	@FindBy(xpath = "//div[contains(@class,'2-error')]")private WebElement errorLogo;

	public PaymentModePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public SBIbankMops clickOnSbi() {
		click(sbiLogo, WaitingStrategy.CLICKABLE, "SBI Logo");
		return new SBIbankMops();
	}

	public void clickOnPayU() {
		click(payuLogo, WaitingStrategy.CLICKABLE, "PAYU Logo");
	}

	public void clickOnCancelButton() {
		click(cancelButton, WaitingStrategy.CLICKABLE, "Cancel Button");
	}

	public boolean checkPresenceOfapymentMode() {
		return DriverManager.getDriver().findElement(paymentModeElement).isDisplayed();
	}

	public void switchToSBIMopsPage() {
		switchToWindowBasedOnTitle("SBI");
	}

	public WebElement getErrorLogo() {
		return errorLogo;
	}
	
	

	

}
