package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class ContactsPage extends Testbase {
	WebDriver driver;

	public ContactsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;

	@FindBy(xpath = "//a[text()='test puli']//parent::td//preceding-sibling::td//input[@name='id' and @type='checkbox']")
	WebElement selectContact;

	@FindBy(xpath = "//button[@class='ui linkedin button' and contains(text(),'Create')]")
	WebElement Create;

	public boolean verifyContactsLabel() {

		// return contactsLabel.getText();
		return contactsLabel.isDisplayed();
	}

//	public void selectContacts(String name) {
//		driver.findElement(By.xpath(
//				"//a[text()='test puli']//parent::td//preceding-sibling::td//input[@name='id' and @type='checkbox']"))
//				.click();
//
//		// a[text()='test puli']//parent::td//preceding-sibling::td//input[@name='id']
//	}

	public void selectContacts() {
		selectContact.click();

	}

	public void mousehover() {
		Actions act = new Actions(driver);
		act.moveToElement(contactsLabel);

	}

	public void createContact() {
		Create.click();

	}

}
