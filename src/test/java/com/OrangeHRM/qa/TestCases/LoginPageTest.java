package com.OrangeHRM.qa.TestCases;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.DashBoardPage;
import com.OrangeHRM.qa.pages.ForgetPasswordPage;
import com.OrangeHRM.qa.pages.LoginPage;
import com.OrangeHRM.qa.pages.OrangeHRMAboutPage;
import com.OrangeHRM.qa.utilities.commonUtils;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	DashBoardPage dbPage;
	commonUtils utils;
	ForgetPasswordPage fPWDPage;
	OrangeHRMAboutPage aboutPage;
	
	public LoginPageTest() throws Exception {
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws Exception  {
		Initialization();
		loginPage = new LoginPage();
		utils = new commonUtils();
		fPWDPage = new ForgetPasswordPage();
		aboutPage = new OrangeHRMAboutPage();
	}
	
	
	@Test(priority = 0)
	public void verifyPageTitile() throws Exception {
		String title = loginPage.ValidatePageTitle();
		System.out.println("Login Page title :: "+title);
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority = 1)
	public void verifyHRMLogo() throws InterruptedException {
		Assert.assertTrue(loginPage.ValidateHRMImage());
		System.out.println("Logo is Displayed on Login Page");
	}
	
	@Test(priority = 2)
	public void verifyLogin() throws Exception {
		dbPage = loginPage.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		
		utils.TakeScrennShot();
		String dbPageName = dbPage.validateDashBoardText();
		Assert.assertEquals(dbPageName, "Dashboard");
		
	}
	
	@Test(priority = 3)
	public void verifyPorgetPasswordLink() throws Exception {
		
		fPWDPage = loginPage.validateForgetPWDLink();
		String text = fPWDPage.validateResetPasswordText();
		Assert.assertEquals(text, "Reset Password");
	}
	
	@Test(priority = 4)
	public void verifyOrangeHRMAboutPage() throws Exception {
				
		aboutPage = loginPage.validateOrangeHRMIncLink();
		String aboutPageTitle = aboutPage.validatePageTitle();
		Thread.sleep(4000);
		Assert.assertTrue(aboutPageTitle.contains("OrangeHRM HR Software"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
