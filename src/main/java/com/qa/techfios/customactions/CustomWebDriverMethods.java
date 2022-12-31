package com.qa.techfios.customactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.techfios.base.TestBase;

public class CustomWebDriverMethods{
	
	WebDriver driver = TestBase.driver;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public void waitUntilClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void customClick(WebElement element) {
		this.waitUntilClickable(element);
		element.click();
	}
	
	public void setText(WebElement element, String value) {
		this.waitUntilVisible(element);
		element.clear();
		element.sendKeys(value);
	}
	
	public boolean isElementSelected(WebElement element) {
		this.waitUntilVisible(element);
		return element.isSelected();
	}
	
	public String getElementText(WebElement element) {
		this.waitUntilVisible(element);
		return element.getText();
	}
}
