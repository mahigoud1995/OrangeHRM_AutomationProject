package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class DashBoardPage extends TestBase{

	public DashBoardPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
	private WebElement DashBoardText;

//	@FindBy(xpath="//input[@name='username']")
//	private WebElement username;
//	
//	@FindBy(xpath="//input[@name='password']")
//	private WebElement password;
//	
//	@FindBy(xpath="//button[@type='submit']")
//	private WebElement loginBtn;
	
	
	public String validateDashBoardText() {
		return DashBoardText.getText();
	}

}
