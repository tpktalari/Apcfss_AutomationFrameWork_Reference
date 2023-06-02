package com.apcfss.tests;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.apcfss.driver.DriverManager;

public final class HomepageTest extends BaseTest {
	private HomepageTest() {}
	
	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing mini bytes-youtube", Keys.ENTER);
		String title=DriverManager.getDriver().getTitle();
		//using assertJ assertions
		/*Assertions.*/assertThat(title)
			.as("Object is null").isNotNull()
			.as("it doesn't contain expected text").containsIgnoringCase("google search")
			.as("length not between 10-100").hasSizeBetween(15, 100);
		
		
		
		
		
		
		
		// using testNg assertions
//		Assert.assertTrue(Objects.nonNull(title));
//		Assert.assertTrue(title.contains("Google Search"));
//		Assert.assertTrue(title.length()>15);
//		Assert.assertTrue(title.length()<100);
		List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath("//h3"));
		
		//using assertJ assertions
/*Assertions. assertThat(elements)
		.hasSize(9)
		.extracting(e->e.getText()).contains("Testing Mini Bytes");*/
		
		
		//using testNg assertions
//		Assert.assertEquals(elements.size(), 9);
//		boolean isElementPresent=false;
//		for(WebElement ele:elements)
//		{
//			if (ele.getText().equalsIgnoreCase("Testing Mini Bytes")) {
//				isElementPresent=true;
//			}
//		}
//		Assert.assertTrue(isElementPresent,"Testing Mini Bytes Link is not present");
//		String pString="pavan";
//		Assertions.assertThat(pString).isNotNull();
	}

}
