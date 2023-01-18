package com.OrangeHRM.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class PIMPage extends TestBase {
	
	
	@FindBy()
	private WebElement aas;
	

	public PIMPage()throws Exception {
		PageFactory.initElements(driver, this);
	}
	

}
