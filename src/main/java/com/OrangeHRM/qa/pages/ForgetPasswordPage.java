package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class ForgetPasswordPage extends TestBase{

	public ForgetPasswordPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h6[text()='Reset Password']")
	private WebElement resetPasswordText;
	
	
	public String validateResetPasswordText() {
		return resetPasswordText.getText();
	}

}
