package com.applaudGS.automation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RunningCloud {

 // public static final String USERNAME = "yuvaraju111";
  public static final String USERNAME = GlobalFunctions.launchProperties("USERNAME");
  public static final String AUTOMATE_KEY = GlobalFunctions.launchProperties("AUTOMATEKEY");
//  public static final String AUTOMATE_KEY = "k9h8nyK3fpaBLnfsQcgC";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
  public static WebDriver driver;
  @Parameters({ "BrowserName", "BrowserVersion", "OSName", "OSVersion" })
  @Test
  public static WebDriver launchBrowser1(WebDriver driver, String BrowserName, String BrowserVersion, String OSName, String OSVersion) throws Exception{
	  	DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", GlobalFunctions.launchProperties(BrowserName));
	    caps.setCapability("browser_version", GlobalFunctions.launchProperties(BrowserVersion));
	    caps.setCapability("os", GlobalFunctions.launchProperties(OSName));
	    caps.setCapability("os_version", GlobalFunctions.launchProperties(OSVersion));
	    caps.setCapability("browserstack.debug", "true");

	     try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     GlobalFunctions.launchBrowser(driver);
	return driver;
	  
  }

  /*public static void main(String[] args) throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "IE");
    caps.setCapability("browser_version", "7.0");
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "XP");
    caps.setCapability("browserstack.debug", "true");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));

    element.sendKeys("BrowserStack");
    element.submit();

    System.out.println(driver.getTitle());
    driver.quit();

  }*/
}
