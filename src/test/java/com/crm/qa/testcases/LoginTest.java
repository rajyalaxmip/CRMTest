package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends Testbase {
	LoginPage lp;
	HomePage hp;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = lp.validateLoginPageTitle();
		Assert.assertEquals(title,
				"Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}

	@Test(priority = 2)
	public void loginTest() {
		lp.login();
		hp = lp.loginPage(prop.getProperty("email"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
