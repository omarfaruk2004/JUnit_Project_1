package com.qa.techfios.tests;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.qa.techfios.base.TestBase;
import com.qa.techfios.pages.HomePage;

public class HomePageTest extends TestBase{
	
	@Before
	public void setUp() {
		initializeBrowser();
	}
	
	@Test
	public void validateToggleAllFunctionality() {
		driver.get(properties.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		homePage.checkListItemIsEmpty();
		List<String> items = new ArrayList<String>();
		items.add("fhhyg");
		items.add("abdhcd");
		homePage.clickToggleAllForNonEmptyList(items);
		homePage.validateAllCheckboxesChecked();
	}
	
	@Test
	public void removeFirstItemIfSelected() {
		driver.get(properties.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		homePage.removeSpecificItemFromList(0);
	}
	
	@Test
	public void removeAllItemsUsingToggleAll() {
		driver.get(properties.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		homePage.toggleAllAndRemove();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
