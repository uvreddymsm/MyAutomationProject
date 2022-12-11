package com.applaudGS.automation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProviderr extends ReportManager{

	public static WebDriver driver;

	@Test(dataProvider="framework")
	public  void sample(String UserName , String Password) throws Exception{
		test=extent.startTest( "Gmail Login Functionality With Dataprovider");
		
		driver=GlobalFunctions.launchBrowser(driver);
		test.log(LogStatus.INFO, "Hey Browser Login Sucessfully");
		driver=GlobalFunctions.openUrl(driver, "url");
		test.log(LogStatus.INFO, "G Mail Application launched");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(UserName);
		
		test.log(LogStatus.INFO, "User Name Entered Sucessfully");
		
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		
		test.log(LogStatus.INFO, "Next Button Clicked Sucessfully");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys(Password);
		
		Thread.sleep(2000);
	
	}
	
	
	
	
	
	
	
	@DataProvider(name="framework")
		public Object[][] getExcelData1() {
			/*Properties properties=new Properties();
			try {
				
				FileInputStream file=new FileInputStream("F:\\SeleniumWorkSpace\\FrameWork\\src\\Config.properties");
				try {
					properties.load(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  	
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			Object[][] arrayObject = getExcelData("E:\\UVAutomation\\AppLaudGS\\Data\\Test Data\\TestData.xls","TestData");
			return arrayObject;
		}
		
	

    	/**
		 * @param File Name
		 * @param Sheet Name
		 * @return
		 */
		public String[][] getExcelData(String fileName, String sheetName) {
			String[][] arrayExcelData = null;
			try {
				FileInputStream fs = new FileInputStream(fileName);
				Workbook wb = Workbook.getWorkbook(fs);
				Sheet sh = wb.getSheet(sheetName);

				int totalNoOfCols = sh.getColumns();
				int totalNoOfRows = sh.getRows();
				
				arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
				
				for (int i= 1 ; i < totalNoOfRows; i++) {

					for (int j=0; j < totalNoOfCols; j++) {
						arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
					}

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
			return arrayExcelData;
		}
		
	 
  }
	
	
	
	

