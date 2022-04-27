package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class DealsPage extends Testbase {

	public DealsPage() {
		PageFactory.initElements(driver, this);
	}

}
