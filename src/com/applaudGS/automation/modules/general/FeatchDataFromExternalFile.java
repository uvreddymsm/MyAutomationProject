package com.applaudGS.automation.modules.general;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.applaudGS.automation.utility.DataReader;
import com.applaudGS.automation.utility.GlobalFunctions;

public class FeatchDataFromExternalFile {
	
	public static Map<String, String> data;
	public static WebDriver driver;
	
	@Test
	public void loginApplicaiton() throws Exception {
		 data=DataReader.readData();
		 
		 driver=GlobalFunctions.launchBrowser(driver);
		
		 
	//	 driver.get("https://phptravels.org/index.php?rp=/login");
		 
		 Thread.sleep(2000);
//		 
//		 System.out.println("*************"+data.get("UserName"));
//		 
//		 System.out.println("*************"+data.get("Pwd"));
//		 
//		 
//		 System.out.println("*************"+data.get("PhoneNO"));
//		 
//		 System.out.println("*************"+data.get("Address"));
		 
		 driver.findElement(By.id("inputEmail")).sendKeys(data.get("UserName"));
	     driver.findElement(By.id("inputPassword")).sendKeys(data.get("Pwd"));
		 

         
		
	}

}
