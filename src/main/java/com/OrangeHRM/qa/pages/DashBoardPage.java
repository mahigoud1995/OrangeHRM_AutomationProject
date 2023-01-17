package com.OrangeHRM.qa.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//div[@class='oxd-brand-banner']/img[@alt='client brand banner']")
	private WebElement OrangeHRmLogo;
	
	@FindBy(xpath="//img[@class='oxd-userdropdown-img']")
	private WebElement UserProfilePicture;
	
	@FindBy(xpath="//img[@class='oxd-userdropdown-img']/following-sibling::p[@class='oxd-userdropdown-name']")
	private WebElement UserNameLabel;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active']")
	private WebElement SearchBox;
		
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/li/a[text()='About']")
	private WebElement AboutLink;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/li/a[text()='Change Password']")
	private WebElement ChangePasswordLink;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/li/a[text()='Support']")
	private WebElement SupportLink;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/li/a[text()='Logout']")
	private WebElement LogoutLink;
	
	
//	
//	@FindBy(xpath="//button[@type='submit']")
//	private WebElement loginBtn;
//	
	
	
	
	public String validateDashBoardText() {
		return DashBoardText.getText();
	}
	
	public boolean validateHRMLogo() {
		return OrangeHRmLogo.isDisplayed();
	}
	
	public boolean validProfilePicture() {
		return UserProfilePicture.isDisplayed();
	}
	
	public String validateUserProfileNameLabel() {
		return UserNameLabel.getText();
	}
	
	public Set<String> validateSearchOption(String optionName) {
		SearchBox.sendKeys(optionName);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li/a"));
		Set<String> ops = new HashSet<>();
		for(WebElement names: options) {
			ops.add(names.getText());
		}
		return ops;
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
	
	public TimePage validateTimeLink() {
		TestMainMenuOptions("Time");
		return new TimePage();
	}
	
	public RecruitmentPage validateRecruitmentLink() {
		TestMainMenuOptions("Time");
		return new RecruitmentPage();
	}
	
	public MyInfoPage validateMyInfoLink() {
		TestMainMenuOptions("Time");
		return new MyInfoPage();
	}
	
	public PerformancePage validatePerformanceLink() {
		TestMainMenuOptions("Time");
		return new PerformancePage();
	}
	
	public String validateDashboardLink() {
		TestMainMenuOptions("Time");
		return validateDashBoardText();
	}
	
	public DirectoryPage validateDirectoryLink() {
		TestMainMenuOptions("Time");
		return new DirectoryPage();
	}
	
	public MaintenancePage validateMaintenanceLink() {
		TestMainMenuOptions("Time");
		return new MaintenancePage();
	}
	
	public BuzzPage validateBuzzLink() {
		TestMainMenuOptions("Time");
		return new BuzzPage();
	}
	
	public void validateUserProfilePicture() {
		
	}
	
	
	public void TestMainMenuOptions(String OptName) {
		
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item']//span[text()='"+OptName+"']")).click();
		
	}
			

}
