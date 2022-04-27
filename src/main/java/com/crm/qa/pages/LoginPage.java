package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class LoginPage extends Testbase {
	public WebDriver driver;

	// Initializing the Page Objects:

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Login")
	WebElement lnkLogin;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[@class=\"ui fluid large blue submit button\"]")
	WebElement loginBtn;

	@FindBy(linkText = "Sign Up")
	WebElement signUpBtn;

	@FindBy(linkText = "Classic CRM")
	WebElement classicCRMBtn;

	@FindBy(linkText = "Forgot your password?")
	WebElement frgtPwd;

	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public HomePage loginPage(String uname, String pwd) {
		email.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage(driver);

	}

	public void login() {
		lnkLogin.click();

	}

}
