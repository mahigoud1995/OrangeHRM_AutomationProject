package com.OrangeHRM.qa.ExtentReportListener;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateBasicExtentReports {
	@Test
	public void generateExtentReport() throws IOException {
		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/testng-results.html");
		extentReport.attachReporter(sparkReporter);
		
		//Passed Test status
		ExtentTest test1 = extentReport.createTest("Test 1");
		test1.pass("This test is Passed");
		
		//Failed Test Status
		extentReport.createTest("Test 2").log(Status.FAIL, "This test is failed");
		
		//Skip Test status
		ExtentTest test3 = extentReport.createTest("Test 3");
		test3.skip("This is Skipped");
		
		//create bold and italic Info Status
		extentReport.createTest("Bold and Italic info")
		.log(Status.INFO, "info 1")
		.log(Status.INFO, "<b>Bold Info</b>")
		.log(Status.INFO, "<i>Italic Info</i>");
		
		
		//XML information Extent Report
		String xmlData = "<bookstore>  \r\n"
				+ "  <book category=\"COOKING\">  \r\n"
				+ "    <title lang=\"en\">Everyday Italian</title>  \r\n"
				+ "    <author>Giada De Laurentiis</author>  \r\n"
				+ "    <year>2005</year>  \r\n"
				+ "    <price>30.00</price>  \r\n"
				+ "  </book>  \r\n"
				+ "  <book category=\"CHILDREN\">  \r\n"
				+ "    <title lang=\"en\">Harry Potter</title>  \r\n"
				+ "    <author>J K. Rowling</author>  \r\n"
				+ "    <year>2005</year>  \r\n"
				+ "    <price>29.99</price>  \r\n"
				+ "  </book>  \r\n"
				+ "  <book category=\"WEB\">  \r\n"
				+ "    <title lang=\"en\">Learning XML</title>  \r\n"
				+ "    <author>Erik T. Ray</author>  \r\n"
				+ "    <year>2003</year>  \r\n"
				+ "    <price>39.95</price>  \r\n"
				+ "  </book>  \r\n"
				+ "</bookstore> ";
		
		extentReport.createTest("XML based Test")
		.info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		
		
		//Json Based Extent Report
		
		String jsonData = "{\"menu\": {  \r\n"
				+ "  \"id\": \"file\",  \r\n"
				+ "  \"value\": \"File\",  \r\n"
				+ "  \"popup\": {  \r\n"
				+ "    \"menuitem\": [  \r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateDoc()\"},  \r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},  \r\n"
				+ "      {\"value\": \"Save\", \"onclick\": \"SaveDoc()\"}  \r\n"
				+ "    ]  \r\n"
				+ "  }  \r\n"
				+ "}}  ";
		
		
		extentReport.createTest("JSON based Test")
		.info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		
		
		
		
		//5. Collection Data (List, Set and Map)
		
		//5.1 List Based Test
		List<String> listData = new ArrayList<>();
		listData.add("mahesh");
		listData.add("Janson");
		listData.add("Tom");
		listData.add("Peter");
		
		extentReport.createTest("List based Test")
		.info(MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));
		
		
		//5.2 Set Based Test
		Set<Object> setData = new HashSet<>();
		setData.add("mahesh");
		setData.add(6000);
		setData.add(2500.00);
		setData.add("Samba");
		
		extentReport.createTest("Set based Test")
		.info(MarkupHelper.createOrderedList(setData))
		.info(MarkupHelper.createUnorderedList(setData));
		
		
		//5.3 Map Based Test
		Map<String, Object> mapData = new HashMap<>();
		mapData.put("Name", "Mahesh");
		mapData.put("Salary", 50000.00);
		mapData.put("EmpID", "V66338k");
		mapData.put("Company Name", "Google");
		
		extentReport.createTest("Map based Test")
		.info(MarkupHelper.createOrderedList(mapData))
		.info(MarkupHelper.createUnorderedList(mapData));
		
		
		
		//6. Highlight log Test
		extentReport.createTest("Highlight log Test")
		.info("Not hightlighted log")
		.info(MarkupHelper.createLabel("This message is Hilighted", ExtentColor.RED));
		
		
		//7.Exception
		//creating an Arithmetic Exception by division by 0 'Zero'
		try {
			int i =5/0;
		}catch (Exception e) {
			extentReport
			.createTest("Exception based Test")
			.info(e);
		}
		
		
		//creating our own Exception
		/* Throwable is the Super class Exception of all the classes */
		Throwable t = new RuntimeException("This is our Custom Exception");
		extentReport
		.createTest("custom Exception based Test")
		.info(t);
		
		
		//once you all the operations done then only you have to create
		extentReport.flush();
		
		/* once report were generated if we want to open that extent report at that time we need to use this step
		 * otherwise there is no need to open this automatically
		 * It will open that extent report in the your default browser itself 
		 */
		Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"/test-output/testng-results.html").toURI());
		
	}
	
	

}
