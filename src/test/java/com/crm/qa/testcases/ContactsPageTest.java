package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends Testbase {

	LoginPage lp;
	HomePage hp;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage(driver);
		lp.login();
		hp = lp.loginPage(prop.getProperty("email"), prop.getProperty("password"));
		contactsPage = new ContactsPage(driver);

		contactsPage = hp.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void VerifycontactsPageLabel() {
		contactsPage.mousehover();
		System.out.println(contactsPage.verifyContactsLabel());
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
		// Assert.assertEquals(contactsPage.verifyContactsLabel(), "Contacts");
	}

	@Test(priority = 2)
	public void selectContactsTest() throws InterruptedException {
		contactsPage.mousehover();
		// Thread.sleep(3000);
		contactsPage.selectContacts();

	}

//	@Test(priority = 2)
//	public void CreateContactsTest() throws InterruptedException {
//		contactsPage.createContact();
//		Thread.sleep(3000);
//
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
