package com.apcfss.pdchallan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;
import com.apcfss.pages.BasePage;
import com.apcfss.reports.ExtentLogger;
import com.github.javafaker.Faker;

public class RemitterDetailsPage extends BasePage {

	@FindBy(xpath = "//span[text()='2. Remitter Details']")
	private WebElement elementRemitterDetails;

	public RemitterDetailsPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	private final By textboxRemitterId = By.name("remitterID");
	private final By textboxRemitterName = By.name("remitterName");
	private final By textareaFieldRemitterAdress = By.name("remitterAddress");
	private final By textareaFieldRemitterPurpose = By.id("purposeId");
	private final By textareaFieldRemitterMobileNo = By.id("mobNo");
	private final By textareaFieldRemitterEmail = By.id("emailcheck");
	private final By textareaFieldRemitterAmount = By.id("amountinRs");
	private final By radioButtonManualPayment = By.xpath("//input[@id='manualpayment']");
	private final By radioButtonRtgsNeftPayment = By.xpath("//input[@id='rtgsneftpayment']");
	private final By radioButtonEpayment = By.xpath("//input[@id='epayment']");
	private final By buttonPrevious = By.xpath("//button[normalize-space()='Previous']");
	private final By buttonSubmit = By.xpath("//button[text()='Submit']");
	private final By errorMessageElement=By.xpath("//div[@id='swal2-html-container']");

	Faker faker = new Faker();

	public RemitterDetailsPage enterDetails() {
		sendKeys(textboxRemitterId, faker.number().digits(12), WaitingStrategy.NONE, "Remiiter Id TextBox");
		sendKeys(textboxRemitterName, "APCFSS", WaitingStrategy.NONE, "Remitter Name TextBox");
		sendKeys(textareaFieldRemitterAdress, faker.address().fullAddress(), WaitingStrategy.NONE,
				"Remitter Adress TextField");
		sendKeys(textareaFieldRemitterPurpose, faker.name().title(), WaitingStrategy.NONE,
				"Remitter Purpose TextField");
		sendKeys(textareaFieldRemitterMobileNo, "9247100100", WaitingStrategy.NONE, "Mobile Number TextBox");
		sendKeys(textareaFieldRemitterEmail, faker.internet().emailAddress(), WaitingStrategy.NONE, "Email TextBox");
		sendKeys(textareaFieldRemitterAmount, faker.number().digits(4), WaitingStrategy.NONE, "Amount TextBox");
		return this;
	}

	public RemitterDetailsPage selectmanualPaymentMode() {
		click(radioButtonManualPayment, WaitingStrategy.CLICKABLE, "Manual Payment Mode Radio button");
		return this;
	}

	public RemitterDetailsPage selectRtgsOrNeftPaymentMode() {
		click(radioButtonRtgsNeftPayment, WaitingStrategy.CLICKABLE, "RTGS/NEFT Payment Mode Radio button");
		return this;
	}

	public RemitterDetailsPage selectEpaymentMode() {
		click(radioButtonEpayment, WaitingStrategy.CLICKABLE, "E Payment Mode Radio button");
		return this;
	}

	public TreasuryInfoPage clickOnPreviousButton() {
		click(buttonPrevious, WaitingStrategy.CLICKABLE, "Previous Button");
		return new TreasuryInfoPage();
	}

	public PaymentModePage clickOnSubmitButtonWithEpaymetnMode() {
		click(buttonSubmit, WaitingStrategy.CLICKABLE, "Submit Button");
		return new PaymentModePage();
	}
	
	public void clickOnSubmitButtonWithRtgsPaymetnMode() {
		click(buttonSubmit, WaitingStrategy.CLICKABLE, "Submit Button");
	}
	
	public AknowledgementPage clickOnSubmitButtonWithManualPaymentMode() {
		click(buttonSubmit, WaitingStrategy.CLICKABLE, "Submit Button");
		return new AknowledgementPage();
	}

	public RemitterDetailsPage scrollBy() {
		scrollActionByValue();
		return this;
	}

	public String getColorOfRemitterDetailsElement() {
		return elementRemitterDetails.getCssValue("color");
	}

	public void isErrorMessageDisplayed() {
		try {
			isDisplayed(errorMessageElement, WaitingStrategy.VISIBLE, "Something Went Wrong Error Message");
		} catch (Exception e) {
			//Reporter.log("Error Message is not Displayed till waiting time",true);
			//throw new RuntimeException("Waited 20 Secend");
		}
	}
}
