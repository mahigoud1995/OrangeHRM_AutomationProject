package com.OrangeHRM.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class AdminPage extends TestBase {

	public AdminPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	

}
