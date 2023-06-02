package com.apcfss.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.apcfss.annotations.FrameworkAnnotations;
import com.apcfss.enums.CategoryType;
import com.apcfss.pages.OrangeLoginPage;
import com.apcfss.utils.DataProviderUtil;

//@Listeners(com.apcfms.listeners.ListenerImplementation.class)
public class OrangeHrmTest extends BaseTest {
	@FrameworkAnnotations(author = { "pavan"}, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test(dataProvider = "getDataKeyValue", dataProviderClass = DataProviderUtil.class)
	public void loginLogoutTest(Map<String, String> map) {
		String title = new OrangeLoginPage().enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin().clickUserDD()
				.clickLogout().getTitle();
		System.out.println(title);
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
	
	
	@FrameworkAnnotations(author = {"tejesh","vishnu"}, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test/*(dataProvider = "getDataKeyValue", dataProviderClass = DataProviderUtil.class, retryAnalyzer = RetryFailedTests.class)*/
	public void newTest(Map<String, String> map) {
		String title = new OrangeLoginPage().enterUsername(map.get("username")).enterPassword(map.get("password")).clickLogin().clickUserDD()
				.clickLogout().getTitle();
		System.out.println(title);
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider/*(name = "loginLogoutDataprovider", parallel = true)*/
	public Object[][] getData() {
		return new Object[][] { { "Admin", "admin123" },
				// {"Admin1","admin123"},
//			{"Admin","admin123"},
//			{"Admin","admin123"}
		};
	}

}
