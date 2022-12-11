package com.applaudGS.automation.modules.general;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GettingAllValuesFromDropdown {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	
		driver=new ChromeDriver();
		driver.get("https://www.telugumatrimony.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='dd']")).click();
		driver.findElement(By.xpath("//li[@id='8']")).click();
		
		
		
		
		
//		
//		Select s=new Select(driver.findElement(By.id("REGISTERED_BY")));
//		List<WebElement> allOptions = s.getOptions();
//		System.out.println(allOptions);
//		System.out.println("Total No Of values In A Dropdown:  "+allOptions.size());
//		
//		for(int i=0;i<allOptions.size();i++) {
//			System.out.println(s.getOptions().get(i).getText());
//			
//			if(s.getOptions().get(i).getText().equals("Son")) {
//				s.selectByIndex(i);
//			}
//		}
	}

}



