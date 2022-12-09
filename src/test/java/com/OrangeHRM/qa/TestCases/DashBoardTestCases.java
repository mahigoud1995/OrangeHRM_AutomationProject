package com.OrangeHRM.qa.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.AdminPage;
import com.OrangeHRM.qa.pages.DashBoardPage;
import com.OrangeHRM.qa.pages.LoginPage;

public class DashBoardTestCases extends TestBase {
	
	DashBoardPage dbPage;
	LoginPage lPage;
	AdminPage adminPage;
	
	public DashBoardTestCases() throws Exception {
		super();
	}

	
	
	@BeforeMethod
	public void openBrowser() throws Exception {
		Initialization();
		lPage = new LoginPage();
		dbPage = lPage.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}
		
	@Test
	public void veifyAdminLink() throws Exception {
		
		adminPage = new AdminPage();
		adminPage = dbPage.ValidateClickOnAdminLink();
	
	}
		
		
		
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
		
		
}
