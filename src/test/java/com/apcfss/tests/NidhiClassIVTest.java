package com.apcfss.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.apcfss.annotations.FrameworkAnnotations;
import com.apcfss.classIV.pages.NidhiHomePage;
import com.apcfss.classIV.pages.NidhiLoginPage;
import com.apcfss.classIV.pages.NidhiUpdateOpeningBalancesPage;
import com.apcfss.enums.CategoryType;
@Listeners(com.apcfss.listeners.ListenerImplementation.class)
public class NidhiClassIVTest extends BaseTest{

	
	NidhiLoginPage loginPage=new NidhiLoginPage();
	NidhiHomePage homePage=new NidhiHomePage();
	NidhiUpdateOpeningBalancesPage uobPage= new NidhiUpdateOpeningBalancesPage();
	
	
	
	
	
	
	@FrameworkAnnotations(author={"pavan kumar"}, category = { CategoryType.SMOKE })
	@Test
	public void classIVtest() {
	loginPage.enterUsername("14165719").enterPassword("Civ@1234").clickLogin()
	.clickClassIVMajorTile().clickClassIVsubTile().clickEmployeeOperationsButton()
		.clickUpdateOpeningBalancesButton().clickUOBTab();
	
	List<String> hrmsIds=getHRMSIds("Sheet1");
	for(String hrmsId:hrmsIds) {
		try {
			uobPage.clearDataInHrmsField();
			uobPage.enterHrmsId(hrmsId);
			
			uobPage.clickSubmitButton();
				try {
//					new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
//					.until(ExpectedConditions.visibilityOf(uobPage.getUserMessage()));
					
					if(uobPage.checkErrorMessageDistisDisplayed()) {
						Thread.sleep(1000);
						uobPage.clickOkButton();
						System.out.println("HRMS ID " + hrmsId + ": Employee doesn't belong to the district.");
						continue;
					}
					else if (uobPage.checkErrorMessageNotCiv()) {
						Thread.sleep(1000);
						uobPage.clickOkButton();
						System.out.println("HRMS ID " + hrmsId + ": Employee doesn't belong to the CIV category.");
						continue;
					}
				} catch (Exception e) {
					// Error message not displayed, proceed to fetch data
					System.out.println("HRMS ID " + hrmsId + ": Fetching data.");
					uobPage.clickSubmitButton();
					System.out.println("Succesfully Fetched the data for : "+ hrmsId+ ", Employee Name : " + uobPage.captureEmployeeData());
				}
		} 
		catch (Exception e) {
			System.err.println("Error processing HRMS ID " + hrmsId + ": " + e.getMessage());

		}
	}
	
	
	
	}
	
	
	
	
	
	
	
	
	@FrameworkAnnotations(author={"pavan kumar"}, category = { CategoryType.SMOKE })
	@Test
	public void classIVtest2() {
	loginPage.enterUsername("14165719").enterPassword("Civ@1234").clickLogin()
	.clickClassIVMajorTile().clickClassIVsubTile().clickEmployeeOperationsButton()
		.clickUpdateOpeningBalancesButton().clickUOBTab();
	
	List<String> hrmsIds=getHRMSIds("Sheet1");
	for(String hrmsId:hrmsIds) {
		try {
			uobPage.clearDataInHrmsField();
			uobPage.enterHrmsId(hrmsId);
			
			uobPage.clickSubmitButton();
				try {
//					new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
//					.until(ExpectedConditions.visibilityOf(uobPage.getUserMessage()));
					
					if(!uobPage.checkErrorMessageDistisDisplayed() && !uobPage.checkErrorMessageNotCiv() ) {
						uobPage.clickSubmitButton();
						
						System.out.println(uobPage.captureEmployeeData());
						Thread.sleep(1000);
//						uobPage.clickforwardButton();
//						uobPage.clickOkButton();
						
										
					}
				} catch (Exception e) {
					uobPage.clickOkButton();
					
				}
		} 
		catch (Exception e) {
			System.err.println("Error processing HRMS ID " + hrmsId + ": " + e.getMessage());

		}
	}
	
	
	
	}
	
	
	
	public static List<String> getHRMSIds(String sheetName) {
	    List<String> hrmsIds = new ArrayList<>();
	    try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\tpkta\\eclipse-workspace\\automationframework\\HrmsIds.xlsx");
	         XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {
	        XSSFSheet sheet = workbook.getSheet(sheetName);

	        // Start reading from row 1 (assuming row 0 contains headers)
	        int lastRowNum = sheet.getLastRowNum();
	        for (int i = 1; i <= lastRowNum; i++) {
	            String hrmsId = sheet.getRow(i).getCell(0).getStringCellValue();
	            hrmsIds.add(hrmsId);
	        }
	    } catch (FileNotFoundException e) {
	        throw new RuntimeException("Excel File trying to read is not found", e);
	    } catch (IOException e) {
	        throw new RuntimeException("Unable to read data from excel file", e);
	    }
	    return hrmsIds;
	}
	
	
	
	
}
