package com.applaudGS.automation.utility;

import org.openqa.selenium.WebDriver;

public class WebDriverNew {
	
	public static  WebDriver driver=null;
	
	
	private WebDriverNew(){
		
	}
	
	public static  WebDriverNew getInstance(){
		
		return (WebDriverNew) driver;
	}

}
