package com.apcfss.classIV.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.apcfss.driver.DriverManager;
import com.apcfss.enums.WaitingStrategy;

public class NidhiHomePage extends BasePage {

	
	private final By classIVtile = By.xpath("//p[text()='Class IV Gpf']");
	private final By classIVsubtile = By.xpath("//a[text()='Class IV Gpf']");
	
	public NidhiHomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public NidhiHomePage clickClassIVMajorTile() {
		click(classIVtile, WaitingStrategy.CLICKABLE, "ClassIV Major Tile");
		return this;
	}
	
	public NidhiClassIVGPF_Page clickClassIVsubTile() {
		click(classIVsubtile, WaitingStrategy.CLICKABLE, "ClassIV Sub Tile");
		return new NidhiClassIVGPF_Page();
	}
}
