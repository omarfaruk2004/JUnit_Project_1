package com.qa.techfios.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.techfios.customactions.CustomWebDriverMethods;

public class HomePage extends CustomWebDriverMethods {

	WebDriver driver;

	@FindBy(css = "#todos-content ul li")
	private List<WebElement> itemList;

	@FindBy(css = "input[name='allbox']")
	private WebElement toggleAll;

	@FindBy(css = "input[name='data']")
	private WebElement itemTextbox;

	@FindBy(css = "input[value='Add']")
	private WebElement addButton;

	@FindBy(css = "#todos-content ul li input")
	private List<WebElement> itemListCheckboxes;

	@FindBy(css = "input[value='Remove']")
	private WebElement removeButton;

	public List<WebElement> getItemList() {
		return this.itemList;
	}

	public WebElement getToggleAll() {
		return this.toggleAll;
	}

	public WebElement getRemoveButton() {
		return this.removeButton;
	}

	public WebElement getItemTextbox() {
		return this.itemTextbox;
	}

	public WebElement getAddButton() {
		return this.addButton;
	}

	public List<WebElement> getItemListCheckboxes() {
		return this.itemListCheckboxes;
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean checkListItemIsEmpty() {
		boolean isEmptyList = getItemList().size() == 0 ? true : false;
		return isEmptyList;
	}

	public void clickToggleAllForNonEmptyList(List<String> items) {
		if (!this.checkListItemIsEmpty()) {
			customClick(getToggleAll());
		} else {
			for (String itemName : items) {
				setText(getItemTextbox(), itemName);
				customClick(getAddButton());
			}
			customClick(getToggleAll());
		}
	}

	public void validateAllCheckboxesChecked() {
		int itemCount = 0;
		for (WebElement checkBox : getItemListCheckboxes()) {

			if (isElementSelected(checkBox)) {
				System.out.println("The checkbox for item " + getElementText(itemList.get(itemCount)) + " is checked");
			}
			itemCount++;
		}
	}

	// itemIndex index starts from 0
	public void removeSpecificItemFromList(int itemIndex) {
		if (!isElementSelected(getItemListCheckboxes().get(itemIndex))) {
			customClick(getItemListCheckboxes().get(itemIndex));
			customClick(getRemoveButton());
			System.out.println("Removed item at index " + itemIndex);
		}
	}

	public void toggleAllAndRemove() {
		customClick(getToggleAll());
		try {
		Thread.sleep(5000);
		}catch(Exception e) {
			
		}
		customClick(getRemoveButton());
		System.out.println("Removed all the items from List");
		if(this.checkListItemIsEmpty()) {
			System.out.println("The list is empty after clicking on remove button using toggle all functionality");
		}
	}

}
