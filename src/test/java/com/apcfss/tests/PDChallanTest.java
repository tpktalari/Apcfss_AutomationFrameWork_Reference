package com.apcfss.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.apcfss.annotations.FrameworkAnnotations;
import com.apcfss.driver.DriverManager;
import com.apcfss.enums.CategoryType;
import com.apcfss.pdchallan.pages.AknowledgementPage;
import com.apcfss.pdchallan.pages.PaymentModePage;
import com.apcfss.pdchallan.pages.RemitterDetailsPage;
import com.apcfss.pdchallan.pages.SBIbankMops;
import com.apcfss.pdchallan.pages.TreasuryInfoPage;
import com.google.common.util.concurrent.Uninterruptibles;

@Listeners(com.apcfss.listeners.ListenerImplementation.class)
public class PDChallanTest extends BaseTest {
	TreasuryInfoPage treasuryInfoPage = new TreasuryInfoPage();
	RemitterDetailsPage remitterDetailsPage = new RemitterDetailsPage();
	AknowledgementPage aknowledgementPage = new AknowledgementPage();
	PaymentModePage paymentModePage = new PaymentModePage();

	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			//System.out.println("Page Is loaded.");
			return;
		}
		for (int i = 0; i < 25; i++) {
			Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	@FrameworkAnnotations(author = { "pavan" }, category = { CategoryType.SMOKE })
	@Test(description = "verify whether logo is displayed and also checking the required page title",priority = 1)
	public void verifyModuleLogoAndTitle() {

		String pageTitle = treasuryInfoPage.getTitle();
		Assert.assertEquals(pageTitle, "Receipts");

		boolean result = treasuryInfoPage.getLogoGoap().isDisplayed();
		Assert.assertTrue(result, "GO.A.P. Logo is not Displayed");
		Reporter.log("GO.A.P. is Dispayed", true);
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Click On Department Input box and chexk whether Department listpage is displayed or not",priority = 2)
	public void ClickOnDepartmentInputBox() {
		checkPageIsReady();
		boolean result = treasuryInfoPage.clickOnDepartmentTextBox().checkPreseneceOfPageHeader();
		Assert.assertTrue(result, "Department List Page is not Displayed");
		Reporter.log("Department List Page is Displayed", true);
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Click On Service Input box and check whether Services listpage is displayed or not",priority = 3)
	public void ClickOnServiceInputBox() {
		checkPageIsReady();
		boolean result = treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartmentByMatchingText("Marketing")
				.clickOnServiceTextBox().checkPresenceOfServiceListPage();
		Assert.assertTrue(result, "Services List Page is not Displayed");
		Reporter.log("Services List Page is Displayed", true);
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button --> remitter details element should be in deep blue color",priority = 4)
	public void EnterRequiredDataAndClickOnProceed() {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartmentByMatchingText("AGAP1")
				.clickOnServiceTextBox().clickOnServiceByMatchingText("5125");
		
		String color = treasuryInfoPage.clickOnProceedButton().getColorOfRemitterDetailsElement();
		Assert.assertEquals(color, "rgba(128, 115, 112, 1)");
		Reporter.log("Successfully navigated to Remitter details Page", true);
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on previous button--> should be able to navigate to treasury info page",priority = 5)
	public void EnterDataAndClickProceedClickPreviousWithManualMode() throws InterruptedException {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
				.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		String TrasuryInfoColor = remitterDetailsPage.selectmanualPaymentMode().clickOnPreviousButton()
				.getColorOfTreasuryInfo();
		Assert.assertEquals(TrasuryInfoColor, "rgba(60, 64, 198, 1)");
		Reporter.log("Navigated Successfully to Back to Treaury Info page ", true);
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on previous button--> should be able to navigate to treasury info page",priority = 6)
	public void EnterDataAndClickProceedClickPreviousWithRtgs() {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
				.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		String TrasuryInfoColor = remitterDetailsPage.selectRtgsOrNeftPaymentMode().clickOnPreviousButton()
				.getColorOfTreasuryInfo();
		Assert.assertEquals(TrasuryInfoColor, "rgba(60, 64, 198, 1)");
		Reporter.log("Navigated Successfully to Back to Treaury Info page", true);
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on previous button--> should be able to navigate to treasury info page",priority = 7)
	public void EnterDataAndClickProceedClickPreviousWithEpay() {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
				.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		String TrasuryInfoColor = remitterDetailsPage.selectEpaymentMode().clickOnPreviousButton()
				.getColorOfTreasuryInfo();
		Assert.assertEquals(TrasuryInfoColor, "rgba(60, 64, 198, 1)");
		Reporter.log("Navigated Successfully BAck to to Treaury Info page", true);
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on Submit button--> should be able to navigate to different page",priority = 8)
	public void EnterDataAndClickProceedClickSubmitWithManualMode() {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
				.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		remitterDetailsPage.selectmanualPaymentMode().clickOnSubmitButtonWithManualPaymentMode();
		Reporter.log("Submit Button is Clicked successfully with Manual Payment Mode radio button");
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on Submit button--> should be able to navigate to different page",priority = 9)
	public void EnterDataAndClickProceedClickSubmitWithRtgs() {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
				.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		remitterDetailsPage.selectRtgsOrNeftPaymentMode().clickOnSubmitButtonWithRtgsPaymetnMode();
		Reporter.log("Submit Button is Clicked successfully with RTGS Payment Mode radio button");
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on Submit button--> should be able to navigate to different page",priority = 10)
	public void EnterDataAndClickProceedClickSubmitWithEpay() {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
				.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		remitterDetailsPage.selectEpaymentMode().clickOnSubmitButtonWithEpaymetnMode();
		Reporter.log("Submit Button is Clicked successfully with E Payment Mode radio button");
	}

	// check
	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on Submit button--> should be able to navigate to SBI Aknowledgement Page",priority = 11)
	public void EnterDataAndClickProceedClickSubmitWithManualModeCheckAknowledgePage() {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
				.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		remitterDetailsPage.selectmanualPaymentMode().clickOnSubmitButtonWithManualPaymentMode();
		checkPageIsReady();
		Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
		boolean result = aknowledgementPage.isAknowledgementPageDisplayed();
		Assert.assertTrue(result);
		Reporter.log("Successfully Navigated to SBI Aknowledgement Page", true);
	}

	// check
	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on Submit button--> should be able to navigate to SBI Aknowledgement Page",priority =12)
	public void EnterDataAndClickProceedClickSubmitWithManualModeCheckAknowledgePageDetails() {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
				.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		remitterDetailsPage.selectmanualPaymentMode().clickOnSubmitButtonWithManualPaymentMode();
		checkPageIsReady();
		Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
		aknowledgementPage.isTranctionDetailsVisible();
		Reporter.log("Successfully Navigated to SBI Aknowledgement Page And Transaction details are visible", true);
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on Submit button--> Should Be Clickable",priority = 13)
	public void EnterDataAndClickProceedClickSubmitWithRtgsStatus() {
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
				.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		remitterDetailsPage.selectRtgsOrNeftPaymentMode().clickOnSubmitButtonWithRtgsPaymetnMode();
		Reporter.log("Submit Button is Clicked successfully with RTGS Payment Mode radio button");
	}

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on Submit button--> should be able to navigate to Sbi Mops Page",priority = 14)
	public void EnterDataAndClickProceedClickSubmitWithEpayClickSbi() {
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService();
		checkPageIsReady();
		treasuryInfoPage.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		boolean result = remitterDetailsPage.selectEpaymentMode().clickOnSubmitButtonWithEpaymetnMode()
				.checkPresenceOfapymentMode();
		Assert.assertTrue(result, "Payment Mode page not dispayed");
		paymentModePage.clickOnSbi().presenceOfSbiLogo();
		String title = new SBIbankMops().getTitle();
		Assert.assertEquals(title, "State Bank MOPS");
		Reporter.log(
				"Submit Button is Clicked successfully with E Payment Mode radio button and navigated to sbi mops page",
				true);
	}
	

	@FrameworkAnnotations(author = { "PavanKumar" }, category = { CategoryType.SMOKE })
	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on Submit button--> should be able to navigate to Sbi Mops Page",priority = 14)
	public void EnterDataAndClickProceedClickSubmitWithEpayClickPayU() {
		checkPageIsReady();
		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService();
		checkPageIsReady();
		treasuryInfoPage.clickOnProceedButton().enterDetails().scrollTillLast();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		boolean result = remitterDetailsPage.selectEpaymentMode().clickOnSubmitButtonWithEpaymetnMode()
				.checkPresenceOfapymentMode();
		Assert.assertTrue(result, "Payment Mode page not dispayed");
		paymentModePage.clickOnPayU();
		checkPageIsReady();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		try {
		    // Your code for executing the test steps
		    
		    // Check if error message is displayed
		    if (DriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'2-error')]")).isDisplayed()) {
		        // Stop execution if error message is displayed
		        throw new RuntimeException("Error message displayed. Stopping execution.");
		    }
		    
		    // Continue execution if error message is not displayed
		    
		    // Your code for continuing the test steps
		    
		} catch (Exception e) {
		    // Handle the exception or log the error message
		    System.out.println("Exception occurred: " + e.getMessage());
		}
		
		Reporter.log(
				"Submit Button is Clicked successfully with E Payment Mode radio button and navigated to sbi mops page",
				true);
	}

//	@FrameworkAnnotations(author = { "pavan" }, category = { CategoryType.SMOKE })
//	@Test(description = "Select department and servive details and click on proceed button,Enter require remitter details and click on previous button--> should be able to navigate to treasury info page")
//	public void verifyCheck() throws InterruptedException {
//		treasuryInfoPage.clickOnDepartmentTextBox().clickOnDepartment().clickOnServiceTextBox().clickOnService()
//				.clickOnProceedButton().enterDetails().scrollTillLast();
//		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
//		boolean result = remitterDetailsPage.selectEpaymentMode().clickOnSubmitButtonWithEpaymetnMode()
//				.checkPresenceOfapymentMode();
//		Assert.assertTrue(result, "Payment Mode page not dispayed");
//		paymentModePage.clickOnSbi();
//		Thread.sleep(5000);
//		System.out.println(DriverManager.getDriver().getTitle());
//	}
//
//	@FrameworkAnnotations(author = { "pavan" }, category = { CategoryType.SMOKE })
//	@Test
//	public void checkPageLoad() {
//		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//		if (js.executeScript("return document.readyState").toString().equals("complete")) {
//			System.out.println("Page Is loaded.");
//			return;
//		}
//	}
}
