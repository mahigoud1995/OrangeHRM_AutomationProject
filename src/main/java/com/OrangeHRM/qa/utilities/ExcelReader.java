package com.OrangeHRM.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelReader {
	static Workbook book;
	static Sheet sheet;
	String currentDir = System.getProperty("user.dir");
	String fileName = currentDir+"\\src\\main\\java\\com\\OrangeHRM\\qa\\testData\\OrangeHRM_TestData.xlsx";
	//String sheetName = "Environment";
	
	public Object[][] getTestData(String sheetName) throws Exception {
		FileInputStream fis=null;
		
		try {
			fis = new FileInputStream(fileName);
		}catch(Exception e) {
			throw new Exception("File not found");
		}
		
		try {
			book=WorkbookFactory.create(fis);
		}catch(Exception e) {
			
		}
		sheet=book.getSheet(sheetName);
		Object [][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	

}
