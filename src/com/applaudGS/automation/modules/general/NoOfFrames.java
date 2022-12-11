package com.applaudGS.automation.modules.general;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoOfFrames {

	public static WebDriver driver;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","E:\\Workspace\\AppLaud\\Library\\chromedriver.exe");
     	/*System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\Library\\IEDriverServer.exe");
     	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Library\\geckodriver.exe");*/
     	driver=new ChromeDriver();
     	driver.get("https://seleniumhq.github.io/selenium/docs/api/java/");
     	driver.manage().window().maximize();
     	Thread.sleep(2000);
		//By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("frame"));
		
		System.out.println("The total number of iframes are " + iframeElements.size());
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("/html/body/div[2]/ul/li[1]/a")).click();
		

	}

}
