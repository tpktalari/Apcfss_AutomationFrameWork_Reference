package com.apcfss.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.apcfss.annotations.FrameworkAnnotations;
import com.apcfss.enums.CategoryType;
import com.apcfss.pages.AmazonHomePage;

@Listeners(com.apcfss.listeners.ListenerImplementation.class)
public final class AmazonHamburgTest extends BaseTest {
	private AmazonHamburgTest() {
	}

	@FrameworkAnnotations(author = { "pavan","kumar"}, category = { CategoryType.SMOKE, CategoryType.REGRESSION })
	@Test
	public void amazonTest() {
		String title = new AmazonHomePage().clickHamburgerBtn().clickMobileAndComputers().clickOnSubMenuItem("Laptops")
				.getTitle();
		Assertions.assertThat(title).isNotNull();
	}
}
 