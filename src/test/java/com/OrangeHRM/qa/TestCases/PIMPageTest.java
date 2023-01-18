package com.OrangeHRM.qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.LoginPage;
import com.OrangeHRM.qa.utilities.ExcelReader;

public class PIMPageTest extends TestBase {
	ExcelReader xlReader;
	LoginPage lPage;
	
	
	
	public PIMPageTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void initialization() throws Exception {
		Initialization();
		lPage = new LoginPage();
		lPage.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws Exception {
		xlReader =new ExcelReader();
		Object [][]data = xlReader.getTestData("AddEmployee");
		return data;
	}
	
	
	@Test(dataProvider = "getData")
	public void createEmployee(String fName, String lName, String Username, String Password) {
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		driver.findElement(By.name("firstName")).sendKeys(fName);
		driver.findElement(By.name("lastName")).sendKeys(lName);
		
		String EmpId = driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div//following-sibling::div/child::input[@class='oxd-input oxd-input--active']")).getAttribute("value");
		System.out.println("Employee ID :: "+EmpId);
		
		driver.findElement(By.xpath("//div[@class='oxd-switch-wrapper']")).click();
		
		WebElement username = driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input"));
		username.clear();
		username.sendKeys(Username);
		WebElement EnableRadioBtn = driver.findElement(By.xpath("//label[text()='Enabled']"));
		if(EnableRadioBtn.isSelected()) {
			System.out.println("Enabled Selected");
		}else {
			EnableRadioBtn.click();
		}
		WebElement password = driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input[@type='password']"));
		password.clear();
		password.sendKeys(Password);
		WebElement passwordStrngth = driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']/span"));
		String PwdStrength = passwordStrngth.getText();
		System.out.println("Password Strength :: "+PwdStrength);
		Assert.assertEquals(PwdStrength, "Strongest");
		System.out.println("************************** Assertion succesfull ************************");
		WebElement confirmPassword = driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input[@type='password']"));
		confirmPassword.clear();
		confirmPassword.sendKeys(Password);
		
		
		
		
		
		
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

}
