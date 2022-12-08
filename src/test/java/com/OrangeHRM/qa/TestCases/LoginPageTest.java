package com.OrangeHRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.DashBoardPage;
import com.OrangeHRM.qa.pages.LoginPage;
import com.OrangeHRM.qa.utilities.commonUtils;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	DashBoardPage dbPage;
	commonUtils utils;
	
	public LoginPageTest() throws Exception {
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws Exception  {
		Initialization();
		loginPage = new LoginPage();
	}
	
	
	//@Test(priority = 0)
	public void verifyPageTitile() throws InterruptedException {
		String title = loginPage.ValidatePageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	//@Test(priority = 1)
	public void verifyHRMLogo() throws InterruptedException {
		Assert.assertTrue(loginPage.ValidateHRMImage());
	}
	
	@Test(priority = 2)
	public void verifyLogin() throws Exception {
		dbPage = loginPage.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		String dbPageName = dbPage.validateDashBoardText();
		Assert.assertEquals(dbPageName, "Dashboard");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
