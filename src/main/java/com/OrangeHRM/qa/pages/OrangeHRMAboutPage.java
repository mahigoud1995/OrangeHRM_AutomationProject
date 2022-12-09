package com.OrangeHRM.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class OrangeHRMAboutPage extends TestBase {

	public OrangeHRMAboutPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String validatePageTitle() {
		System.out.println("OrangeHRMAboutPage Title ::: "+driver.getTitle());
		driver.getPageSource();
		return driver.getTitle();
	}

}
