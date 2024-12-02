package com.apcfss.classIV.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;

public class NidhiUpdateOpeningBalancesPage extends BasePage{

	
	private By updateOpeningbalancesTab = By.xpath("//li[text()='Update Opening Balances ']");
	private By hrmsIDinputField = By.xpath("//label[text()=' HRMS ID ']/..//input");
	private By submitButton = By.xpath("//button[text()='Submit']");
	
	private By okButton = By.xpath("//button[text()='Ok']");
	
	
	private By employeeName = By.xpath("//b[text()='Name']/../..//div[@class='emptyspace3']");
	private By gpfAccountNumber = By.xpath("//b[text()='Account Number']/../..//div[@class='emptyspace3']");
	private By hrmsId = By.xpath("//b[text()='HRMS ID']/../..//div[@class='emptyspace3']");
	private By forwardButton = By.xpath("//button[text()=' Forward']");
	private By remarksTextField = By.xpath("//textarea[@name='Updateremarks']");
	private By uploadFileInputField = By.xpath("//input[@id='file']");
	private By errorMessageDistrict = By.xpath("//div[text()='Employee doesnot belong to the district']");
	private By errorMessageNotCIV = By.xpath("//div[text()='Employee doesnot belong to the CIV GPF Category']");
	
	
	
	@FindBy (xpath = "//div[text()='Employee doesnot belong to the district']")
	private WebElement userMessagElement;
	
	//private By userMessage = By.xpath("//div[text()='Employee doesnot belong to the district']");
	public WebElement getUserMessage() {
		return userMessagElement;
	}
	
	@FindBy (xpath = "//label[text()=' HRMS ID ']/..//input")
	private WebElement hrmsIdElement;
	
	public WebElement gethrmsidElement(){
		return  hrmsIdElement;
	}


	


	public NidhiUpdateOpeningBalancesPage() {
		PageFactory.initElements(DriverManager.getDriver(),this);
	}
	
	
	public NidhiUpdateOpeningBalancesPage clickUOBTab() {
		click(updateOpeningbalancesTab, WaitingStrategy.CLICKABLE, "Update Opening Balances Button Tile");
		return this;
	}
	
	public NidhiUpdateOpeningBalancesPage enterHrmsId(String hrmsID) {
		sendKeys(hrmsIDinputField,hrmsID,WaitingStrategy.PRESENCE, "Hrms ID input Field");
		return this;
	}
	
	public NidhiUpdateOpeningBalancesPage clickSubmitButton() {
		click(submitButton, WaitingStrategy.CLICKABLE, "Submit Button");
		return this;
	}
	
	
	public String captureEmployeeData() {
		//getElementText(hrmsId, WaitingStrategy.PRESENCE);
		return getElementText(employeeName, WaitingStrategy.PRESENCE);
		//getElementText(gpfAccountNumber, WaitingStrategy.PRESENCE);
	}
	
	public NidhiUpdateOpeningBalancesPage uploadFile(String filePath) {
		sendKeys(uploadFileInputField, "filePath", WaitingStrategy.PRESENCE, "Upload File Input Field");
		return this;
	}
	
	public NidhiUpdateOpeningBalancesPage enterRemarks(String remarks) {
		sendKeys(remarksTextField, remarks, WaitingStrategy.PRESENCE, "Remarks Text Field");
		return this;
	}
	
	
	public NidhiUpdateOpeningBalancesPage clickforwardButton() {
		click(forwardButton, WaitingStrategy.CLICKABLE, "forwardButton");
		return this;
	}
	
	
	public NidhiUpdateOpeningBalancesPage clickOkButton() {
		click(okButton, WaitingStrategy.CLICKABLE, "Ok Button");
		return this;
	}
//	public NidhiUpdateOpeningBalancesPage checkEmployeeDistrictandclickOk() {
//		getElementText(userMessage, WaitingStrategy.PRESENCE);
//		click(okButton, WaitingStrategy.CLICKABLE, "Ok Button");
//		return this;
//	}
	
	
	public boolean checkErrorMessageDistisDisplayed() {
		return isDisplayed(errorMessageDistrict,WaitingStrategy.VISIBLE,"Same District error message");
	}
	
	public boolean checkErrorMessageNotCiv() {
		return isDisplayed(errorMessageNotCIV,WaitingStrategy.VISIBLE,"Not CIC Category error message");
	}
	
	public NidhiUpdateOpeningBalancesPage clearDataInHrmsField() {
		clearDataInField(hrmsIDinputField, WaitingStrategy.PRESENCE, "Hrms Id Input Field");
		return this;
	}
	
	
	
	
	
}
