package com.OrangeHRM.qa.utilities;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.qa.base.TestBase;

public class commonUtils extends TestBase{
	
	public commonUtils() throws Exception {
		super();
	}


	static JavascriptExecutor js;
	
	public void TakeScrennShot() throws Exception {
		//js.executeScript("argument[0].setAttribute('style', 'border:2px solid red; background:yellow')", WebElement ele);
		String getCurrentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		String getCurrentClassName = new Throwable().getStackTrace()[0].getClassName();

		System.out.println("Method Name :::: "+getCurrentMethodName);
		System.out.println("Class Name :::: "+getCurrentClassName);
		
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		File file = new File(".//ScreenShots/"+getCurrentClassName+"_"+getCurrentMethodName+".png");
		FileUtils.copyFile(src, file);
		
		
	}
	
	public void switchToChildWindow(WebElement ele) throws InterruptedException {
		String PagernWindow = driver.getWindowHandle();
		System.out.println("Parent window Id :: "+PagernWindow);
		Thread.sleep(3000);
		ele.click();
		Thread.sleep(3000);

		Set<String> windows = driver.getWindowHandles();
		
		for(String window : windows) {
			if(!PagernWindow.equals(window)) {
				driver.switchTo().window(window);
				System.out.println("We are in child window");
				System.out.println("Child window :: "+window);
				
			}
		}
		
	}
	
	
	public void switchToParentWindow() {
		String childWindow = driver.getWindowHandle();
		System.out.println("child window Id :: "+childWindow);
		Set<String> windows = driver.getWindowHandles();
		
		for(String window : windows) {
			if(!childWindow.equals(window)) {
				driver.switchTo().window(window);
				System.out.println();
			}
		}
	}
	

	
	
	
	
	
	
	
	
	
}
