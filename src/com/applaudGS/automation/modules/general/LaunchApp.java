package com.applaudGS.automation.modules.general;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LaunchApp {

	
		public static WebDriver driver ;
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Yuvaraju Reddy\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://spiceclub.spicejet.com/signup");
			Thread.sleep(2000);
		    String title=	driver.getTitle();
			System.out.println("Title Of Spice Jet Signin Page : "+title);
			
			//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IHONE");
			
			Select sel=new Select(driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/select")));
//			sel.selectByVisibleText("Mrs");
			sel.selectByIndex(2);
			sel.selectByValue("MRS");
//			
//			driver.findElement(By.id("first_name")).sendKeys("YUVARAJU");
//			driver.findElement(By.id("last_name")).sendKeys("Rami");
//			
//			driver.findElement(By.id("dobDate")).sendKeys("09/12/1990");
//			driver.findElement(By.id("email_id")).sendKeys("abctest@gmail.com");
			
			
			
			
			
			//driver.close();
			
			
		}
	}



