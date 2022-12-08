package com.OrangeHRM.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.OrangeHRM.qa.base.TestBase;

public class commonUtils extends TestBase{
	static JavascriptExecutor js;
	public commonUtils() throws Exception{
		super();
	}
	
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
	

}
