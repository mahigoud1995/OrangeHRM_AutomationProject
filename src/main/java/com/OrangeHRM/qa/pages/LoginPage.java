package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Define the all WebElements in the Login Page 
	
	@FindBy(xpath="//div[@class='orangehrm-login-branding']/img")
	private WebElement HRMImage;

	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='orangehrm-login-forgot']")
	private WebElement forgetPasswordLink;
	
	
	
	
	//Initializing the Page Objects
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String ValidatePageTitle() {
		return driver.getTitle();
	}
	public boolean ValidateHRMImage() {
		return HRMImage.isDisplayed();
	}
	
	public DashBoardPage validateLogin(String UserName, String pwd) throws Exception {
		username.sendKeys(UserName);
		password.sendKeys(pwd);
		loginBtn.click();
		return new DashBoardPage();
		
	}
	
	public ForgetPasswordPage verifyLoginLink() throws Exception {
		forgetPasswordLink.click();
		return new ForgetPasswordPage();
	}

}
