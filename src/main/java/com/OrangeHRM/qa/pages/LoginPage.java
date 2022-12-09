package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.utilities.commonUtils;

public class LoginPage extends TestBase {

	//Define the all WebElements in the Login Page 
	
	@FindBy(xpath="//div[@class='orangehrm-login-branding']/img")
	private WebElement HRMImage;

	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
		
	@FindBy(xpath="//div[@class='orangehrm-login-forgot']")
	private WebElement forgetPasswordLink;
	
	@FindBy(xpath="//div[@class='orangehrm-login-logo-mobile']")
	private WebElement LoginText;
	
	
	//*************************** Footer Elements *************************************//
	
	@FindBy(xpath="//p[contains(text(), 'OrangeHRM OS')]")
	private WebElement OrangeHRMVersion;
	
	@FindBy(xpath="//a[contains(text(), 'OrangeHRM')]")
	private WebElement OrangeHRMIncLink;
	
	

	
	//Initializing the Page Objects
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	
//***************************** Initializing the methods ************************************//
	//Actions:
	public String ValidatePageTitle() throws InterruptedException {
		Thread.sleep(3000);
		return driver.getTitle();
	}
	
	public boolean ValidateHRMImage() throws InterruptedException {
		Thread.sleep(3000);
		return HRMImage.isDisplayed();
		
	}
	
	public DashBoardPage validateLogin(String UserName, String pwd) throws Exception {
		username.sendKeys(UserName);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(3000);
		return new DashBoardPage();
		
	}
	
	public ForgetPasswordPage validateForgetPWDLink() throws Exception {
		forgetPasswordLink.click();
		Thread.sleep(3000);
		return new ForgetPasswordPage();
	}
	
	public OrangeHRMAboutPage validateOrangeHRMIncLink() throws Exception {
		
		/*
		 * while clicking link we should navigate to the new window
		 * for that we need to call the switch to window method from the CommonUtils class
		 */
		
//		creating instance for CommonUtils class
		commonUtils util = new commonUtils();
//		calling the SwitchTo window Method
		util.switchToChildWindow(OrangeHRMIncLink);
		
//		if we click that link we should navigate to the OrangeHRMAboutPage 
		return new OrangeHRMAboutPage();
	}

}
