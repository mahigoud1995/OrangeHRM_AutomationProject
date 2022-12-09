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
	
	
	public void TestMainMenuOptions(String OptName) {
		
		List<WebElement> menuOptions = driver.findElements(By.xpath("//div[@class='oxd-sidepanel-body']/ul[@class='oxd-main-menu']/li"));
	
		for(WebElement  MenuOption : menuOptions) {
			String optname = MenuOption.getText();
			if(optname.equalsIgnoreCase(OptName)) {
				MenuOption.click();
				
			}

		}
	}
			

}
