package com.OrangeHRM.qa.ExtentReportListener; 


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class attachScreenshotForFailedTestLogs {
	public static WebDriver driver;

	@Test
	public void getScreenshot() throws IOException {
		// String localPath = takeScreenshotMethod();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();

		//storing the absolute path of the screenshot location into a string variable
		String localPath = takeScreenshotMethod();
		//storing the Screenshot location path as a string base64 variable
		String base64Path = base64takeScreenshotMethod();
		
		driver.quit();
		
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		//attaching the spark report to the ExtentReport
		extentReports.attachReporter(sparkReporter);
		//we can add multiple Screenshots for a single test
		extentReports.createTest("Screenshot Test 1 -- Base64 -- Media")
		.info("This is the info message for Screenshot")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Path).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Path, "Base64 Format screenshot").build());
		
		extentReports.createTest("Screenshot Test 2 - regular -- media")
		.info("This is the info message for Screenshot")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(localPath).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(localPath, "Regular Format screenshot").build());
		
		extentReports.createTest("Screenshot Test 3 -- Base64 -- (details, media)")
		.info("This is the info message for Screenshot")
		.fail("info message for screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Path).build())
		.fail("info message for screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Path, "Base64 Format Screenshot").build());
		
		
		extentReports.createTest("Screenshot Test 4 -- Regular -- (details, media)")
		.info("This is the info message for Screenshot")
		.fail("info message for screenshot", MediaEntityBuilder.createScreenCaptureFromPath(localPath).build())
		.fail("info message for screenshot", MediaEntityBuilder.createScreenCaptureFromPath(localPath, "Regular Format Screenshot").build());
		
		Throwable t = new Throwable("This is custom Exception");
		extentReports.createTest("Screenshot Test 5 -- Baseg4 (Throwable, media)")
		.info("This is the info message for Screenshot")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Path).build())
		.fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Path, "Base64 Format Screenshot").build());

		
		extentReports.createTest("Screenshot Test 5 -- Baseg4 (Throwable, media)")
		.info("This is the info message for Screenshot")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(localPath).build())
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(localPath, "Regular Format Screenshot").build());

		//after that at the end we need to maintain this flush() method then only we can get the report 
		extentReports.flush();

		/* if we want to open that extent report automatically after the execution 
		 * then only we can add this below command otherwise no need of this 
		 */	
		Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "/test-output/ExtentReport.html").toURI());
	}

	public static String takeScreenshotMethod() throws IOException {

		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File srcfile = screenShot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "/ScreenShots/" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(srcfile, file);

		System.out.println(file.getAbsolutePath());
		return file.getAbsolutePath();
	}

	public static String base64takeScreenshotMethod() throws IOException {

		TakesScreenshot screenShot = (TakesScreenshot) driver;
		String srcfile = screenShot.getScreenshotAs(OutputType.BASE64);
		File file = new File(System.getProperty("user.dir") + "/ScreenShots/" + System.currentTimeMillis() + ".png");
		return srcfile;
	}

}

