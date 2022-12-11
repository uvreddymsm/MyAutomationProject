package com.applaudGS.automation.modules.general;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingValuesFromLi {

	public static WebDriver driver;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		
		driver=new ChromeDriver();
		driver.get("https://www.telugumatrimony.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='dd']")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> ele=driver.findElements(By.xpath("//*[@id=\"REGISTERED_BY_VALUE\"]/li"));
		
		for(int i=0;i<ele.size();i++) {
//			System.out.println(ele.get(i).getText());	
			if(ele.get(i).getText().equals("Friend")) {
				System.out.println("9999999999999999");
				ele.get(i).click();
			}
		}
		

	}

}
