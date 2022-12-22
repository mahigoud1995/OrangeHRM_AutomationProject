package com.OrangeHRM.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;

public class DashBoardPage extends TestBase{

	public DashBoardPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
	private WebElement DashBoardText;

	
//	@FindBy(xpath="//div[@class='oxd-sidepanel-body']/ul[@class='oxd-main-menu']/li")
//	private WebElement mainMenu;
//	
//	@FindBy(xpath="//input[@name='password']")
//	private WebElement password;
//	
//	@FindBy(xpath="//button[@type='submit']")
//	private WebElement loginBtn;
	
	
	public String validateDashBoardText() {
		return DashBoardText.getText();
	}
	
	public AdminPage ValidateClickOnAdminLink() throws Exception {
		TestMainMenuOptions("Admin");
		return new AdminPage();
			
	}
	
	public PIMPage validateClickOnPIMLink() throws Exception {
		TestMainMenuOptions("PIM");
		return new PIMPage();
	}
	
	public LeavePage validateLeavesLink() {
		TestMainMenuOptions("Leave");
		return new LeavePage();
	}
	
	
	public void TestMainMenuOptions(String OptName) {
		
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item']//span[text()='"+OptName+"']")).click();
		
	}
			

}
