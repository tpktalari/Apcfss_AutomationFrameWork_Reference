package com.apcfss.classIV.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;

public class NidhiClassIVGPF_Page extends BasePage {

	private By employeeOperationsMenuButton = By.xpath("//span[text()='Employee Operations']");
	private By updateOpeningBalancesButton=By.xpath("//span[text()='Update Opening']");
	
	public NidhiClassIVGPF_Page() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public NidhiClassIVGPF_Page clickEmployeeOperationsButton() {
		click(employeeOperationsMenuButton, WaitingStrategy.CLICKABLE, "Employee Operations Menu Button");
		return this;
	}
	
	public NidhiUpdateOpeningBalancesPage clickUpdateOpeningBalancesButton() {
		click(updateOpeningBalancesButton, WaitingStrategy.CLICKABLE, "Update Opening Balances Button");
		return new NidhiUpdateOpeningBalancesPage();
	}

}
