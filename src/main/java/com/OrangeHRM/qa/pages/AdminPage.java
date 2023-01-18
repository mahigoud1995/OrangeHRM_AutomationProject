package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class AdminPage extends TestBase {

	public AdminPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy()
	private WebElement a;
	
	@FindBy()
	private WebElement b;
	
	@FindBy(xpath="")
	private WebElement c;
	
	@FindBy()
	private WebElement d;
	

	
	
	
}
