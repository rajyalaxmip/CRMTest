package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomepageTest extends Testbase {
	LoginPage lp;
	HomePage hp;
	ContactsPage contactsPage;

	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage(driver);
		lp.login();
		hp = lp.loginPage(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = hp.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(hp.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {

		contactsPage = hp.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
